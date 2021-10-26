package com.cs.dipocketback.pojo.accounts;

import java.util.List;

public class OtherAccountList2 {

    private List<OtherAccount2> thirdAccounts;

    public OtherAccountList2() {
    }

    public OtherAccountList2(List<OtherAccount2> thirdAccounts) {
        this.thirdAccounts = thirdAccounts;
    }

    public void setThirdAccounts(List<OtherAccount2> thirdAccounts) {
        this.thirdAccounts = thirdAccounts;
    }

    public List<OtherAccount2> getThirdAccounts() {
        return thirdAccounts;
    }
}
