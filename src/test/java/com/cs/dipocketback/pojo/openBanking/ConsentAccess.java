package com.cs.dipocketback.pojo.openBanking;

import java.util.List;

public class ConsentAccess {

    private List<ConsentIban> balances;
    private List<ConsentIban> transactions;

    public ConsentAccess() {
    }

    public ConsentAccess(List<ConsentIban> balances, List<ConsentIban> transactions) {
        this.balances = balances;
        this.transactions = transactions;
    }

    public List<ConsentIban> getBalances() {
        return balances;
    }

    public void setBalances(List<ConsentIban> balances) {
        this.balances = balances;
    }

    public List<ConsentIban> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<ConsentIban> transactions) {
        this.transactions = transactions;
    }
}
