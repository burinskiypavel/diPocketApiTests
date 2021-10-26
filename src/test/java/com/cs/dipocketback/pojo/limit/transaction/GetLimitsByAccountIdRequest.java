package com.cs.dipocketback.pojo.limit.transaction;

import com.cs.dipocketback.base.data.TransactionLimitGroup;

public class GetLimitsByAccountIdRequest {

    private Long accountId;
    private TransactionLimitGroup tranGroup;

    public GetLimitsByAccountIdRequest() {
    }

    public GetLimitsByAccountIdRequest(Long accountId, TransactionLimitGroup tranGroup) {
        this.accountId = accountId;
        this.tranGroup = tranGroup;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public TransactionLimitGroup getTranGroup() {
        return tranGroup;
    }

    public void setTranGroup(TransactionLimitGroup tranGroup) {
        this.tranGroup = tranGroup;
    }

}
