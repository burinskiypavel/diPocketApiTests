package com.cs.dipocketback.pojo.payments;

public class BankTransferRequest {
    
    private Long srcAmount;
    private String srcCcy;
    private String trnCcy;
    private Long trnAmount;
    private Long fxCalcId;
    private Double rate;
    private Double rateRev;
    private String feeCcy;
    private Long feeAmount;
    
    private String firstName;
    private String lastName;
    private String bankId;
    private String accountNo;
    private Long accountId;
    
    public BankTransferRequest() {
    }

    public void setSrcAmount(Long srcAmount) {
        this.srcAmount = srcAmount;
    }

    public Long getSrcAmount() {
        return srcAmount;
    }

    public void setSrcCcy(String srcCcy) {
        this.srcCcy = srcCcy;
    }

    public String getSrcCcy() {
        return srcCcy;
    }

    public void setTrnCcy(String trnCcy) {
        this.trnCcy = trnCcy;
    }

    public String getTrnCcy() {
        return trnCcy;
    }

    public void setTrnAmount(Long trnAmount) {
        this.trnAmount = trnAmount;
    }

    public Long getTrnAmount() {
        return trnAmount;
    }

    public void setFxCalcId(Long fxCalcId) {
        this.fxCalcId = fxCalcId;
    }

    public Long getFxCalcId() {
        return fxCalcId;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getRate() {
        return rate;
    }

    public void setRateRev(Double rateRev) {
        this.rateRev = rateRev;
    }

    public Double getRateRev() {
        return rateRev;
    }

    public void setFeeCcy(String feeCcy) {
        this.feeCcy = feeCcy;
    }

    public String getFeeCcy() {
        return feeCcy;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Long getFeeAmount() {
        return feeAmount;
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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
