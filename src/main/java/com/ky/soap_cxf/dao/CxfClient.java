package com.ky.soap_cxf.dao;


import com.ky.common.bean.EhrBean;
import com.ky.common.dao.EhrBeanDao;
import com.ky.soap_cxf.help.InvokeRemoteDao;
import com.ky.soap_cxf.service.UpAndDownMbService;
import com.mongodb.util.JSON;
import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.CORBA.OBJ_ADAPTER;
import org.omg.CORBA.ServerRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        String resultStr = InvokeRemoteDao.invokeRemoteMethod(url, method, parameters)[0].toString();
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
    public static JSONArray getPersonDa(Map<String, Object> IDMap, String RegionCode, int index) {
        JSONArray Msg = new JSONArray();
        for (int i = 0; i < index; i++) {
            String url = IDMap.get("url").toString();
            String method = IDMap.get("method").toString();
            String TradeCode = "55-12";
            String InputParameter = "{\n" +
                    "\"ProductCode\": \"" + IDMap.get("productCode").toString() + "\",\n" +
                    "\"RegionCode\": \"" + RegionCode + "\",\n" +
                    "\"PageSize\": 100,\n" +
                    "\"PageIndex\": " + i + "\n" +
                    "}";
            Object[] parameters = new Object[]{TradeCode, InputParameter};
            String resultStr = InvokeRemoteDao.invokeRemoteMethod(url, method, parameters)[0].toString();
            JSONObject resultJson = new JSONObject(resultStr);
            Msg = resultJson.getJSONArray("Msg");
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
        String resultStr = InvokeRemoteDao.invokeRemoteMethod(url, method, parameters)[0].toString();
        JSONObject resultJson = new JSONObject(resultStr);
        JSONArray Msg = resultJson.getJSONArray("Msg");
        return Msg;
    }

    /**
     * 59-1 查询个人高血压随访记录列表
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
        String resultStr = InvokeRemoteDao.invokeRemoteMethod(url, method, parameters)[0].toString();
        JSONObject resultJson = new JSONObject(resultStr);
        JSONArray Msg = resultJson.getJSONArray("Msg");
        return Msg;
    }
}
