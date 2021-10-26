package com.cs.dipocketback.pojo.dashboard;

import java.util.List;

public class TransNotificationList {
    
    private List<TransNotification> transNotificationList;

    public TransNotificationList() {
    }

    public TransNotificationList(List<TransNotification> transNotificationList) {
        this.transNotificationList = transNotificationList;
    }

    public void setTransNotificationList(List<TransNotification> transNotificationList) {
        this.transNotificationList = transNotificationList;
    }

    public List<TransNotification> getTransNotificationList() {
        return transNotificationList;
    }

}
