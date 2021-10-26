package com.cs.dipocketback.pojo.registration;

public class CheckPhoneRequest {
    
    private String phoneNum;
    private Integer langId;
    private Boolean registered;
    private Integer smsCodeNo;
    
    public CheckPhoneRequest() {
    }

    public void setPhoneNum(String phone) {
        this.phoneNum = phone;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setRegistered(Boolean registered) {
        this.registered = registered;
    }

    public Boolean getRegistered() {
        return registered;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

    public Integer getLangId() {
        return langId;
    }

    public void setSmsCodeNo(Integer smsCodeNo) {
        this.smsCodeNo = smsCodeNo;
    }

    public Integer getSmsCodeNo() {
        return smsCodeNo;
    }
    
}
