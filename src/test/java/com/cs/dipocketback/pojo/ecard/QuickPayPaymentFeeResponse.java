package com.cs.dipocketback.pojo.ecard;

public class QuickPayPaymentFeeResponse {
    
    private Integer feeCurrencyId;
    private String feeCurrencyCode;
    private Long feeAmount;
    private boolean feeEnoughFunds;
    
    public QuickPayPaymentFeeResponse() {
    }

    public QuickPayPaymentFeeResponse(Integer feeCurrencyId, 
                                      String feeCurrencyCode,
                                      Long feeAmount, 
                                      boolean feeEnoughFunds) {
        this.feeCurrencyId = feeCurrencyId;
        this.feeCurrencyCode = feeCurrencyCode;
        this.feeAmount = feeAmount;
        this.feeEnoughFunds = feeEnoughFunds;
    }

    public void setFeeCurrencyId(Integer feeCurrencyId) {
        this.feeCurrencyId = feeCurrencyId;
    }

    public Integer getFeeCurrencyId() {
        return feeCurrencyId;
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

    public void setFeeEnoughFunds(boolean feeEnoughFunds) {
        this.feeEnoughFunds = feeEnoughFunds;
    }

    public boolean isFeeEnoughFunds() {
        return feeEnoughFunds;
    }
    
}
