package com.cs.dipocketback.pojo.client;

import java.util.HashMap;
import java.util.Map;

public enum CardholderNameState {
    TOO_LONG,
    NOT_VERIFIED,
    VERIFIED;
    
    private static final Map<Integer, CardholderNameState> matrix;
    static {
        matrix = new HashMap<>();
        matrix.put(-1, TOO_LONG);
        matrix.put(0, NOT_VERIFIED);
        matrix.put(1, VERIFIED);
    }

    public static CardholderNameState valueOf(Integer value) {
        return matrix.get(value);
    }
}
