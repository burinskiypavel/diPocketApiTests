package com.cs.dipocketback.pojo.customer;

public class AccountCalcBankTranSepaResponse {

    private Long feeAmount;
    private String feeCurrencyCode;

    public AccountCalcBankTranSepaResponse() {
    }

    public AccountCalcBankTranSepaResponse(Long feeAmount, String feeCurrencyCode) {
        this.feeAmount = feeAmount;
        this.feeCurrencyCode = feeCurrencyCode;
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
