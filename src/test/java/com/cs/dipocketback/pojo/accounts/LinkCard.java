package com.cs.dipocketback.pojo.accounts;

public class LinkCard {

    private Long accountId;
    private String accountName;
    private String univToken;
    private String pin;

    public LinkCard() {
    }

    public LinkCard(Long accountId, String accountName, String univToken, String pin) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.univToken = univToken;
        this.pin = pin;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setUnivToken(String univToken) {
        this.univToken = univToken;
    }

    public String getUnivToken() {
        return univToken;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

}
