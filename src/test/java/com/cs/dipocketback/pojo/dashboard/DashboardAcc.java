package com.cs.dipocketback.pojo.dashboard;

import com.cs.dipocketback.pojo.accounts.SharedModeType;

public class DashboardAcc {
    
    private Long accountId;
    private String accName;
    private Integer ccyId;
    private String fromDateISO;
    private String tillDateISO;
    private SharedModeType sharedModeType;
    
    public DashboardAcc() {
    }

    public DashboardAcc(Long accountId, 
                        String accName, 
                        Integer ccyId, 
                        String fromDateISO, 
                        String tillDateISO, 
                        Integer sharedMode) {
        this.accountId = accountId;
        this.accName = accName;
        this.ccyId = ccyId;
        this.fromDateISO = fromDateISO;
        this.tillDateISO = tillDateISO;
        setSharedModeType(SharedModeType.valueOf(sharedMode));
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccName() {
        return accName;
    }

    public void setCcyId(Integer ccyId) {
        this.ccyId = ccyId;
    }

    public Integer getCcyId() {
        return ccyId;
    }

    public void setFromDateISO(String fromDateISO) {
        this.fromDateISO = fromDateISO;
    }

    public String getFromDateISO() {
        return fromDateISO;
    }

    public void setTillDateISO(String tillDateISO) {
        this.tillDateISO = tillDateISO;
    }

    public String getTillDateISO() {
        return tillDateISO;
    }

    public void setSharedModeType(SharedModeType sharedModeType) {
        this.sharedModeType = sharedModeType;
    }

    public SharedModeType getSharedModeType() {
        return sharedModeType;
    }
    
}
