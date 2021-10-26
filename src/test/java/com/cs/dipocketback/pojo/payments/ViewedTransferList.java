package com.cs.dipocketback.pojo.payments;

import java.util.ArrayList;
import java.util.List;

public class ViewedTransferList {

    private List<Long> viewedTransfers;

    public ViewedTransferList() {
    }

    public ViewedTransferList(List<Long> viewedTransfers) {
      this.viewedTransfers = viewedTransfers;
    }

    public void setViewedTransfers(List<Long> viewedTransfers) {
        this.viewedTransfers = viewedTransfers;
    }

    public List<Long> getViewedTransfers() {
        return (viewedTransfers != null) ? viewedTransfers : (viewedTransfers = new ArrayList<>(2));
    }

}
