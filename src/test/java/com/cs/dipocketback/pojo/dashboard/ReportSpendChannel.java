package com.cs.dipocketback.pojo.dashboard;


public class ReportSpendChannel {
    
    private String spendChannel;
    private Long amount;
    private String ccySymbol;
    private Long spendChannelID;
    
    public ReportSpendChannel() {
    }
    
    public ReportSpendChannel(String spendChannel, 
                              Long amount) {
        this.spendChannel = spendChannel;
        this.amount = amount;
    }

    public ReportSpendChannel(String spendChannel, 
                              Long amount, 
                              String ccySymbol, 
                              Long spendChannelID) {
        this.spendChannel = spendChannel;
        this.amount = amount;
        this.ccySymbol = ccySymbol;
        this.spendChannelID = spendChannelID;
    }

    public void setSpendChannel(String spendChannel) {
        this.spendChannel = spendChannel;
    }

    public String getSpendChannel() {
        return spendChannel;
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

    public void setSpendChannelID(Long spendChannelID) {
        this.spendChannelID = spendChannelID;
    }

    public Long getSpendChannelID() {
        return spendChannelID;
    }

}
