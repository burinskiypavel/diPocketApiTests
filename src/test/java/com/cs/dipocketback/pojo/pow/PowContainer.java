package com.cs.dipocketback.pojo.pow;

public class PowContainer {
    
    private Long powId;
    private Long clientId;
    
    public PowContainer() {
    }

    public PowContainer(Long powId, Long clientId) {
        this.powId = powId;
        this.clientId = clientId;
    }

    public void setPowId(Long powId) {
        this.powId = powId;
    }

    public Long getPowId() {
        return powId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }
}
