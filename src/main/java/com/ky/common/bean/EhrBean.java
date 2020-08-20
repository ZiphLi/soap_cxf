package com.ky.common.bean;

import java.util.Date;

public class EhrBean {
    private String id;

    private String name;

    private String idno;

    private String sex;

    private String address;

    private String tel;

    private Date birthday;

    private String nation;

    private String qyYear;

    private String mbTypeId;

    private String mbType;

    private String mbSpecialTypeId;

    private String mbSpecialType;

    private String qyType;

    private String gwDah;

    private String gwDahId;

    private String orgId;

    private String orgName;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private String status;

    private String origin;

    private String remarks;

    private String field;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno == null ? null : idno.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getQyYear() {
        return qyYear;
    }

    public void setQyYear(String qyYear) {
        this.qyYear = qyYear == null ? null : qyYear.trim();
    }

    public String getMbTypeId() {
        return mbTypeId;
    }

    public void setMbTypeId(String mbTypeId) {
        this.mbTypeId = mbTypeId == null ? null : mbTypeId.trim();
    }

    public String getMbType() {
        return mbType;
    }

    public void setMbType(String mbType) {
        this.mbType = mbType == null ? null : mbType.trim();
    }

    public String getMbSpecialTypeId() {
        return mbSpecialTypeId;
    }

    public void setMbSpecialTypeId(String mbSpecialTypeId) {
        this.mbSpecialTypeId = mbSpecialTypeId == null ? null : mbSpecialTypeId.trim();
    }

    public String getMbSpecialType() {
        return mbSpecialType;
    }

    public void setMbSpecialType(String mbSpecialType) {
        this.mbSpecialType = mbSpecialType == null ? null : mbSpecialType.trim();
    }

    public String getQyType() {
        return qyType;
    }

    public void setQyType(String qyType) {
        this.qyType = qyType == null ? null : qyType.trim();
    }

    public String getGwDah() {
        return gwDah;
    }

    public void setGwDah(String gwDah) {
        this.gwDah = gwDah == null ? null : gwDah.trim();
    }

    public String getGwDahId() {
        return gwDahId;
    }

    public void setGwDahId(String gwDahId) {
        this.gwDahId = gwDahId == null ? null : gwDahId.trim();
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field == null ? null : field.trim();
    }
}