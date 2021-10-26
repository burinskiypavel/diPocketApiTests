package com.cs.dipocketback.pojo.payments.f2f;

import com.cs.dipocketback.pojo.accounts.Account;
import com.cs.dipocketback.pojo.payments.PayRequest;

public class F2FDoSendMoneyResponse {

    private String dstMainPhone;
    private Long transactionId;
    private PayRequest.PayRequestStatus status;
    private Account srcAccount;

    public String getDstMainPhone() {
        return dstMainPhone;
    }

    public void setDstMainPhone(String dstMainPhone) {
        this.dstMainPhone = dstMainPhone;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public PayRequest.PayRequestStatus getStatus() {
        return status;
    }

    public void setStatus(PayRequest.PayRequestStatus status) {
        this.status = status;
    }

    public Account getSrcAccount() {
        return srcAccount;
    }

    public void setSrcAccount(Account srcAccount) {
        this.srcAccount = srcAccount;
    }
}
