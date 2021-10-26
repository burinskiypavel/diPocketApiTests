package com.cs.dipocketback.pojo.customer;





public class AccountTransferResponse {


    private Long transactionId;

    private Long feeAmount;

    private String feeCurrencyCode;


    private Long powId;

    public AccountTransferResponse() {
    }

    public AccountTransferResponse( Long transactionId,  Long feeAmount,
                                    String feeCurrencyCode,  Long powId) {
        this.transactionId = transactionId;
        this.feeAmount = feeAmount;
        this.feeCurrencyCode = feeCurrencyCode;
        this.powId = powId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
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

    public Long getPowId() {
        return powId;
    }

    public void setPowId(Long powId) {
        this.powId = powId;
    }
}
