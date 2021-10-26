package com.cs.dipocketback.pojo.accounts;

import java.util.HashMap;
import java.util.Map;

public enum SharedModeType {

    REGULAR,
    SUPERVISED;
    
    private static final Map<Integer, SharedModeType> matrix;
    static {
        matrix = new HashMap<>();
        matrix.put(0, REGULAR);
        matrix.put(1, SUPERVISED);
    }

    public static SharedModeType valueOf(Integer value) {
        return matrix.get(value);
    }
    
}
