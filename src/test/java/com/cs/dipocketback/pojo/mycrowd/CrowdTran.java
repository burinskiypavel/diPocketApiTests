package com.cs.dipocketback.pojo.mycrowd;

public class CrowdTran {
    
    private Long eventId;
    private Long tranId;
    
    public CrowdTran() {
    }

    public CrowdTran(Long eventId, Long tranId) {
        this.eventId = eventId;
        this.tranId = tranId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setTranId(Long tranId) {
        this.tranId = tranId;
    }

    public Long getTranId() {
        return tranId;
    }
    
}
