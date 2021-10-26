package com.cs.dipocketback.pojo.openBanking;

public class ConsentAccountTran {

    private ConsentIban account;
    private BookedTransaction transactions;

    public ConsentAccountTran() {
    }

    public ConsentAccountTran(ConsentIban account, BookedTransaction transactions) {
        this.account = account;
        this.transactions = transactions;
    }

    public ConsentIban getAccount() {
        return account;
    }

    public void setAccount(ConsentIban account) {
        this.account = account;
    }

    public BookedTransaction getTransactions() {
        return transactions;
    }

    public void setTransactions(BookedTransaction transactions) {
        this.transactions = transactions;
    }
}
