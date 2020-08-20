package com.ky.soap_cxf.help;

import com.ky.core.util.StringUtil;
import org.json.JSONObject;

/**
 * Code by lzp on 2020/8/20
 */
public class EhrHelp {

    public static String getNation(String nationCode) {
        String mzflag = "";
        String mz = StringUtil.getRealStringByStr(nationCode);
        if (mz.contains("01")) {
            mzflag = "汉族";
        }
        if (mz.contains("02")) {
            mzflag = "蒙古族";
        }
        if (mz.contains("03")) {
            mzflag = "回族";
        }
        if (mz.contains("04")) {
            mzflag = "藏族";
        }
        if (mz.contains("05")) {
            mzflag = "维吾尔族";
        }
        if (mz.contains("06")) {
            mzflag = "苗族";
        }
        if (mz.contains("07")) {
            mzflag = "彝族";
        }
        if (mz.contains("08")) {
            mzflag = "壮族";
        }
        if (mz.contains("09")) {
            mzflag = "布依族";
        }
        if (mz.contains("10")) {
            mzflag = "朝鲜族";
        }
        if (mz.contains("11")) {
            mzflag = "满族";
        }
        if (mz.contains("12")) {
            mzflag = "侗族";
        }
        if (mz.contains("13")) {
            mzflag = "瑶族";
        }
        if (mz.contains("14")) {
            mzflag = "白族";
        }
        if (mz.contains("15")) {
            mzflag = "土家族";
        }
        if (mz.contains("16")) {
            mzflag = "哈尼族";
        }
        if (mz.contains("17")) {
            mzflag = "哈萨克族";
        }
        if (mz.contains("18")) {
            mzflag = "傣族";
        }
        if (mz.contains("19")) {
            mzflag = "黎族";
        }
        if (mz.contains("20")) {
            mzflag = "傈僳族";
        }
        if (mz.contains("21")) {
            mzflag = "佤族";
        }
        if (mz.contains("22")) {
            mzflag = "畲族";
        }
        if (mz.contains("23")) {
            mzflag = "高山族";
        }
        if (mz.contains("24")) {
            mzflag = "拉祜族";
        }
        if (mz.contains("25")) {
            mzflag = "水族";
        }
        if (mz.contains("26")) {
            mzflag = "东乡族";
        }
        if (mz.contains("27")) {
            mzflag = "纳西族";
        }
        if (mz.contains("28")) {
            mzflag = "景颇族";
        }
        if (mz.contains("29")) {
            mzflag = "柯尔克孜族";
        }
        if (mz.contains("30")) {
            mzflag = "土族";
        }
        if (mz.contains("31")) {
            mzflag = "达斡尔族";
        }
        if (mz.contains("32 ")) {
            mzflag = "仫佬族";
        }
        if (mz.contains("33")) {
            mzflag = "羌族";
        }
        if (mz.contains("34")) {
            mzflag = "布朗族";
        }
        if (mz.contains("35")) {
            mzflag = "撒拉族";
        }
        if (mz.contains("36")) {
            mzflag = "毛难族";
        }
        if (mz.contains("37")) {
            mzflag = "仡佬族";
        }
        if (mz.contains("38")) {
            mzflag = "锡伯族";
        }
        if (mz.contains("39")) {
            mzflag = "阿昌族";
        }
        if (mz.contains("40")) {
            mzflag = "普米族";
        }
        if (mz.contains("41")) {
            mzflag = "塔吉克族";
        }
        if (mz.contains("42")) {
            mzflag = "怒族";
        }
        if (mz.contains("43")) {
            mzflag = "乌孜别克族";
        }
        if (mz.contains("44")) {
            mzflag = "俄罗斯族";
        }
        if (mz.contains("45")) {
            mzflag = "鄂温克族";
        }
        if (mz.contains("46")) {
            mzflag = "德昂族";
        }
        if (mz.contains("47")) {
            mzflag = "保安族";
        }
        if (mz.contains("48")) {
            mzflag = "裕固族";
        }
        if (mz.contains("49")) {
            mzflag = "京族";
        }
        if (mz.contains("50")) {
            mzflag = "塔塔尔族";
        }
        if (mz.contains("51")) {
            mzflag = "独龙族";
        }
        if (mz.contains("52")) {
            mzflag = "鄂伦春族";
        }
        if (mz.contains("53")) {
            mzflag = "赫哲族";
        }
        if (mz.contains("54")) {
            mzflag = "门巴族";
        }
        if (mz.contains("55")) {
            mzflag = "珞巴族";
        }
        if (mz.contains("56")) {
            mzflag = "基诺族";
        }
        return mzflag;

    }

    /**
     * 慢病类型
     *
     * @param wdEhr
     */
    public static String encodeMbType(JSONObject wdEhr) {
        StringBuffer mbType = new StringBuffer("");
        if (wdEhr.get("TT").toString().contains("糖")) {
            mbType.append("糖尿病,");
        }
        if (wdEhr.get("TG").toString().contains("高")) {
            mbType.append("高血压,");
        }
        if (Integer.parseInt(wdEhr.get("AGE").toString().replace("岁", "").replace("月", "").replace("天","").replaceAll(" ", "")) >= 65) {
            mbType.append("老年人,");
        }
        String mbTypeStr = mbType.toString();
        if (mbTypeStr.endsWith(",")) {
            mbTypeStr = mbTypeStr.substring(0, mbTypeStr.length() - 1);
        }
        return mbTypeStr;
    }

    /**
     * 特殊慢病
     *
     * @param wdEhr
     * @return
     */
    public static String encodeMbSpecial(JSONObject wdEhr) {
        StringBuffer mbType = new StringBuffer("");
        if (wdEhr.get("IS_POOR").toString().contains("1")) {
            mbType.append("贫困,");
        }

        String mbTypeStr = mbType.toString();
        if (mbTypeStr.endsWith(",")) {
            mbTypeStr = mbTypeStr.substring(0, mbTypeStr.length() - 1);
        }
        return mbTypeStr;
    }
}
