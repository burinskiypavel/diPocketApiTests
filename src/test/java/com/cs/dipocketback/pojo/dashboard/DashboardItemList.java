package com.cs.dipocketback.pojo.dashboard;

import java.util.List;

public class DashboardItemList {
    
    private List<DashboardItem> dashboardItemList;
    
    public DashboardItemList() {
    }

    public DashboardItemList(List<DashboardItem> dashboardItemList) {
        this.dashboardItemList = dashboardItemList;
    }

    public void setDashboardItemList(List<DashboardItem> dashboardItemList) {
        this.dashboardItemList = dashboardItemList;
    }

    public List<DashboardItem> getDashboardItemList() {
        return dashboardItemList;
    }
    
}
