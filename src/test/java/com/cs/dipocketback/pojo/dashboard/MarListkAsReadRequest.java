package com.cs.dipocketback.pojo.dashboard;

import java.util.List;

public class MarListkAsReadRequest {
    
    private List<MarkedNotification> notifications;
    
    public MarListkAsReadRequest() {
    }

    public void setNotifications(List<MarkedNotification> notifications) {
        this.notifications = notifications;
    }

    public List<MarkedNotification> getNotifications() {
        return notifications;
    }
}
