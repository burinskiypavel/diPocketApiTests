package com.cs.dipocketback.pojo.festival;

public class FestivalCalcTopupResponse {
    
    private String feeCcy;
    private Long feeAmount;
    
    public FestivalCalcTopupResponse() {
    }

    public void setFeeCcy(String feeCcy) {
        this.feeCcy = feeCcy;
    }

    public String getFeeCcy() {
        return feeCcy;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }
}
