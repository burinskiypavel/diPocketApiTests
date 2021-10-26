package com.cs.dipocketback.pojo.customer;

public class RegisterCompanyResponse {

    private Long powId;
    private Long clientId;

    public RegisterCompanyResponse() {
    }

    public RegisterCompanyResponse(Long powId, Long clientId) {
        this.powId = powId;
        this.clientId = clientId;
    }

    public Long getPowId() {
        return powId;
    }

    public void setPowId(Long powId) {
        this.powId = powId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
