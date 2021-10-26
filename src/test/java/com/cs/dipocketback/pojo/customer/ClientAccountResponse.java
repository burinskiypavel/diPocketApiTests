package com.cs.dipocketback.pojo.customer;



public class ClientAccountResponse {


    private Long id;

    private Long availableBalance;

    private Long financeBalance;

    private String state;

    private String name;

    private String currencyCode;

    public ClientAccountResponse() {
    }

    public ClientAccountResponse( Long id,  Long availableBalance,  Long financeBalance,
                                  String state,  String name,  String currencyCode) {
        this.id = id;
        this.availableBalance = availableBalance;
        this.financeBalance = financeBalance;
        this.state = state;
        this.name = name;
        this.currencyCode = currencyCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Long availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Long getFinanceBalance() {
        return financeBalance;
    }

    public void setFinanceBalance(Long financeBalance) {
        this.financeBalance = financeBalance;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
