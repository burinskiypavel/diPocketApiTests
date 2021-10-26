package com.cs.dipocketback.pojo.playit;

public class BalanceRequest {
    
    private String pan;
    private String token;
    
    public BalanceRequest() {
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPan() {
        return pan;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
