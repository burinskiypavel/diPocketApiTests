package com.cs.dipocketback.pojo.openBanking;

public class AccountBalanceAmount {

    private String currency;
    private Long amount;

    public AccountBalanceAmount() {
    }

    public AccountBalanceAmount(String currency, Long amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
