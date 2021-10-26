package com.cs.dipocketback.pojo.payments;

import java.util.ArrayList;
import java.util.List;

public class RecentTransferList {
    
    private List<RecentTransfer> recentTransferList;

    public RecentTransferList() {
    }

    public RecentTransferList(List<RecentTransfer> recentTransferList) {
        this.recentTransferList = recentTransferList;
    }

    public void setRecentTransferList(List<RecentTransfer> recentTransferList) {
        this.recentTransferList = recentTransferList;
    }

    public List<RecentTransfer> getRecentTransferList() {
        return (recentTransferList != null) ? recentTransferList : (recentTransferList = new ArrayList<>(2));
    }

}
