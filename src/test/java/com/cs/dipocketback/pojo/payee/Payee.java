package com.cs.dipocketback.pojo.payee;

public class Payee {
    
    public static final int PAYMENT_TYPE_LOCAL = 1;
    public static final int PAYMENT_TYPE_SEPA = 2;
    public static final int PAYMENT_TYPE_SWIFT = 3;

    private Long id;
    private String nickName;
    private Integer paymentType;
    private String firstName;
    private String lastName;
    private String companyName;
    private Integer currencyId;
    private String code;
    private Integer isIndividual;
    private String bankId;
    private String accountNo;
    private Integer countryId;
    private String state;
    private String city;
    private String zip;
    private String address1;
    private String address2;

    public Payee() {
    }


    public Payee(Long id, 
                 String nickName, 
                 Integer paymentType, 
                 String firstName, 
                 String lastName, 
                 String companyName,
                 Integer currencyId, 
                 String code, 
                 Integer isIndividual, 
                 String bankId, 
                 String accountNo,
                 Integer countryId, 
                 String state, 
                 String zip, 
                 String address1, 
                 String address2, 
                 String city) {
        this.id = id;
        this.nickName = nickName;
        this.paymentType = paymentType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.currencyId = currencyId;
        this.code = code;
        this.isIndividual = isIndividual;
        this.bankId = bankId;
        this.accountNo = accountNo;
        this.countryId = countryId;
        this.state = state;
        this.zip = zip;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setIsIndividual(Integer isIndividual) {
        this.isIndividual = isIndividual;
    }

    public Integer getIsIndividual() {
        return isIndividual;
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

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress2() {
        return address2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
    
}
