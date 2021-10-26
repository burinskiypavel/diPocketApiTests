package com.cs.dipocketback.pojo.pos;

public class CalcFeeCardRelinkResponse {

    private String feeCurrencyCode;
    private Long feeAmount;

    public String getFeeCurrencyCode() {
        return feeCurrencyCode;
    }

    public void setFeeCurrencyCode(String feeCurrencyCode) {
        this.feeCurrencyCode = feeCurrencyCode;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }
}
