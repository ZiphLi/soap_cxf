package com.ky.soap_cxf.dao;

import com.ky.common.bean.EhrBean;
import com.ky.common.bean.MbFolDiaBean;
import com.ky.common.bean.MbFolHypBean;
import com.ky.common.bean.MbGlkHypBean;
import com.ky.core.util.DateUtil;
import com.ky.core.util.StringUtil;
import com.ky.soap_cxf.help.MbHelp;
import org.json.JSONObject;
import sun.misc.GC;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

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
     * @param IDMap
     * @param tnbFol
     * @param tnbFolDetail
     * @return
     */
    public static MbFolDiaBean addMbTnb(Map<String, Object> IDMap, JSONObject tnbFol, JSONObject tnbFolDetail) {
        MbFolDiaBean mbTnb = new MbFolDiaBean();
        //id	主键uuid
        mbTnb.setId(UUID.randomUUID().toString());
        //origin	随访来源，TQ ，APP
        mbTnb.setOrigin("TQ");
        //fol_url1	随访照片url
        //fol_url2	随访照片url
        //wpzyy	未拍照原因
        //card_id	管理卡主键
        //ehr_id	被访人档案号
        //doctor_id	医生id
        //doctor_name	医生签名
        //org_id	随访机构
        //org_name	随访机构名称
        //name	姓名
        //follow_up_style	随访方式
        //follow_up_date	随访日期
        //symptom	症状
        //symptom_other	其他症状
        //high_pressure	血压-收缩压
        //low_pressure	血压-舒张压
        //height	身高
        //weight	体重
        //weight_exp	下一次期望体重
        //bmi	bmi
        //bmi_exp	下一次随访期望的bmi
        //heart_rate	心率
        //foot_pulstates	足背动脉搏动
        //foot_pilstates_where	足背动脉搏动减弱或者消失的位置
        //sign_other	其他体征
        //count_cigarette	日吸烟量
        //count_cigarette_exp	下一次随访期望的日吸烟量
        //count_wine	日饮酒量
        //count_wine_exp	下一次随访期望的日饮酒量
        //exercise	运动量
        //frequency	运动频率
        //exercise_exp	下一次随访期望的运动量
        //frequency_exp	目标运动频率
        //staple_food	主食
        //stable_food_exp	目标主食
        //psy_recovery	心理调整
        //treatment_compliance	遵医行为
        //glu	空腹血糖
        //GHb	糖化血糖蛋白
        //GHb_date	糖化血糖蛋白检查时间
        //GHb_other	糖化血红蛋白备注
        //insulin_variety	胰岛素
        //insulin_directions	胰岛素用量
        //medication	当前用药情况
        //medication_exp	调整用药情况
        //medication_compliance	服药依从性
        //adverce_reaction_code	药物不良反应
        //adverce_reaction_detail	药物不良反应描述
        //hypoglycemia_reaction	低血糖反应
        //classify_follow_up	（单选）此次随访分类1满意2不满意3不良反应4并发症
        //classify_follow_up1	（多选）3不良反应4并发症【前端 传值字符串，以，分割】
        //management_next_step	下一步管理措施
        //insulin_adjustmment_variety	调整胰岛素
        //insulin_adjustmment_directions	调整胰岛素用量
        //transfer_reason	转诊原因
        //transfer_org	转诊机构和科别
        //contract_name	转诊联系人
        //contract_tel	联系人电话
        //transfer_result	转诊结果
        //next_date	下次随访时间
        //jumin_name	被随访人签名
        //jumin_name_url	被随访人签名照
        //jkzd	健康指导
        //is_standard	随访是否规范
        //remarks	备注
        //latitude	经度
        //longitude	纬度
        //location	随访定位
        //lost_date	失访日期
        //lost_reason	失访原因
        //death_date	死亡日期
        //death_reason	死亡原因
        //status	状态，1 正常，2已删除
        //create_time	随访创建时间
        //gw_sf_id	公卫随访id（公卫系统中）
        //gw_sf_dah	随访人档案号（公卫系统中）
        //gw_da_status	随访人公卫档案状态
        //gw_da_msg	随访人公卫档案状态描述
        //gw_up_flag	随访记录上传状态
        //gw_up_msg	随访记录上传公卫状态描述
        //gw_up_create_time	公卫上传时间
        //gw_up_update_time	公卫上传更新时间
        //update_time	更新时间
        //field	备用
        return mbTnb;
    }

    /**
     * 添加高血压随访记录
     *
     * @param IDMap
     * @param GxyFol
     * @param gxyFolDetail
     * @return
     */
    public static MbFolHypBean addMbGxy(Map<String, Object> IDMap, JSONObject GxyFol, JSONObject gxyFolDetail) {
        MbFolHypBean mbGxy = new MbFolHypBean();
        //id	主键id
        mbGxy.setId(UUID.randomUUID().toString());
        //origin	随访来源 TQ ，APP
        mbGxy.setOrigin("TQ");
        //fol_url1	随访照片url
        //fol_url2	随访照片url
        //wpzyy	未拍照原因
        //card_id	管理卡主键
        mbGxy.setCardId(IDMap.get("gxyGlkId").toString());
        //ehr_id	被访人档案号（公司自建档案号）
        mbGxy.setEhrId(IDMap.get("ehrId").toString());
        //doctor_id	医生id
        mbGxy.setDoctorId(gxyFolDetail.getJSONObject("cmHypertension").get("DoctorID").toString());
        //doctor_name	医生签名
        mbGxy.setDoctorName(gxyFolDetail.getJSONObject("cmHypertension").get("DoctorName").toString());
        //org_id	随访机构
        mbGxy.setOrgId(IDMap.get("orgId").toString());
        //org_name	随访机构名称
        mbGxy.setOrgName(IDMap.get("orgName").toString());
        //name	姓名
        mbGxy.setName(GxyFol.get("PersonName").toString());
        //follow_up_style	随访方式
        mbGxy.setFollowUpStyle(gxyFolDetail.getJSONObject("cmHypertension").get("WayUp").toString());
        //follow_up_date	随访日期
        mbGxy.setFollowUpDate(DateUtil.getFormatDateTimeStringForDate(GxyFol.get("FollowUpDateStr").toString()));
        //symptom	症状
        mbGxy.setSymptom(GxyFol.get("SymptomStr").toString());
        //symptom_other	其他症状
        mbGxy.setSymptomOther(GxyFol.get("SymptomLiteStr").toString());
        //血压-收缩压
        String Sbp = StringUtil.getRealStringByStr(GxyFol.get("Sbp").toString());
        if (!StringUtil.isEmpty(Sbp)) {
            mbGxy.setHighPressure(Integer.parseInt(Sbp));
        }
        //血压-舒张压
        String Dbp = StringUtil.getRealStringByStr(GxyFol.get("Dbp").toString());
        if (!StringUtil.isEmpty(Dbp)) {
            mbGxy.setLowPressure(Integer.parseInt(Dbp));
        }
        //身高
        String Height = StringUtil.getRealStringByStr(gxyFolDetail.getJSONObject("examBody").get("Height").toString());
        if (!StringUtil.isEmpty(Height)) {
            mbGxy.setHeight(Double.parseDouble(Height));
        }
        //体重
        String Weight = StringUtil.getRealStringByStr(gxyFolDetail.getJSONObject("examBody").get("Weight").toString());
        if (!StringUtil.isEmpty(Weight)) {
            mbGxy.setWeight(Double.parseDouble(Weight));
        }
        //下一次期望体重
        String NextWeight = StringUtil.getRealStringByStr(gxyFolDetail.getJSONObject("cmHypertension").get("NextWeight").toString());
        if (!StringUtil.isEmpty(NextWeight)) {
            mbGxy.setWeightExp(Double.parseDouble(NextWeight));
        }
        //bmi
        DecimalFormat df = new DecimalFormat("######0.00");
        String Bmi = StringUtil.getRealStringByStr(gxyFolDetail.getJSONObject("examBody").get("Bmi").toString());
        if (!StringUtil.isEmpty(Bmi)) {
            mbGxy.setBmi(Double.parseDouble(Bmi));
        }

        //bmi_exp	下一次随访期望的bmi
        if (!StringUtil.isEmpty(Height) && !StringUtil.isEmpty(NextWeight)) {
            mbGxy.setBmiExp(StringUtil.getBmi(Double.parseDouble(Height), Double.parseDouble(NextWeight)));//下次随访期望bmi double
        }
        //heart_rate	心率
        String HeartRate = StringUtil.getRealStringByStr(gxyFolDetail.getJSONObject("examBody").get("HeartRate").toString());
        if (!StringUtil.isEmpty(HeartRate)) {
            mbGxy.setHeartRate(Integer.parseInt(HeartRate));
        }
        //其他体征
        mbGxy.setSignOther(gxyFolDetail.getJSONObject("cmHypertension").get("ExamBodyOther").toString());
        //日吸烟量
        mbGxy.setCountCigarette(gxyFolDetail.getJSONObject("examLifestyle").get("Smoking").toString());
        //下一次随访期望的日吸烟量
        mbGxy.setCountCigaretteExp(gxyFolDetail.getJSONObject("cmHypertension").get("NextSmoking").toString());
        //日饮酒量
        mbGxy.setCountWine(gxyFolDetail.getJSONObject("examLifestyle").get("DailyAlcoholIntake").toString());
        //下一次随访期望的日饮酒量
        mbGxy.setCountWineExp(gxyFolDetail.getJSONObject("cmHypertension").get("NextDailyAlcohol").toString());
        //运动量
        mbGxy.setExercise(gxyFolDetail.getJSONObject("examLifestyle").get("EachExerciseTime").toString());
        //运动频率
        mbGxy.setFrequency(gxyFolDetail.getJSONObject("examLifestyle").get("ExerciseWeekTimes").toString());
        //下一次随访期望的运动量
        mbGxy.setExerciseExp(gxyFolDetail.getJSONObject("cmHypertension").get("NextExerciseWeekMinute").toString());
        //frequency_exp	目标运动频率
        mbGxy.setFrequencyExp(gxyFolDetail.getJSONObject("cmHypertension").get("NextExerciseWeekTimes").toString());
        //salt_situation	摄盐情况
        mbGxy.setSaltSituation(gxyFolDetail.getJSONObject("cmHypertension").get("SaltIntake").toString());
        //salt_situation_exp	目标摄盐情况
        mbGxy.setSaltSituationExp(gxyFolDetail.getJSONObject("cmHypertension").get("NextSaltIntake").toString());
        //psy_recovery	心理调整
        mbGxy.setPsyRecovery(gxyFolDetail.getJSONObject("cmHypertension").get("PsychologicalAdjustment").toString());
        //treatment_compliance	遵医行为
        mbGxy.setTreatmentCompliance(gxyFolDetail.getJSONObject("cmHypertension").get("ComplianceBehavior").toString());
        //other_check	辅助检查 ???
        //        "labora": {
        //            "ID": "辅助检查ID",
        //                    "FastingBloodGlucose": "空腹血糖float",
        //                    "PostprandialBloodGlucose": "餐后血糖float",
        //                    "RandomBloodGlucose": "随机血糖float",
        //                    "Hemoglobin": "血红蛋白float",
        //                    "Leukocyte": "白细胞varchar(50)",
        //                    "Platelet": "血小板varchar50",
        //                    "OtherBlood": "血常规其他varchar(200)",
        //                    "UrineProtein": "尿蛋白varchar(50)+-",
        //                    "Urine": "尿糖(50)+-",
        //                    "Ketone": "尿酮体(50)+-",
        //                    "OccultBloodInUrine": "尿潜血varchar(50)+-",
        //                    "OtherUrine": "尿常规其他varchaar(200)",
        //                    "UrinaryAlbumin": "尿微量白蛋白float",
        //                    "FecalOccultBlood": "大便潜血integer: 1 阴性 2 阳性",
        //                    "SerumAla": "血清谷丙转氨酶float",
        //                    "SerumAa": "血清谷草转氨酶float",
        //                    "Albumin": "白蛋白float",
        //                    "TotalBilirubin": "总胆红素float",
        //                    "Bilirubin": "结合胆红素float",
        //                    "SerumCreatinine": "血清肌酐float",
        //                    "Bun": "血尿素氮float",
        //                    "PotassiumConcentration": "血钾浓度float",
        //                    "SodiumConcentration": "血钠浓度float",
        //                    "TotalCholesterol": "总胆固醇float",
        //                    "Triglycerides": "甘油三酯float",
        //                    "GPT": "GPT varchar50",
        //                    "LdlCholesterol": "血清低密度脂蛋白胆固醇float",
        //                    "HdlCholesterol": "血清高密度脂蛋白胆固醇float",
        //                    "GlycatedHemoglobin": "糖化血红蛋白float",
        //                    "HepatitisBSurfaceAntigen": "乙型肝炎表面抗原varchar50",
        //                    "Ecg": "心电图varchar(100) 1 正常 2 异常 格式：1\u0001",
        //                    "ChestXRay": "胸部X线片 1正常2异常 格式：2\u0001胸部太大",
        //                    "BUltrasonicWave": "B超1正常2异常 格式：1\u0001",
        //                    "CervicalSmear": "宫颈涂片0未选择1正常2异常 格式： 0\u0001",
        //                    "OtherLaboratory": "辅助检查其他varchar（200）",
        //                    "ExamDate": "检查日期",
        //                    "Erythrocytes": "红细胞varchar50",
        //                    "DifferentialCount": "白细胞分类计数varchar50",
        //                    "BloodTransaminase": "血转氨酶float",
        //                    "Sg": "尿比重varchar50",
        //                    "Ph": "尿酸碱度varchar50",
        //                    "Ng": "淋球菌varchar50",
        //                    "Tppa": "梅毒螺旋体抗体varchar50",
        //                    "Hiv": "HIV抗体varchar50"
        //        }

        //medication	当前服药情况
        mbGxy.setMedication(gxyFolDetail.getJSONArray("drugJson").toString());
        //medication_exp	调整用药 (无)
        //medication_compliance	服药依从性
        mbGxy.setMedicationCompliance(gxyFolDetail.getJSONObject("cmHypertension").get("MedicationCompliance").toString());
        //adverce_reaction_code	药物不良反应
        mbGxy.setMedicationCompliance(gxyFolDetail.getJSONObject("cmHypertension").get("AdverseDrugReactions").toString());
        //adverce_reaction_detail	药物不良反应描述
//        mbGxy.setMedicationCompliance(gxyFolDetail.getJSONArray("otherJson").toString());
        //classify_follow_up	此次随访分类1满意2不满意3不良反应4并发症
        mbGxy.setMedicationCompliance(gxyFolDetail.getJSONObject("cmHypertension").get("FuClassification").toString());
        //classify_follow_up1	3不良反应4并发症
        //management_next_step	下一步管理措施

        //transfer_reason	转诊原因

        //transfer_org	转诊机构和科别

        //contract_name	转诊联系人

        //contract_tel	联系人电话

        //transfer_result	转诊结果

        //contract_impression	初步印象 四川公卫

        //contract_jws	既往史 四川公卫

        //contract_cure	治疗经过 四川公卫

        //next_date	下次随访时间
        if (gxyFolDetail.getJSONObject("cmHypertension").get("NextFollowUpDate").toString().length() > 6) {
            mbGxy.setNextDate(MbHelp.encodeNextDate(gxyFolDetail.getJSONObject("cmHypertension").get("NextFollowUpDate").toString()));
        }
        //jumin_name	被随访人签名
        mbGxy.setJuminName(GxyFol.get("PersonName").toString());
        //jumin_name_url	被随访人签名照

        //is_standard	随访是否标准

        //jkzd	健康指导

        //remarks	备注
        //longitude	经度
        //latitude	纬度
        //location	随访定位
        //lost_date	失访日期
        //lost_reason	失访原因
        //death_date	死亡日期
        //death_reason	死亡原因
        //status	状态，1 正常，2已删除
        mbGxy.setStatus("1");
        //create_time	创建时间
        mbGxy.setCreateTime(new Date());
        //gw_sf_id	公卫随访id（公卫系统中）
        mbGxy.setGwSfId(GxyFol.get("ID").toString());
        //gw_sf_dah	随访人档案号（公卫系统中）
        mbGxy.setGwSfDah(IDMap.get("ehrId").toString());
        //gw_da_status	随访人公卫档案状态
        //gw_da_msg	随访人公卫档案状态描述
        //gw_up_flag	随访记录上传状态
        //gw_up_msg	随访记录上传公卫状态描述
        //gw_up_create_time	公卫上传时间
        //gw_up_update_time	公卫上传更新时间
        //update_time	更新时间
        //field

        return mbGxy;
    }

    /**
     * 添加高血压管理卡
     *
     * @param ehrBean
     * @param gxyGlkMsg
     * @param IDMap
     * @param wdEhr
     * @return
     */
    public static MbGlkHypBean addGlkGxy(EhrBean ehrBean, JSONObject gxyGlkMsg, Map<String, Object> IDMap, JSONObject wdEhr) {
        MbGlkHypBean gxyGlk = new MbGlkHypBean();
        //id	主键
        gxyGlk.setId(UUID.randomUUID().toString());
        //ehr_id	档案主键
        gxyGlk.setEhrId(wdEhr.get("ID").toString());
        //idno	身份证号
        gxyGlk.setIdno(wdEhr.get("CARD_ID").toString());
        //name	姓名
        gxyGlk.setName(wdEhr.get("NAME").toString());
        //tel	电话
        gxyGlk.setTel(wdEhr.get("TELPHONE").toString());
        //type	高血压类型(不写)

        //birthday	生日
        gxyGlk.setBirthday(ehrBean.getBirthday());
        //org_id	卫生室id
        gxyGlk.setOrgId(IDMap.get("orgId").toString());
        //org_name	卫生室名
        gxyGlk.setOrgName(IDMap.get("orgName").toString());
        //standard_body_id(不写)

        //standard_follow_id	随访标准id(不写)

        //plan_date	应随访时间(下次随访时间)(之后获取)

        //img_url	上次随访照片(不写)

        //last_fol_id	随访主键，该计划由此随访产生 (最近一次随访记录id)(之后获取)

        //last_date

        //create_date	管理卡创建时间
        gxyGlk.setCreateDate(new Date());
        //status	1 有效 ； 0 删除；
        gxyGlk.setStatus("1");
        //is_precise

        //remarks

        //field
        return gxyGlk;
    }
}
