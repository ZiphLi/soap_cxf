package com.ky.soap_cxf.service;

import com.alibaba.druid.util.StringUtils;
import com.ky.common.bean.*;
import com.ky.common.dao.*;
import com.ky.core.util.DateUtil;
import com.ky.soap_cxf.dao.CxfClient;
import com.ky.soap_cxf.dao.KyEhrDao;
import com.ky.soap_cxf.dao.KyMbDao;
import com.ky.soap_cxf.help.EhrHelp;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service
public class UpAndDownMbService {
    @Autowired
    private EhrBeanDao ehrBeanDao;
    @Autowired
    private OrgBeanDao orgBeanDao;
    @Autowired
    private MbFolHypBeanDao MbFolHypBeanDao;
    @Autowired
    private MbFolDiaBeanDao MbFolDiaBeanDao;
    @Autowired
    private MbGlkHypBeanDao mbGlkHypBeanDao;
    @Autowired
    private MbGlkDiaBeanDao mbGlkDiaBeanDao;

    /**
     * 所有对接业务
     */
    public void AllService() {
        Map<String, Object> IDMap = new HashMap<>();
        //读取配置表以及获取机构相关信息
        String[] orgIdList = getCommonData(IDMap);
        /**
         * 同步高血压信息
         * 48-2 获取机构信息
         * 55-12 根据机构号获取个人ID
         * 58-1 根据个人ID 查询高血压随访记录
         * 59-1 根据个人ID 查询糖尿病随访记录
         */
        for (String orgId : orgIdList) {
            List<OrgBean> orgBeanList = orgBeanDao.selectListByPrimaryKey(orgId);
            for (OrgBean orgBean : orgBeanList) {
                IDMap.put("username", orgBean.getZlUser());
                IDMap.put("password", orgBean.getZlPasswd());
                IDMap.put("url", orgBean.getZlServerAddress());
                IDMap.put("productCode", orgBean.getYyCode());
                IDMap.put("orgId", orgBean.getId());
                IDMap.put("orgName", orgBean.getName());
                upAndDownMb(IDMap);
            }
        }
    }

    /**
     * 同步慢病档案及随访数据 业务层
     *
     * @param IDMap
     */
    private void upAndDownMb(Map<String, Object> IDMap) {

        //48-2 获取机构信息
        JSONArray RegionCodeList = CxfClient.getRegionCodeList(IDMap);
        int index = 1;
        for (int i = 0; i < RegionCodeList.length(); i++) {
            IDMap.put("RegionCode", RegionCodeList.getString(i));
            //根据机构号获取个人ID
            while (true) {
                JSONArray Msg = CxfClient.getPersonDa(IDMap, index);
                //获取每个人的档案
                for (int j = 0; j < 100; j++) {
                    JSONObject wdEhr = Msg.getJSONObject(j);
                    if (wdEhr == null) {
                        break;
                    }
                    String sfz = wdEhr.get("CARD_ID").toString();
                    String xm = wdEhr.get("NAME").toString();
                    String personID = wdEhr.get("ID").toString();
                    //上传档案到com_ehr
                    EhrBean ehrBean = new EhrBean();
                    ehrBean = updateWdEhr(ehrBean, wdEhr, IDMap);

                    if (ehrBean.getId() != null) {
                        String ehrId = ehrBean.getId();
                        //高血压 TG
                        if (wdEhr.get("TG").toString().contains("高")) {
                            System.err.println(sfz + "--" + xm + "是高血压");
                            //添加高血压管理卡(更新ehrBean)
                            uploadGxyGlk(ehrBean, IDMap, wdEhr);
                            //调接口58-1 获取人员全部高血压随访记录
                            JSONArray GxyMsg = CxfClient.getGxyFollow(IDMap, personID);
                            //遍历人员全部高血压随访记录并添加或更新
                            uploadGxy(IDMap, GxyMsg, ehrId);
                        }
//                    //糖尿病 TT
//                    if (wdEhr.get("TT").toString().contains("糖")) {
//                        System.err.println(sfz + "--" + xm + "是糖尿病");
//                        //获取糖尿病随访记录
//                        JSONArray TnbMsg = CxfClient.getTnbFollow(IDMap, personID);
//                        //遍历人员全部糖尿病随访记录并添加或更新
//                        uploadTnb(IDMap, TnbMsg, ehrId);
//                    }
                        ehrBeanDao.insertSelective(ehrBean);
                    }

                }
                index++;
            }
        }
    }


    /**
     * 更新或添加到wdEhr
     */
    private EhrBean updateWdEhr(EhrBean ehrBean, JSONObject wdEhr, Map<String, Object> IDMap) {
        //sfz
        String sfz = wdEhr.get("CARD_ID").toString();
        //查wd_Ehr 是否有该sfz 没有则添加(可能有重复档案)
        List<EhrBean> EhrBeanList = this.ehrBeanDao.selectBySfz(sfz);
        String ehrId = "";
        if (EhrBeanList.size() == 0) {
            //添加档案操作...部分数据需要访问封面获取
            JSONObject coverMsg = CxfClient.getCover(wdEhr.get("ID"), IDMap);
            System.out.println("添加档案..." + sfz);
            ehrBean = KyEhrDao.addEhr(ehrBean, IDMap, wdEhr, coverMsg);
        } else {
            if (EhrBeanList.get(0).getIdno().equals(sfz)) {
                //更新档案操作???
            }
        }
        return ehrBean;
    }


