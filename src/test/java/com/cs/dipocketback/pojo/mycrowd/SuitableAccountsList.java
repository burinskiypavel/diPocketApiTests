package com.cs.dipocketback.pojo.mycrowd;

import com.cs.dipocketback.pojo.payments.SuitableAccount;

import java.util.List;

public class SuitableAccountsList {
    
    private List<SuitableAccount> suitableAccounts;
    
    public SuitableAccountsList() {
    }

    public void setSuitableAccounts(List<SuitableAccount> suitableAccounts) {
        this.suitableAccounts = suitableAccounts;
    }

    public List<SuitableAccount> getSuitableAccounts() {
        return suitableAccounts;
    }
}
