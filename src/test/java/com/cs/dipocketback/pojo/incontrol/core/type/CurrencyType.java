package com.cs.dipocketback.pojo.incontrol.core.type;

public enum CurrencyType {
    
    M("Merchant - transaction"), 
    B("Base – cardholder account currency");
    
    private String description;
    
    private CurrencyType(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }

}