    /**
     * 创建高血压管理卡
     *
     * @param ehrBean
     * @param IDMap
     * @param wdEhr
     */
    private void uploadGxyGlk(EhrBean ehrBean, Map<String, Object> IDMap, JSONObject wdEhr) {
        //sfz
        String sfz = wdEhr.get("CARD_ID").toString();
        List<MbGlkHypBean> mbGlkHypBeanList = this.mbGlkHypBeanDao.selectBySfz(sfz);


        //调接口 57-1 查询个人慢病名册列表 获取管理卡对象
        JSONObject gxyGlkMsg = CxfClient.getGxyGlkMsg(IDMap, wdEhr);
        //慢病名册ID
        String ID = gxyGlkMsg.get("ID").toString();
        //调接口 57-7 更新档案表 获取心脑肾状态
        JSONObject personMbMc = CxfClient.getPerSonMbMc(IDMap, ID);
        if (personMbMc.get("cmHyLevel") == null) {
            String TargetOrganDamage = personMbMc.getJSONObject("cmHyLevel").get("TargetOrganDamage").toString();
            //更新档案(心脑肾)
            ehrBean.setMbSpecialType(ehrBean.getMbSpecialType() + ",心脑肾");
            ehrBean.setMbSpecialTypeId(ehrBean.getMbSpecialTypeId() + ",1");
        }
        //添加管理卡...
        if (mbGlkHypBeanList.size() == 0) {
            MbGlkHypBean mbGlkHypBean = KyMbDao.addGlkGxy(ehrBean, gxyGlkMsg, IDMap, wdEhr);
            mbGlkHypBeanDao.insertSelective(mbGlkHypBean);
        } else {
        }
    }


    /**
     * 遍历人员全部高血压随访记录并添加或更新
     *
     * @param IDMap
     * @param mbMsg
     * @param ehrId
     */
    private void uploadGxy(Map<String, Object> IDMap, JSONArray mbMsg, String ehrId) {
        //遍历高血压随访记录
        for (int gxyIndex = 0; gxyIndex < mbMsg.length(); gxyIndex++) {
            JSONObject GxyFol = mbMsg.getJSONObject(gxyIndex);
            String folTime = GxyFol.get("FollowUpDateStr").toString();
            if (folTime.length() > 9) {
                List<MbFolHypBean> MbFolHypBeanList = MbFolHypBeanDao.getHyperListByEhrId(ehrId);
                StringBuffer sfrqs = new StringBuffer("");
                for (MbFolHypBean MbFolHypBean : MbFolHypBeanList) {
                    sfrqs.append(DateUtil.getDateString(MbFolHypBean.getFollowUpDate()));
                }

                if (sfrqs.toString().contains(folTime)) {
                    //无操作或需要更新随访
                } else {
                    //需要添加随访...
                    System.out.println("需要添加高血压随访--" + folTime + "--" + ehrId);
                    //获取详细的随访记录 ID:随访记录ID
                    String ID = GxyFol.get("ID").toString();
                    JSONObject GxyFolDetail = CxfClient.getGxyFolDetail(IDMap, ID);
                    //根据获取的随访数据,写入慢病Bean,insert到数据库
                    MbFolHypBean mbGxy = KyMbDao.addMbGxy(IDMap, GxyFol, GxyFolDetail);
                    MbFolHypBeanDao.insertSelective(mbGxy);
                }
            }
        }
    }

    /**
     * 遍历人员全部糖尿病随访记录并添加或更新
     *
     * @param IDMap
     * @param mbMsg
     * @param ehrId
     */
    private void uploadTnb(Map<String, Object> IDMap, JSONArray mbMsg, String ehrId) {
        //遍历高血压随访记录
        for (int tnbIndex = 0; tnbIndex < mbMsg.length(); tnbIndex++) {
            JSONObject TnbFol = mbMsg.getJSONObject(tnbIndex);
            String folTime = TnbFol.get("FollowUpDateStr").toString();
            if (folTime.length() > 9) {
                List<MbFolDiaBean> MbFolDiaBeanList = MbFolDiaBeanDao.getDiabeListByEhrId(ehrId);
                StringBuffer sfrqs = new StringBuffer("");
                for (MbFolDiaBean MbFolDiaBean : MbFolDiaBeanList) {
                    sfrqs.append(DateUtil.getDateString(MbFolDiaBean.getFollowUpDate()));
                }
                if (sfrqs.toString().contains(folTime)) {
                    //无操作或需要更新随访
                } else {
                    //需要添加随访...
                    System.out.println("需要添加糖尿病随访--" + folTime + "--" + ehrId);
                    //获取详细的随访记录 ID:随访记录ID
                    String ID = TnbFol.get("ID").toString();
                    JSONObject TnbFolDetail = CxfClient.getTnbFolDetail(IDMap, ID);
                    //根据获取的随访数据,写入慢病Bean,insert到数据库
                    MbFolDiaBean mbTnb = KyMbDao.addMbTnb(IDMap, TnbFol, TnbFolDetail);
                    MbFolDiaBeanDao.insertSelective(mbTnb);
                }
            }
        }
    }


    /**
     * 读取配置表以及获取机构相关信息
     */
    private String[] getCommonData(Map<String, Object> IDMap) {
        String[] orgIdList = null;
        try {
            //获取机构信息
            String orgIds = PropertiesLoaderUtils.loadAllProperties("common/common.properties").getProperty("upload_org");
            if (!StringUtils.isEmpty(orgIds)) {
                if (orgIds.endsWith(";;")) {
                    orgIdList = orgIds.replace(";;", "").split(",");
                } else {
                    orgIdList = orgIds.split(",");
                }
            }
            IDMap.put("orgIdList", orgIdList);
            //method
            String method = PropertiesLoaderUtils.loadAllProperties("common/common.properties").getProperty("mb_method");
            IDMap.put("method", method);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return orgIdList;
    }
}
