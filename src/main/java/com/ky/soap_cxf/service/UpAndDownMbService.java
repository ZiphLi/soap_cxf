package com.ky.soap_cxf.service;

import com.alibaba.druid.util.StringUtils;
import com.ky.common.bean.WdEhrBean;
import com.ky.common.bean.WdMbDiabeFol;
import com.ky.common.bean.WdMbHyperFol;
import com.ky.common.dao.WdEhrBeanDao;
import com.ky.common.dao.WdMbDiabeFolDao;
import com.ky.common.dao.WdMbHyperFolDao;
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


@Service
public class UpAndDownMbService {
    @Autowired
    private WdEhrBeanDao wdEhrBeanDao;
    @Autowired
    private WdMbHyperFolDao wdMbHyperFolDao;
    @Autowired
    private WdMbDiabeFolDao wdMbDiabeFolDao;

    /**
     * 所有对接业务
     */
    public void AllService() {
        Map<String, Object> IDMap = new HashMap<>();
        //读取配置表
        getCommonData(IDMap);
        /**
         * 同步高血压信息
         * 48-2 获取机构信息
         * 55-12 根据机构号获取个人ID
         * 58-1 根据个人ID 查询高血压随访记录
         * 59-1 根据个人ID 查询糖尿病随访记录
         */
        upAndDownMb(IDMap);
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
//                System.out.println(sfz + "--" + xm);
                    String personID = wdEhr.get("ID").toString();
                    //高血压 TG
                    if (wdEhr.get("TG").toString().contains("高")) {
                        System.err.println(sfz + "--" + xm + "是高血压");
                        updateWdEhr(sfz, wdEhr);
                        //获取人员全部高血压随访记录
                        JSONArray GxyMsg = CxfClient.getGxyFollow(IDMap, personID);
                        //遍历人员全部高血压随访记录并添加或更新
                        uploadGxy(GxyMsg, sfz);
                    }
                    //糖尿病 TT
                    if (wdEhr.get("TT").toString().contains("糖")) {
                        System.err.println(sfz + "--" + xm + "是糖尿病");
                        updateWdEhr(sfz, wdEhr);
                        //获取糖尿病随访记录
                        JSONArray TnbMsg = CxfClient.getTnbFollow(IDMap, personID);
                        //遍历人员全部糖尿病随访记录并添加或更新
                        uploadTnb(TnbMsg, sfz);
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
     * @param sfz
     */
    private void uploadGxy(JSONArray mbMsg, String sfz) {
        //遍历高血压随访记录
        for (int gxyIndex = 0; gxyIndex < mbMsg.length(); gxyIndex++) {
            JSONObject GxyFol = mbMsg.getJSONObject(gxyIndex);
            String folTime = GxyFol.get("FollowUpDateStr").toString();
            if (folTime.length() > 9) {
                List<WdMbHyperFol> wdMbHyperFolList = wdMbHyperFolDao.getHyperListBySfzAndOrgId("", sfz);
                for (WdMbHyperFol wdMbHyperFol : wdMbHyperFolList) {
                    String sfrq = DateUtil.getDateString(wdMbHyperFol.getFollowUpDate());
                    if (sfrq.equals(folTime)) {
                        //无操作或需要更新随访
                    } else {
                        //需要添加随访...
                        System.out.println("需要添加高血压随访--" + sfrq + "--" + sfz);
                    }
                }
            }
        }
    }

    /**
     * 遍历人员全部糖尿病随访记录并添加或更新
     *
     * @param mbMsg
     * @param sfz
     */
    private void uploadTnb(JSONArray mbMsg, String sfz) {
        //遍历高血压随访记录
        for (int gxyIndex = 0; gxyIndex < mbMsg.length(); gxyIndex++) {
            JSONObject GxyFol = mbMsg.getJSONObject(gxyIndex);
            String folTime = GxyFol.get("FollowUpDateStr").toString();
            if (folTime.length() > 9) {
                List<WdMbDiabeFol> wdMbDiabeFolList = wdMbDiabeFolDao.getDiabeListBySfzAndOrgId("", sfz);
                for (WdMbDiabeFol wdMbDiabeFol : wdMbDiabeFolList) {
                    String sfrq = DateUtil.getDateString(wdMbDiabeFol.getFollowUpDate());
                    if (sfrq.equals(folTime)) {
                        //无操作或需要更新随访
                    } else {
                        //需要添加随访...
                        System.out.println("需要添加糖尿病随访--" + sfrq + "--" + sfz);
                    }
                }
            }
        }
    }

    /**
     * 更新或添加到wdEhr(更新管理卡)
     *
     * @param sfz
     */
    private void updateWdEhr(String sfz, JSONObject wdEhr) {
        //查wd_Ehr 是否有该sfz 没有则添加(可能有重复档案)
        List<WdEhrBean> wdEhrBeanList = this.wdEhrBeanDao.selectBySfz(sfz);
        if (wdEhrBeanList.size() == 0) {
            //添加档案操作...
            System.out.println("添加档案" + sfz);
        } else {
            if (wdEhrBeanList.get(0).getSfz().equals(sfz)) {
                //更新档案操作...
            }
        }
    }


    /**
     * 获取配置表数据
     */
    private void getCommonData(Map<String, Object> IDMap) {
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
            //获取用户名
            String username = PropertiesLoaderUtils.loadAllProperties("common/common.properties").getProperty("mb_username");
            IDMap.put("username", username);
            //获取密码
            String password = PropertiesLoaderUtils.loadAllProperties("common/common.properties").getProperty("mb_password");
            IDMap.put("password", password);
            //url
            String url = PropertiesLoaderUtils.loadAllProperties("common/common.properties").getProperty("mb_url");
            IDMap.put("url", url);
            //method
            String method = PropertiesLoaderUtils.loadAllProperties("common/common.properties").getProperty("mb_method");
            IDMap.put("method", method);
            //method
            String productCode = PropertiesLoaderUtils.loadAllProperties("common/common.properties").getProperty("mb_productCode");
            IDMap.put("productCode", productCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
