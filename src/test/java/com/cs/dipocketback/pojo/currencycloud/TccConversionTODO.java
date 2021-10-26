package com.cs.dipocketback.pojo.currencycloud;

public class TccConversionTODO {
    
    private String buyCurrency;
    private String sellCurrency;
    private String fixedSide;
    private Long amount;
    private String reason;
    private String currencyPair;
    private String uniqueRequestId;
    private Boolean newMode;
    
    public TccConversionTODO() {
    }

    public TccConversionTODO(String buyCurrency, 
                             String sellCurrency, 
                             String fixedSide, 
                             Long amount, 
                             String reason,
                             String currencyPair, 
                             String uniqueRequestId, 
                             Boolean newMode) {
        this.buyCurrency = buyCurrency;
        this.sellCurrency = sellCurrency;
        this.fixedSide = fixedSide;
        this.amount = amount;
        this.reason = reason;
        this.currencyPair = currencyPair;
        this.uniqueRequestId = uniqueRequestId;
        this.newMode = newMode;
    }

    public void setBuyCurrency(String buyCurrency) {
        this.buyCurrency = buyCurrency;
    }

    public String getBuyCurrency() {
        return buyCurrency;
    }

    public void setSellCurrency(String sellCurrency) {
        this.sellCurrency = sellCurrency;
    }

    public String getSellCurrency() {
        return sellCurrency;
    }

    public void setFixedSide(String fixedSide) {
        this.fixedSide = fixedSide;
    }

    public String getFixedSide() {
        return fixedSide;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setCurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
    }

    public String getCurrencyPair() {
        return currencyPair;
    }

    public void setUniqueRequestId(String uniqueRequestId) {
        this.uniqueRequestId = uniqueRequestId;
    }

    public String getUniqueRequestId() {
        return uniqueRequestId;
    }

    public void setNewMode(Boolean newMode) {
        this.newMode = newMode;
    }

    public Boolean getNewMode() {
        return newMode;
    }

}
