package com.cs.dipocketback.pojo.gps;

public class CardMerchantTodoRequest {

    private Long wsId;
    private String issCode;
    private String whiteList;
    private String merchantId;
    private Integer action;

    public Long getWsId() {
        return wsId;
    }

    public void setWsId(Long wsId) {
        this.wsId = wsId;
    }

    public String getIssCode() {
        return issCode;
    }

    public void setIssCode(String issCode) {
        this.issCode = issCode;
    }

    public String getWhiteList() {
        return whiteList;
    }

    public void setWhiteList(String whiteList) {
        this.whiteList = whiteList;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }
}
