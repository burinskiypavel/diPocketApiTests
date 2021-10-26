package com.cs.dipocketback.pojo.customer;

public class ClientInfoRequest {
    
    private Long clientId;
    
    public ClientInfoRequest() {
    }

    public ClientInfoRequest(Long clientId) {
        this.clientId = clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

}
