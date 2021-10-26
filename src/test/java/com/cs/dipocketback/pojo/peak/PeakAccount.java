package com.cs.dipocketback.pojo.peak;

public class PeakAccount {
    
    private Integer accCurrencyId;
    private Long accAvailableBalance;
    private Long accFinanceBalance;
    
    public PeakAccount() {
    }

    public PeakAccount(Integer accCurrencyId, Long accAvailableBalance, Long accFinanceBalance) {
        this.accCurrencyId = accCurrencyId;
        this.accAvailableBalance = accAvailableBalance;
        this.accFinanceBalance = accFinanceBalance;
    }

    public void setAccCurrencyId(Integer accCurrencyId) {
        this.accCurrencyId = accCurrencyId;
    }

    public Integer getAccCurrencyId() {
        return accCurrencyId;
    }

    public void setAccAvailableBalance(Long accAvailableBalance) {
        this.accAvailableBalance = accAvailableBalance;
    }

    public Long getAccAvailableBalance() {
        return accAvailableBalance;
    }

    public void setAccFinanceBalance(Long accFinanceBalance) {
        this.accFinanceBalance = accFinanceBalance;
    }

    public Long getAccFinanceBalance() {
        return accFinanceBalance;
    }

}
