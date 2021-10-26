package com.cs.dipocketback.pojo.customer;

public class TransactionListRequest {
    
    private Long accountId;
    private String startDate; //YYYY-MM-DD
    private String endDate; //YYYY-MM-DD
    
    public TransactionListRequest() {
    }

    public TransactionListRequest(Long accountId, String startDate, String endDate) {
        this.accountId = accountId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDate() {
        return endDate;
    }

}
