package com.cs.dipocketback.pojo.gps;

public class GpsErrorMessage {
    
    private String code;
    private String message;

    public GpsErrorMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    
}
