package com.cs.dipocketback.pojo.openBanking;

public class ConsentAccountLink {

    private ConsentRedirect balances;
    private ConsentRedirect transactions;

    public ConsentAccountLink() {
    }

    public ConsentAccountLink(ConsentRedirect balances, ConsentRedirect transactions) {
        this.balances = balances;
        this.transactions = transactions;
    }

    public ConsentRedirect getBalances() {
        return balances;
    }

    public void setBalances(ConsentRedirect balances) {
        this.balances = balances;
    }

    public ConsentRedirect getTransactions() {
        return transactions;
    }

    public void setTransactions(ConsentRedirect transactions) {
        this.transactions = transactions;
    }
}
