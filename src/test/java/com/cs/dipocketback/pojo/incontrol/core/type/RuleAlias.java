package com.cs.dipocketback.pojo.incontrol.core.type;

import java.util.HashMap;
import java.util.Map;

public enum RuleAlias {
    
    CASH_DAILY("CASH DAILY"),
    PURCHASE_DAILY("PURCHASE DAILY"),
    BLOCK_CARD("BLOCK_CARD"),
    DECLINE_BY_TRANSACTION_TYPE("DECLINE_BY_TRANSACTION_TYPE"),
    DECLINE_BY_TRANSACTION_TYPE_AND_COUNTRY("DECLINE_BY_TRANSACTION_TYPE_AND_COUNTRY"),
    DECLINE_BY_MCCS("DECLINE_BY_MCCS");

    private String description;
    
    private static Map<String, RuleAlias> mapAlias = new HashMap<>();
    
    static {
        for (RuleAlias ra : values()) {
            mapAlias.put(ra.description, ra);
        }
    }

    private RuleAlias(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    public static RuleAlias findByDescription(String name) {
        return mapAlias.get(name);
    }
}
