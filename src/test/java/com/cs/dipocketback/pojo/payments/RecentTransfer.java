package com.cs.dipocketback.pojo.payments;

public class RecentTransfer {
    
    private Long id;
    private Integer typeId;
    private Long dateTime;
    private Integer stateId;
    private String stateSName;
    private Boolean isIncome;
    private Integer ccyId;
    private String ccyCode;
    private String ccySymbol;
    private String ccySName;
    private Long amount;
    private Long accountId;
    private String accountSName;
    private Long otherClientId;
    private Long otherAccountId;
    private String otherName;
    private String note;

    public RecentTransfer() {
    }

    public RecentTransfer(Long id, 
                          Integer typeId, 
                          Long dateTime, 
                          Integer stateId, 
                          String stateSName, 
                          Boolean isIncome,
                          Integer ccyId, 
                          String ccyCode, 
                          String ccySymbol, 
                          String ccySName, 
                          Long amount, 
                          Long accountId,
                          String accountSName, 
                          Long otherClientId, 
                          Long otherAccountId, 
                          String otherName, 
                          String note) {
        this.id = id;
        this.typeId = typeId;
        this.dateTime = dateTime;
        this.stateId = stateId;
        this.stateSName = stateSName;
        this.isIncome = Boolean.TRUE.equals(isIncome);
        this.ccyId = ccyId;
        this.ccyCode = ccyCode;
        this.ccySymbol = ccySymbol;
        this.ccySName = ccySName;
        this.amount = amount;
        this.accountId = accountId;
        this.accountSName = accountSName;
        this.otherClientId = otherClientId;
        this.otherAccountId = otherAccountId;
        this.otherName = otherName;
        this.note = note;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setDateTime(Long dateTime) {
        this.dateTime = dateTime;
    }

    public Long getDateTime() {
        return dateTime;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateSName(String stateSName) {
        this.stateSName = stateSName;
    }

    public String getStateSName() {
        return stateSName;
    }

    public void setIsIncome(Boolean isIncome) {
        this.isIncome = isIncome;
    }

    public Boolean getIsIncome() {
        return isIncome;
    }

    public void setCcyId(Integer ccyId) {
        this.ccyId = ccyId;
    }

    public Integer getCcyId() {
        return ccyId;
    }

    public void setCcyCode(String ccyCode) {
        this.ccyCode = ccyCode;
    }

    public String getCcyCode() {
        return ccyCode;
    }

    public void setCcySymbol(String ccySymbol) {
        this.ccySymbol = ccySymbol;
    }

    public String getCcySymbol() {
        return ccySymbol;
    }

    public void setCcySName(String ccySName) {
        this.ccySName = ccySName;
    }

    public String getCcySName() {
        return ccySName;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountSName(String accountSName) {
        this.accountSName = accountSName;
    }

    public String getAccountSName() {
        return accountSName;
    }

    public void setOtherClientId(Long otherClientId) {
        this.otherClientId = otherClientId;
    }

    public Long getOtherClientId() {
        return otherClientId;
    }

    public void setOtherAccountId(Long otherAccountId) {
        this.otherAccountId = otherAccountId;
    }

    public Long getOtherAccountId() {
        return otherAccountId;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

}
