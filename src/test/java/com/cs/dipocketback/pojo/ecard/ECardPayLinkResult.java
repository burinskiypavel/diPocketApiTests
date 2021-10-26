package com.cs.dipocketback.pojo.ecard;

public class ECardPayLinkResult {

    private String merchantNumber;
    private Long orderNumber;
    private String commType;
    private String previousState;
    private String currentState;
    private Integer paymentType;
    private Integer eventType;
    private Long paymentNumber;
    private String approvalCode;
    private String validationCode;
    private String bin;
    private String authTime;
    private Integer type;
    private String withCVC;
    private Integer currency;
    private Integer country;
    private String brand;
    private String accountName;
    private String accountNo;
    private String street;
    private String city;
    private String hash;

    public ECardPayLinkResult() {
    }

    public ECardPayLinkResult(String merchantNumber, Long orderNumber, String commType, String previousState,
                             String currentState, Integer paymentType, Integer eventType, Long paymentNumber,
                             String approvalCode, String validationCode, String bin, String authTime, Integer type,
                             String withCVC, Integer currency, Integer country, String brand, String accountName,
                             String accountNo, String street, String city, String hash) {
        this.merchantNumber = merchantNumber;
        this.orderNumber = orderNumber;
        this.commType = commType;
        this.previousState = previousState;
        this.currentState = currentState;
        this.paymentType = paymentType;
        this.eventType = eventType;
        this.paymentNumber = paymentNumber;
        this.approvalCode = approvalCode;
        this.validationCode = validationCode;
        this.bin = bin;
        this.authTime = authTime;
        this.type = type;
        this.withCVC = withCVC;
        this.currency = currency;
        this.country = country;
        this.brand = brand;
        this.accountName = accountName;
        this.accountNo = accountNo;
        this.street = street;
        this.city = city;
        this.hash = hash;
    }

    public void setMerchantNumber(String merchantNumber) {
        this.merchantNumber = merchantNumber;
    }

    public String getMerchantNumber() {
        return merchantNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setCommType(String commType) {
        this.commType = commType;
    }

    public String getCommType() {
        return commType;
    }

    public void setPreviousState(String previousState) {
        this.previousState = previousState;
    }

    public String getPreviousState() {
        return previousState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setPaymentType(Integer paymenType) {
        this.paymentType = paymenType;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setPaymentNumber(Long paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public Long getPaymentNumber() {
        return paymentNumber;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    public String getValidationCode() {
        return validationCode;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getBin() {
        return bin;
    }

    public void setAuthTime(String authTime) {
        this.authTime = authTime;
    }

    public String getAuthTime() {
        return authTime;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setWithCVC(String withCVC) {
        this.withCVC = withCVC;
    }

    public String getWithCVC() {
        return withCVC;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCountry(Integer couhntry) {
        this.country = couhntry;
    }

    public Integer getCountry() {
        return country;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHash() {
        return hash;
    }

    @Override
    public String toString() {
        return "PaymentLinkResult{" + "merchantNumber=" + merchantNumber + ", orderNumber=" + orderNumber +
               ", commType=" + commType + ", previousState=" + previousState + ", currentState=" + currentState +
               ", paymenType=" + paymentType + ", eventType=" + eventType + ", paymentNumber=" + paymentNumber +
               ", approvalCode=" + approvalCode + ", validationCode=" + validationCode + ", bin=" + bin +
               ", authTime=" + authTime + ", type=" + type + ", withCVC=" + withCVC + ", currency=" + currency +
               ", country=" + country + ", brand=" + brand + ", accountName=" + accountName + ", accountNo=" +
               accountNo + ", street=" + street + ", city=" + city + ", hash=" + hash + '}';
    }
}
