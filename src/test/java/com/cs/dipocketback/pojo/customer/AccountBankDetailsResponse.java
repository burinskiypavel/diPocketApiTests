package com.cs.dipocketback.pojo.customer;

////import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountBankDetailsResponse {

    ////@JsonProperty("paymentType")
    private String paymentType;
    ////@JsonProperty("currencyCode")
    private String currencyCode;
    ////@JsonProperty("beneficiaryName")
    private String beneficiaryName;
    ////@JsonProperty("bankId")
    private String bankId;
    ////@JsonProperty("accountNo")
    private String accountNo;
    ////@JsonProperty("address")
    private String address;
    ////@JsonProperty("bankName")
    private String bankName;

    public AccountBankDetailsResponse(String paymentType,
                                      String currencyCode,
                                      String beneficiaryName,
                                      String bankId,
                                      String accountNo,
                                      String address,
                                      String bankName) {
        this.paymentType = paymentType;
        this.currencyCode = currencyCode;
        this.beneficiaryName = beneficiaryName;
        this.bankId = bankId;
        this.accountNo = accountNo;
        this.address = address;
        this.bankName = bankName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
