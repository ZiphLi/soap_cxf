package com.ky.common.bean;

import java.util.Date;
import java.util.List;

public class WdMbHyperFol {

    /**
     * 档案号id (平邑)
     */
    private String dah;

    public String getDah() {
        return dah;
    }

    public void setDah(String dah) {
        this.dah = dah;
    }

    /**
     * 公卫记录id (平邑)
     */
    private String GwId;

    public String getGwId() {
        return GwId;
    }

    public void setGwId(String gwId) {
        GwId = gwId;
    }


    private String histtoryUrl;
    private String uuid;

    private String orgin;

    private String folUrl;

    private String idno;

    private String doctorId;

    private String doctorName;

    private String doctorSignUrl;

    private String teamId;

    private String orgId;

    private String orgName;

    private Date birthday;

    private String name;

    private String identifier;

    private String followUpStyle;

    private Date followUpDate;

    private String symptom;

    private String symptomOther;

    private Integer highPressure;

    private Integer lowPressure;

    private Double height;

    private Double weight;

    private Double weightExp;

    private Double bmi;

    private Double bmiExp;

    private Integer heartRate;

    private String signOther;

    private String countCigarette;

    private String countCigaretteExp;

    private String countWine;

    private String countWineExp;

    private String exercise;

    private String frequency;

    private String exerciseExp;

    private String frequencyExp;

    private String saltSituation;

    private String saltSituationExp;

    private String psyRecovery;

    private String treatmentCompliance;

    private String otherCheck;

    private String medicationCompliance;

    private String adverceReactionCode;

    private String adverceReactionDetail;

    private String classifyFollowUp;

    private String managementNextStep;

    private String transferReason;

    private String transferOrg;

    private String contractName;

    private String contractTel;

    private String transferResult;

    private Date nextDate;

    private String juminName;

    private String juminNameUrl;

    private String remarks;

    private Date lostDate;

    private String lostReason;

    private Date deathDate;

    private String deathReason;

    private String gwSfId;

    private String gwGlkId;

    private String gwDahId;

    private String gwSfDah;

    private String gwDaStatus;

    private String gwDaMsg;

    private String gwUpFlag;

    private String gwUpMsg;

    private Date gwUpCreateTime;

    private Date gwUpUpdateTime;

    private List<WdMbMedicine> nowMedList;
    private  List<WdMbMedicine> adjustMedList;

    public String getGwDahId () {
        return gwDahId;
    }

    public void setGwDahId (String gwDahId) {
        this.gwDahId = gwDahId;
    }

    public String getGwGlkId () {
        return gwGlkId;
    }

    public void setGwGlkId (String gwGlkId) {
        this.gwGlkId = gwGlkId;
    }

    public List<WdMbMedicine> getNowMedList () {
        return nowMedList;
    }

    public void setNowMedList (List<WdMbMedicine> nowMedList) {
        this.nowMedList = nowMedList;
    }

    public List<WdMbMedicine> getAdjustMedList () {
        return adjustMedList;
    }

