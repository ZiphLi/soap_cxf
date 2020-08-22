package com.ky.common.bean;

import java.util.Date;

public class OrgBean {
    private String id;

    private String name;

    private Integer level;

    private String parentId;

    private String yyCode;

    private String zlServerAddress;

    private String zlUser;

    private String zlPasswd;

    private Integer xqrk;

    private String yyAddress;

    private String gwUrl;

    private String gwAccount;

    private String gwPassword;

    private String zrys;

    private Boolean enableFlag;

    private Boolean deleteFlag;

    private Date createTime;

    private Date updateTime;

    private String createUid;

    private String createName;

    private String updateUid;

    private String updateName;

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getYyCode() {
        return yyCode;
    }

    public void setYyCode(String yyCode) {
        this.yyCode = yyCode == null ? null : yyCode.trim();
    }

    public String getZlServerAddress() {
        return zlServerAddress;
    }

    public void setZlServerAddress(String zlServerAddress) {
        this.zlServerAddress = zlServerAddress == null ? null : zlServerAddress.trim();
    }

    public String getZlUser() {
        return zlUser;
    }

    public void setZlUser(String zlUser) {
        this.zlUser = zlUser == null ? null : zlUser.trim();
    }

    public String getZlPasswd() {
        return zlPasswd;
    }

    public void setZlPasswd(String zlPasswd) {
        this.zlPasswd = zlPasswd == null ? null : zlPasswd.trim();
    }

    public Integer getXqrk() {
        return xqrk;
    }

    public void setXqrk(Integer xqrk) {
        this.xqrk = xqrk;
    }

    public String getYyAddress() {
        return yyAddress;
    }

    public void setYyAddress(String yyAddress) {
        this.yyAddress = yyAddress == null ? null : yyAddress.trim();
    }

    public String getGwUrl() {
        return gwUrl;
    }

    public void setGwUrl(String gwUrl) {
        this.gwUrl = gwUrl == null ? null : gwUrl.trim();
    }

    public String getGwAccount() {
        return gwAccount;
    }

    public void setGwAccount(String gwAccount) {
        this.gwAccount = gwAccount == null ? null : gwAccount.trim();
    }

    public String getGwPassword() {
        return gwPassword;
    }

    public void setGwPassword(String gwPassword) {
        this.gwPassword = gwPassword == null ? null : gwPassword.trim();
    }

    public String getZrys() {
        return zrys;
    }

    public void setZrys(String zrys) {
        this.zrys = zrys == null ? null : zrys.trim();
    }

    public Boolean getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(Boolean enableFlag) {
        this.enableFlag = enableFlag;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
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

    public String getCreateUid() {
        return createUid;
    }

    public void setCreateUid(String createUid) {
        this.createUid = createUid == null ? null : createUid.trim();
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public String getUpdateUid() {
        return updateUid;
    }

    public void setUpdateUid(String updateUid) {
        this.updateUid = updateUid == null ? null : updateUid.trim();
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }
}