package com.cs.dipocketback.pojo.accounts;

import java.util.List;

public class OpeningAccountFeeResponce {
    
    private List<OpeningAccountFee> feeList;
    
    public OpeningAccountFeeResponce() {
    }

    public OpeningAccountFeeResponce(List<OpeningAccountFee> feeList) {
        this.feeList = feeList;
    }

    public void setFeeList(List<OpeningAccountFee> feeList) {
        this.feeList = feeList;
    }

    public List<OpeningAccountFee> getFeeList() {
        return feeList;
    }

}
