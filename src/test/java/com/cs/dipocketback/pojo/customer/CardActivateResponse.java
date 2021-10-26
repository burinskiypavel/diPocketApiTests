package com.cs.dipocketback.pojo.customer;

public class CardActivateResponse {

    private Long powId;
    private Long feeAmount;
    private String feeCurrencyCode;

    public CardActivateResponse() {
    }

    public CardActivateResponse(Long powId, Long feeAmount, String feeCurrencyCode) {
        this.powId = powId;
        this.feeAmount = feeAmount;
        this.feeCurrencyCode = feeCurrencyCode;
    }

    public Long receivePowId() {
        return powId;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getFeeCurrencyCode() {
        return feeCurrencyCode;
    }

    public void setFeeCurrencyCode(String feeCurrencyCode) {
        this.feeCurrencyCode = feeCurrencyCode;
    }

}
