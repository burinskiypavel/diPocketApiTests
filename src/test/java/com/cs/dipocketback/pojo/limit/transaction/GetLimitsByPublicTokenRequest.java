package com.cs.dipocketback.pojo.limit.transaction;

import com.cs.dipocketback.base.data.TransactionLimitGroup;

public class GetLimitsByPublicTokenRequest {

    private String publicToken;
    private TransactionLimitGroup tranGroup;

    public GetLimitsByPublicTokenRequest() {
    }

    public GetLimitsByPublicTokenRequest(String publicToken, TransactionLimitGroup tranGroup) {
        this.publicToken = publicToken;
        this.tranGroup = tranGroup;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public TransactionLimitGroup getTranGroup() {
        return tranGroup;
    }

    public void setTranGroup(TransactionLimitGroup tranGroup) {
        this.tranGroup = tranGroup;
    }

}
