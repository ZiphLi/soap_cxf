package com.ky.soap_cxf;

import com.ky.core.util.DateUtil;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Code by lzp on 2020/8/18
 */
public class test {

    public static void main(String[] args) {
//        int total = 1;
//        for (int i = 0; i < total; i++) {
//            System.out.println("q");
//            if (false) {
//                total = 5;
//            }
//
//        String date = "1994-07-25T00:00:00";
//
//        Date date1 = DateUtil.getFormatDateTimeStringForDate(date);
//
////        System.out.println(date1);
//
//        String dateStr = "2017-12-29";
//        Date date = DateUtil.getFormatDateTimeStringForDate(dateStr);
//        System.out.println(date);
        DecimalFormat df   = new DecimalFormat("######0.00");

        double d1 = 3.23456;
        double d2 = 0.0;
        double d3 = 2.0;
        df.format(d1);
        df.format(d2);
        df.format(d3);

        System.out.println(df.format(d1));

    }

}
