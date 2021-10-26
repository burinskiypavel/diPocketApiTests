package com.cs.dipocketback.pojo.mycrowd;

public class EventOwner {
    
    private String sName;
    private Long ownerId; 
    
    public EventOwner() {
    }

    public EventOwner(String sName, Long ownerId) {
        this.sName = sName;
        this.ownerId = ownerId;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getSName() {
        return sName;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getOwnerId() {
        return ownerId;
    }
    
}
