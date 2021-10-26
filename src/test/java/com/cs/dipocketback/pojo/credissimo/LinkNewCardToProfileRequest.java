package com.cs.dipocketback.pojo.credissimo;

public class LinkNewCardToProfileRequest {
    
    private String publicToken;
    private String dipToken;
    private Integer langId;
    private String phoneNumber;
    
    public LinkNewCardToProfileRequest() {
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setDipToken(String dipToken) {
        this.dipToken = dipToken;
    }

    public String getDipToken() {
        return dipToken;
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

}
