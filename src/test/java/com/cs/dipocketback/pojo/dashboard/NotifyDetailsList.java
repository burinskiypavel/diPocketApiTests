package com.cs.dipocketback.pojo.dashboard;

import java.util.List;

public class NotifyDetailsList {
    
    private List<NotifyDetails> detailsList;
    
    public NotifyDetailsList() {
    }

    public NotifyDetailsList(List<NotifyDetails> detailsList) {
        this.detailsList = detailsList;
    }

    public void setDetailsList(List<NotifyDetails> detailsList) {
        this.detailsList = detailsList;
    }

    public List<NotifyDetails> getDetailsList() {
        return detailsList;
    }
}
