package com.cs.dipocketback.pojo.topUp;

public class CalculateNeosurfResponse {
    
    private String feeCurrencyCode;
    private Long feeAmount;
    private Boolean feeEnoughFunds;
    
    public CalculateNeosurfResponse() {
    }

    public CalculateNeosurfResponse(String feeCurrencyCode, Long feeAmount, Boolean feeEnoughFunds) {
        this.feeCurrencyCode = feeCurrencyCode;
        this.feeAmount = feeAmount;
        this.feeEnoughFunds = feeEnoughFunds;
    }

    public void setFeeCurrencyCode(String feeCurrencyCode) {
        this.feeCurrencyCode = feeCurrencyCode;
    }

    public String getFeeCurrencyCode() {
        return feeCurrencyCode;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setFeeEnoughFunds(Boolean feeEnoughFunds) {
        this.feeEnoughFunds = feeEnoughFunds;
    }

    public Boolean getFeeEnoughFunds() {
        return feeEnoughFunds;
    }
}
