package com.cs.dipocketback.pojo.pos;

public class CashierAvlCurrency {

    private String currencyCode;
    private Long avlBalance;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Long getAvlBalance() {
        return avlBalance;
    }

    public void setAvlBalance(Long avlBalance) {
        this.avlBalance = avlBalance;
    }
}
