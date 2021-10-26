package com.cs.dipocketback.pojo.credissimo;

public class CardLoadRequest {
    
    private String requestId;
    private Long amount;
    private String currencyCode;
    private String note;
    
    public CardLoadRequest() {
    }

    public CardLoadRequest(String requestId, Long amount, String currencyCode, String note) {
        this.requestId = requestId;
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
