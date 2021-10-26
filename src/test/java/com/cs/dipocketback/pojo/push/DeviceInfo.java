package com.cs.dipocketback.pojo.push;

import java.io.Serializable;

public class DeviceInfo implements Serializable {

    private Long id;
    private String devToken;
    private String devType;
    private String deviceUUID;
    private String gcmSenderId;
    private String dpi;
    private String appVersion;
    private Long width;
    private Long height;
    private String otp;
    private String authenticationMethod;
    
    public DeviceInfo() {
    }
    
    public DeviceInfo(Long id, 
                      String devToken, 
                      String devType, 
                      String deviceUUID, 
                      String gcmSenderId, 
                      String dpi,
                      Long width, 
                      Long height) {
        this.id = id;
        this.devToken = devToken;
        this.devType = devType;
        this.deviceUUID = deviceUUID;
        this.gcmSenderId = gcmSenderId;
        this.dpi = dpi;
        this.width = width;
        this.height = height;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getDpi() {
        return dpi;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getWidth() {
        return width;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getHeight() {
        return height;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDevToken(String devToken) {
        this.devToken = devToken;
    }

    public String getDevToken() {
        return devToken;
    }

    public void setDevType(String devType) {
        this.devType = devType;
    }

    public String getDevType() {
        return devType;
    }

    public void setDeviceUUID(String deviceUUID) {
        this.deviceUUID = deviceUUID;
    }

    public String getDeviceUUID() {
        return deviceUUID;
    }

    public void setGcmSenderId(String gcmSenderId) {
        this.gcmSenderId = gcmSenderId;
    }

    public String getGcmSenderId() {
        return gcmSenderId;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getAuthenticationMethod() {
        return authenticationMethod;
    }

    public void setAuthenticationMethod(String authenticationMethod) {
        this.authenticationMethod = authenticationMethod;
    }
}
