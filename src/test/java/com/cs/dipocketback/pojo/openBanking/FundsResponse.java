package com.cs.dipocketback.pojo.openBanking;

public class FundsResponse {

    private Boolean fundsAvailable;

    public FundsResponse() {
    }

    public FundsResponse(Boolean fundsAvailable) {
        this.fundsAvailable = fundsAvailable;
    }

    public Boolean getFundsAvailable() {
        return fundsAvailable;
    }

    public void setFundsAvailable(Boolean fundsAvailable) {
        this.fundsAvailable = fundsAvailable;
    }
}
