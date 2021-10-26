package com.cs.dipocketback.pojo.bacca;

public class BaccaModifyPaymentSchedule {
    
    private Integer modifyDay;
    private String modifyScheduleUrl;

    public BaccaModifyPaymentSchedule() {
    }

    public BaccaModifyPaymentSchedule(Integer modifyDay, String modifyScheduleUrl) {
        this.modifyDay = modifyDay;
        this.modifyScheduleUrl = modifyScheduleUrl;
    }

    public void setModifyDay(Integer modifyDay) {
        this.modifyDay = modifyDay;
    }

    public Integer getModifyDay() {
        return modifyDay;
    }

    public void setModifyScheduleUrl(String modifyScheduleUrl) {
        this.modifyScheduleUrl = modifyScheduleUrl;
    }

    public String getModifyScheduleUrl() {
        return modifyScheduleUrl;
    }

}
