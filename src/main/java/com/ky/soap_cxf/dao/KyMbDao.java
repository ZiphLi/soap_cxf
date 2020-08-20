package com.ky.soap_cxf.dao;

import com.ky.common.bean.MbFolDiaBean;
import com.ky.common.bean.MbFolHypBean;
import org.json.JSONObject;

import java.util.Date;
import java.util.Map;

/**
 * Code by lzp on 2020/8/19
 */
public class KyMbDao {
    /**
     * 更新
     */
    public static void updateWdEhr() {
    }

    /**
     * 添加糖尿病随访记录
     *
     *
     * @param IDMap
     * @param tnbFol
     * @param tnbFolDetail
     * @return
     */
    public static MbFolDiaBean addMbTnb(Map<String, Object> IDMap, JSONObject tnbFol, JSONObject tnbFolDetail) {
        MbFolDiaBean mbTnb = new MbFolDiaBean();

        return mbTnb;
    }

    /**
     * 添加高血压随访记录
     *
     *
     * @param IDMap
     * @param GxyFol
     * @param gxyFolDetail
     * @return
     */
    public static MbFolHypBean addMbGxy(Map<String, Object> IDMap, JSONObject GxyFol, JSONObject gxyFolDetail) {
        MbFolHypBean mbGxy = new MbFolHypBean();
        //详细高血压随访记录数据
        String ID = GxyFol.get("ID").toString();
        //主键uuid
        //随访来源，TQ ，APP
        mbGxy.setOrigin("TQ");
        //随访照片url
        //随访照片url
        //未拍照原因
        //管理卡主键
        //被访人档案号
        //医生id
        //医生签名
        mbGxy.setDoctorName(GxyFol.get("DoctorName").toString());
        //随访机构
        mbGxy.setOrgId(IDMap.get("orgId").toString());
        //随访机构名称
        mbGxy.setOrgName(IDMap.get("orgName").toString());
        //姓名
        mbGxy.setName(GxyFol.get("PersonName").toString());
        //随访方式
        mbGxy.setFollowUpStyle(gxyFolDetail.get("WayUp").toString());
        //随访日期
        mbGxy.setFollowUpDate((Date) GxyFol.get("FollowUpDateStr"));
        //症状
        //其他症状
        //血压-收缩压
        mbGxy.setHighPressure((Integer) GxyFol.get("Sbp"));
        //血压-舒张压
        mbGxy.setLowPressure((Integer) GxyFol.get("Dbp"));
        //身高
        mbGxy.setHeight(Double.parseDouble(gxyFolDetail.getJSONObject("body").get("Height").toString()));
        //体重
        mbGxy.setWeight(Double.parseDouble(gxyFolDetail.getJSONObject("body").get("Weight").toString()));
        //下一次期望体重
        mbGxy.setWeightExp(Double.parseDouble(gxyFolDetail.getJSONObject("body").get("NextWeight").toString()));
        //bmi
        mbGxy.setBmi(Double.parseDouble(gxyFolDetail.getJSONObject("body").get("Bmi").toString()));
        //下一次随访期望的bmi

        //心率
        mbGxy.setHeartRate(Integer.parseInt(gxyFolDetail.getJSONObject("body").get("HeartRate").toString()));
        //足背动脉搏动
        //足背动脉搏动减弱或者消失的位置
        //其他体征
        mbGxy.setSignOther(gxyFolDetail.getJSONObject("CmHypertension").get("ExamBodyOther").toString());
        //日吸烟量
        mbGxy.setCountCigarette(gxyFolDetail.getJSONObject("lifeStyle").get("Smoking").toString());
        //下一次随访期望的日吸烟量
        mbGxy.setCountCigaretteExp(gxyFolDetail.getJSONObject("CmHypertension").get("NextSmoking").toString());
        //日饮酒量
        mbGxy.setCountWine(gxyFolDetail.getJSONObject("lifeStyle").get("DailyAlcoholIntake").toString());
        //下一次随访期望的日饮酒量
        mbGxy.setCountWineExp(gxyFolDetail.getJSONObject("CmHypertension").get("NextDailyAlcohol").toString());
        //运动量
        mbGxy.setExercise(gxyFolDetail.getJSONObject("lifeStyle").get("EachExerciseTime").toString());
        //运动频率
        mbGxy.setFrequency(gxyFolDetail.getJSONObject("lifeStyle").get("ExerciseWeekTimes").toString());
        //下一次随访期望的运动量
        mbGxy.setExerciseExp(gxyFolDetail.getJSONObject("CmHypertension").get("NextExerciseWeekMinute").toString());
        //目标运动频率
        //主食
        //目标主食
        //心理调整
        //遵医行为
        //空腹血糖
        //糖化血糖蛋白
        //糖化血糖蛋白检查时间
        //糖化血红蛋白备注
        //胰岛素
        //胰岛素用量
        //当前用药情况
        //调整用药情况
        //服药依从性
        //药物不良反应
        //药物不良反应描述
        //低血糖反应
        //（单选）此次随访分类1满意2不满意3不良反应4并发症
        //（多选）3不良反应4并发症【前端 传值字符串，以，分割】
        //下一步管理措施
        //调整胰岛素
        //调整胰岛素用量
        //转诊原因
        //转诊机构和科别
        //转诊联系人
        //联系人电话
        //转诊结果
        //下次随访时间
        //被随访人签名
        //被随访人签名照
        //健康指导
        //随访是否规范
        //备注
        //经度
        //纬度
        //随访定位
        //失访日期
        //失访原因
        //死亡日期
        //死亡原因
        //状态，1 正常，2已删除
        //随访创建时间
        //公卫随访id（公卫系统中）
        //随访人档案号（公卫系统中）
        //随访人公卫档案状态
        //随访人公卫档案状态描述
        //随访记录上传状态
        //随访记录上传公卫状态描述
        //公卫上传时间
        //公卫上传更新时间
        //更新时间
        //备用
        //

        return mbGxy;
    }
}
