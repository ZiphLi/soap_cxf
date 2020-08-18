package com.ky.soap_cxf.service;

import com.alibaba.druid.util.StringUtils;
import com.ky.soap_cxf.dao.CxfClient;
import org.apache.poi.util.IdentifierManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UpAndDownMbService {

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
         * 55-11 根据机构号获取个人ID
         * 58-1 根据个人ID 查询高血压随访记录
         */
        CxfClient.upAndDownGxy(IDMap);
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
