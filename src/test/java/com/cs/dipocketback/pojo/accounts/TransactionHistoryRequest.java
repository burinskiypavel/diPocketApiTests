package com.cs.dipocketback.pojo.accounts;

public class TransactionHistoryRequest {
    
    private Long accountId;
    
    public TransactionHistoryRequest() {
    }

    public TransactionHistoryRequest(Long accountId) {
        this.accountId = accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }
}
