package com.cs.dipocketback.pojo.customer;

public class CardUnloadResponse {

    private Long powId;
    private Long transactionId;
    private Long feeAmount;
    private String feeCurrencyCode;

    public CardUnloadResponse() {
    }

    public CardUnloadResponse(Long transactionId, Long feeAmount, String feeCurrencyCode) {
        this.transactionId = transactionId;
        this.feeAmount = feeAmount;
        this.feeCurrencyCode = feeCurrencyCode;
    }

    public CardUnloadResponse(Long powId, Long transactionId, Long feeAmount, String feeCurrencyCode) {
        this.powId = powId;
        this.transactionId = transactionId;
        this.feeAmount = feeAmount;
        this.feeCurrencyCode = feeCurrencyCode;
    }

    public Long receivePowId() {
        return powId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setFeeCurrencyCode(String feeCurrencyCode) {
        this.feeCurrencyCode = feeCurrencyCode;
    }

    public String getFeeCurrencyCode() {
        return feeCurrencyCode;
    }

}
