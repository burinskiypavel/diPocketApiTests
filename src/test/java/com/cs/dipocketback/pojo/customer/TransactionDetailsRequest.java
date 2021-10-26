package com.cs.dipocketback.pojo.customer;

public class TransactionDetailsRequest {

    private String detailsRef;
    private Long clientId;

    public TransactionDetailsRequest() {
    }

    public TransactionDetailsRequest(String detailsRef) {
        this.detailsRef = detailsRef;
    }

    public TransactionDetailsRequest(String detailsRef, Long clientId) {
        this.detailsRef = detailsRef;
        this.clientId = clientId;
    }

    public String getDetailsRef() {
        return detailsRef;
    }

    public void setDetailsRef(String detailsRef) {
        this.detailsRef = detailsRef;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
