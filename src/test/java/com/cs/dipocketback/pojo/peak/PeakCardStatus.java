package com.cs.dipocketback.pojo.peak;

import java.util.HashMap;
import java.util.Map;

public enum PeakCardStatus {
    
    INACTIVE(null),
    ACTIVE(null),
    DO_NOT_HONOR("05"),
    LOST("41"),
    STOLEN("43"),
    DESTROYED("83");
    
    private final String code;
    
    private static final Map<String, PeakCardStatus> matrix;
    static {
        matrix = new HashMap<>(values().length);
        for (PeakCardStatus status : values()) {
            matrix.put(status.name(), status);
        }
    }
    
    private PeakCardStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
    
    public static PeakCardStatus getByName(String name) {
        PeakCardStatus peakCardStatus = matrix.get(name.toUpperCase());
        return peakCardStatus;
    }

}
