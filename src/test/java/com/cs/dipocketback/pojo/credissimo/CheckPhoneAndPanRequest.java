package com.cs.dipocketback.pojo.credissimo;

public class CheckPhoneAndPanRequest {
    
    private String phoneNumber;
    private String pan;
    private Integer langId;
    
    public CheckPhoneAndPanRequest() {
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPan() {
        return pan;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

    public Integer getLangId() {
        return langId;
    }
}
