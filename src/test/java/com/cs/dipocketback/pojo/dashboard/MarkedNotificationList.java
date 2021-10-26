package com.cs.dipocketback.pojo.dashboard;

import java.util.List;

public class MarkedNotificationList {
    
    private List<MarkedNotification> notifications;
    
    public MarkedNotificationList() {
    }

    public MarkedNotificationList(List<MarkedNotification> notifications) {
        this.notifications = notifications;
    }

    public void setNotifications(List<MarkedNotification> notifications) {
        this.notifications = notifications;
    }

    public List<MarkedNotification> getNotifications() {
        return notifications;
    }
}
