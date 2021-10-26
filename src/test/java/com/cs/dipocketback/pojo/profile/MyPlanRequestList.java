package com.cs.dipocketback.pojo.profile;

import java.util.Arrays;
import java.util.List;

public class MyPlanRequestList {
    
    private static final MyPlanRequestList stub = new MyPlanRequestList(Arrays.asList(new MyPlanRequest[] {
        new MyPlanRequest("monthly", "Account in GBP", 1050L, 1L, 1050L, "GBP"),
        new MyPlanRequest("monthToDate", "SEPA Transfer", 5000L, 2L, 2500L, "EUR"),
        new MyPlanRequest("lastMonth", "SMS Notification", 5000L, 1L, 5000L, "PLN")
    }));
    
    private List<MyPlanRequest> myPlanRequestList;
    
    public MyPlanRequestList() {
    }
    
    public MyPlanRequestList(List<MyPlanRequest> myPlanRequestList) {
        this.myPlanRequestList = myPlanRequestList;
    }

    public void setMyPlanRequestList(List<MyPlanRequest> myPlanRequestList) {
        this.myPlanRequestList = myPlanRequestList;
    }

    public List<MyPlanRequest> getMyPlanRequestList() {
        return myPlanRequestList;
    }
    
    public static MyPlanRequestList getStub() {
        return stub;
    }

}
