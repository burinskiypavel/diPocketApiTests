package com.cs.dipocketback.pojo.incontrol.core.type;

import java.util.HashMap;
import java.util.Map;

public enum TransactionType {

    ATM("Automated Teller Machine"),
    ECOM("eCommerce"),
    MOTO("Mail Order Telephone Order"),
    PAYPASS("Contactless Payment Application"),
    POS("POS"),
    PWCB("Purchase with Cash Back");

    public static final String[] OUTSIDE_OPERATIONS_LIST = { 
        ATM.name(), 
        POS.name(), 
        PAYPASS.name() 
    };

     public static final String[] ALL_OPERATIONS_LIST = {
         ATM.name(),
         ECOM.name(),
         MOTO.name(),
         PAYPASS.name(),
         POS.name(),
         PWCB.name()
     };

     public static final String[] PURCASE_TYPE_OPERATIONS_LIST = {
         ECOM.name(),
         MOTO.name(),
         PAYPASS.name(),
         POS.name()
     };
     
     public static final String[] CASH_TYPE_OPERATIONS_LIST = {
         ATM.name()        
     };

    private static Map<String, TransactionType> mapTransactions = new HashMap<>();

    static {
        for (TransactionType tt : values()) {
            mapTransactions.put(tt.name(), tt);
        }
    }

    private String description;

    private TransactionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static TransactionType findByName(String name) {
        return mapTransactions.get(name);
    }
     
}
