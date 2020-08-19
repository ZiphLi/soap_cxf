package com.ky.soap_cxf.dao;


import com.ky.soap_cxf.help.InvokeRemoteDao;
import com.mongodb.util.JSON;
import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.CORBA.OBJ_ADAPTER;

import java.util.Map;


public class CxfClient {

    /**
     * 同步高血压数据
     *
     * @param IDMap
     */
    public static void upAndDownGxy(Map<String, Object> IDMap) {
        //48-2 通过用户名密码获取所在机构信息 getRegionCode
        String url = IDMap.get("url").toString();
        String method = IDMap.get("method").toString();
        String TradeCode = "48-2";
        String InputParameter = "{\"UserName\":\"" + IDMap.get("username").toString() + "\",\"Password\":\"" + IDMap.get("password").toString() + "\"}";
        Object[] parameters = new Object[]{TradeCode, InputParameter};
        String resultStr = InvokeRemoteDao.invokeRemoteMethod(url, method, parameters)[0].toString();
        JSONObject resultJson = new JSONObject(resultStr);
        JSONObject Msg = resultJson.getJSONObject("Msg");
        JSONArray RegionCodeList = Msg.getJSONArray("RegionCodeList");
        StringBuffer RegionCodeLists = new StringBuffer("");
        for (int i = 0; i < RegionCodeList.length(); i++) {
            String RegionCode = RegionCodeList.getString(i);
            //根据机构号获取个人ID
            getPersonDa(IDMap, RegionCode);
        }
    }


    /**
     * 55-11 根据机构号获取个人ID (个人档案)
     *
     * @param IDMap
     */
    public static void getPersonDa(Map<String, Object> IDMap, String RegionCode) {
        int total = 1;
        for (int i = 0; i < total; i++) {
            String url = IDMap.get("url").toString();
            String method = IDMap.get("method").toString();
            String TradeCode = "55-11";
            String InputParameter = "{\n" +
                    "\"ProductCode\": \"" + IDMap.get("productCode").toString() + "\",\n" +
                    "\"RegionCode\": \"" + RegionCode + "\",\n" +
                    "\"PageSize\": 100,\n" +
                    "\"PageIndex\": " + i + "\n" +
                    "}";
            Object[] parameters = new Object[]{TradeCode, InputParameter};
            String resultStr = InvokeRemoteDao.invokeRemoteMethod(url, method, parameters)[0].toString();
            JSONObject resultJson = new JSONObject(resultStr);
            JSONArray Msg = resultJson.getJSONArray("Msg");
            //获取每个人的档案
            for (int j = 0; j < 100; j++) {
                JSONObject wdEhr = Msg.getJSONObject(j);
                System.out.println(wdEhr);
            }
            //total
            total = resultJson.getInt("Total");
        }
    }
}
