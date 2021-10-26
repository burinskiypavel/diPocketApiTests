package com.cs.dipocketback.pojo.push;

public class PushSharedInvite {
    
    private Long clientId;
    private Long accountId;
    private String accountName;
    private String palName;
    
    public PushSharedInvite() {
    }

    public PushSharedInvite(Long clientId, Long accountId, String accountName, String palName) {
        this.clientId = clientId;
        this.accountId = accountId;
        this.accountName = accountName;
        this.palName = palName;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setPalName(String palName) {
        this.palName = palName;
    }

    public String getPalName() {
        return palName;
    }
}
