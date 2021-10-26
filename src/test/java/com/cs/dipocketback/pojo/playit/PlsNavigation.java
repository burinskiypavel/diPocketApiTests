package com.cs.dipocketback.pojo.playit;

public class PlsNavigation {
    
    private PlsNavigationStatus status;    
    private String message;
    private String plsUrl;
    
    public PlsNavigation() {
    }

    public PlsNavigation(PlsNavigationStatus status, String plsUrl, String message) {
        this.status = status;
        this.plsUrl = plsUrl;
        this.message = message;
    }

    public void setStatus(PlsNavigationStatus status) {
        this.status = status;
    }

    public PlsNavigationStatus getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setPlsUrl(String plsUrl) {
        this.plsUrl = plsUrl;
    }

    public String getPlsUrl() {
        return plsUrl;
    }
}
