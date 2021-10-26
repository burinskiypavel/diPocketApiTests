package com.cs.dipocketback.pojo.santander;

import java.util.List;

public class TransactionsStatusRequestList {
    
    private List<TransactionsStatusRequest> transactions;
    
    public TransactionsStatusRequestList() {
    }

    public TransactionsStatusRequestList(List<TransactionsStatusRequest> tranList) {
        this.transactions = tranList;
    }

    public void setTransactions(List<TransactionsStatusRequest> tranList) {
        this.transactions = tranList;
    }

    public List<TransactionsStatusRequest> getTransactions() {
        return transactions;
    }
}
