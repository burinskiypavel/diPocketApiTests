package com.cs.dipocketback.pojo.peak;

public class PeakTopUpRequest {
    
    private String requestId;
    private Long amount;
    private Integer currencyId;
    private String cvv;
    private String pan;
    private String validThru;
    private String publicTokenTo;
    
    public PeakTopUpRequest() {
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCvv() {
        return cvv;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPan() {
        return pan;
    }

    public void setValidThru(String validThru) {
        this.validThru = validThru;
    }

    public String getValidThru() {
        return validThru;
    }

    public void setPublicTokenTo(String publicTokenTo) {
        this.publicTokenTo = publicTokenTo;
    }

    public String getPublicTokenTo() {
        return publicTokenTo;
    }

}
