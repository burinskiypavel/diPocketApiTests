package com.cs.dipocketback.pojo.customer;





public class AccountCreateResponse {


    private Long accountId;


    private Long powId;

    public AccountCreateResponse() {
    }

    public AccountCreateResponse( Long accountId,  Long powId) {
        this.accountId = accountId;
        this.powId = powId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getPowId() {
        return powId;
    }

    public void setPowId(Long powId) {
        this.powId = powId;
    }
}
