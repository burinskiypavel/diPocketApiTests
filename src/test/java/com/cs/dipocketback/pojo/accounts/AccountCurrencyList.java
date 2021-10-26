package com.cs.dipocketback.pojo.accounts;

import java.util.List;

public class AccountCurrencyList {
    
    private List<AccountCurrency> accountCurrencyList;
    private String avlCurrencyForNewAccHash;
    
    public AccountCurrencyList() {
    }
    
    public AccountCurrencyList(List<AccountCurrency> accountCurrencyList, String avlCurrencyForNewAccHash) {
        this.accountCurrencyList = accountCurrencyList;
        this.avlCurrencyForNewAccHash = avlCurrencyForNewAccHash;
    }

    public void setAccountCurrencyList(List<AccountCurrency> accountCurrencyList) {
        this.accountCurrencyList = accountCurrencyList;
    }

    public List<AccountCurrency> getAccountCurrencyList() {
        return accountCurrencyList;
    }

    public void setAvlCurrencyForNewAccHash(String avlCurrencyForNewAccHash) {
        this.avlCurrencyForNewAccHash = avlCurrencyForNewAccHash;
    }

    public String getAvlCurrencyForNewAccHash() {
        return avlCurrencyForNewAccHash;
    }
    
}
