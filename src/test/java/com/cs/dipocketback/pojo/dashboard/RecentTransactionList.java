package com.cs.dipocketback.pojo.dashboard;

import java.util.List;

@Deprecated
public class RecentTransactionList {
    
    private List<RecentTransaction> recentTransactionList;

    public void setRecentTransactionList(List<RecentTransaction> recentTransactionList) {
        this.recentTransactionList = recentTransactionList;
    }

    public List<RecentTransaction> getRecentTransactionList() {
        return recentTransactionList;
    }

    public RecentTransactionList() {
    }

    public RecentTransactionList(List<RecentTransaction> recentTransactionList) {
        this.recentTransactionList = recentTransactionList;
    }
}
