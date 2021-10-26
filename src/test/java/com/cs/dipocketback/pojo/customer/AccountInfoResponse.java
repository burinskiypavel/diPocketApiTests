package com.cs.dipocketback.pojo.customer;



public class AccountInfoResponse {


    private Long clientId;
    private String program;

    private String currencyCode;
    private Long feeTariffPlanId;

    private String name;

    private Long avlBalance;

    private Long finBalance;

    private String state;

    public AccountInfoResponse() {
    }

    public AccountInfoResponse(Long clientId, String program, String currencyCode, Long feeTariffPlanId,
                               String name, Long avlBalance, Long finBalance, String state) {
        this.clientId = clientId;
        this.program = program;
        this.currencyCode = currencyCode;
        this.feeTariffPlanId = feeTariffPlanId;
        this.name = name;
        this.avlBalance = avlBalance;
        this.finBalance = finBalance;
        this.state = state;
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

    public Long getAvlBalance() {
        return avlBalance;
    }

    public void setAvlBalance(Long avlBalance) {
        this.avlBalance = avlBalance;
    }

    public Long getFinBalance() {
        return finBalance;
    }

    public void setFinBalance(Long finBalance) {
        this.finBalance = finBalance;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
