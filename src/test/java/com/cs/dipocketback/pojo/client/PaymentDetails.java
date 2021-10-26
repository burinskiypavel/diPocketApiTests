package com.cs.dipocketback.pojo.client;

public class PaymentDetails {
    
    private Integer paymentType;
    private Integer ccyId;
    private String ccy;
    private String accountName;
    private String bankId;
    private String accountNo;
    private String ref;
    private String address;
    private String bankName;
        
    public PaymentDetails() {
    }

    public PaymentDetails(Integer paymentType, 
                          Integer ccyId, 
                          String ccy, 
                          String accountName, 
                          String bankId,
                          String accountNo, 
                          String ref, 
                          String address, 
                          String bankName) {
        this.paymentType = paymentType;
        this.ccyId = ccyId;
        this.ccy = ccy;
        this.accountName = accountName;
        this.bankId = bankId;
        this.accountNo = accountNo;
        this.ref = ref;
        this.address = address;
        this.bankName = bankName;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setCcyId(Integer ccyId) {
        this.ccyId = ccyId;
    }

    public Integer getCcyId() {
        return ccyId;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getCcy() {
        return ccy;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankId() {
        return bankId;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getRef() {
        return ref;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }
    
}
