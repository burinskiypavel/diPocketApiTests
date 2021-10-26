package com.cs.dipocketback.pojo.payments.f2f;

public class F2FComputeSendMoneyRequest {

    private Long dstAmount;
    private Long srcAccountId;

    public Long getDstAmount() {
        return dstAmount;
    }

    public void setDstAmount(Long dstAmount) {
        this.dstAmount = dstAmount;
    }

    public Long getSrcAccountId() {
        return srcAccountId;
    }

    public void setSrcAccountId(Long srcAccountId) {
        this.srcAccountId = srcAccountId;
    }
}
