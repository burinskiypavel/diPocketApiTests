package com.cs.dipocketback.pojo.payee;

import java.util.HashMap;
import java.util.Map;

public enum PaymentType {
    
    LOCAL_PLN(1),
    SEPA(2),
    SWIFT(3),
    LOCAL_GBP(4),
    LOCAL_HUF(5);
    
    private Integer id;
    
    private PaymentType(int id) {
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }
    
    private static final Map<Integer, PaymentType> matrix = new HashMap<>();
    static {
        for (PaymentType type : values()) {
            matrix.put(type.getId(), type);
        }
    }
    
    public static PaymentType valueOf(Integer id) {
        return matrix.get(id);
    }
    
}
