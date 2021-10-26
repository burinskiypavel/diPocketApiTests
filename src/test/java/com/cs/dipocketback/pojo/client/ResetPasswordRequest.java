package com.cs.dipocketback.pojo.client;

public class ResetPasswordRequest {
    
    private String email;
    private String phoneNumber;
    private String url;
    
    public ResetPasswordRequest() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
