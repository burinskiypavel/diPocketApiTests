package com.cs.dipocketback.pojo.accounts;

import com.cs.dipocketback.pojo.references.Currency;

import java.util.List;

public class AccountLinkList {

    private List<Account4Link> accountLinkList;
    private Boolean canOpenNewAccount;
    private Currency cardCurrency;

    public AccountLinkList() {
    }

    public AccountLinkList(List<Account4Link> accountLinkList) {
        this.accountLinkList=accountLinkList;
    }

    public void setAccountLinkList(List<Account4Link> accountLinkList) {
        this.accountLinkList = accountLinkList;
    }

    public List<Account4Link> getAccountLinkList() {
        return accountLinkList;
    }

    public void setCanOpenNewAccount(Boolean canOpenNewAccount) {
        this.canOpenNewAccount = canOpenNewAccount;
    }

    public Boolean getCanOpenNewAccount() {
        return canOpenNewAccount;
    }

    public Currency getCardCurrency() {
        return cardCurrency;
    }

    public void setCardCurrency(Currency cardCurrency) {
        this.cardCurrency = cardCurrency;
    }

}

