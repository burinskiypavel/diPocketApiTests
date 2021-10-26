package com.cs.dipocketback.pojo.currencycloud;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CurrencyPair {
    
    private Integer buyCurrencyId;
    private Integer sellCurrencyId;
    private String code;
    private Timestamp conversionDate;
    private Double rate;
    private BigDecimal tccRate;
    
    public CurrencyPair() {
    }

    public CurrencyPair(Integer buyCurrencyId, 
                        Integer sellCurrencyId, 
                        String code, 
                        Timestamp conversionDate) {
        this.buyCurrencyId = buyCurrencyId;
        this.sellCurrencyId = sellCurrencyId;
        this.code = code;
        this.conversionDate = conversionDate;
    }

    public void setBuyCurrencyId(Integer buyCurrencyId) {
        this.buyCurrencyId = buyCurrencyId;
    }

    public Integer getBuyCurrencyId() {
        return buyCurrencyId;
    }

    public void setSellCurrencyId(Integer sellCurrencyId) {
        this.sellCurrencyId = sellCurrencyId;
    }

    public Integer getSellCurrencyId() {
        return sellCurrencyId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
    
    public void setConversionDate(Timestamp conversionDate) {
        this.conversionDate = conversionDate;
    }

    public Timestamp getConversionDate() {
        return conversionDate;
    }
    
    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getRate() {
        return rate;
    }

    public void setTccRate(BigDecimal tccRate) {
        this.tccRate = tccRate;
    }

    public BigDecimal getTccRate() {
        return tccRate;
    }
    
}
