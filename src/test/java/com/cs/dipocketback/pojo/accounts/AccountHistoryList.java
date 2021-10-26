package com.cs.dipocketback.pojo.accounts;

import java.util.List;

public class AccountHistoryList {
    
    private List<AccountHistory> accountHistoryList;
    private Account2 account;
    private String reportDate;
    
    public AccountHistoryList() {
    }

    public AccountHistoryList(List<AccountHistory> accountHistoryList) {
        this.accountHistoryList = accountHistoryList;
    }

    public AccountHistoryList(List<AccountHistory> accountHistoryList, Account2 account) {
        this.accountHistoryList = accountHistoryList;
        this.account = account;
    }

    public void setAccountHistoryList(List<AccountHistory> accountHistoryList) {
        this.accountHistoryList = accountHistoryList;
    }

    public List<AccountHistory> getAccountHistoryList() {
        return accountHistoryList;
    }

    public void setAccount(Account2 account) {
        this.account = account;
    }

    public Account2 getAccount() {
        return account;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportDate() {
        return reportDate;
    }

}
