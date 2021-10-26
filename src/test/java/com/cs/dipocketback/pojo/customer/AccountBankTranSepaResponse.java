package com.cs.dipocketback.pojo.customer;


public class AccountBankTranSepaResponse {

    private Long powId;
    private Long transactionId;

    public AccountBankTranSepaResponse() {
    }

    public AccountBankTranSepaResponse(Long powId, Long transactionId) {
        this.powId = powId;
        this.transactionId = transactionId;
    }

    public Long getPowId() {
        return powId;
    }

    public void setPowId(Long powId) {
        this.powId = powId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
}
