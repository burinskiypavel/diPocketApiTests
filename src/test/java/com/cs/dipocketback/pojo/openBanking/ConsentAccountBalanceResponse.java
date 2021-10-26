package com.cs.dipocketback.pojo.openBanking;

import java.util.List;

public class ConsentAccountBalanceResponse {

    private ConsentIban account;
    private List<ConsentAccountBalance> balances;

    public ConsentAccountBalanceResponse() {
    }

    public ConsentAccountBalanceResponse(ConsentIban account, List<ConsentAccountBalance> balances) {
        this.account = account;
        this.balances = balances;
    }

    public ConsentIban getAccount() {
        return account;
    }

    public void setAccount(ConsentIban account) {
        this.account = account;
    }

    public List<ConsentAccountBalance> getBalances() {
        return balances;
    }

    public void setBalances(List<ConsentAccountBalance> balances) {
        this.balances = balances;
    }
}
