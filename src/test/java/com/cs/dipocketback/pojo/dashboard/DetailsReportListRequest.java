package com.cs.dipocketback.pojo.dashboard;

import java.util.List;


public class DetailsReportListRequest {

    private Integer monthCount;
    private List<Long> accountIds;

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

    public DetailsReportListRequest() {
    }

    public DetailsReportListRequest(Integer monthCount, List<Long> accountIds) {
        this.monthCount = monthCount;
        this.accountIds = accountIds;
    }

}
