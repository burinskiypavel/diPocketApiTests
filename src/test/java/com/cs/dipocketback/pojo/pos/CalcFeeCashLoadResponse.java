package com.cs.dipocketback.pojo.pos;

public class CalcFeeCashLoadResponse {

    private String feeCurrencyCode;
    private Long feeAmount;
    private Long estimatedBalance;

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

    public Long getEstimatedBalance() {
        return estimatedBalance;
    }

    public void setEstimatedBalance(Long estimatedBalance) {
        this.estimatedBalance = estimatedBalance;
    }
}
