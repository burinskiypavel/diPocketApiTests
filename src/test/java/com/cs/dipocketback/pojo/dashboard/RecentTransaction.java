package com.cs.dipocketback.pojo.dashboard;

@Deprecated
public class RecentTransaction {
    
    private Long id;
    private Boolean isIncome;
    private String otherName;
    private Long dateTime;
    private String ccyCode;
    private Long amount;

    public RecentTransaction() {
    }

    public RecentTransaction(Long id, Boolean isIncome, String otherName, Long dateTime, String ccyCode, Long amount) {
        this.id = id;
        this.isIncome = isIncome;
        this.otherName = otherName;
        this.dateTime = dateTime;
        this.ccyCode = ccyCode;
        this.amount = amount;
    }

//    public RecentTransaction(Long id, Integer isIncome, String otherName, Date dateTime, String ccyCode, Long amount) {
//        this(id, CommonUtils.intToBoolean(isIncome), otherName, dateTime.getTime(), ccyCode, amount);
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setIsIncome(Boolean isIncome) {
        this.isIncome = isIncome;
    }

    public Boolean getIsIncome() {
        return isIncome;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setDateTime(Long dateTime) {
        this.dateTime = dateTime;
    }

    public Long getDateTime() {
        return dateTime;
    }

    public void setCcyCode(String ccyCode) {
        this.ccyCode = ccyCode;
    }

    public String getCcyCode() {
        return ccyCode;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

}
