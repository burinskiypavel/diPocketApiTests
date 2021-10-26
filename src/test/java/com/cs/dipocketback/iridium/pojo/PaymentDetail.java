/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.dipocketback.iridium.pojo;

/**
 * @author zavulon
 */
public class PaymentDetail {

    private String cardName = "";
    private String cardNumber = "";
    private String expiryDateMonth = "";
    private String expiryDateYear = "";
    private String startDateMonth = "";
    private String startDateYear = "";
    private String issueNumber = "";
    private String CV2 = "";
    private String address1 = "";
    private String address2 = "";
    private String address3 = "";
    private String address4 = "";
    private String city = "";
    private String state = "";
    private String postCode = "";
    private int countryISOCode = -1;
    private String amount = "";
    private int currencyISOCode = -1;
    private String email;
    private String phoneNumber;
    private String customerIPAddress;
    private String orderID = "";
    private String orderDescription = "";
    private String crossReference = "";
    private String paRES = "";
    private String paREQ = "";

    private String transactionType;
    private Boolean echoCardType;
    private Boolean echoAVSCheckResult;
    private Boolean echoCV2CheckResult;
    private Integer duplicateDelay;
    private String avsOverridePolicy;
    private String cv2OverridePolicy;
    private Boolean threeDSecureOverridePolicy;

    private Boolean newTransaction;

    private String userAgent;

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDateMonth() {
        return expiryDateMonth;
    }

    public void setExpiryDateMonth(String expiryDateMonth) {
        this.expiryDateMonth = expiryDateMonth;
    }

    public String getExpiryDateYear() {
        return expiryDateYear;
    }

    public void setExpiryDateYear(String expiryDateYear) {
        this.expiryDateYear = expiryDateYear;
    }

    public String getStartDateMonth() {
        return startDateMonth;
    }

    public void setStartDateMonth(String startDateMonth) {
        this.startDateMonth = startDateMonth;
    }

    public String getStartDateYear() {
        return startDateYear;
    }

    public void setStartDateYear(String startDateYear) {
        this.startDateYear = startDateYear;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getCV2() {
        return CV2;
    }

    public void setCV2(String CV2) {
        this.CV2 = CV2;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public int getCountryISOCode() {
        return countryISOCode;
    }

    public void setCountryISOCode(int countryISOCode) {
        this.countryISOCode = countryISOCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getCurrencyISOCode() {
        return currencyISOCode;
    }

    public void setCurrencyISOCode(int currencyISOCode) {
        this.currencyISOCode = currencyISOCode;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getCrossReference() {
        return crossReference;
    }

    public void setCrossReference(String crossReference) {
        this.crossReference = crossReference;
    }

    public String getPaRES() {
        return paRES;
    }

    public void setPaRES(String paRES) {
        this.paRES = paRES;
    }

    public String getPaREQ() {
        return paREQ;
    }

    public void setPaREQ(String paREQ) {
        this.paREQ = paREQ;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setCustomerIPAddress(String customerIPAddress) {
        this.customerIPAddress = customerIPAddress;
    }

    public String getCustomerIPAddress() {
        return customerIPAddress;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setEchoCardType(Boolean echoCardType) {
        this.echoCardType = echoCardType;
    }

    public Boolean getEchoCardType() {
        return echoCardType;
    }

    public void setEchoAVSCheckResult(Boolean echoAVSCheckResult) {
        this.echoAVSCheckResult = echoAVSCheckResult;
    }

    public Boolean getEchoAVSCheckResult() {
        return echoAVSCheckResult;
    }

    public void setEchoCV2CheckResult(Boolean echoCV2CheckResult) {
        this.echoCV2CheckResult = echoCV2CheckResult;
    }

    public Boolean getEchoCV2CheckResult() {
        return echoCV2CheckResult;
    }

    public void setDuplicateDelay(Integer duplicateDelay) {
        this.duplicateDelay = duplicateDelay;
    }

    public Integer getDuplicateDelay() {
        return duplicateDelay;
    }

    public void setAvsOverridePolicy(String avsOverridePolicy) {
        this.avsOverridePolicy = avsOverridePolicy;
    }

    public String getAvsOverridePolicy() {
        return avsOverridePolicy;
    }

    public void setCv2OverridePolicy(String cv2OverridePolicy) {
        this.cv2OverridePolicy = cv2OverridePolicy;
    }

    public String getCv2OverridePolicy() {
        return cv2OverridePolicy;
    }

    public void setNewTransaction(Boolean newTransaction) {
        this.newTransaction = newTransaction;
    }

    public Boolean getNewTransaction() {
        return newTransaction;
    }

    public void setThreeDSecureOverridePolicy(Boolean threeDSecureOverridePolicy) {
        this.threeDSecureOverridePolicy = threeDSecureOverridePolicy;
    }

    public Boolean getThreeDSecureOverridePolicy() {
        return threeDSecureOverridePolicy;
    }

    @Override
    public String toString() {
        return "PaymentDetail{" +
                "cardName='" + cardName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expiryDateMonth='" + expiryDateMonth + '\'' +
                ", expiryDateYear='" + expiryDateYear + '\'' +
                ", startDateMonth='" + startDateMonth + '\'' +
                ", startDateYear='" + startDateYear + '\'' +
                ", issueNumber='" + issueNumber + '\'' +
                ", CV2='" + CV2 + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", address3='" + address3 + '\'' +
                ", address4='" + address4 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postCode='" + postCode + '\'' +
                ", countryISOCode=" + countryISOCode +
                ", amount='" + amount + '\'' +
                ", currencyISOCode=" + currencyISOCode +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", customerIPAddress='" + customerIPAddress + '\'' +
                ", orderID='" + orderID + '\'' +
                ", orderDescription='" + orderDescription + '\'' +
                ", crossReference='" + crossReference + '\'' +
                ", paRES='" + paRES + '\'' +
                ", paREQ='" + paREQ + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", echoCardType=" + echoCardType +
                ", echoAVSCheckResult=" + echoAVSCheckResult +
                ", echoCV2CheckResult=" + echoCV2CheckResult +
                ", duplicateDelay=" + duplicateDelay +
                ", avsOverridePolicy='" + avsOverridePolicy + '\'' +
                ", cv2OverridePolicy='" + cv2OverridePolicy + '\'' +
                ", newTransaction=" + newTransaction +
                ", threeDSecureOverridePolicy=" + threeDSecureOverridePolicy +
                '}';
    }
}
