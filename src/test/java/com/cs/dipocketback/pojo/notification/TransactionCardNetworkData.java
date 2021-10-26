package com.cs.dipocketback.pojo.notification;

public class TransactionCardNetworkData {

    private String msgType;
    private String mccCode;
    private String merchIdDE42;
    private String txnDesc;
    private String procCode;
    private Boolean isEcommerce;
    private Boolean isContactless;
    private String authType;
    private String merchName;
    private String merchStreet;
    private String merchCity;
    private String merchRegion;
    private String merchPostCode;
    private String merchCountry;
    private String txnCtry;
    private String respCode;

    public TransactionCardNetworkData() {
    }

    public TransactionCardNetworkData(String msgType, String mccCode, String merchIdDE42, String txnDesc,
                                      String procCode, Boolean isEcommerce, Boolean isContactless, String authType,
                                      String merchName, String merchStreet, String merchCity, String merchRegion,
                                      String merchPostCode, String merchCountry, String txnCtry, String respCode) {
        this.msgType = msgType;
        this.mccCode = mccCode;
        this.merchIdDE42 = merchIdDE42;
        this.txnDesc = txnDesc;
        this.procCode = procCode;
        this.isEcommerce = isEcommerce;
        this.isContactless = isContactless;
        this.authType = authType;
        this.merchName = merchName;
        this.merchStreet = merchStreet;
        this.merchCity = merchCity;
        this.merchRegion = merchRegion;
        this.merchPostCode = merchPostCode;
        this.merchCountry = merchCountry;
        this.txnCtry = txnCtry;
        this.respCode = respCode;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMccCode() {
        return mccCode;
    }

    public void setMccCode(String mccCode) {
        this.mccCode = mccCode;
    }

    public String getMerchIdDE42() {
        return merchIdDE42;
    }

    public void setMerchIdDE42(String merchIdDE42) {
        this.merchIdDE42 = merchIdDE42;
    }

    public String getTxnDesc() {
        return txnDesc;
    }

    public void setTxnDesc(String txnDesc) {
        this.txnDesc = txnDesc;
    }

    public String getProcCode() {
        return procCode;
    }

    public void setProcCode(String procCode) {
        this.procCode = procCode;
    }

    public Boolean getEcommerce() {
        return isEcommerce;
    }

    public void setEcommerce(Boolean ecommerce) {
        isEcommerce = ecommerce;
    }

    public Boolean getContactless() {
        return isContactless;
    }

    public void setContactless(Boolean contactless) {
        isContactless = contactless;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getMerchName() {
        return merchName;
    }

    public void setMerchName(String merchName) {
        this.merchName = merchName;
    }

    public String getMerchStreet() {
        return merchStreet;
    }

    public void setMerchStreet(String merchStreet) {
        this.merchStreet = merchStreet;
    }

    public String getMerchCity() {
        return merchCity;
    }

    public void setMerchCity(String merchCity) {
        this.merchCity = merchCity;
    }

    public String getMerchRegion() {
        return merchRegion;
    }

    public void setMerchRegion(String merchRegion) {
        this.merchRegion = merchRegion;
    }

    public String getMerchPostCode() {
        return merchPostCode;
    }

    public void setMerchPostCode(String merchPostCode) {
        this.merchPostCode = merchPostCode;
    }

    public String getMerchCountry() {
        return merchCountry;
    }

    public void setMerchCountry(String merchCountry) {
        this.merchCountry = merchCountry;
    }

    public String getTxnCtry() {
        return txnCtry;
    }

    public void setTxnCtry(String txnCtry) {
        this.txnCtry = txnCtry;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    @Override
    public String toString() {
        return "TransactionCardNetworkData{" +
                "msgType='" + msgType + '\'' +
                ", mccCode='" + mccCode + '\'' +
                ", merchIdDE42='" + merchIdDE42 + '\'' +
                ", txnDesc='" + txnDesc + '\'' +
                ", procCode='" + procCode + '\'' +
                ", isEcommerce=" + isEcommerce +
                ", isContactless=" + isContactless +
                ", authType='" + authType + '\'' +
                ", merchName='" + merchName + '\'' +
                ", merchStreet='" + merchStreet + '\'' +
                ", merchCity='" + merchCity + '\'' +
                ", merchRegion='" + merchRegion + '\'' +
                ", merchPostCode='" + merchPostCode + '\'' +
                ", merchCountry='" + merchCountry + '\'' +
                ", txnCtry='" + txnCtry + '\'' +
                ", respCode='" + respCode + '\'' +
                '}';
    }
}
