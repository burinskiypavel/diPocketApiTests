package com.cs.dipocketback.pojo.dashboard;

public class DashboardItem {
      
    private Long amount;
    
    private Integer ccyId;
    private String ccySymbol;
    
    private Long feeAmount;
    private Integer feeCcyId;
    private String feeCcySymbol;
    private String finType;
    
    private String fullName;
    private Long id;
    /*
    ANDROID 1.0.7   WHITE   BACCA
    IOS     1.0.8   WHITE   BACCA
    ANDROID 2.1.0   WHITE   DIPOCKET
    IOS     2.0.4   WHITE   DIPOCKET
    ANDROID 1.0.0   WHITE   DISCONTU
    IOS     1.0.1   WHITE   DISCONTU
    ANDROID 1.2.2   WHITE   PLAYIT
    IOS     1.4.9   WHITE   PLAYIT
    ANDROID 1.1.3   WHITE   PZT
    IOS     1.0.9   GRAY    PZT
    ANDROID 1.0.2   WHITE   UPANDGO
    IOS     1.0.3   WHITE   UPANDGO
    */
    @Deprecated
    private String itemDate; // 2018-11-18 12:28:59.081889 Europe/Kiev
    private String itemDateISO; // ISO 2019-06-05T12:09:12+0300
    private Integer stateId;
    private Integer typeId;
    private String typeName;
    
    public DashboardItem() {
    }

    public DashboardItem(Integer typeId, 
                         Long id, 
                         Integer stateId, 
                         String itemDate, 
                         String itemDateISO, 
                         String typeName, 
                         String fullName,
                         Integer ccyId, 
                         String ccySymbol, 
                         Long amount, 
                         Integer feeCcyId, 
                         String feeCcySymbol,
                         Long feeAmount, 
                         String finType) {
        this.typeId = typeId;
        this.id = id;
        this.stateId = stateId;
        this.itemDate = itemDate;
        this.itemDateISO = itemDateISO;
        this.typeName = typeName;
        this.fullName = fullName;
        this.ccyId = ccyId;
        this.ccySymbol = ccySymbol;
        this.amount = amount;
        this.feeCcyId = feeCcyId;
        this.feeCcySymbol = feeCcySymbol;
        this.feeAmount = feeAmount;
        this.finType = finType;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setItemDate(String itemDate) {
        this.itemDate = itemDate;
    }

    public String getItemDate() {
        return itemDate;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
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

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
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

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setFinType(String finType) {
        this.finType = finType;
    }

    public String getFinType() {
        return finType;
    }


    public void setItemDateISO(String itemDateISO) {
        this.itemDateISO = itemDateISO;
    }

    public String getItemDateISO() {
        return itemDateISO;
    }
    
}
