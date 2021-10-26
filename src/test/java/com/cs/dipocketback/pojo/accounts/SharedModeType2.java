package com.cs.dipocketback.pojo.accounts;

import java.util.HashMap;
import java.util.Map;

public enum SharedModeType2 {

    NONE,
    OWNER,
    REGULAR,
    SUPERVISED;
    
    private static final Map<Integer, SharedModeType2> matrix = new HashMap<>();
    static {
        matrix.put(0, REGULAR);
        matrix.put(1, SUPERVISED);
    }

    public static SharedModeType2 valueOf(Integer value) {
        SharedModeType2 sharedModeType2 = matrix.get(value);
        if (sharedModeType2 != null) {
            return sharedModeType2;
        }
        return NONE;
    }
    
}
