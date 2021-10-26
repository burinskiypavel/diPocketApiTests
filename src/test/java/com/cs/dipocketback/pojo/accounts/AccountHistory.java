package com.cs.dipocketback.pojo.accounts;

public class AccountHistory {
    
    private Long amount;
    
    private Integer ccyId;
    private String ccySymbol;
    
    private Long feeAmount;
    private Integer feeCcyId;
    private String feeCcySymbol;
    private String finType;
    
    private String fullName;
    private Long id;
    private String itemDateISO;
    private Integer stateId;
    private String stateName;
    private Integer typeId;
    private String typeName;
    
    private Integer accCcyId;
    private String accCcySymbol;
    private Long accAmount;
    
    public AccountHistory() {
    }

    public AccountHistory(Long amount, 
                          Integer ccyId, 
                          String ccySymbol, 
                          Long feeAmount, 
                          Integer feeCcyId,
                          String feeCcySymbol, 
                          String finType, 
                          String fullName, 
                          Long id, 
                          String itemDateISO,
                          Integer stateId,
                          String stateName,
                          Integer typeId, 
                          String typeName) {
        this.amount = amount;
        this.ccyId = ccyId;
        this.ccySymbol = ccySymbol;
        this.feeAmount = feeAmount;
        this.feeCcyId = feeCcyId;
        this.feeCcySymbol = feeCcySymbol;
        this.finType = finType;
        this.fullName = fullName;
        this.id = id;
        this.itemDateISO = itemDateISO;
        this.stateId = stateId;
        this.stateName = stateName;
        this.typeId = typeId;
        this.typeName = typeName;
    }


    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setCcyId(Integer ccyId) {
        this.ccyId = ccyId;
    }

    public Integer getCcyId() {
        return ccyId;
    }

    public void setCcySymbol(String ccySymbol) {
        this.ccySymbol = ccySymbol;
    }

    public String getCcySymbol() {
        return ccySymbol;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setFeeCcyId(Integer feeCcyId) {
        this.feeCcyId = feeCcyId;
    }

    public Integer getFeeCcyId() {
        return feeCcyId;
    }

    public void setFeeCcySymbol(String feeCcySymbol) {
        this.feeCcySymbol = feeCcySymbol;
    }

    public String getFeeCcySymbol() {
        return feeCcySymbol;
    }

    public void setFinType(String finType) {
        this.finType = finType;
    }

    public String getFinType() {
        return finType;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setItemDateISO(String itemDateISO) {
        this.itemDateISO = itemDateISO;
    }

    public String getItemDateISO() {
        return itemDateISO;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setAccCcyId(Integer accCcyId) {
        this.accCcyId = accCcyId;
    }

    public Integer getAccCcyId() {
        return accCcyId;
    }

    public void setAccCcySymbol(String accCcySymbol) {
        this.accCcySymbol = accCcySymbol;
    }

    public String getAccCcySymbol() {
        return accCcySymbol;
    }

    public void setAccAmount(Long accAmount) {
        this.accAmount = accAmount;
    }

    public Long getAccAmount() {
        return accAmount;
    }
}
