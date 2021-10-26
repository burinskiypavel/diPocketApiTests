package com.cs.dipocketback.pojo.customer;

public class CardUnloadRequest {
    
    private String requestId;
    private String token;
    private Long amount;
    private String currencyCode;
    private String note;
    
    public CardUnloadRequest() {
    }

    public CardUnloadRequest(String requestId, String token, Long amount, String currencyCode, String note) {
        this.requestId = requestId;
        this.token = token;
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.note = note;
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

}
