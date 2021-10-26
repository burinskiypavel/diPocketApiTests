package com.cs.dipocketback.pojo.openBanking;

import java.util.List;

public class ConsentAccountList {

    private List<ConsentAccount> accounts;

    public ConsentAccountList() {
    }

    public ConsentAccountList(List<ConsentAccount> accounts) {
        this.accounts = accounts;
    }

    public List<ConsentAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<ConsentAccount> accounts) {
        this.accounts = accounts;
    }
}
