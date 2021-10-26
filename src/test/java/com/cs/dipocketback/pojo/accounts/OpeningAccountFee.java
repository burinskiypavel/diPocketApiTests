package com.cs.dipocketback.pojo.accounts;

import com.cs.dipocketback.pojo.card.CardFee;

public class OpeningAccountFee {
    
    private Integer currencyId;
    private String currencyCode;
    private CardFee plasticCardFee;
    private CardFee virtualCardFee;
    
    public OpeningAccountFee() {
    }

    public OpeningAccountFee(Integer currencyId, String currencyCode, CardFee plasticCardFee, CardFee virtualCardFee) {
        this.currencyId = currencyId;
        this.currencyCode = currencyCode;
        this.plasticCardFee = plasticCardFee;
        this.virtualCardFee = virtualCardFee;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setPlasticCardFee(CardFee plasticCardFee) {
        this.plasticCardFee = plasticCardFee;
    }

    public CardFee getPlasticCardFee() {
        return plasticCardFee;
    }

    public void setVirtualCardFee(CardFee virtualCardFee) {
        this.virtualCardFee = virtualCardFee;
    }

    public CardFee getVirtualCardFee() {
        return virtualCardFee;
    }

}
