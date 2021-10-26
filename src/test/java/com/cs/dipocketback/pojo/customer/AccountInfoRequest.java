package com.cs.dipocketback.pojo.customer;



public class AccountInfoRequest {

    private Long accountId;

    public AccountInfoRequest() {
    }

    public AccountInfoRequest( Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
