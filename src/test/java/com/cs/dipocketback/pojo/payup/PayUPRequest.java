package com.cs.dipocketback.pojo.payup;

import javax.xml.bind.annotation.XmlElement;

public class PayUPRequest {
    
    private String requestId;
    private String terminalId;
    private String cashierId;
    private Long amount;
    private String ccy;
    
    private String pan;
    private String expDate;
    private String cvv;
    private String pin;
    private Boolean duplicate;
    private String publicToken;
    
    private String fromDate;
    private String tillDate;
    
    private Boolean useTimeout;
    
    public PayUPRequest() {
    }

    public PayUPRequest(String pan, String expDate, String cvv, String pin, Boolean duplicate) {
        this.pan = pan;
        this.expDate = expDate;
        this.cvv = cvv;
        this.pin = pin;
        this.duplicate = duplicate;
    }

    public PayUPRequest(String fromDate, String tillDate) {
        this.fromDate = fromDate;
        this.tillDate = tillDate;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }

    public String getCashierId() {
        return cashierId;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getCcy() {
        return ccy;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPan() {
        return pan;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCvv() {
        return cvv;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public void setDuplicate(Boolean duplicate) {
        this.duplicate = duplicate;
    }

    public Boolean getDuplicate() {
        return duplicate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setTillDate(String tillDate) {
        this.tillDate = tillDate;
    }

    public String getTillDate() {
        return tillDate;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setUseTimeout(Boolean useTimeout) {
        this.useTimeout = useTimeout;
    }

    public Boolean getUseTimeout() {
        return useTimeout;
    }
}
