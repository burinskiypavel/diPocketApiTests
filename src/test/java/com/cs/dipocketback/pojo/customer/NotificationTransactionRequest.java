package com.cs.dipocketback.pojo.customer;

public class NotificationTransactionRequest {
    
    private String clientId;
    private String transactionEvent;
    
    public NotificationTransactionRequest() {
    }

    public NotificationTransactionRequest(String clientId, String transactionEvent) {
        this.clientId = clientId;
        this.transactionEvent = transactionEvent;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setTransactionEvent(String transactionEvent) {
        this.transactionEvent = transactionEvent;
    }

    public String getTransactionEvent() {
        return transactionEvent;
    }

}
