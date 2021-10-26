package com.cs.dipocketback.pojo.accounts;


public class SharedAccountDetail {
        
    private String phoneNumber;
    private String palName;
    private String userName;
    private Boolean accepted;
    private Boolean cancelled;
    
    public SharedAccountDetail() {
    }

    public SharedAccountDetail(String phoneNumber, 
                               String palName, 
                               String userName, 
                               Boolean accepted,
                               Boolean cancelled) {
        this.phoneNumber = phoneNumber;
        this.palName = palName;
        this.userName = userName;
        this.accepted = accepted;
        this.cancelled = cancelled;
    }

    public void setCancelled(Boolean pCancelled) {
        this.cancelled = pCancelled;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setPhoneNumber(String pPhoneNumber) {
        this.phoneNumber = pPhoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPalName(String pPalName) {
        this.palName = pPalName;
    }

    public String getPalName() {
        return palName;
    }

    public void setUserName(String pUserName) {
        this.userName = pUserName;
    }

    public String getUserName() {
        return userName;
    }

    public void setAccepted(Boolean pAccepted) {
        this.accepted = pAccepted;
    }

    public Boolean getAccepted() {
        return accepted;
    }

}
