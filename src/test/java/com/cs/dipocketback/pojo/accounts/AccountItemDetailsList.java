package com.cs.dipocketback.pojo.accounts;

import java.util.List;

public class AccountItemDetailsList {
    
    private List<AccountItemDetails> accountTranDetailsList;
    
    public AccountItemDetailsList() {
    }

    public AccountItemDetailsList(List<AccountItemDetails> accountTranDetailsList) {
        this.accountTranDetailsList = accountTranDetailsList;
    }

    public void setAccountTranDetailsList(List<AccountItemDetails> accountTranDetailsList) {
        this.accountTranDetailsList = accountTranDetailsList;
    }

    public List<AccountItemDetails> getAccountTranDetailsList() {
        return accountTranDetailsList;
    }
}
