package com.cs.dipocketback.pojo.customer.topup;

public class CustomerTopUpResultResponse {

    private CustomerTopUpStatus topUpStatus;
    private Long thirdPartyCardId;
    private Long recurringId;
    private Long transactionId;

    public CustomerTopUpStatus getTopUpStatus() {
        return topUpStatus;
    }

    public void setTopUpStatus(CustomerTopUpStatus topUpStatus) {
        this.topUpStatus = topUpStatus;
    }

    public Long getThirdPartyCardId() {
        return thirdPartyCardId;
    }

    public void setThirdPartyCardId(Long thirdPartyCardId) {
        this.thirdPartyCardId = thirdPartyCardId;
    }

    public Long getRecurringId() {
        return recurringId;
    }

    public void setRecurringId(Long recurringId) {
        this.recurringId = recurringId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
}
