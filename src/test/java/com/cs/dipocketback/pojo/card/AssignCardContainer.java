package com.cs.dipocketback.pojo.card;

public class AssignCardContainer {
    
    private Long clidentId;
    private Long powId;
    
    public AssignCardContainer() {
    }

    public AssignCardContainer(Long clidentId, Long powId) {
        this.clidentId = clidentId;
        this.powId = powId;
    }

    public void setClidentId(Long clidentId) {
        this.clidentId = clidentId;
    }

    public Long getClidentId() {
        return clidentId;
    }

    public void setPowId(Long powId) {
        this.powId = powId;
    }

    public Long getPowId() {
        return powId;
    }

}
