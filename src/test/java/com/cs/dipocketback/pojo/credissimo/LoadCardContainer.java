package com.cs.dipocketback.pojo.credissimo;

public class LoadCardContainer {
    
    private Long powId;
    private Long transactionId;
    
    public LoadCardContainer() {
    }

    public LoadCardContainer(Long powId, Long transactionId) {
        this.powId = powId;
        this.transactionId = transactionId;
    }

    public void setPowId(Long powId) {
        this.powId = powId;
    }

    public Long getPowId() {
        return powId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getTransactionId() {
        return transactionId;
    }
}
