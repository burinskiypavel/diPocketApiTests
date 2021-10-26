package com.cs.dipocketback.pojo.currencycloud;

import java.sql.Timestamp;

public class TccPaymentToCreate {
    
    private Long id;
    private Integer stateId;
    private String beneficiaryGuId;
    private String conversionGuId;
    private String currency;
    private Long amount;
    private String paymentType;
    private String reference;
    private String reason;
    private String uniqueRequestId;
    private String payerentitytype;
    private String payerCompanyName;
    private String payerFirstName;
    private String payerLastName;
    private String payerCity;
    private String payerAddress;
    private String payerPostCode;
    private String payerStateOrProvince;
    private String payerCountry;
    private Timestamp payerDateOfBirth;
    private String payerIdentificationType;
    private String payerIdentificationValue;
    private String payerDateOfBirthIso; //yyyy-MM-dd
    private Boolean newMode;
    
    public TccPaymentToCreate() {
    }

    public TccPaymentToCreate(Long id, Integer stateId, String beneficiaryGuId, String conversionGuId, String currency,
                              Long amount, String paymentType, String reference, String reason, String uniqueRequestId,
                              String payerentitytype, String payerCompanyName, String payerFirstName,
                              String payerLastName, String payerCity, String payerAddress, String payerPostCode,
                              String payerStateOrProvince, String payerCountry, Timestamp payerDateOfBirth,
                              String payerIdentificationType, String payerIdentificationValue, String payerDateOfBirthIso,
                              Boolean newMode) {
        this.id = id;
        this.stateId = stateId;
        this.beneficiaryGuId = beneficiaryGuId;
        this.conversionGuId = conversionGuId;
        this.currency = currency;
        this.amount = amount;
        this.paymentType = paymentType;
        this.reference = reference;
        this.reason = reason;
        this.uniqueRequestId = uniqueRequestId;
        this.payerentitytype = payerentitytype;
        this.payerCompanyName = payerCompanyName;
        this.payerFirstName = payerFirstName;
        this.payerLastName = payerLastName;
        this.payerCity = payerCity;
        this.payerAddress = payerAddress;
        this.payerPostCode = payerPostCode;
        this.payerStateOrProvince = payerStateOrProvince;
        this.payerCountry = payerCountry;
        this.payerDateOfBirth = payerDateOfBirth;
        this.payerIdentificationType = payerIdentificationType;
        this.payerIdentificationValue = payerIdentificationValue;
        this.payerDateOfBirthIso = payerDateOfBirthIso;
        this.newMode = newMode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setBeneficiaryGuId(String beneficiaryGuId) {
        this.beneficiaryGuId = beneficiaryGuId;
    }

    public String getBeneficiaryGuId() {
        return beneficiaryGuId;
    }

    public void setConversionGuId(String conversionGuId) {
        this.conversionGuId = conversionGuId;
    }

    public String getConversionGuId() {
        return conversionGuId;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setUniqueRequestId(String uniqueRequestId) {
        this.uniqueRequestId = uniqueRequestId;
    }

    public String getUniqueRequestId() {
        return uniqueRequestId;
    }

    public void setPayerentitytype(String payerentitytype) {
        this.payerentitytype = payerentitytype;
    }

    public String getPayerentitytype() {
        return payerentitytype;
    }

    public void setPayerCompanyName(String payerCompanyName) {
        this.payerCompanyName = payerCompanyName;
    }

    public String getPayerCompanyName() {
        return payerCompanyName;
    }

    public void setPayerFirstName(String payerFirstName) {
        this.payerFirstName = payerFirstName;
    }

    public String getPayerFirstName() {
        return payerFirstName;
    }

    public void setPayerLastName(String payerLastName) {
        this.payerLastName = payerLastName;
    }

    public String getPayerLastName() {
        return payerLastName;
    }

    public void setPayerCity(String payerCity) {
        this.payerCity = payerCity;
    }

    public String getPayerCity() {
        return payerCity;
    }

    public void setPayerAddress(String payerAddress) {
        this.payerAddress = payerAddress;
    }

    public String getPayerAddress() {
        return payerAddress;
    }

    public void setPayerPostCode(String payerPostCode) {
        this.payerPostCode = payerPostCode;
    }

    public String getPayerPostCode() {
        return payerPostCode;
    }

    public void setPayerStateOrProvince(String payerStateOrProvince) {
        this.payerStateOrProvince = payerStateOrProvince;
    }

    public String getPayerStateOrProvince() {
        return payerStateOrProvince;
    }

    public void setPayerCountry(String payerCountry) {
        this.payerCountry = payerCountry;
    }

    public String getPayerCountry() {
        return payerCountry;
    }

    public void setPayerDateOfBirth(Timestamp payerDateOfBirth) {
        this.payerDateOfBirth = payerDateOfBirth;
    }

    public Timestamp getPayerDateOfBirth() {
        return payerDateOfBirth;
    }

    public void setPayerIdentificationType(String payerIdentificationType) {
        this.payerIdentificationType = payerIdentificationType;
    }

    public String getPayerIdentificationType() {
        return payerIdentificationType;
    }

    public void setPayerIdentificationValue(String payerIdentificationValue) {
        this.payerIdentificationValue = payerIdentificationValue;
    }

    public String getPayerIdentificationValue() {
        return payerIdentificationValue;
    }

    public void setPayerDateOfBirthIso(String payerDateOfBirthIso) {
        this.payerDateOfBirthIso = payerDateOfBirthIso;
    }

    public String getPayerDateOfBirthIso() {
        return payerDateOfBirthIso;
    }

    public void setNewMode(Boolean newMode) {
        this.newMode = newMode;
    }

    public Boolean getNewMode() {
        return newMode;
    }
    
}
