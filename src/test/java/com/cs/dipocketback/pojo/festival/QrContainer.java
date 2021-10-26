package com.cs.dipocketback.pojo.festival;

public class QrContainer {
    
    private String qrCode;
    private Boolean justGenerated;
    
    public QrContainer() {
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setJustGenerated(Boolean justGenerated) {
        this.justGenerated = justGenerated;
    }

    public Boolean getJustGenerated() {
        return justGenerated;
    }
}
