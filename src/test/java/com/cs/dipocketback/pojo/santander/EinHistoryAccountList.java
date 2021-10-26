package com.cs.dipocketback.pojo.santander;

import java.util.List;

public class EinHistoryAccountList {
    
    private List<EinHistoryAccount> accountList;
    
    public EinHistoryAccountList() {
    }

    public EinHistoryAccountList(List<EinHistoryAccount> accountList) {
        this.accountList = accountList;
    }

    public void setAccountList(List<EinHistoryAccount> accountList) {
        this.accountList = accountList;
    }

    public List<EinHistoryAccount> getAccountList() {
        return accountList;
    }
}
