package com.cs.dipocketback.pojo.bacca;

public class BaccaRequest {
    
    private BaccaNavigationStatus navigationStatus;
    private String baccaClientId;
    private String identifyCode;
    private String password;
    private String createAccountUrl;
    private String resetPasswordUrl;
    
    public BaccaRequest() {
    }

    public BaccaRequest(BaccaNavigationStatus navigationStatus, String baccaClientId, String identifyCode,
                        String password, String createAccountUrl, String resetPasswordUrl) {
        this.navigationStatus = navigationStatus;
        this.baccaClientId = baccaClientId;
        this.identifyCode = identifyCode;
        this.password = password;
        this.createAccountUrl = createAccountUrl;
        this.resetPasswordUrl = resetPasswordUrl;
    }

    public BaccaRequest(BaccaNavigationStatus navigationStatus) {
        this.navigationStatus = navigationStatus;
    }

    public void setNavigationStatus(BaccaNavigationStatus navigationStatus) {
        this.navigationStatus = navigationStatus;
    }

    public BaccaNavigationStatus getNavigationStatus() {
        return navigationStatus;
    }

    public void setBaccaClientId(String baccaClientId) {
        this.baccaClientId = baccaClientId;
    }

    public String getBaccaClientId() {
        return baccaClientId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setIdentifyCode(String identifyCode) {
        this.identifyCode = identifyCode;
    }

    public String getIdentifyCode() {
        return identifyCode;
    }

    public void setCreateAccountUrl(String createAccountUrl) {
        this.createAccountUrl = createAccountUrl;
    }

    public String getCreateAccountUrl() {
        return createAccountUrl;
    }

    public void setResetPasswordUrl(String resetPasswordUrl) {
        this.resetPasswordUrl = resetPasswordUrl;
    }

    public String getResetPasswordUrl() {
        return resetPasswordUrl;
    }
}
