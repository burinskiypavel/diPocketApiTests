package com.cs.dipocketback.pojo.customer;

import com.cs.dipocketback.pojo.customer.signature.CardCashResponseSignature;

public class CardCashUnloadResponse implements CardCashResponseSignature {

    private Long powId;
    private Long transactionId;
    private Long feeAmount;
    private String feeCurrencyCode;
    private String signature;

    public CardCashUnloadResponse() {
    }

    public CardCashUnloadResponse(Long transactionId, Long feeAmount, String feeCurrencyCode) {
        this.transactionId = transactionId;
        this.feeAmount = feeAmount;
        this.feeCurrencyCode = feeCurrencyCode;
    }

    public CardCashUnloadResponse(Long powId, Long transactionId, Long feeAmount, String feeCurrencyCode) {
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

    @Override
    public Long getTransactionId() {
        return transactionId;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    @Override
    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setFeeCurrencyCode(String feeCurrencyCode) {
        this.feeCurrencyCode = feeCurrencyCode;
    }

    @Override
    public String getFeeCurrencyCode() {
        return feeCurrencyCode;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

}
