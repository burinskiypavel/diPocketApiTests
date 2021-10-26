package com.cs.dipocketback.pojo.openBanking;

public class ConsentAccountResponse {

    private ConsentAccount account;

    public ConsentAccountResponse() {
    }

    public ConsentAccountResponse(ConsentAccount account) {
        this.account = account;
    }

    public ConsentAccount getAccount() {
        return account;
    }

    public void setAccount(ConsentAccount account) {
        this.account = account;
    }
}
