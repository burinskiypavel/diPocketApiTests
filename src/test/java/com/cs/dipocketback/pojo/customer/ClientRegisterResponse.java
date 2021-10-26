package com.cs.dipocketback.pojo.customer;

public class ClientRegisterResponse {

    private Long powId;
    private Long clientId;
    
    public ClientRegisterResponse() {
    }

    public ClientRegisterResponse(Long clientId) {
        this.clientId = clientId;
    }

    public ClientRegisterResponse(Long powId, Long clientId) {
        this.powId = powId;
        this.clientId = clientId;
    }

    public Long receivePowId() {
        return powId;
    }

    public void setPowId(Long powId) {
        this.powId = powId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

}
