package com.cs.dipocketback.pojo.incontrol.core;

public class RegisterCardRequest {

    private String pan;
    private String expDate;

    public RegisterCardRequest() {
    }

    public RegisterCardRequest(String pan, String expDate) {
        this.pan = pan;
        this.expDate = expDate;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

}
