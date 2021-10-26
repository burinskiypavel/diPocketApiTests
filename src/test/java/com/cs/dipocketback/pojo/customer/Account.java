package com.cs.dipocketback.pojo.customer;

public class Account {
    
    private String currencyCode;
    private Long availableBalance;
    private Long financeBalance;
    
    public Account() {
    }

    public Account(String currencyCode, Long availableBalance, Long financeBalance) {
        this.currencyCode = currencyCode;
        this.availableBalance = availableBalance;
        this.financeBalance = financeBalance;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setAvailableBalance(Long availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Long getAvailableBalance() {
        return availableBalance;
    }

    public void setFinanceBalance(Long financeBalance) {
        this.financeBalance = financeBalance;
    }

    public Long getFinanceBalance() {
        return financeBalance;
    }

}
