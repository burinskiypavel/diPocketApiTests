package com.cs.dipocketback.pojo.playit;

import com.cs.dipocketback.pojo.accounts.DiPocketCard;

public class LoadResponse {
    
    private Long transactionId;
    private DiPocketCard.DiPocketCardStatus state;
    private Long avlBalance;
    private String currencyCode;
    private String token;
    
    public LoadResponse() {
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setState(DiPocketCard.DiPocketCardStatus state) {
        this.state = state;
    }

    public DiPocketCard.DiPocketCardStatus getState() {
        return state;
    }

    public void setAvlBalance(Long avlBalance) {
        this.avlBalance = avlBalance;
    }

    public Long getAvlBalance() {
        return avlBalance;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
