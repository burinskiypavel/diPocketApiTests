package com.cs.dipocketback.pojo.payee;

public class AvailCurrencies {
    
    private Integer ccyId;
    private String ccy;
    private String symbol;
    private String name;
    
    public AvailCurrencies() {
    }

    public AvailCurrencies(Integer ccyId, 
                           String ccy, 
                           String symbol, 
                           String name) {
        this.ccyId = ccyId;
        this.ccy = ccy;
        this.symbol = symbol;
        this.name = name;
    }

    public void setCcyId(Integer ccyId) {
        this.ccyId = ccyId;
    }

    public Integer getCcyId() {
        return ccyId;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getCcy() {
        return ccy;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
