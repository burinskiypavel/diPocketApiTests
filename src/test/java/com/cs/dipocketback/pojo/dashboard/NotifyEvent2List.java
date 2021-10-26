package com.cs.dipocketback.pojo.dashboard;

import java.util.List;

public class NotifyEvent2List {
    
    private List<NotifyEvent2> notificationList;
    
    public NotifyEvent2List() {
    }

    public NotifyEvent2List(List<NotifyEvent2> list) {
        this.notificationList = list;
    }

    public void setNotificationList(List<NotifyEvent2> list) {
        this.notificationList = list;
    }

    public List<NotifyEvent2> getNotificationList() {
        return notificationList;
    }
}
