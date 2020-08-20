package com.ky.soap_cxf.service;

import com.alibaba.druid.util.StringUtils;
import com.ky.common.bean.EhrBean;
import com.ky.common.bean.MbFolDiaBean;
import com.ky.common.bean.MbFolHypBean;
import com.ky.common.bean.OrgBean;
import com.ky.common.dao.*;
import com.ky.core.util.DateUtil;
import com.ky.soap_cxf.dao.CxfClient;
import com.ky.soap_cxf.dao.WdEhrDao;
import com.mongodb.util.JSON;
import org.apache.poi.util.IdentifierManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service
public class UpAndDownMbService {
    @Autowired
    private EhrBeanDao EhrBeanDao;
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
                upAndDownMb(IDMap);
            }
        }
    }

    /**
     * @param IDMap
     */
    private void upAndDownMb(Map<String, Object> IDMap) {

        //48-2 获取机构信息
        JSONArray RegionCodeList = CxfClient.getRegionCodeList(IDMap);
        int index = 1;
        for (int i = 0; i < RegionCodeList.length(); i++) {
            String RegionCode = RegionCodeList.getString(i);
            //根据机构号获取个人ID
            while (true) {
                JSONArray Msg = CxfClient.getPersonDa(IDMap, RegionCode, index);
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
                    String ehrId = updateWdEhr(wdEhr);
                    //高血压 TG
                    if (wdEhr.get("TG").toString().contains("高")) {
                        System.err.println(sfz + "--" + xm + "是高血压");
                        //获取人员全部高血压随访记录
                        JSONArray GxyMsg = CxfClient.getGxyFollow(IDMap, personID);
                        //遍历人员全部高血压随访记录并添加或更新
                        uploadGxy(GxyMsg, ehrId);
                    }
                    //糖尿病 TT
                    if (wdEhr.get("TT").toString().contains("糖")) {
                        System.err.println(sfz + "--" + xm + "是糖尿病");
                        //获取糖尿病随访记录
                        JSONArray TnbMsg = CxfClient.getTnbFollow(IDMap, personID);
                        //遍历人员全部糖尿病随访记录并添加或更新
                        uploadTnb(TnbMsg, ehrId);
                    }
                }
                index++;
            }
        }
    }

    /**
     * 遍历人员全部高血压随访记录并添加或更新
     *
     * @param mbMsg
     * @param ehrId
     */
    private void uploadGxy(JSONArray mbMsg, String ehrId) {
        //遍历高血压随访记录
        for (int gxyIndex = 0; gxyIndex < mbMsg.length(); gxyIndex++) {
            JSONObject GxyFol = mbMsg.getJSONObject(gxyIndex);
            String folTime = GxyFol.get("FollowUpDateStr").toString();
            if (folTime.length() > 9) {
                List<MbFolHypBean> MbFolHypBeanList = MbFolHypBeanDao.getHyperListByEhrId(ehrId);
                for (MbFolHypBean MbFolHypBean : MbFolHypBeanList) {
                    String sfrq = DateUtil.getDateString(MbFolHypBean.getFollowUpDate());
                    if (sfrq.equals(folTime)) {
                        //无操作或需要更新随访
                    } else {
                        //需要添加随访...
                        System.out.println("需要添加高血压随访--" + sfrq + "--" + ehrId);
                    }
                }
            }
        }
    }

    /**
     * 遍历人员全部糖尿病随访记录并添加或更新
     *
     * @param mbMsg
     * @param ehrId
     */
    private void uploadTnb(JSONArray mbMsg, String ehrId) {
        //遍历高血压随访记录
        for (int gxyIndex = 0; gxyIndex < mbMsg.length(); gxyIndex++) {
            JSONObject GxyFol = mbMsg.getJSONObject(gxyIndex);
            String folTime = GxyFol.get("FollowUpDateStr").toString();
            if (folTime.length() > 9) {
                List<MbFolDiaBean> MbFolDiaBeanList = MbFolDiaBeanDao.getDiabeListByEhrId(ehrId);
                for (MbFolDiaBean MbFolDiaBean : MbFolDiaBeanList) {
                    String sfrq = DateUtil.getDateString(MbFolDiaBean.getFollowUpDate());
                    if (sfrq.equals(folTime)) {
                        //无操作或需要更新随访
                    } else {
                        //需要添加随访...
                        System.out.println("需要添加糖尿病随访--" + sfrq + "--" + ehrId);
                    }
                }
            }
        }
    }

    /**
     * 更新或添加到wdEhr
     */
    private String updateWdEhr(JSONObject wdEhr) {
        //sfz
        String sfz = wdEhr.get("CARD_ID").toString();
        //查wd_Ehr 是否有该sfz 没有则添加(可能有重复档案)
        List<EhrBean> EhrBeanList = this.EhrBeanDao.selectBySfz(sfz);
        String ehrId = "";//需要返回
        if (EhrBeanList.size() == 0) {
            //添加档案操作...
            System.out.println("添加档案" + sfz);
            EhrBean ehr = new EhrBean();
            //档案号
            ehr.setId(UUID.randomUUID().toString());
            //姓名
            ehr.setName(wdEhr.get("NAME").toString());
        } else {
            if (EhrBeanList.get(0).getIdno().equals(sfz)) {
                //更新档案操作...
            }
        }
        return ehrId;
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

//
//            //获取用户名
//            String username = PropertiesLoaderUtils.loadAllProperties("common/common.properties").getProperty("mb_username");
//            IDMap.put("username", username);
//            //获取密码
//            String password = PropertiesLoaderUtils.loadAllProperties("common/common.properties").getProperty("mb_password");
//            IDMap.put("password", password);
//            //url
//            String url = PropertiesLoaderUtils.loadAllProperties("common/common.properties").getProperty("mb_url");
//            IDMap.put("url", url);
//            //productCode
//            String productCode = PropertiesLoaderUtils.loadAllProperties("common/common.properties").getProperty("mb_productCode");
//            IDMap.put("productCode", productCode);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return orgIdList;
    }

    public void uploadAllInfo() {

        //第一步:依据卫生机构ID获取下属机构
        //第二步:遍历下属机构信息,依次抓取信息
        for (int i = 0; i < 1; i++) {
            //第三步:


            //di
        }

    }
}
