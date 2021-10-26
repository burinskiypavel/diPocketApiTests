package com.cs.dipocketback.pojo.dashboard;

public class NotifyEvent {
    
    private Integer typeId;
    private Integer priority;
    private Long notifyDate;
    private Long trTranId;
    private Long trTranItemId;
    private Integer trTypeId;
    private String trTypeName;
    private Boolean trIsReversal;
    private Long trTranDate;
    private Integer trCcyId;
    private String trCcySymbol;
    private String trCcy;
    private Long trAccountId;
    private Long trAmount;
    private String trCorrName;
    private Integer trFeeCcyId;
    private String trFeeCcySymbol;
    private String trFeeCcy;
    private Long trFeeAmount;
    private Integer trStateId;
    private String trStateName;
    private String trNote;
    private String trTrnClientName;
    private String trAccOwnerName;
    private String trFinType;
    private Long saAccountId;
    private String saOwnerName;
    private String saAccountName;
    private String saMessage;
    private Integer saCcyId;
    private String saCcy;
    private Long cpEventId;
    private String cpOwnerName;
    private String cpEventName;
    private String avlActions;
    
    public NotifyEvent() {
    }

    public NotifyEvent(Integer typeId, Integer priority, Long notifyDate, Long trTranId, Long trTranItemId,
                       Integer trTypeId, String trTypeName, Boolean trIsReversal, Long trTranDate, Integer trCcyId,
                       String trCcySymbol, String trCcy, Long trAccountId, Long trAmount, String trCorrName,
                       Integer trFeeCcyId, String trFeeCcySymbol, String trFeeCcy, Long trFeeAmount, Integer trStateId,
                       String trStateName, String trNote, String trTrnClientName, String trAccOwnerName, String trFinType, Long saAccountId,
                       String saOwnerName, String saAccountName, String saMessage, Integer saCcyId, String saCcy, Long cpEventId, String cpOwnerName,
                       String cpEventName, String avlActions) {
        this.typeId = typeId;
        this.priority = priority;
        this.notifyDate = notifyDate;
        this.trTranId = trTranId;
        this.trTranItemId = trTranItemId;
        this.trTypeId = trTypeId;
        this.trTypeName = trTypeName;
        this.trIsReversal = trIsReversal;
        this.trTranDate = trTranDate;
        this.trCcyId = trCcyId;
        this.trCcySymbol = trCcySymbol;
        this.trCcy = trCcy;
        this.trAccountId = trAccountId;
        this.trAmount = trAmount;
        this.trCorrName = trCorrName;
        this.trFeeCcyId = trFeeCcyId;
        this.trFeeCcySymbol = trFeeCcySymbol;
        this.trFeeCcy = trFeeCcy;
        this.trFeeAmount = trFeeAmount;
        this.trStateId = trStateId;
        this.trStateName = trStateName;
        this.trNote = trNote;
        this.trTrnClientName = trTrnClientName;        
        this.trAccOwnerName = trAccOwnerName;
        this.trFinType = trFinType;
        this.saAccountId = saAccountId;
        this.saOwnerName = saOwnerName;
        this.saAccountName = saAccountName;
        this.saMessage = saMessage;
        this.saCcyId = saCcyId;
        this.saCcy = saCcy;
        this.cpEventId = cpEventId;
        this.cpOwnerName = cpOwnerName;
        this.cpEventName = cpEventName;
        this.avlActions = avlActions;
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

    public void setNotifyDate(Long notifyDate) {
        this.notifyDate = notifyDate;
    }

    public Long getNotifyDate() {
        return notifyDate;
    }

    public void setTrTranId(Long trTranId) {
        this.trTranId = trTranId;
    }

    public Long getTrTranId() {
        return trTranId;
    }

    public void setTrTranItemId(Long trTranItemId) {
        this.trTranItemId = trTranItemId;
    }

    public Long getTrTranItemId() {
        return trTranItemId;
    }

    public void setTrTypeId(Integer trTypeId) {
        this.trTypeId = trTypeId;
    }

    public Integer getTrTypeId() {
        return trTypeId;
    }

    public void setTrTypeName(String trTypeName) {
        this.trTypeName = trTypeName;
    }

    public String getTrTypeName() {
        return trTypeName;
    }

    public void setTrIsReversal(Boolean trIsReversal) {
        this.trIsReversal = trIsReversal;
    }

    public Boolean getTrIsReversal() {
        return trIsReversal;
    }

    public void setTrTranDate(Long trTranDate) {
        this.trTranDate = trTranDate;
    }

    public Long getTrTranDate() {
        return trTranDate;
    }

    public void setTrCcyId(Integer trCcyId) {
        this.trCcyId = trCcyId;
    }

    public Integer getTrCcyId() {
        return trCcyId;
    }

    public void setTrCcySymbol(String trCcySymbol) {
        this.trCcySymbol = trCcySymbol;
    }

    public String getTrCcySymbol() {
        return trCcySymbol;
    }

    public void setTrCcy(String trCcy) {
        this.trCcy = trCcy;
    }

    public String getTrCcy() {
        return trCcy;
    }

    public void setTrAccountId(Long trAccountId) {
        this.trAccountId = trAccountId;
    }

    public Long getTrAccountId() {
        return trAccountId;
    }

    public void setTrAmount(Long trAmount) {
        this.trAmount = trAmount;
    }

    public Long getTrAmount() {
        return trAmount;
    }

    public void setTrCorrName(String trCorrName) {
        this.trCorrName = trCorrName;
    }

    public String getTrCorrName() {
        return trCorrName;
    }

    public void setTrFeeCcyId(Integer trFeeCcyId) {
        this.trFeeCcyId = trFeeCcyId;
    }

    public Integer getTrFeeCcyId() {
        return trFeeCcyId;
    }

    public void setTrFeeCcySymbol(String trFeeCcySymbol) {
        this.trFeeCcySymbol = trFeeCcySymbol;
    }

    public String getTrFeeCcySymbol() {
        return trFeeCcySymbol;
    }

    public void setTrFeeCcy(String trFeeCcy) {
        this.trFeeCcy = trFeeCcy;
    }

    public String getTrFeeCcy() {
        return trFeeCcy;
    }

    public void setTrFeeAmount(Long trFeeAmount) {
        this.trFeeAmount = trFeeAmount;
    }

    public Long getTrFeeAmount() {
        return trFeeAmount;
    }

    public void setTrStateId(Integer trStateId) {
        this.trStateId = trStateId;
    }

    public Integer getTrStateId() {
        return trStateId;
    }

    public void setTrStateName(String trStateName) {
        this.trStateName = trStateName;
    }

    public String getTrStateName() {
        return trStateName;
    }

    public void setTrNote(String trNote) {
        this.trNote = trNote;
    }

    public String getTrNote() {
        return trNote;
    }

    public void setTrTrnClientName(String trTrnClientName) {
        this.trTrnClientName = trTrnClientName;
    }

    public String getTrTrnClientName() {
        return trTrnClientName;
    }

    public void setTrAccOwnerName(String trAccOwnerName) {
        this.trAccOwnerName = trAccOwnerName;
    }

    public String getTrAccOwnerName() {
        return trAccOwnerName;
    }

    public void setTrFinType(String trFinType) {
        this.trFinType = trFinType;
    }

    public String getTrFinType() {
        return trFinType;
    }

    public void setSaAccountId(Long saAccountId) {
        this.saAccountId = saAccountId;
    }

    public Long getSaAccountId() {
        return saAccountId;
    }

    public void setSaOwnerName(String saOwnerName) {
        this.saOwnerName = saOwnerName;
    }

    public String getSaOwnerName() {
        return saOwnerName;
    }

    public void setSaAccountName(String saAccountName) {
        this.saAccountName = saAccountName;
    }

    public String getSaAccountName() {
        return saAccountName;
    }

    public void setSaMessage(String saMessage) {
        this.saMessage = saMessage;
    }

    public String getSaMessage() {
        return saMessage;
    }

    public void setCpEventId(Long cpEventId) {
        this.cpEventId = cpEventId;
    }

    public Long getCpEventId() {
        return cpEventId;
    }

    public void setCpOwnerName(String cpOwnerName) {
        this.cpOwnerName = cpOwnerName;
    }

    public String getCpOwnerName() {
        return cpOwnerName;
    }

    public void setCpEventName(String cpEventName) {
        this.cpEventName = cpEventName;
    }

    public String getCpEventName() {
        return cpEventName;
    }

    public void setSaCcyId(Integer saCcyId) {
        this.saCcyId = saCcyId;
    }

    public Integer getSaCcyId() {
        return saCcyId;
    }

    public void setSaCcy(String saCcy) {
        this.saCcy = saCcy;
    }

    public String getSaCcy() {
        return saCcy;
    }

    public void setAvlActions(String avlActions) {
        this.avlActions = avlActions;
    }

    public String getAvlActions() {
        return avlActions;
    }
}
