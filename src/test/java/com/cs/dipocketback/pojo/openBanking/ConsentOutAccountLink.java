package com.cs.dipocketback.pojo.openBanking;

public class ConsentOutAccountLink {

    private AccountLink account;

    public ConsentOutAccountLink() {
    }

    public ConsentOutAccountLink(AccountLink account) {
        this.account = account;
    }

    public AccountLink getAccount() {
        return account;
    }

    public void setAccount(AccountLink account) {
        this.account = account;
    }
}
