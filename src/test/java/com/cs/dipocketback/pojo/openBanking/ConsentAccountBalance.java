package com.cs.dipocketback.pojo.openBanking;

public class ConsentAccountBalance {

    private String balanceType;
    private AccountBalanceAmount balanceAmount;

    public ConsentAccountBalance() {
    }

    public ConsentAccountBalance(String balanceType, AccountBalanceAmount balanceAmount) {
        this.balanceType = balanceType;
        this.balanceAmount = balanceAmount;
    }

    public String getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(String balanceType) {
        this.balanceType = balanceType;
    }

    public AccountBalanceAmount getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(AccountBalanceAmount balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
}
