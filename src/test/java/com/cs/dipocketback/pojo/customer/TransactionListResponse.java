package com.cs.dipocketback.pojo.customer;

import java.util.List;

public class TransactionListResponse {
    
    private Account account;
    private List<Transaction> transactions;

    public TransactionListResponse() {
    }

    public TransactionListResponse(Account account, List<Transaction> transactions) {
        this.account = account;
        this.transactions = transactions;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}
