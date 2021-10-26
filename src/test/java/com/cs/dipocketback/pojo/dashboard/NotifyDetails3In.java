package com.cs.dipocketback.pojo.dashboard;


public class NotifyDetails3In {
    
    private Integer typeId;
    private Long notifyId;
    private String detailsRef;
    
    public NotifyDetails3In() {
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setNotifyId(Long notifyId) {
        this.notifyId = notifyId;
    }

    public Long getNotifyId() {
        return notifyId;
    }

    public void setDetailsRef(String detailsRef) {
        this.detailsRef = detailsRef;
    }

    public String getDetailsRef() {
        return detailsRef;
    }
}
