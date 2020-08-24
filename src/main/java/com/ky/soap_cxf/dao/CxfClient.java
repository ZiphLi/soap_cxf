package com.ky.soap_cxf.dao;


import com.ky.soap_cxf.help.InvokeRemoteHelp;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Code by lzp on 2020/8/18
 */
@Service
public class CxfClient {


    /**
     * 同步高血压数据
     *
     * @param IDMap
     */
    public static JSONArray getRegionCodeList(Map<String, Object> IDMap) {
        //48-2 通过用户名密码获取所在机构信息 getRegionCode
        String url = IDMap.get("url").toString();
        String method = IDMap.get("method").toString();
        String TradeCode = "48-2";
        String InputParameter = "{\"UserName\":\"" + IDMap.get("username").toString() + "\",\"Password\":\"" + IDMap.get("password").toString() + "\"}";
        Object[] parameters = new Object[]{TradeCode, InputParameter};
        String resultStr = InvokeRemoteHelp.invokeRemoteMethod(url, method, parameters)[0].toString();
        JSONObject resultJson = new JSONObject(resultStr);
        JSONObject Msg = resultJson.getJSONObject("Msg");
        JSONArray RegionCodeList = Msg.getJSONArray("RegionCodeList");
        return RegionCodeList;
    }


    /**
     * 55-12 根据机构号获取个人ID (个人档案)
     *
     * @param IDMap
     */
    public static JSONArray getPersonDa(Map<String, Object> IDMap, int index) {
        JSONArray Msg = new JSONArray();
        for (int i = 0; i < index; i++) {
            String url = IDMap.get("url").toString();
            String method = IDMap.get("method").toString();
            String TradeCode = "55-12";
            String InputParameter = "{\n" +
                    "\"ProductCode\": \"" + IDMap.get("productCode").toString() + "\",\n" +
                    "\"RegionCode\": \"" + IDMap.get("RegionCode").toString() + "\",\n" +
                    "\"IsStatus\": 0,\n" +
                    "\"PageSize\": 100,\n" +
                    "\"PageIndex\": " + i + "\n" +
                    "}";
            Object[] parameters = new Object[]{TradeCode, InputParameter};
            String resultStr = InvokeRemoteHelp.invokeRemoteMethod(url, method, parameters)[0].toString();
            JSONObject resultJson = new JSONObject(resultStr);
            try {
                Msg = resultJson.getJSONArray("Msg");
            } catch (Exception e) {
                System.err.println(resultJson);
                e.printStackTrace();

            }
        }
        return Msg;

    }

    /**
     * 58-1 查询个人高血压随访记录列表
     *
     * @param IDMap
     * @param personID
     */
    public static JSONArray getGxyFollow(Map<String, Object> IDMap, String personID) {
        String url = IDMap.get("url").toString();
        String method = IDMap.get("method").toString();
        String TradeCode = "58-1";
        String InputParameter = "{\n" +
                "\"ProductCode\":\"" + IDMap.get("productCode").toString() + "\",\n" +
                "\"PersonID\":\"" + personID + "\",\n" +
                "\"PageSize\":\"100\",\n" +
                "\"PageIndex\":\"0\"\n" +
                "}";
        Object[] parameters = new Object[]{TradeCode, InputParameter};
        String resultStr = InvokeRemoteHelp.invokeRemoteMethod(url, method, parameters)[0].toString();
        JSONObject resultJson = new JSONObject(resultStr);
        JSONArray Msg = resultJson.getJSONArray("Msg");
        return Msg;
    }

    /**
     * 58-3 高血压随访详细数据
     *
     * @param IDMap
     * @param ID
     * @return
     */
    public static JSONObject getGxyFolDetail(Map<String, Object> IDMap, String ID) {
        String url = IDMap.get("url").toString();
        String method = IDMap.get("method").toString();
        String TradeCode = "58-3";
        String InputParameter = "{\n" +
                "\"ProductCode\":\"" + IDMap.get("productCode").toString() + "\",\n" +
                "\"ID\":\"" + ID + "\"\n" +
                "}";
        Object[] parameters = new Object[]{TradeCode, InputParameter};
        String resultStr = InvokeRemoteHelp.invokeRemoteMethod(url, method, parameters)[0].toString();
        JSONObject resultJson = new JSONObject(resultStr);
        JSONObject Msg = resultJson.getJSONObject("Msg");
        return Msg;
    }


