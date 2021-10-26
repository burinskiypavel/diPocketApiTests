package com.cs.dipocketback.pojo.mycrowd;

public class Contribution {
    
    private Long srcAccountId;
    private Long srcAmount;
    private Long srcCcyId;
    private String srcCcy;
    
    public Contribution() {
    }

    public void setSrcAccountId(Long srcAccountId) {
        this.srcAccountId = srcAccountId;
    }

    public Long getSrcAccountId() {
        return srcAccountId;
    }

    public void setSrcAmount(Long srcAmount) {
        this.srcAmount = srcAmount;
    }

    public Long getSrcAmount() {
        return srcAmount;
    }

    public void setSrcCcyId(Long srcCcyId) {
        this.srcCcyId = srcCcyId;
    }

    public Long getSrcCcyId() {
        return srcCcyId;
    }

    public void setSrcCcy(String srcCcy) {
        this.srcCcy = srcCcy;
    }

    public String getSrcCcy() {
        return srcCcy;
    }

}
