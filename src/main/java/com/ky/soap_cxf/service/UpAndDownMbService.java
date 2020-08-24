package com.ky.soap_cxf.service;

import com.alibaba.druid.util.StringUtils;
import com.ky.common.bean.*;
import com.ky.common.dao.*;
import com.ky.core.util.DateUtil;
import com.ky.soap_cxf.dao.CxfClient;
import com.ky.soap_cxf.dao.KyEhrDao;
import com.ky.soap_cxf.dao.KyMbDao;
import com.ky.soap_cxf.help.EhrHelp;
import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
                try {
                    JSONArray Msg = CxfClient.getPersonDa(IDMap, index);
                    //获取每个人的档案
                    for (int j = 0; j < 100; j++) {
                        JSONObject wdEhr = Msg.getJSONObject(j);
                        if (wdEhr == null) {
                            break;
                        }
                        String personID = wdEhr.get("ID").toString();
                        //上传档案到com_ehr
                        EhrBean ehrBean = new EhrBean();
                        //取得新建的ehrBean,或已经存在的
                        Boolean isTrue = updateWdEhr(ehrBean, wdEhr, IDMap);
                        //高血压 TG
                        if (IDMap.get("ehrId") != null) {
                            if (wdEhr.get("TG").toString().contains("高")) {
                                //添加高血压管理卡(更新ehrBean)
                                uploadGxyGlk(ehrBean, IDMap, wdEhr);
                                //调接口58-1 获取人员全部高血压随访记录
                                JSONArray GxyMsg = CxfClient.getGxyFollow(IDMap, personID);
                                //遍历人员全部高血压随访记录并添加或更新
                                uploadGxy(IDMap, GxyMsg);
                            }
//                    //糖尿病 TT
//                    if (wdEhr.get("TT").toString().contains("糖")) {
//                        System.err.println(sfz + "--" + xm + "是糖尿病");
//                        //获取糖尿病随访记录
//                        JSONArray TnbMsg = CxfClient.getTnbFollow(IDMap, personID);
//                        //遍历人员全部糖尿病随访记录并添加或更新
//                        uploadTnb(IDMap, TnbMsg, ehrId);
//                    }
                        }
                        //如果新建了ehrBean,则insert
                        if (isTrue) {
                            try {
                                System.out.println("添加档案..." + ehrBean.getName() + ehrBean.getIdno());
                                ehrBeanDao.insertSelective(ehrBean);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    }
                    index++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 更新或添加到wdEhr
     */
    private Boolean updateWdEhr(EhrBean ehrBean, JSONObject wdEhr, Map<String, Object> IDMap) {
        Boolean isTrue = false;
        //sfz
        String gwDah = wdEhr.get("PERSON_CODE").toString();
        //查wd_Ehr 是否有该sfz 没有则添加(可能有重复档案)
        List<EhrBean> EhrBeanList = this.ehrBeanDao.selectByGwDah(gwDah);
        if (EhrBeanList.size() == 0) {
            //添加档案操作...部分数据需要访问封面获取
            JSONObject coverMsg = CxfClient.getCover(wdEhr.get("ID"), IDMap);
            ehrBean = KyEhrDao.addEhr(ehrBean, IDMap, wdEhr, coverMsg);
            isTrue = true;//上传的新数据
        } else {
            if (EhrBeanList.get(0).getGwDah().equals(gwDah)) {
                ehrBean = EhrBeanList.get(0);
                isTrue = false;//取的已有数据
            }
        }
        if (ehrBean.getId() == null) {
            System.out.println("k");
        }
        IDMap.put("ehrId", ehrBean.getId());
        return isTrue;
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
        if (personMbMc.get("cmHyLevel") != null) {
            String TargetOrganDamage = personMbMc.getJSONObject("cmHyLevel").get("TargetOrganDamage").toString();
            //更新档案(心脑肾)
            if (TargetOrganDamage != null && !TargetOrganDamage.equals("null")) {
                ehrBean.setMbSpecialType(ehrBean.getMbSpecialType() + ",心脑肾");
                ehrBean.setMbSpecialTypeId(ehrBean.getMbSpecialTypeId() + ",1");
            }
        }
        //添加管理卡...
        String glkId = "";
        if (mbGlkHypBeanList.size() == 0) {
            MbGlkHypBean mbGlkHypBean = KyMbDao.addGlkGxy(ehrBean, gxyGlkMsg, IDMap, wdEhr);
            System.out.println("添加高血压管理卡..." + ehrBean.getName() + ehrBean.getIdno());
            mbGlkHypBeanDao.insertSelective(mbGlkHypBean);
            glkId = mbGlkHypBean.getId();
        } else {
            glkId = mbGlkHypBeanList.get(0).getId();
        }
        IDMap.put("gxyGlkId", glkId);
    }

    /**
     * 遍历人员全部高血压随访记录并添加或更新
     *
     * @param IDMap
     * @param mbMsg
     */
    private void uploadGxy(Map<String, Object> IDMap, JSONArray mbMsg) {
        String ehrId = IDMap.get("ehrId").toString();
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

                    //获取详细的随访记录 ID:随访记录ID
                    String ID = GxyFol.get("ID").toString();
                    //调接口 58-3 高血压随访详细数据
                    JSONObject GxyFolDetail = CxfClient.getGxyFolDetail(IDMap, ID);
                    //根据获取的随访数据,写入慢病Bean,insert到数据库
                    MbFolHypBean mbGxy = KyMbDao.addMbGxy(IDMap, GxyFol, GxyFolDetail);
                    try {
                        MbFolHypBeanDao.insertSelective(mbGxy);
                        System.out.println("添加高血压随访成功..." + folTime + "--" + ehrId);
                    } catch (Exception e) {
                        System.out.println("高血压随访上传错误...");
                        System.out.println(mbGxy.getClass());
                        e.printStackTrace();
                    }
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
