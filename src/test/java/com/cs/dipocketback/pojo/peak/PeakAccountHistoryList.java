package com.cs.dipocketback.pojo.peak;

import java.util.List;

public class PeakAccountHistoryList {
    
    private String reportDate;
    private PeakAccount account;
    private List<PeakAccountHistory> accountHistoryList;
    
    public PeakAccountHistoryList() {
    }

    public PeakAccountHistoryList(List<PeakAccountHistory> accountHistoryList) {
        this.accountHistoryList = accountHistoryList;
    }

    public PeakAccountHistoryList(PeakAccount account, List<PeakAccountHistory> accountHistoryList) {
        this.accountHistoryList = accountHistoryList;
        this.account = account;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setAccount(PeakAccount account) {
        this.account = account;
    }

    public PeakAccount getAccount() {
        return account;
    }

    public void setAccountHistoryList(List<PeakAccountHistory> accountHistoryList) {
        this.accountHistoryList = accountHistoryList;
    }

    public List<PeakAccountHistory> getAccountHistoryList() {
        return accountHistoryList;
    }

}
