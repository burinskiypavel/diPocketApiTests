package com.cs.dipocketback.pojo.playit;

public class LoadResult {
    
    private Long powId;
    private Long tranid;
    private Long accountId;
    
    public LoadResult() {
    }

    public void setPowId(Long powId) {
        this.powId = powId;
    }

    public Long getPowId() {
        return powId;
    }

    public void setTranid(Long tranid) {
        this.tranid = tranid;
    }

    public Long getTranid() {
        return tranid;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }
}
