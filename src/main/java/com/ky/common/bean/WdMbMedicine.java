package com.ky.common.bean;

public class WdMbMedicine {
    private String id;

    private String folType;

    private String mediStyle;

    private String filedid;

    private String sfz;

    private String name;

    private String timeUnit;

    private String time;

    private String amount;

    private String amountUnit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFolType() {
        return folType;
    }

    public void setFolType(String folType) {
        this.folType = folType == null ? null : folType.trim();
    }

    public String getMediStyle() {
        return mediStyle;
    }

    public void setMediStyle(String mediStyle) {
        this.mediStyle = mediStyle == null ? null : mediStyle.trim();
    }

    public String getFiledid() {
        return filedid;
    }

    public void setFiledid(String filedid) {
        this.filedid = filedid == null ? null : filedid.trim();
    }

    public String getSfz() {
        return sfz;
    }

    public void setSfz(String sfz) {
        this.sfz = sfz == null ? null : sfz.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit == null ? null : timeUnit.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getAmountUnit() {
        return amountUnit;
    }

    public void setAmountUnit(String amountUnit) {
        this.amountUnit = amountUnit == null ? null : amountUnit.trim();
    }
}