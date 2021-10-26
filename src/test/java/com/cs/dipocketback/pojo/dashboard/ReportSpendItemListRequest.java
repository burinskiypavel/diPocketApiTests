package com.cs.dipocketback.pojo.dashboard;

import java.util.List;


public class ReportSpendItemListRequest {
    private Integer monthCount;
    private List<Long> accountIds;
    /**
     * SpendChannelID or SpendTypeID
     */
    private Long spendID;

    public void setMonthCount(Integer monthCount) {
        this.monthCount = monthCount;
    }

    public Integer getMonthCount() {
        return monthCount;
    }

    public void setAccountIds(List<Long> accountIds) {
        this.accountIds = accountIds;
    }

    public List<Long> getAccountIds() {
        return accountIds;
    }

    public ReportSpendItemListRequest() {
    }

    public void setSpendID(Long spendID) {
        this.spendID = spendID;
    }

    public Long getSpendID() {
        return spendID;
    }

    public ReportSpendItemListRequest(Integer monthCount, List<Long> accountIds, Long spendID) {
        this();
        this.monthCount = monthCount;
        this.accountIds = accountIds;
        this.spendID = spendID;
    }

}
