package com.cs.dipocketback.pojo.accounts;

import java.util.ArrayList;
import java.util.List;

public class AccountList {

    private List<Account> accounts;

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return (accounts != null) ? accounts : (accounts = new ArrayList<>(2));
    }

    public AccountList() {
    }

    public AccountList(List<Account> accounts) {
        this.accounts = accounts;
    }

}
