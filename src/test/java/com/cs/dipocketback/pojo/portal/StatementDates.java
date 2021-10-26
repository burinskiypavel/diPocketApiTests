package com.cs.dipocketback.pojo.portal;

public class StatementDates {
    
    private String startDate;
    private String endDate;
    
    public StatementDates() {
    }

    public StatementDates(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
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
