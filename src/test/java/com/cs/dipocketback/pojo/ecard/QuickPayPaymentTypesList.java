package com.cs.dipocketback.pojo.ecard;

import java.util.List;

public class QuickPayPaymentTypesList {
    
    List<QuickPayPaymentTypes> quickPayPaymentTypesList;
    
    public QuickPayPaymentTypesList() {
    }

    public QuickPayPaymentTypesList(List<QuickPayPaymentTypes> quickPayPaymentTypesList) {
        this.quickPayPaymentTypesList = quickPayPaymentTypesList;
    }

    public void setQuickPayPaymentTypesList(List<QuickPayPaymentTypes> quickPayPaymentTypesList) {
        this.quickPayPaymentTypesList = quickPayPaymentTypesList;
    }

    public List<QuickPayPaymentTypes> getQuickPayPaymentTypesList() {
        return quickPayPaymentTypesList;
    }

}
