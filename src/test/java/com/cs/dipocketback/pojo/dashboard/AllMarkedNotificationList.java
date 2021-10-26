package com.cs.dipocketback.pojo.dashboard;

import java.util.List;

public class AllMarkedNotificationList {
    
    private List<MarkedNotification> notifications;
    private List<Long> tileIds;
    
    public AllMarkedNotificationList() {
    }

    public void setNotifications(List<MarkedNotification> notifications) {
        this.notifications = notifications;
    }

    public List<MarkedNotification> getNotifications() {
        return notifications;
    }

    public void setTileIds(List<Long> tileIds) {
        this.tileIds = tileIds;
    }

    public List<Long> getTileIds() {
        return tileIds;
    }
}
