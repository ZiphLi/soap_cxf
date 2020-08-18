package com.ky.core.util;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author RM
 * @version V1.0.0
 * @date 2019-09-24 07:32
 */
public class JsoupHelpUtil {

    /**
     * 根据筛选标记获取单选相应的值或者字符串
     * @param boxFlag            0 单选  1  多选
     * @param doc  DOM元素
     * @param selectPrex 筛选标记
     * @param valueType  获取值类型   0  value   1  text
     * @return
     */
    public static String getValueForRadioOrCheckBox(String boxFlag,Document doc,String selectPrex,String valueType){
        StringBuffer resultB = new StringBuffer("");
        Elements eles = doc.select(selectPrex);
        if(eles==null||eles.size()<=0){
            return "";
        }else{
            for(Element ele:eles){
                if(ele.hasAttr("checked")){
                    if(valueType.contains("0")){
                         resultB.append(ele.attr("value")+",");
                    }else{
                        resultB.append( ele.text()+",");
                    }
                }else{
                    continue;
                }
            }
        }
        String resultStr = resultB.toString();
        if(resultStr.endsWith(",")){
            return resultStr.substring(0,resultStr.length()-1);
        }else{
            return resultStr;
        }
    }


    /**
     * 获取SelectDOM元素相对应的值或者text内容
     * @param doc
     * @param selectPrex
     * @param valueType
     * @return
     */
    public static String getValueForSelect(Document doc,String selectPrex,String valueType){
        Elements eles = doc.select(selectPrex).get(0).select("option");
        String resultStr = "";
        if(eles!=null&&eles.size()>0){
            for(Element ele:eles){
                if(ele.hasAttr("selected")){
                    if(valueType.contains("0")){
                        resultStr = ele.attr("value");
                    }else{
                        resultStr = ele.text();
                    }
                    break;
                }else{
                    continue;
                }
            }
        }else{
            return "";
        }
        return resultStr;
    }
}
