package com.cs.dipocketback.pojo.gps;

import java.util.List;

public class GPSSubLimit {
    
    private String process;
    private Long maxPerTransaction;
    private Long minPerTransaction;        
    private List<GPSSubLimitPeriod> subLimitPeriods;
    
    public GPSSubLimit() {
    }
    
    public GPSSubLimit(String process,
                       Long maxPerTransaction,
                       Long minPerTransaction,
                       List<GPSSubLimitPeriod> subLimitPeriods) {
        this.process = process;
        this.maxPerTransaction = maxPerTransaction;
        this.minPerTransaction = minPerTransaction;
        this.subLimitPeriods = subLimitPeriods;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getProcess() {
        return process;
    }

    public void setMaxPerTransaction(Long maxPerTransaction) {
        this.maxPerTransaction = maxPerTransaction;
    }

    public Long getMaxPerTransaction() {
        return maxPerTransaction;
    }

    public void setMinPerTransaction(Long minPerTransaction) {
        this.minPerTransaction = minPerTransaction;
    }

    public Long getMinPerTransaction() {
        return minPerTransaction;
    }

    public void setSubLimitPeriods(List<GPSSubLimitPeriod> subLimitPeriods) {
        this.subLimitPeriods = subLimitPeriods;
    }

    public List<GPSSubLimitPeriod> getSubLimitPeriods() {
        return subLimitPeriods;
    }
}
