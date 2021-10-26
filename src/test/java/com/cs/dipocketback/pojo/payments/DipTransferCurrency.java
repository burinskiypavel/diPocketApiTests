package com.cs.dipocketback.pojo.payments;

public class DipTransferCurrency {
    
    private Integer id;
    private String code;
    private String symbol;
    private String name;
    
    public DipTransferCurrency() {
    }

    public DipTransferCurrency(Integer id, String code, String symbol, String name) {
        this.id = id;
        this.code = code;
        this.symbol = symbol;
        this.name = name;
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
    
}
