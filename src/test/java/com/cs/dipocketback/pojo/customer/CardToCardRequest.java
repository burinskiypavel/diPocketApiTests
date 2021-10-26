package com.cs.dipocketback.pojo.customer;

public class CardToCardRequest {
    private String requestId;
    private String tokenFrom;
    private Long amount;
    private String currencyCode;
    private String note;
    private String tokenTo;

    public CardToCardRequest() {
    }

    public CardToCardRequest(String requestId, String tokenFrom, Long amount, String currencyCode, String note, String tokenTo) {
        this.requestId = requestId;
        this.tokenFrom = tokenFrom;
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.note = note;
        this.tokenTo = tokenTo;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTokenFrom() {
        return tokenFrom;
    }

    public void setTokenFrom(String tokenFrom) {
        this.tokenFrom = tokenFrom;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTokenTo() {
        return tokenTo;
    }

    public void setTokenTo(String tokenTo) {
        this.tokenTo = tokenTo;
    }
}
