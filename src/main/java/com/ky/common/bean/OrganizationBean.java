package com.ky.common.bean;

import java.util.Date;

public class OrganizationBean {
    private String orgId;

    private String id;

    private String teamId;

    private String username;

    private String pwd;

    private String name;

    private Integer level;

    private String parentId;

    private String parentTel;

    private String linkman;

    private String linkTel;

    private Date createTime;

    private String extend;

    private String yyCode;

    private String zlServerAddress;

    private String zlUser;

    private String zlPasswd;

    private Integer enable;

    private Integer sort;

    private Integer zhFlag;

    private Integer isTq;

    private Integer xqrk;

    private String erweima;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId == null ? null : teamId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
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

    public String getParentTel() {
        return parentTel;
    }

    public void setParentTel(String parentTel) {
        this.parentTel = parentTel == null ? null : parentTel.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getLinkTel() {
        return linkTel;
    }

    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel == null ? null : linkTel.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
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

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getZhFlag() {
        return zhFlag;
    }

    public void setZhFlag(Integer zhFlag) {
        this.zhFlag = zhFlag;
    }

    public Integer getIsTq() {
        return isTq;
    }

    public void setIsTq(Integer isTq) {
        this.isTq = isTq;
    }

    public Integer getXqrk() {
        return xqrk;
    }

    public void setXqrk(Integer xqrk) {
        this.xqrk = xqrk;
    }

    public String getErweima() {
        return erweima;
    }

    public void setErweima(String erweima) {
        this.erweima = erweima == null ? null : erweima.trim();
    }
}