    public void setAdjustMedList (List<WdMbMedicine> adjustMedList) {
        this.adjustMedList = adjustMedList;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getOrgin() {
        return orgin;
    }

    public void setOrgin(String orgin) {
        this.orgin = orgin == null ? null : orgin.trim();
    }

    public String getFolUrl() {
        return folUrl;
    }

    public void setFolUrl(String folUrl) {
        this.folUrl = folUrl == null ? null : folUrl.trim();
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno == null ? null : idno.trim();
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
    }

    public String getDoctorSignUrl() {
        return doctorSignUrl;
    }

    public void setDoctorSignUrl(String doctorSignUrl) {
        this.doctorSignUrl = doctorSignUrl == null ? null : doctorSignUrl.trim();
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId == null ? null : teamId.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier == null ? null : identifier.trim();
    }

    public String getFollowUpStyle() {
        return followUpStyle;
    }

    public void setFollowUpStyle(String followUpStyle) {
        this.followUpStyle = followUpStyle == null ? null : followUpStyle.trim();
    }

    public Date getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(Date followUpDate) {
        this.followUpDate = followUpDate;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom == null ? null : symptom.trim();
    }

    public String getSymptomOther() {
        return symptomOther;
    }

    public void setSymptomOther(String symptomOther) {
        this.symptomOther = symptomOther == null ? null : symptomOther.trim();
    }

    public Integer getHighPressure() {
        return highPressure;
    }

    public void setHighPressure(Integer highPressure) {
        this.highPressure = highPressure;
    }

    public Integer getLowPressure() {
        return lowPressure;
    }

    public void setLowPressure(Integer lowPressure) {
        this.lowPressure = lowPressure;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeightExp() {
        return weightExp;
    }

    public void setWeightExp(Double weightExp) {
        this.weightExp = weightExp;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Double getBmiExp() {
        return bmiExp;
    }

    public void setBmiExp(Double bmiExp) {
        this.bmiExp = bmiExp;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public String getSignOther() {
        return signOther;
    }

    public void setSignOther(String signOther) {
        this.signOther = signOther == null ? null : signOther.trim();
    }

    public String getCountCigarette() {
        return countCigarette;
    }

    public void setCountCigarette(String countCigarette) {
        this.countCigarette = countCigarette == null ? null : countCigarette.trim();
    }

    public String getCountCigaretteExp() {
        return countCigaretteExp;
    }

    public void setCountCigaretteExp(String countCigaretteExp) {
        this.countCigaretteExp = countCigaretteExp == null ? null : countCigaretteExp.trim();
    }

    public String getCountWine() {
        return countWine;
    }

    public void setCountWine(String countWine) {
        this.countWine = countWine == null ? null : countWine.trim();
    }

    public String getCountWineExp() {
        return countWineExp;
    }

    public void setCountWineExp(String countWineExp) {
        this.countWineExp = countWineExp == null ? null : countWineExp.trim();
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise == null ? null : exercise.trim();
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency == null ? null : frequency.trim();
    }

    public String getExerciseExp() {
        return exerciseExp;
    }

    public void setExerciseExp(String exerciseExp) {
        this.exerciseExp = exerciseExp == null ? null : exerciseExp.trim();
    }

    public String getFrequencyExp() {
        return frequencyExp;
    }

    public void setFrequencyExp(String frequencyExp) {
        this.frequencyExp = frequencyExp == null ? null : frequencyExp.trim();
    }

    public String getSaltSituation() {
        return saltSituation;
    }

    public void setSaltSituation(String saltSituation) {
        this.saltSituation = saltSituation == null ? null : saltSituation.trim();
    }

    public String getSaltSituationExp() {
        return saltSituationExp;
    }

    public void setSaltSituationExp(String saltSituationExp) {
        this.saltSituationExp = saltSituationExp == null ? null : saltSituationExp.trim();
    }

    public String getPsyRecovery() {
        return psyRecovery;
    }

    public void setPsyRecovery(String psyRecovery) {
        this.psyRecovery = psyRecovery == null ? null : psyRecovery.trim();
    }

    public String getTreatmentCompliance() {
        return treatmentCompliance;
    }

    public void setTreatmentCompliance(String treatmentCompliance) {
        this.treatmentCompliance = treatmentCompliance == null ? null : treatmentCompliance.trim();
    }

    public String getOtherCheck() {
        return otherCheck;
    }

    public void setOtherCheck(String otherCheck) {
        this.otherCheck = otherCheck == null ? null : otherCheck.trim();
    }

    public String getMedicationCompliance() {
        return medicationCompliance;
    }

    public void setMedicationCompliance(String medicationCompliance) {
        this.medicationCompliance = medicationCompliance == null ? null : medicationCompliance.trim();
    }

    public String getAdverceReactionCode() {
        return adverceReactionCode;
    }

    public void setAdverceReactionCode(String adverceReactionCode) {
        this.adverceReactionCode = adverceReactionCode == null ? null : adverceReactionCode.trim();
    }

    public String getAdverceReactionDetail() {
        return adverceReactionDetail;
    }

    public void setAdverceReactionDetail(String adverceReactionDetail) {
        this.adverceReactionDetail = adverceReactionDetail == null ? null : adverceReactionDetail.trim();
    }

    public String getClassifyFollowUp() {
        return classifyFollowUp;
    }

    public void setClassifyFollowUp(String classifyFollowUp) {
        this.classifyFollowUp = classifyFollowUp == null ? null : classifyFollowUp.trim();
    }

    public String getManagementNextStep() {
        return managementNextStep;
    }

    public void setManagementNextStep(String managementNextStep) {
        this.managementNextStep = managementNextStep == null ? null : managementNextStep.trim();
    }

    public String getTransferReason() {
        return transferReason;
    }

    public void setTransferReason(String transferReason) {
        this.transferReason = transferReason == null ? null : transferReason.trim();
    }

    public String getTransferOrg() {
        return transferOrg;
    }

    public void setTransferOrg(String transferOrg) {
        this.transferOrg = transferOrg == null ? null : transferOrg.trim();
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    public String getContractTel() {
        return contractTel;
    }

    public void setContractTel(String contractTel) {
        this.contractTel = contractTel == null ? null : contractTel.trim();
    }

    public String getTransferResult() {
        return transferResult;
    }

    public void setTransferResult(String transferResult) {
        this.transferResult = transferResult == null ? null : transferResult.trim();
    }

    public Date getNextDate() {
        return nextDate;
    }

    public void setNextDate(Date nextDate) {
        this.nextDate = nextDate;
    }

    public String getJuminName() {
        return juminName;
    }

    public void setJuminName(String juminName) {
        this.juminName = juminName == null ? null : juminName.trim();
    }

    public String getJuminNameUrl() {
        return juminNameUrl;
    }

    public void setJuminNameUrl(String juminNameUrl) {
        this.juminNameUrl = juminNameUrl == null ? null : juminNameUrl.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getLostDate() {
        return lostDate;
    }

    public void setLostDate(Date lostDate) {
        this.lostDate = lostDate;
    }

    public String getLostReason() {
        return lostReason;
    }

    public void setLostReason(String lostReason) {
        this.lostReason = lostReason == null ? null : lostReason.trim();
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public String getDeathReason() {
        return deathReason;
    }

    public void setDeathReason(String deathReason) {
        this.deathReason = deathReason == null ? null : deathReason.trim();
    }

    public String getGwSfId() {
        return gwSfId;
    }

    public void setGwSfId(String gwSfId) {
        this.gwSfId = gwSfId == null ? null : gwSfId.trim();
    }

    public String getGwSfDah() {
        return gwSfDah;
    }

    public void setGwSfDah(String gwSfDah) {
        this.gwSfDah = gwSfDah == null ? null : gwSfDah.trim();
    }

    public String getGwDaStatus() {
        return gwDaStatus;
    }

    public void setGwDaStatus(String gwDaStatus) {
        this.gwDaStatus = gwDaStatus == null ? null : gwDaStatus.trim();
    }

    public String getGwDaMsg() {
        return gwDaMsg;
    }

    public void setGwDaMsg(String gwDaMsg) {
        this.gwDaMsg = gwDaMsg == null ? null : gwDaMsg.trim();
    }

    public String getGwUpFlag() {
        return gwUpFlag;
    }

    public void setGwUpFlag(String gwUpFlag) {
        this.gwUpFlag = gwUpFlag == null ? null : gwUpFlag.trim();
    }

    public String getGwUpMsg() {
        return gwUpMsg;
    }

    public void setGwUpMsg(String gwUpMsg) {
        this.gwUpMsg = gwUpMsg == null ? null : gwUpMsg.trim();
    }

    public Date getGwUpCreateTime() {
        return gwUpCreateTime;
    }

    public void setGwUpCreateTime(Date gwUpCreateTime) {
        this.gwUpCreateTime = gwUpCreateTime;
    }

    public Date getGwUpUpdateTime() {
        return gwUpUpdateTime;
    }

    public String getHisttoryUrl () {
        return histtoryUrl;
    }

    public void setHisttoryUrl (String histtoryUrl) {
        this.histtoryUrl = histtoryUrl;
    }

    public void setGwUpUpdateTime(Date gwUpUpdateTime) {
        this.gwUpUpdateTime = gwUpUpdateTime;
    }


}