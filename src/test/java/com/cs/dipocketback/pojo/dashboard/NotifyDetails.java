package com.cs.dipocketback.pojo.dashboard;

import com.cs.dipocketback.pojo.payments.DetailsType;
import com.cs.dipocketback.pojo.payments.TransactionTypes;

public class NotifyDetails {
    
    private String icon;
    private Long tranId;
    private String fullName;
    private String dtails;
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
    private String eventDate;
    private String eventDateISO; // ISO 2019-06-05T12:09:12+0300
    private Integer stateId;
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
    private String notifyDate;
    private String notifyDateISO; // ISO 2019-06-05T12:09:12+0300
    private Long trnAmount;
    private Integer trnCcyId;
    private String trnCcySymbol;
    private Long accAmount;
    private Integer accCcyId;
    private String accCcySymbol;
    private Double rate;
    private Double rateRev;
    private Long trnFeeAmount;
    private Integer trnFeeCcyId;
    private String trnFeeCcySymbol;
    private Long convFeeAmount;
    private Integer convFeeCcyId;
    private String convFeeCcySymbol;
    private String notifyTypeName;
    private String accountName;
    private String maskedPan;
    private String madeBy;
    private String category;
    private String note;
    private String finType;
    private TransactionTypes trnType;
    private String iconURL;
    
    private String status;
    private String finishDate; // ISO 2019-06-05T12:09:12+0300
    private String warning;
    private Long tranItemId; 
    private String avlActions;
    private Integer typeId;
    private DetailsType detailsType;
    private Long notifyId;

    public NotifyDetails() {
    }

    public NotifyDetails(String icon, 
                         Long tranId, 
                         String fullName, 
                         String dtails, 
                         String eventDate, 
                         String eventDateISO,
                         Integer stateId,
                         String notifyDate, 
                         String notifyDateISO, 
                         Long trnAmount, 
                         Integer trnCcyId, 
                         String trnCcySymbol,
                         Long accAmount, 
                         Integer accCcyId, 
                         String accCcySymbol, 
                         Double rate, Double rateRev,
                         Long trnFeeAmount, 
                         Integer trnFeeCcyId, 
                         String trnFeeCcySymbol, 
                         Long convFeeAmount,
                         Integer convFeeCcyId, 
                         String convFeeCcySymbol, 
                         String notifyTypeName, 
                         String accountName,
                         String maskedPan, 
                         String madeBy, 
                         String category, 
                         String note, 
                         String finType,
                         TransactionTypes trnType, 
                         String status, 
                         String finishDate, 
                         String warning) {
        this.icon = icon;
        this.tranId = tranId;
        this.fullName = fullName;
        this.dtails = dtails;
        this.eventDate = eventDate;
        this.eventDateISO = eventDateISO;
        this.stateId = stateId;
        this.notifyDate = notifyDate;
        this.notifyDateISO = notifyDateISO;
        this.trnAmount = trnAmount;
        this.trnCcyId = trnCcyId;
        this.trnCcySymbol = trnCcySymbol;
        this.accAmount = accAmount;
        this.accCcyId = accCcyId;
        this.accCcySymbol = accCcySymbol;
        this.rate = rate;
        this.rateRev = rateRev;
        this.trnFeeAmount = trnFeeAmount;
        this.trnFeeCcyId = trnFeeCcyId;
        this.trnFeeCcySymbol = trnFeeCcySymbol;
        this.convFeeAmount = convFeeAmount;
        this.convFeeCcyId = convFeeCcyId;
        this.convFeeCcySymbol = convFeeCcySymbol;
        this.notifyTypeName = notifyTypeName;
        this.accountName = accountName;
        this.maskedPan = maskedPan;
        this.madeBy = madeBy;
        this.category = category;
        this.note = note;
        this.finType = finType;
        this.trnType = trnType;
        this.status = status;
        this.finishDate = finishDate;
        this.warning = warning;
    }

