package com.cs.dipocketback.pojo.references.params;

public class AppParamsPayments {
    
    private ParamsRequestMoney requestMoney;
    private ParamsSendMoney sendMoney;
    private ParamsTopUp topUp;

    public AppParamsPayments() {
    }

    public void setRequestMoney(ParamsRequestMoney requestMoney) {
        this.requestMoney = requestMoney;
    }

    public ParamsRequestMoney getRequestMoney() {
        return requestMoney;
    }

    public void setSendMoney(ParamsSendMoney sendMoney) {
        this.sendMoney = sendMoney;
    }

    public ParamsSendMoney getSendMoney() {
        return sendMoney;
    }

    public void setTopUp(ParamsTopUp topUp) {
        this.topUp = topUp;
    }

    public ParamsTopUp getTopUp() {
        return topUp;
    }

}
