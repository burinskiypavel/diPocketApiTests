package com.cs.dipocketback.base.data;

public class Currency {

    // ISO 4217
    private int id;
    private String code;
    private String symbol;

    public Currency(int id, String code, String symbol) {
        this.id = id;
        this.code = code;
        this.symbol = symbol;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }

}