    public NotifyDetails(Long tranId, 
                         String fullName, 
                         String dtails, 
                         String eventDate, 
                         String eventDateISO,
                         Integer stateId,
                         String notifyDate, 
                         String notifyDateISO, 
                         Long trnAmount, 
                         Integer trnCcyId, 
                         String trnCcySymbol,
                         Long accAmount, 
                         Integer accCcyId, 
                         String accCcySymbol, 
                         Double rate, 
                         Double rateRev,
                         Long trnFeeAmount, 
                         Integer trnFeeCcyId, 
                         String trnFeeCcySymbol, 
                         Long convFeeAmount,
                         Integer convFeeCcyId, 
                         String convFeeCcySymbol, 
                         String notifyTypeName, 
                         String accountName,
                         String maskedPan, 
                         String madeBy, 
                         String category, 
                         String note, 
                         String finType,
                         TransactionTypes trnType, 
                         String iconURL, 
                         String status, 
                         String finishDate, 
                         String warning,
                         Long tranItemId,
                         String avlActions,
                         Integer typeId,
                         DetailsType detailsType,
                         Long notifyId) {
        this.tranId = tranId;
        this.fullName = fullName;
        this.dtails = dtails;
        this.eventDate = eventDate;
        this.eventDateISO = eventDateISO;
        this.stateId = stateId;
        this.notifyDate = notifyDate;
        this.notifyDateISO = notifyDateISO;
        this.trnAmount = trnAmount;
        this.trnCcyId = trnCcyId;
        this.trnCcySymbol = trnCcySymbol;
        this.accAmount = accAmount;
        this.accCcyId = accCcyId;
        this.accCcySymbol = accCcySymbol;
        this.rate = rate;
        this.rateRev = rateRev;
        this.trnFeeAmount = trnFeeAmount;
        this.trnFeeCcyId = trnFeeCcyId;
        this.trnFeeCcySymbol = trnFeeCcySymbol;
        this.convFeeAmount = convFeeAmount;
        this.convFeeCcyId = convFeeCcyId;
        this.convFeeCcySymbol = convFeeCcySymbol;
        this.notifyTypeName = notifyTypeName;
        this.accountName = accountName;
        this.maskedPan = maskedPan;
        this.madeBy = madeBy;
        this.category = category;
        this.note = note;
        this.finType = finType;
        this.trnType = trnType;
        this.iconURL = iconURL;
        this.status = status;
        this.finishDate = finishDate;
        this.warning = warning;
        this.tranItemId = tranItemId;
        this.avlActions = avlActions;
        this.typeId = typeId;
        this.detailsType = detailsType;
        this.notifyId = notifyId;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setDtails(String dtails) {
        this.dtails = dtails;
    }

    public String getDtails() {
        return dtails;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDate() {
        return eventDate;
    }


    public void setEventDateISO(String eventDateISO) {
        this.eventDateISO = eventDateISO;
    }

    public String getEventDateISO() {
        return eventDateISO;
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

    public void setTrnAmount(Long trnAmount) {
        this.trnAmount = trnAmount;
    }

    public Long getTrnAmount() {
        return trnAmount;
    }

    public void setTrnCcyId(Integer trnCcyId) {
        this.trnCcyId = trnCcyId;
    }

    public Integer getTrnCcyId() {
        return trnCcyId;
    }

    public void setTrnCcySymbol(String trnCcySymbol) {
        this.trnCcySymbol = trnCcySymbol;
    }

    public String getTrnCcySymbol() {
        return trnCcySymbol;
    }

    public void setAccAmount(Long accAmount) {
        this.accAmount = accAmount;
    }

    public Long getAccAmount() {
        return accAmount;
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

    public void setTrnFeeAmount(Long trnFeeAmount) {
        this.trnFeeAmount = trnFeeAmount;
    }

    public Long getTrnFeeAmount() {
        return trnFeeAmount;
    }

    public void setTrnFeeCcyId(Integer trnFeeCcyId) {
        this.trnFeeCcyId = trnFeeCcyId;
    }

    public Integer getTrnFeeCcyId() {
        return trnFeeCcyId;
    }

    public void setTrnFeeCcySymbol(String trnFeeCcySymbol) {
        this.trnFeeCcySymbol = trnFeeCcySymbol;
    }

    public String getTrnFeeCcySymbol() {
        return trnFeeCcySymbol;
    }

    public void setConvFeeAmount(Long convFeeAmount) {
        this.convFeeAmount = convFeeAmount;
    }

    public Long getConvFeeAmount() {
        return convFeeAmount;
    }

    public void setConvFeeCcyId(Integer convFeeCcyId) {
        this.convFeeCcyId = convFeeCcyId;
    }

    public Integer getConvFeeCcyId() {
        return convFeeCcyId;
    }

    public void setConvFeeCcySymbol(String convFeeCcySymbol) {
        this.convFeeCcySymbol = convFeeCcySymbol;
    }

    public String getConvFeeCcySymbol() {
        return convFeeCcySymbol;
    }

    public void setNotifyTypeName(String notifyTypeName) {
        this.notifyTypeName = notifyTypeName;
    }

    public String getNotifyTypeName() {
        return notifyTypeName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMadeBy(String madeBy) {
        this.madeBy = madeBy;
    }

    public String getMadeBy() {
        return madeBy;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
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

    public void setTrnType(TransactionTypes trnType) {
        this.trnType = trnType;
    }

    public TransactionTypes getTrnType() {
        return trnType;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public String getWarning() {
        return warning;
    }

    public void setTranItemId(Long tranItemId) {
        this.tranItemId = tranItemId;
    }

    public Long getTranItemId() {
        return tranItemId;
    }

    public void setAvlActions(String avlActions) {
        this.avlActions = avlActions;
    }

    public String getAvlActions() {
        return avlActions;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public void setDetailsType(DetailsType detailsType) {
        this.detailsType = detailsType;
    }

    public DetailsType getDetailsType() {
        return detailsType;
    }

    public void setNotifyId(Long notifyId) {
        this.notifyId = notifyId;
    }

    public Long getNotifyId() {
        return notifyId;
    }

}
