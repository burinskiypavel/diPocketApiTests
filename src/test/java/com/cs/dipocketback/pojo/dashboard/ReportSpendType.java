package com.cs.dipocketback.pojo.dashboard;


public class ReportSpendType {
    
    private String spendTypeGroup;
    private Long amount;
    private String ccySymbol;
    private Long spendTypeID;

    public ReportSpendType() {
    }
    
    public ReportSpendType(String spendTypeGroup, Long amount) {
        this.spendTypeGroup = spendTypeGroup;
        this.amount = amount;
    }

    public ReportSpendType(String spendTypeGroup, Long amount, String ccySymbol, Long spendTypeID) {
        this.spendTypeGroup = spendTypeGroup;
        this.amount = amount;
        this.ccySymbol = ccySymbol;
        this.spendTypeID = spendTypeID;
    }

    public void setSpendTypeGroup(String spendTypeGroup) {
        this.spendTypeGroup = spendTypeGroup;
    }

    public String getSpendTypeGroup() {
        return spendTypeGroup;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setCcySymbol(String ccySymbol) {
        this.ccySymbol = ccySymbol;
    }

    public String getCcySymbol() {
        return ccySymbol;
    }
    
    public void setSpendTypeID(Long spendTypeID) {
        this.spendTypeID = spendTypeID;
    }

    public Long getSpendTypeID() {
        return spendTypeID;
    }

}
