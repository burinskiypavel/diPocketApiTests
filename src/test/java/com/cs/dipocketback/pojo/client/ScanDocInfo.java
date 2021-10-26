package com.cs.dipocketback.pojo.client;

import java.util.List;

public class ScanDocInfo {
    
    private String message;
    private List<Long> imageTypes;
    
    public ScanDocInfo() {
    }

    public ScanDocInfo(String message, List<Long> imageTypes) {
        this.message = message;
        this.imageTypes = imageTypes;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setImageTypes(List<Long> imageTypes) {
        this.imageTypes = imageTypes;
    }

    public List<Long> getImageTypes() {
        return imageTypes;
    }
}
