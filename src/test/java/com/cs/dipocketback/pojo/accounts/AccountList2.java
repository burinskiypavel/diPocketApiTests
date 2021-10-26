package com.cs.dipocketback.pojo.accounts;

import java.util.List;

public class AccountList2 {
    
    private List<Account2> accounts;
    
    public AccountList2() {
    }

    public AccountList2(List<Account2> accounts) {
        this.accounts = accounts;
    }

    public void setAccounts(List<Account2> accounts) {
        this.accounts = accounts;
    }

    public List<Account2> getAccounts() {
        return accounts;
    }
}
