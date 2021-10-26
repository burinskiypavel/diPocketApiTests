package com.cs.dipocketback.pojo.accounts;

public class AccountCurrency {
    
    private Integer id;
    private String code;
    private String symbol;
    private String name;
    private Boolean canOpenVirtual;
    private Boolean canOpenPlastic;
    
    public AccountCurrency() {
    }
    
    public AccountCurrency(Integer id, 
                           String code, 
                           String symbol, 
                           String name, 
                           Boolean canOpenVirtual,
                           Boolean canOpenPlastic) {
        this.id = id;
        this.code = code;
        this.symbol = symbol;
        this.name = name;
        this.canOpenVirtual = canOpenVirtual;
        this.canOpenPlastic = canOpenPlastic;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
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

    public void setCanOpenVirtual(Boolean canOpenVirtual) {
        this.canOpenVirtual = canOpenVirtual;
    }

    public Boolean getCanOpenVirtual() {
        return canOpenVirtual;
    }

    public void setCanOpenPlastic(Boolean canOpenPlastic) {
        this.canOpenPlastic = canOpenPlastic;
    }

    public Boolean getCanOpenPlastic() {
        return canOpenPlastic;
    }

}
