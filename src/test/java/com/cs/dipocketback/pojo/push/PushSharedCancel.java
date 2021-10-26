package com.cs.dipocketback.pojo.push;

public class PushSharedCancel {

    private Long clientId;
    private String accountName;
    private String palName;
    
    public PushSharedCancel() {
    }

    public PushSharedCancel(Long clientId, String accountName, String palName) {
        this.clientId = clientId;
        this.accountName = accountName;
        this.palName = palName;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
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
