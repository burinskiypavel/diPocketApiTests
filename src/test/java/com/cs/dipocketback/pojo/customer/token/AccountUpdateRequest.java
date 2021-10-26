package com.cs.dipocketback.pojo.customer.token;



public class AccountUpdateRequest {


    private String requestId;

    private Long accountId;
    private Long feeTariffPlanId;

    private String name;

    public AccountUpdateRequest() {
    }

    public AccountUpdateRequest(String requestId, Long accountId, Long feeTariffPlanId, String name) {
        this.requestId = requestId;
        this.accountId = accountId;
        this.feeTariffPlanId = feeTariffPlanId;
        this.name = name;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getFeeTariffPlanId() {
        return feeTariffPlanId;
    }

    public void setFeeTariffPlanId(Long feeTariffPlanId) {
        this.feeTariffPlanId = feeTariffPlanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
