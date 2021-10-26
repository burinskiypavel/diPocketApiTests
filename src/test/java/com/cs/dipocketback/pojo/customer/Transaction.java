package com.cs.dipocketback.pojo.customer;



public class Transaction {

    // Account field

    private String currencyCode;

    private Long availableBalance;

    private Long financeBalance;

    private Long id;
    private String detailsRef;
    private String kind;
    private Integer stateId;
    private String stateName;
    private String eventDate; //2018-07-09 17:28:40.344849 Europe/Warsaw
    private Long trnAmount;
    private String trnCurrencyCode;
    private Long feeAmount;
    private String feeCurrencyCode;
    private String fullName;
    private Long accAmount;

    public Transaction() {
    }

    public Transaction(String currencyCode,
                       Long availableBalance,
                       Long financeBalance,
                       Long id,
                       String detailsRef,
                       String kind,
                       Integer stateId,
                       String stateName,
                       String eventDate,
                       Long trnAmount,
                       String trnCurrencyCode,
                       Long feeAmount,
                       String feeCurrencyCode,
                       String fullName,
                       Long accAmount) {
        this.currencyCode = currencyCode;
        this.availableBalance = availableBalance;
        this.financeBalance = financeBalance;
        this.id = id;
        this.detailsRef = detailsRef;
        this.kind = kind;
        this.stateId = stateId;
        this.stateName = stateName;
        this.eventDate = eventDate;
        this.trnAmount = trnAmount;
        this.trnCurrencyCode = trnCurrencyCode;
        this.feeAmount = feeAmount;
        this.feeCurrencyCode = feeCurrencyCode;
        this.fullName = fullName;
        this.accAmount = accAmount;
    }

    public Transaction(Long id,
                       String detailsRef,
                       String kind,
                       Integer stateId,
                       String stateName,
                       String eventDate,
                       Long trnAmount,
                       String trnCurrencyCode,
                       Long feeAmount,
                       String feeCurrencyCode,
                       String fullName,
                       Long accAmount) {
        this.id = id;
        this.detailsRef = detailsRef;
        this.kind = kind;
        this.stateId = stateId;
        this.stateName = stateName;
        this.eventDate = eventDate;
        this.trnAmount = trnAmount;
        this.trnCurrencyCode = trnCurrencyCode;
        this.feeAmount = feeAmount;
        this.feeCurrencyCode = feeCurrencyCode;
        this.fullName = fullName;
        this.accAmount = accAmount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Long getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Long availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Long getFinanceBalance() {
        return financeBalance;
    }

    public void setFinanceBalance(Long financeBalance) {
        this.financeBalance = financeBalance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetailsRef() {
        return detailsRef;
    }

    public void setDetailsRef(String detailsRef) {
        this.detailsRef = detailsRef;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public Long getTrnAmount() {
        return trnAmount;
    }

    public void setTrnAmount(Long trnAmount) {
        this.trnAmount = trnAmount;
    }

    public String getTrnCurrencyCode() {
        return trnCurrencyCode;
    }

    public void setTrnCurrencyCode(String trnCurrencyCode) {
        this.trnCurrencyCode = trnCurrencyCode;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getFeeCurrencyCode() {
        return feeCurrencyCode;
    }

    public void setFeeCurrencyCode(String feeCurrencyCode) {
        this.feeCurrencyCode = feeCurrencyCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getAccAmount() {
        return accAmount;
    }

    public void setAccAmount(Long accAmount) {
        this.accAmount = accAmount;
    }

}
