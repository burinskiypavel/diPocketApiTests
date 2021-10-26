package com.cs.dipocketback.pojo.accounts;

import java.util.List;

public class AllClientAccounts {

    private List<Account> accounts;
    private List<OtherAccount> otherAccounts;

    public AllClientAccounts() {
    }

    public AllClientAccounts(List<Account> accounts, List<OtherAccount> otherAccounts) {
      this.accounts = accounts;
      this.otherAccounts = otherAccounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setOtherAccounts(List<OtherAccount> otherAccounts) {
        this.otherAccounts = otherAccounts;
    }

    public List<OtherAccount> getOtherAccounts() {
        return otherAccounts;
    }

}
