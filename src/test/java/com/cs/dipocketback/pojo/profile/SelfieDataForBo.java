package com.cs.dipocketback.pojo.profile;

public class SelfieDataForBo {
    
    private Long clientId;
    private String base64Selfie1;
    private String base64Selfie2;

    public SelfieDataForBo() {
    }

    public SelfieDataForBo(Long clientId, String base64Selfie1, String base64Selfie2) {
        this.clientId = clientId;
        this.base64Selfie1 = base64Selfie1;
        this.base64Selfie2 = base64Selfie2;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setBase64Selfie1(String base64Selfie1) {
        this.base64Selfie1 = base64Selfie1;
    }

    public String getBase64Selfie1() {
        return base64Selfie1;
    }

    public void setBase64Selfie2(String base64Selfie2) {
        this.base64Selfie2 = base64Selfie2;
    }

    public String getBase64Selfie2() {
        return base64Selfie2;
    }

}
