package com.cs.dipocketback.pojo.dashboard;


public class NotifyEvent2 {
    
    private Integer typeId;
    private Long tranId;
    private Integer priority;
    private Integer stateId;
    private String stateName;
    private String notifyDate;
    private String notifyDateISO;
    private Long notifyId;
    private String notifyTypeName;
    private String FullName;
    private Integer ccyId;
    private String ccySymbol;
    private Long amount;
    private Integer feeCcyId;
    private String feeCcySymbol;
    private Long feeAmount;
    private String avlActions;
    private String finType;
    private Boolean isRead;
    private String detailsRef;
    
    public NotifyEvent2() {
    }

    public NotifyEvent2(Integer typeId,
                        Long tranId,
                        Integer priority,
                        Integer stateId,
                        String stateName,
                        String notifyDate,
                        String notifyDateISO,
                        Long notifyId,
                        String notifyTypeName,
                        String corrName,
                        Integer ccyId,
                        String ccySymbol,
                        Long amount,
                        Integer feeCcyId,
                        String feeCcySymbol,
                        Long feeAmount,
                        String avlActions,
                        String finType,
                        Boolean isRead,
                        String detailsRef) {
        this.typeId = typeId;
        this.priority = priority;
        this.stateId = stateId;
        this.stateName = stateName;
        this.notifyDate = notifyDate;
        this.notifyDateISO = notifyDateISO;
        this.notifyId = notifyId;
        this.notifyTypeName = notifyTypeName;
        this.FullName = corrName;
        this.ccyId = ccyId;
        this.ccySymbol = ccySymbol;
        this.amount = amount;
        this.feeCcyId = feeCcyId;
        this.feeCcySymbol = feeCcySymbol;
        this.feeAmount = feeAmount;
        this.avlActions = avlActions;
        this.finType = finType;
        this.tranId = tranId;
        this.isRead = isRead;
        this.detailsRef = detailsRef;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setNotifyDate(String notifyDate) {
        this.notifyDate = notifyDate;
    }

    public String getNotifyDate() {
        return notifyDate;
    }

    public void setNotifyId(Long notifyId) {
        this.notifyId = notifyId;
    }

    public Long getNotifyId() {
        return notifyId;
    }

    public void setNotifyTypeName(String notifyTypeName) {
        this.notifyTypeName = notifyTypeName;
    }

    public String getNotifyTypeName() {
        return notifyTypeName;
    }

    public void setFullName(String corrName) {
        this.FullName = corrName;
    }

    public String getFullName() {
        return FullName;
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

    public void setAvlActions(String avlActions) {
        this.avlActions = avlActions;
    }

    public String getAvlActions() {
        return avlActions;
    }

    public void setFinType(String finType) {
        this.finType = finType;
    }

    public String getFinType() {
        return finType;
    }

    public void setTranId(Long tranId) {
        this.tranId = tranId;
    }

    public Long getTranId() {
        return tranId;
    }

    public void setNotifyDateISO(String notifyDateISO) {
        this.notifyDateISO = notifyDateISO;
    }

    public String getNotifyDateISO() {
        return notifyDateISO;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setDetailsRef(String detailsRef) {
        this.detailsRef = detailsRef;
    }

    public String getDetailsRef() {
        return detailsRef;
    }

}
