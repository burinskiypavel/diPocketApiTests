package com.cs.dipocketback.pojo.limit.transaction;

public class GetLimitsByTranGroupResponse {

    private Long min;
    private Long max;
    private String currencyCode;

    public GetLimitsByTranGroupResponse() {
    }

    public GetLimitsByTranGroupResponse(Long min, Long max, String currencyCode) {
        this.min = min;
        this.max = max;
        this.currencyCode = currencyCode;
    }

    public Long getMin() {
        return min;
    }

    public void setMin(Long min) {
        this.min = min;
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}
