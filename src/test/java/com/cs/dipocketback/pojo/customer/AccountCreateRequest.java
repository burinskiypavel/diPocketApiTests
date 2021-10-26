package com.cs.dipocketback.pojo.customer;



public class AccountCreateRequest {

    private String requestId;

    private Long clientId;
    private String program;
    private String currencyCode;
    private Long feeTariffPlanId;

    private String name;

    public AccountCreateRequest() {
    }

    public AccountCreateRequest(String requestId, Long clientId, String program,
                                String currencyCode, Long feeTariffPlanId, String name) {
        this.requestId = requestId;
        this.clientId = clientId;
        this.program = program;
        this.currencyCode = currencyCode;
        this.name = name;
        this.feeTariffPlanId = feeTariffPlanId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFeeTariffPlanId() {
        return feeTariffPlanId;
    }

    public void setFeeTariffPlanId(Long feeTariffPlanId) {
        this.feeTariffPlanId = feeTariffPlanId;
    }
}
