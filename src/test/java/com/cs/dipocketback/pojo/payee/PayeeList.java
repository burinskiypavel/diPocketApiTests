package com.cs.dipocketback.pojo.payee;

import java.util.List;

public class PayeeList {

    private List<Payee> payeeList;

    public PayeeList() {
    }

    public PayeeList(List<Payee> payeeList) {
        this.payeeList = payeeList;
    }

    public void setPayeeList(List<Payee> payeeList) {
        this.payeeList = payeeList;
    }

    public List<Payee> getPayeeList() {
        return payeeList;
    }

}