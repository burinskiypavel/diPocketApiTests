package com.cs.dipocketback.pojo.peak;

public class CardIssueResponse {
    
    private String publicToken;
    private String pan;
    private String pin;
    private String expDate;
    private String cvv;
    
    public CardIssueResponse() {
    }

    public CardIssueResponse(String publicToken, String pan, String pin, String expDate, String cvv) {
        this.publicToken = publicToken;
        this.pan = pan;
        this.pin = pin;
        this.expDate = expDate;
        this.cvv = cvv;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPan() {
        return pan;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCvv() {
        return cvv;
    }

}
