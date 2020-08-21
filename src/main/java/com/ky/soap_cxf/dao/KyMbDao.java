package com.ky.soap_cxf.dao;

import com.ky.common.bean.EhrBean;
import com.ky.common.bean.MbFolDiaBean;
import com.ky.common.bean.MbFolHypBean;
import com.ky.common.bean.MbGlkHypBean;
import org.json.JSONObject;

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
