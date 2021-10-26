package com.cs.dipocketback.pojo.references.params;

public class ParamsThemes {
    
    private String defaultType;
    private Boolean isSwitchSupported;
    
    public ParamsThemes() {
    }

    public ParamsThemes(String defaultType, Boolean isSwitchSupported) {
        this.defaultType = defaultType;
        this.isSwitchSupported = isSwitchSupported;
    }

    public void setDefaultType(String defaultType) {
        this.defaultType = defaultType;
    }

    public String getDefaultType() {
        return defaultType;
    }

    public void setIsSwitchSupported(Boolean isSwitchSupported) {
        this.isSwitchSupported = isSwitchSupported;
    }

    public Boolean getIsSwitchSupported() {
        return isSwitchSupported;
    }
    
}
