package com.cs.dipocketback.pojo.playit;

import com.cs.dipocketback.pojo.accounts.DiPocketCard;

public class BalanceResponse {
    
    private Long avlBalance;
    private String currencyCode;
    private String token;
    private DiPocketCard.DiPocketCardStatus state;
    
    public BalanceResponse() {
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

    public void setState(DiPocketCard.DiPocketCardStatus state) {
        this.state = state;
    }

    public DiPocketCard.DiPocketCardStatus getState() {
        return state;
    }
}
