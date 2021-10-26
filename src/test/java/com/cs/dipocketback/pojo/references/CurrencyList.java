package com.cs.dipocketback.pojo.references;

import java.util.List;

public class CurrencyList {
    
    private List<Currency> currencyList;

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public CurrencyList() {
    }

    public CurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }
}
