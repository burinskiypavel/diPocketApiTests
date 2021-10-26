package com.cs.dipocketback.pojo.web.dashboard;

import com.cs.dipocketback.pojo.accounts.Account2;
import com.cs.dipocketback.pojo.accounts.AccountHistory;

import java.util.List;

public class AccountHistoryResponse {

    private List<AccountHistory> accountHistoryList;
    private Account2 account;
    private String reportDate;
    private boolean needSca;

    public AccountHistoryResponse() {
    }

    public AccountHistoryResponse(List<AccountHistory> accountHistoryList, Account2 account) {
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

    public boolean isNeedSca() {
        return needSca;
    }

    public void setNeedSca(boolean needSca) {
        this.needSca = needSca;
    }

}
