package com.cs.dipocketback.pojo.telenor;

public class ValidationData {
    
    private Boolean validPhone;
    private Boolean validToken;
    private Boolean isLinkedToken;
    
    public ValidationData() {
    }

    public ValidationData(Boolean validPhone, Boolean validToken, Boolean isLinkedToken) {
        this.validPhone = validPhone;
        this.validToken = validToken;
        this.isLinkedToken = isLinkedToken;
    }

    public ValidationData(Boolean validPhone) {
        this.validPhone = validPhone;
    }

    public void setValidPhone(Boolean validPhone) {
        this.validPhone = validPhone;
    }

    public Boolean getValidPhone() {
        return validPhone;
    }

    public void setValidToken(Boolean validToken) {
        this.validToken = validToken;
    }

    public Boolean getValidToken() {
        return validToken;
    }

    public void setIsLinkedToken(Boolean isLinkedToken) {
        this.isLinkedToken = isLinkedToken;
    }

    public Boolean getIsLinkedToken() {
        return isLinkedToken;
    }
}
