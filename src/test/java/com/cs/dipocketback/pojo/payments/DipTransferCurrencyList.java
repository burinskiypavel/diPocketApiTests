package com.cs.dipocketback.pojo.payments;

import java.util.List;

public class DipTransferCurrencyList {
    
    private List<DipTransferCurrency> currencies;
    private String dipTransferCurrencyHash;

    public DipTransferCurrencyList() {
    }
    
    public DipTransferCurrencyList(List<DipTransferCurrency> currencies, String dipTransferCurrencyHash) {
        this.currencies = currencies;
        this.dipTransferCurrencyHash = dipTransferCurrencyHash;
    }

    public void setCurrencies(List<DipTransferCurrency> currencies) {
        this.currencies = currencies;
    }

    public List<DipTransferCurrency> getCurrencies() {
        return currencies;
    }

    public void setDipTransferCurrencyHash(String dipTransferCurrencyHash) {
        this.dipTransferCurrencyHash = dipTransferCurrencyHash;
    }

    public String getDipTransferCurrencyHash() {
        return dipTransferCurrencyHash;
    }
    
}
