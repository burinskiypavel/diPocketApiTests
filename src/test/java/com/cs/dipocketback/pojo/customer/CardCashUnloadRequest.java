package com.cs.dipocketback.pojo.customer;

import com.cs.dipocketback.pojo.customer.signature.CardCashRequestSignature;
import com.cs.dipocketback.pojo.customer.token.TokenContainer;

public class CardCashUnloadRequest implements CardCashRequestSignature, TokenContainer {

    private String requestId;
    private String pan;
    private String token;
    private String publicToken;
    private Long amount;
    private String currencyCode;
    private String note;
    private String signature;

    public CardCashUnloadRequest() {
    }

    public CardCashUnloadRequest(String requestId, String token, Long amount, String currencyCode, String note) {
        this.requestId = requestId;
        this.token = token;
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.note = note;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @Override
    public String getRequestId() {
        return requestId;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String getToken() {
        return token;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public Long getAmount() {
        return amount;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String getNote() {
        return note;
    }

    @Override
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    @Override
    public String getPublicToken() {
        return publicToken;
    }

    @Override
    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

}
