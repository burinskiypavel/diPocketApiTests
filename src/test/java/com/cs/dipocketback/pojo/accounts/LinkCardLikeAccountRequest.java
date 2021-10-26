package com.cs.dipocketback.pojo.accounts;

public class LinkCardLikeAccountRequest {

    private String token;
    private String otp; // optional field

    public LinkCardLikeAccountRequest() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

}
