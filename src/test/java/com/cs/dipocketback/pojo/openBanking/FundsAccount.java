package com.cs.dipocketback.pojo.openBanking;

public class FundsAccount {

    private String iban;

    public FundsAccount() {
    }

    public FundsAccount(String iban) {
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
