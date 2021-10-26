package com.cs.dipocketback.pojo.dashboard;

import java.util.List;

public class DashboardAccList {
    
    private List<DashboardAcc> dashAccList;
    
    public DashboardAccList() {
    }

    public DashboardAccList(List<DashboardAcc> dashAccList) {
        this.dashAccList = dashAccList;
    }

    public void setDashAccList(List<DashboardAcc> dashAccList) {
        this.dashAccList = dashAccList;
    }

    public List<DashboardAcc> getDashAccList() {
        return dashAccList;
    }
}