    /**
     * 59-1 查询个人糖尿病随访记录列表
     *
     * @param IDMap
     * @param personID
     */
    public static JSONArray getTnbFollow(Map<String, Object> IDMap, String personID) {
        String url = IDMap.get("url").toString();
        String method = IDMap.get("method").toString();
        String TradeCode = "59-1";
        String InputParameter = "{\n" +
                "\"ProductCode\":\"" + IDMap.get("productCode").toString() + "\",\n" +
                "\"PersonID\":\"" + personID + "\",\n" +
                "\"PageSize\":\"100\",\n" +
                "\"PageIndex\":\"0\"\n" +
                "}";
        Object[] parameters = new Object[]{TradeCode, InputParameter};
        String resultStr = InvokeRemoteHelp.invokeRemoteMethod(url, method, parameters)[0].toString();
        JSONObject resultJson = new JSONObject(resultStr);
        JSONArray Msg = resultJson.getJSONArray("Msg");
        return Msg;
    }

    /**
     * 59-3 获取详细糖尿病随访数据
     *
     * @param IDMap
     * @param ID
     * @return
     */
    public static JSONObject getTnbFolDetail(Map<String, Object> IDMap, String ID) {
        String url = IDMap.get("url").toString();
        String method = IDMap.get("method").toString();
        String TradeCode = "59-3";
        String InputParameter = "{\n" +
                "\"ProductCode\":\"" + IDMap.get("productCode").toString() + "\",\n" +
                "\"PersonID\":\"" + ID + "\"\n" +
                "}";
        Object[] parameters = new Object[]{TradeCode, InputParameter};
        String resultStr = InvokeRemoteHelp.invokeRemoteMethod(url, method, parameters)[0].toString();
        JSONObject resultJson = new JSONObject(resultStr);
        JSONObject Msg = resultJson.getJSONObject("Msg");
        return Msg;
    }


    /**
     * 55-10 获取档案封面
     *
     * @param ID
     * @param IDMap
     */
    public static JSONObject getCover(Object ID, Map<String, Object> IDMap) {
        String url = IDMap.get("url").toString();
        String method = IDMap.get("method").toString();
        String TradeCode = "55-10";
        String InputParameter = "{\n" +
                "\"ProductCode\":\"" + IDMap.get("productCode").toString() + "\",\n" +
                "\"ID\":\"" + ID + "\"\n" +
                "}";
        Object[] parameters = new Object[]{TradeCode, InputParameter};
        String resultStr = InvokeRemoteHelp.invokeRemoteMethod(url, method, parameters)[0].toString();
        JSONObject resultJson = new JSONObject(resultStr);
        JSONObject Msg = resultJson.getJSONObject("Msg");
        return Msg;
    }


    /**
     * 57-1 查询个人慢病名册列表(高血压管理卡)
     *
     * @param IDMap
     * @param wdEhr
     * @return
     */
    public static JSONObject getGxyGlkMsg(Map<String, Object> IDMap, JSONObject wdEhr) {
        String url = IDMap.get("url").toString();
        String method = IDMap.get("method").toString();
        String TradeCode = "57-1";
        String InputParameter = "{\n" +
                "\"ProductCode\":\"" + IDMap.get("productCode").toString() + "\",\n" +
                "\"RegionID\":\"" + IDMap.get("RegionCode").toString() + "\",\n" +
                "\"BuildType\":\"高血压\",\n" +
                "\"PersonID\":\"" + wdEhr.get("ID").toString() + "\",\n" +
                "\"PageSize\":\"100\",\n" +
                "\"PageIndex\":\"0\"\n" +
                "}";
        Object[] parameters = new Object[]{TradeCode, InputParameter};
        String resultStr = InvokeRemoteHelp.invokeRemoteMethod(url, method, parameters)[0].toString();
        JSONObject resultJson = new JSONObject(resultStr);
        JSONObject Msg = resultJson.getJSONArray("Msg").getJSONObject(0);

        if (resultJson.getJSONArray("Msg").length() > 1) {
            System.err.println(wdEhr.get("CARD_ID").toString() + "有多个管理卡");
        }
        return Msg;
    }

    /**
     * 57-7 查询个人具体慢病名册
     *
     * @param IDMap
     * @param ID
     * @return
     */
    public static JSONObject getPerSonMbMc(Map<String, Object> IDMap, String ID) {
        String url = IDMap.get("url").toString();
        String method = IDMap.get("method").toString();
        String TradeCode = "57-7";
        String InputParameter = "{\n" +
                "\"ProductCode\":\"" + IDMap.get("productCode").toString() + "\",\n" +
                "\"ID\":\"" + ID + "\",\n" +
                "\"BuildType\":\"高血压\"\n" +
                "}";
        Object[] parameters = new Object[]{TradeCode, InputParameter};
        String resultStr = InvokeRemoteHelp.invokeRemoteMethod(url, method, parameters)[0].toString();
        JSONObject resultJson = new JSONObject(resultStr);
        JSONObject Msg = resultJson.getJSONObject("Msg");
        return Msg;
    }
}
