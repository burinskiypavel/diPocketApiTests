package com.cs.dipocketback.pojo.openBanking;

public class FundsAmount {

    private String currency;
    private String amount;

    public FundsAmount() {
    }

    public FundsAmount(String currency, String amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
