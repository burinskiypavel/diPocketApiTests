package com.cs.dipocketback.pojo.registration;

public class VerifyPhoneRequest {
    
    private Integer langId;
    private String phoneNumber;
    private String code;
    
    public VerifyPhoneRequest() {
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

    public Integer getLangId() {
        return langId;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
