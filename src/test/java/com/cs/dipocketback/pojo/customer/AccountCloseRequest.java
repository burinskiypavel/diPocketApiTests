package com.cs.dipocketback.pojo.customer;

public class AccountCloseRequest {

    private String requestId;

    private Long accountId;

    public AccountCloseRequest() {
    }

    public AccountCloseRequest(String requestId, Long accountId) {
        this.requestId = requestId;
        this.accountId = accountId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
