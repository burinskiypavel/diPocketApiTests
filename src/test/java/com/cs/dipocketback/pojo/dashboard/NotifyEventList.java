package com.cs.dipocketback.pojo.dashboard;

import java.util.List;

public class NotifyEventList {
    
    private List<NotifyEvent> notifyList;
    
    public NotifyEventList() {
    }

    public NotifyEventList(List<NotifyEvent> notifyList) {
        this.notifyList = notifyList;
    }

    public void setNotifyList(List<NotifyEvent> notifyList) {
        this.notifyList = notifyList;
    }

    public List<NotifyEvent> getNotifyList() {
        return notifyList;
    }
}
