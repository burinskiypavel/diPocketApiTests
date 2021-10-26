package com.cs.dipocketback.pojo.currencycloud;

import java.util.List;

public class CurrencyPairList {
    
    private List<CurrencyPair> list;
    
    public CurrencyPairList() {
    }

    public CurrencyPairList(List<CurrencyPair> list) {
        this.list = list;
    }

    public void setList(List<CurrencyPair> list) {
        this.list = list;
    }

    public List<CurrencyPair> getList() {
        return list;
    }
}
