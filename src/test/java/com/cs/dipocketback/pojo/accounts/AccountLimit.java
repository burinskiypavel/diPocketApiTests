package com.cs.dipocketback.pojo.accounts;

public class AccountLimit {
    
    private String name;
    private Long dayCount;
    private Integer ccyId;
    private String ccySymbol;
    private Long maxAmount;
    private Long limitAmount;
    
    public AccountLimit() {
    }

    public AccountLimit(String name, Long dayCount, Integer ccyId, String ccySymbol, Long maxAmount, Long limitAmount) {
        this.name = name;
        this.dayCount = dayCount;
        this.ccyId = ccyId;
        this.ccySymbol = ccySymbol;
        this.maxAmount = maxAmount;
        this.limitAmount = limitAmount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDayCount(Long dayCount) {
        this.dayCount = dayCount;
    }

    public Long getDayCount() {
        return dayCount;
    }

    public void setCcyId(Integer ccyId) {
        this.ccyId = ccyId;
    }

    public Integer getCcyId() {
        return ccyId;
    }

    public void setCcySymbol(String ccySymbol) {
        this.ccySymbol = ccySymbol;
    }

    public String getCcySymbol() {
        return ccySymbol;
    }

    public void setMaxAmount(Long maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Long getMaxAmount() {
        return maxAmount;
    }

    public void setLimitAmount(Long limitAmount) {
        this.limitAmount = limitAmount;
    }

    public Long getLimitAmount() {
        return limitAmount;
    }

}
