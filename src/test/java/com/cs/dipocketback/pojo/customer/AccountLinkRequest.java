package com.cs.dipocketback.pojo.customer;

public class AccountLinkRequest {

    private String requestId;
    private Long clientId;
    private Long accountId;

    public AccountLinkRequest() {
    }

    public AccountLinkRequest(String requestId, Long clientId, Long accountId) {
        this.requestId = requestId;
        this.clientId = clientId;
        this.accountId = accountId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
