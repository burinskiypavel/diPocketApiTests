package com.cs.dipocketback.pojo.customer;

import com.cs.dipocketback.pojo.customer.signature.CardCashRequestSignature;
import com.cs.dipocketback.pojo.customer.token.TokenContainer;

public class CardCashLoadRequest implements CardCashRequestSignature, TokenContainer {

    private String requestId;
    private String pan;
    private String token; //DipToken
    private String publicToken;
    private Long amount;
    private String currencyCode;
    private String note;
    private String signature;

    public CardCashLoadRequest() {
    }

    public CardCashLoadRequest(String requestId,
                               String pan,
                               String token,
                               String publicToken,
                               Long amount,
                               String currencyCode,
                               String note) {
        this.requestId = requestId;
        this.pan = pan;
        this.token = token;
        this.publicToken = publicToken;
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.note = note;
    }

    public CardCashLoadRequest(String requestId,
                               String pan,
                               String token,
                               String publicToken,
                               Long amount,
                               String currencyCode,
                               String note,
                               String signature) {
        this.requestId = requestId;
        this.pan = pan;
        this.token = token;
        this.publicToken = publicToken;
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.note = note;
        this.signature = signature;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @Override
    public String getRequestId() {
        return requestId;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String getPublicToken() {
        return publicToken;
    }

    @Override
    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
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

}
