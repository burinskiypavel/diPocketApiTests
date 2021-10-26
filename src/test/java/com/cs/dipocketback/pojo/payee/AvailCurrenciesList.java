package com.cs.dipocketback.pojo.payee;

import java.util.List;

public class AvailCurrenciesList {
    
    private List<AvailCurrencies> currencyList;
    private String payeeCurrencyHash;

    public AvailCurrenciesList() {
    }
    
    public AvailCurrenciesList(List<AvailCurrencies> currencyList, String payeeCurrencyHash) {
        this.currencyList = currencyList;
        this.payeeCurrencyHash = payeeCurrencyHash;
    }

    public void setCurrencyList(List<AvailCurrencies> currencyList) {
        this.currencyList = currencyList;
    }

    public List<AvailCurrencies> getCurrencyList() {
        return currencyList;
    }

    public void setPayeeCurrencyHash(String hash) {
        this.payeeCurrencyHash = hash;
    }

    public String getPayeeCurrencyHash() {
        return payeeCurrencyHash;
    }
    
}
