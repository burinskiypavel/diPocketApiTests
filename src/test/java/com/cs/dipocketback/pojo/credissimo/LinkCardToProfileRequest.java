package com.cs.dipocketback.pojo.credissimo;

public class LinkCardToProfileRequest {
    
    private String publicToken;
    private Integer langId;
    private String phoneNumber;
    private String password;
    private String confirmedPassword;
    
    public LinkCardToProfileRequest() {
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public String getPublicToken() {
        return publicToken;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

}
