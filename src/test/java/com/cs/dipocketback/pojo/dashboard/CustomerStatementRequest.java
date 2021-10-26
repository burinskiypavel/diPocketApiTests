package com.cs.dipocketback.pojo.dashboard;

public class CustomerStatementRequest {
    
    private String month;
    private String year;
    private Boolean isOn;
    
    public CustomerStatementRequest() {
    }
    
    public CustomerStatementRequest(String month, String year, Boolean isOn) {
        this.month = month;
        this.year = year;
        this.isOn = isOn;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMonth() {
        return month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public void setIsOn(Boolean isOn) {
        this.isOn = isOn;
    }

    public Boolean getIsOn() {
        return isOn;
    }

}
