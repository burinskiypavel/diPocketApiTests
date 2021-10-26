package com.cs.dipocketback.pojo.customer;

public class CardLoadRequest {
    
    private String requestId;
    private String token; //DipToken
    private Long amount;
    private String currencyCode;
    private String note;
    private String emailTypeId;
    
    public CardLoadRequest() {
    }

    public CardLoadRequest(String requestId, String token, Long amount, String currencyCode, String note, String emailTypeId) {
        this.requestId = requestId;
        this.token = token;
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.note = note;
        this.emailTypeId = emailTypeId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public String getEmailTypeId() {
        return emailTypeId;
    }

    public void setEmailTypeId(String emailTypeId) {
        this.emailTypeId = emailTypeId;
    }
}
