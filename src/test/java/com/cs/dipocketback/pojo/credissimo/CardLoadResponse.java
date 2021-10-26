package com.cs.dipocketback.pojo.credissimo;

public class CardLoadResponse {
    
    private String transactionId;
    
    public CardLoadResponse() {
    }

    public CardLoadResponse(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
