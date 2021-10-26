package com.cs.dipocketback.pojo.openBanking;

public class FundsRequest {

    private FundsAccount account;
    private FundsAmount instructedAmount;

    public FundsRequest() {
    }

    public FundsRequest(FundsAccount account, FundsAmount instructedAmount) {
        this.account = account;
        this.instructedAmount = instructedAmount;
    }

    public FundsAccount getAccount() {
        return account;
    }

    public void setAccount(FundsAccount account) {
        this.account = account;
    }

    public FundsAmount getInstructedAmount() {
        return instructedAmount;
    }

    public void setInstructedAmount(FundsAmount instructedAmount) {
        this.instructedAmount = instructedAmount;
    }
}
