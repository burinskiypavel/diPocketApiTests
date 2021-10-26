package com.cs.dipocketback.pojo.dippal;

public class ClientPal {

    private Long clientId;
    private String palName;
    private String palPhone;
    private Boolean phoneChanged;
    private String imageSURL;
    private String imageMURL;
    
    public ClientPal() {
    }
    
    public ClientPal(String palPhone, String palName) {
        this.palPhone = palPhone;
        this.palName = palName;
    }

    public ClientPal(Long clientId, 
                     String palName, 
                     String palPhone, 
                     Boolean phoneChanged, 
                     String imageSURL, 
                     String imageMURL) {
        this.clientId = clientId;
        this.palName = palName;
        this.palPhone = palPhone;
        this.phoneChanged = phoneChanged;
        this.imageSURL = imageSURL;
        this.imageMURL = imageMURL;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setPalName(String palName) {
        this.palName = palName;
    }

    public String getPalName() {
        return palName;
    }

    public void setPalPhone(String palPhone) {
        this.palPhone = palPhone;
    }

    public String getPalPhone() {
        return palPhone;
    }

    public void setPhoneChanged(Boolean phoneChanged) {
        this.phoneChanged = phoneChanged;
    }

    public Boolean getPhoneChanged() {
        return phoneChanged;
    }

    public void setImageSURL(String imageSURL) {
        this.imageSURL = imageSURL;
    }

    public String getImageSURL() {
        return imageSURL;
    }

    public void setImageMURL(String imageMURL) {
        this.imageMURL = imageMURL;
    }

    public String getImageMURL() {
        return imageMURL;
    }

}
