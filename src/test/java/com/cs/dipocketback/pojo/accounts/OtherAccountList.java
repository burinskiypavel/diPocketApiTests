package com.cs.dipocketback.pojo.accounts;

import java.util.List;

public class OtherAccountList {
    
    private List<OtherAccount> thirdAccounts;

    public OtherAccountList() {
    }

    public OtherAccountList(List<OtherAccount> thirdAccounts) {
        this.thirdAccounts = thirdAccounts;
    }

    public void setThirdAccounts(List<OtherAccount> thirdAccounts) {
        this.thirdAccounts = thirdAccounts;
    }

    public List<OtherAccount> getThirdAccounts() {
        return thirdAccounts;
    }

}
