package com.cs.dipocketback.pojo.limit.gps;

public class PeriodLimitContainer {
    
    private long cardId;
    private int cardType;
    private String ccySymbol;
    private Long annualMaxAmount;
    private Long annualAvailableAmount;
       
    private LimitTypeContainer dailyLimit;
    private LimitTypeContainer monthlyLimit;

    public PeriodLimitContainer() {
    }

    public PeriodLimitContainer(long cardId, int cardType, LimitTypeContainer dailyLimit, LimitTypeContainer monthlyLimit) {
        this.cardId = cardId;
        this.cardType = cardType;
        this.dailyLimit = dailyLimit;
        this.monthlyLimit = monthlyLimit;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public int getCardType() {
        return cardType;
    }

    public void setCcySymbol(String ccySymbol) {
        this.ccySymbol = ccySymbol;
    }

    public String getCcySymbol() {
        return ccySymbol;
    }

    public void setDailyLimit(LimitTypeContainer dailyLimit) {
        this.dailyLimit = dailyLimit;
    }

    public LimitTypeContainer getDailyLimit() {
        return dailyLimit;
    }

    public void setMonthlyLimit(LimitTypeContainer monthlyLimit) {
        this.monthlyLimit = monthlyLimit;
    }

    public LimitTypeContainer getMonthlyLimit() {
        return monthlyLimit;
    }
    
    public void setAnnualMaxAmount(Long annualMaxAmount) {
        this.annualMaxAmount = annualMaxAmount;
    }

    public Long getAnnualMaxAmount() {
        return annualMaxAmount;
    }

    public void setAnnualAvailableAmount(Long annualAvailableAmount) {
        this.annualAvailableAmount = annualAvailableAmount;
    }

    public Long getAnnualAvailableAmount() {
        return annualAvailableAmount;
    }

}
