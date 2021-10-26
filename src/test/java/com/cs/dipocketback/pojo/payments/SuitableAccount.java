package com.cs.dipocketback.pojo.payments;


public class SuitableAccount {
    
    public static final String MARK_GREEN = "G";
    public static final String MARK_RED = "R";

    private Long accountId;
    private String accountName;
    private String ccy;
    private Integer ccyId;
    private String mark;
    private Long paymentAmount;
    private Double rate;
    private String feeCcy;
    private Integer feeCcyId;
    private Long feeAmount;
    private Boolean isDefault;
    
    public SuitableAccount() {
    }

    public SuitableAccount(Long accountId, 
                           String accountName, 
                           String ccy, 
                           Integer ccyId, 
                           String mark,
                           Long paymentAmount, 
                           Double rate, 
                           String feeCcy, 
                           Integer feeCcyId, 
                           Long feeAmount,
                           Boolean isDefault) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.ccy = ccy;
        this.ccyId = ccyId;
        this.mark = mark;
        this.paymentAmount = paymentAmount;
        this.rate = rate;
        this.feeCcy = feeCcy;
        this.feeCcyId = feeCcyId;
        this.feeAmount = feeAmount;
        this.isDefault = isDefault;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcyId(Integer ccyId) {
        this.ccyId = ccyId;
    }

    public Integer getCcyId() {
        return ccyId;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public void setPaymentAmount(Long paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Long getPaymentAmount() {
        return paymentAmount;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getRate() {
        return rate;
    }

    public void setFeeCcy(String feeCcy) {
        this.feeCcy = feeCcy;
    }

    public String getFeeCcy() {
        return feeCcy;
    }

    public void setFeeCcyId(Integer feeCcyId) {
        this.feeCcyId = feeCcyId;
    }

    public Integer getFeeCcyId() {
        return feeCcyId;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public static String getMark(Integer intMark) {
        return ((intMark != null) && (intMark.intValue() > 0)) ? MARK_GREEN : MARK_RED;
    }
    
}
