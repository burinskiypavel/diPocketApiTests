package com.cs.dipocketback.pojo.customer;



public class ClientAccountsRequest {

    private Long clientId;

    public ClientAccountsRequest() {
    }

    public ClientAccountsRequest(Long clientId) {
        this.clientId = clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

}
