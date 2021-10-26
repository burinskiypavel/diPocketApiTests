package com.cs.dipocketback.pojo.ecard;

public class QuickPayPaymentResponse {
    
    private String ecardUrl;
    private String returnLink;
    
    public QuickPayPaymentResponse() {
    }

    public QuickPayPaymentResponse(String ecardUrl, String returnLink) {
        this.ecardUrl = ecardUrl;
        this.returnLink = returnLink;
    }

    public void setEcardUrl(String ecardUrl) {
        this.ecardUrl = ecardUrl;
    }

    public String getEcardUrl() {
        return ecardUrl;
    }

    public void setReturnLink(String returnLink) {
        this.returnLink = returnLink;
    }

    public String getReturnLink() {
        return returnLink;
    }
    
}
