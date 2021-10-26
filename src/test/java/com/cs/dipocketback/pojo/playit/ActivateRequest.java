package com.cs.dipocketback.pojo.playit;

public class ActivateRequest {
    
    private String pan;
    private String token;
    
    public ActivateRequest() {
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
