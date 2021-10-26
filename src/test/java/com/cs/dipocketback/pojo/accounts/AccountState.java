package com.cs.dipocketback.pojo.accounts;

import java.util.HashMap;
import java.util.Map;

public enum AccountState {
    
    TOCONFIRM,
    TOOPEN,
    HIDDEN,
    ACTIVE,
    FROZEN,
    CLOSED;
    
    private static final Map<Integer, AccountState> matrix;
    static {
        matrix = new HashMap<>();
        matrix.put(0, TOCONFIRM);
        matrix.put(5, TOOPEN);
        matrix.put(10, HIDDEN);
        matrix.put(20, ACTIVE);
        matrix.put(-50, FROZEN);
        matrix.put(-100, CLOSED);
    }
    
    public static AccountState valueOf(Integer value) {
        return matrix.get(value);
    }
}
