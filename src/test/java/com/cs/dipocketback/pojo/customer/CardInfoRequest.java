package com.cs.dipocketback.pojo.customer;

public class CardInfoRequest {

    private String pan;
    private String encryptedPan;
    private String token;
    
    public CardInfoRequest() {
    }

    public CardInfoRequest(String pan) {
        this.pan = pan;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getEncryptedPan() {
        return encryptedPan;
    }

    public void setEncryptedPan(String encryptedPan) {
        this.encryptedPan = encryptedPan;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

}
