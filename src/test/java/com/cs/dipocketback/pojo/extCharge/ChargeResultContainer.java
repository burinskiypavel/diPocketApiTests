package com.cs.dipocketback.pojo.extCharge;

public class ChargeResultContainer {

    private Long transactionId;
    private Long powId;
    private Long orderNumber;

    public ChargeResultContainer(Long transactionId, Long powId, Long orderNumber) {
        this.transactionId = transactionId;
        this.powId = powId;
        this.orderNumber = orderNumber;
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

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }
}
