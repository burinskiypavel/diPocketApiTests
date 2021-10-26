package com.cs.dipocketback.pojo.gps;

import java.util.List;

public class GPSLimitInformation {
    
    private Long maxAllowableBalance;
    private Long minPerTransaction;
    private List<GPSSubLimit> subLimits;
    
    public GPSLimitInformation() {
    }
    
    public GPSLimitInformation(Long maxAllowableBalance, Long minPerTransaction,
                               List<GPSSubLimit> subLimits) {
        this.maxAllowableBalance = maxAllowableBalance;
        this.minPerTransaction = minPerTransaction;
        this.subLimits = subLimits;
    }

    public void setMaxAllowableBalance(Long maxAllowableBalance) {
        this.maxAllowableBalance = maxAllowableBalance;
    }

    public Long getMaxAllowableBalance() {
        return maxAllowableBalance;
    }

    public void setMinPerTransaction(Long minPerTransaction) {
        this.minPerTransaction = minPerTransaction;
    }

    public Long getMinPerTransaction() {
        return minPerTransaction;
    }

    public void setSubLimits(List<GPSSubLimit> subLimits) {
        this.subLimits = subLimits;
    }

    public List<GPSSubLimit> getSubLimits() {
        return subLimits;
    }
}
