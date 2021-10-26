package com.cs.dipocketback.pojo.customer;

public class CompanyInfoRequest {

    private Long clientId;

    public CompanyInfoRequest() {
    }

    public CompanyInfoRequest(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
