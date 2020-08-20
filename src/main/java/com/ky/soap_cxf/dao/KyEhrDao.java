package com.ky.soap_cxf.dao;

import com.ky.common.bean.EhrBean;
import com.ky.core.util.DateUtil;
import com.ky.soap_cxf.help.EhrHelp;
import org.json.JSONObject;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Code by lzp on 2020/8/20
 */
public class KyEhrDao {
    /**
     * 添加ehr到数据库
     *
     * @param IDMap
     * @param wdEhr
     * @param coverMsg
     * @return
     */
    public static EhrBean addEhr(Map<String, Object> IDMap, JSONObject wdEhr, JSONObject coverMsg) {
        EhrBean ehr = new EhrBean();
        //档案号
        ehr.setId(UUID.randomUUID().toString());
        //姓名
        ehr.setName(wdEhr.get("NAME").toString());
        //身份证
        ehr.setIdno(wdEhr.get("CARD_ID").toString());
        //男   女
        ehr.setSex(wdEhr.get("GENDER").toString());
        //家庭住址
        ehr.setAddress(wdEhr.get("ADDRESS").toString().replaceAll(" ", "").replaceAll(">", ""));
        //电话
        ehr.setTel(wdEhr.get("TELPHONE").toString());
        //出生日期
        ehr.setBirthday(DateUtil.getFormatDateTimeStringForDate(coverMsg.get("BirthDay").toString()));
        //民族
        ehr.setNation(EhrHelp.getNation(coverMsg.get("NationCode").toString()));
        //最新的签约年份(不写)

        //慢病类型 多种,号隔开  高血压，糖尿病,老年人,
        ehr.setMbType(EhrHelp.encodeMbType(wdEhr));
        //人群类型 id 多种,分开 1,2,3
        ehr.setMbTypeId(EhrHelp.encodeMbType(wdEhr).replace("高血压", "1").replace("糖尿病", "2").replace("老年人", "3"));
        //特殊慢病  心脑肾1 贫困2
        ehr.setMbSpecialType(EhrHelp.encodeMbSpecial(wdEhr));
        //特殊慢病id
        ehr.setMbSpecialTypeId(EhrHelp.encodeMbSpecial(wdEhr).replace("贫困", "2"));
        //签约类型(不写)

        //公卫档案号
        ehr.setGwDah(wdEhr.get("ID").toString());
        //公卫档案号对应记录ID

        //所属卫生室
        ehr.setOrgId(IDMap.get("orgId").toString());
        //所属卫生室名
        ehr.setOrgName(IDMap.get("orgName").toString());
        //创建时间
        ehr.setCreateTime(new Date());
        //更新时间

        //删除时间

        //1 有效  0 删除   -1死亡
        ehr.setStatus("1");
        //来源：sign签约建档 batch批量导入  new新建档案
        ehr.setOrigin("batch");
        return ehr;
    }
}
