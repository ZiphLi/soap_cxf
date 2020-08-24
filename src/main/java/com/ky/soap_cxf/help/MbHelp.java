package com.ky.soap_cxf.help;

import com.ky.core.util.DateUtil;

import java.util.Date;

/**
 * Code by lzp on 2020/8/22
 */
public class MbHelp {
    /**
     * 下次随访时间
     *
     * @param time
     * @return
     */
    public static Date encodeNextDate(String time) {
        //取出括号内的毫秒
        time = time.substring(time.indexOf("(") + 1, time.indexOf(")"));
        //毫秒转字符串时间
        time = DateUtil.getDateStringBySecondTime(Long.parseLong(time));
        return DateUtil.getFormatDateTimeStringForDate(time);
    }
}
