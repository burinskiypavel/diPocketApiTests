package com.cs.dipocketback.pojo.telenor;

public class RegisterClientContainer {

    private final Long clientId;
    private final Long powId;

    public RegisterClientContainer(Long clientId,
                                          Long powId) {
        this.clientId = clientId;
        this.powId = powId;
    }

    public Long getClientId() {
        return clientId;
    }

    public Long getPowId() {
        return powId;
    }

}
