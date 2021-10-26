package com.cs.dipocketback.pojo.credissimo;

public class RegistrationResponse {

    private Long clientId;

    public RegistrationResponse() {
    }

    public RegistrationResponse(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
