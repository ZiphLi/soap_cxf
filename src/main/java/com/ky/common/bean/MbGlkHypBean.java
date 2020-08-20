package com.ky.common.bean;

import java.util.Date;

public class MbGlkHypBean {
    private String id;

    private String ehrId;

    private String idno;

    private String name;

    private String tel;

    private String type;

    private Date birthday;

    private String orgId;

    private String orgName;

    private String standardBodyId;

    private String standardFollowId;

    private Date planDate;

    private String imgUrl;

    private String lastFolId;

    private Date lastDate;

    private Date createDate;

    private String status;

    private String isPrecise;

    private String remarks;

    private String field;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEhrId() {
        return ehrId;
    }

    public void setEhrId(String ehrId) {
        this.ehrId = ehrId == null ? null : ehrId.trim();
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno == null ? null : idno.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getStandardBodyId() {
        return standardBodyId;
    }

    public void setStandardBodyId(String standardBodyId) {
        this.standardBodyId = standardBodyId == null ? null : standardBodyId.trim();
    }

    public String getStandardFollowId() {
        return standardFollowId;
    }

    public void setStandardFollowId(String standardFollowId) {
        this.standardFollowId = standardFollowId == null ? null : standardFollowId.trim();
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getLastFolId() {
        return lastFolId;
    }

    public void setLastFolId(String lastFolId) {
        this.lastFolId = lastFolId == null ? null : lastFolId.trim();
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIsPrecise() {
        return isPrecise;
    }

    public void setIsPrecise(String isPrecise) {
        this.isPrecise = isPrecise == null ? null : isPrecise.trim();
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