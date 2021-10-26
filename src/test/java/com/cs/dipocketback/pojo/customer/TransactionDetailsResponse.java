package com.cs.dipocketback.pojo.customer;

public class TransactionDetailsResponse {

    private Long accAmount;
    private String accCurrencyCode;
    private String category;
    private Long convFeeAmount;
    private String convFeeCurrencyCode;
    private String details;
    private String eventDate; //2018-07-09 17:28:40.344849 Europe/Warsaw
    private String finishDate;

    private String fullName;
    private String maskedPan;
    private String note;
    private String rate;
    private String rateRev;

    private Integer stateId;
    private String stateMsg;
    private String stateName;

    private Integer tranTypeId;
    private String kind;

    private Long trnAmount;
    private String trnCurrencyCode;
    private Long feeAmount;
    private String feeCurrencyCode;
    private Double ecbMarkup;

    public TransactionDetailsResponse() {
    }

    public TransactionDetailsResponse(Long accAmount,
                                      String accCurrencyCode,
                                      String category,
                                      Long convFeeAmount,
                                      String convFeeCurrencyCode,
                                      String details,
                                      String eventDate,
                                      String finishDate,
                                      String fullName,
                                      String maskedPan,
                                      String note,
                                      String rate,
                                      String rateRev,
                                      Integer stateId,
                                      String stateMsg,
                                      String stateName,
                                      Integer tranTypeId,
                                      String kind,
                                      Long trnAmount,
                                      String trnCurrencyCode,
                                      Long feeAmount,
                                      String feeCurrencyCode,
                                      Double ecbMarkup ) {
        this.accAmount = accAmount;
        this.accCurrencyCode = accCurrencyCode;
        this.category = category;
        this.convFeeAmount = convFeeAmount;
        this.convFeeCurrencyCode = convFeeCurrencyCode;
        this.details = details;
        this.eventDate = eventDate;
        this.finishDate = finishDate;
        this.fullName = fullName;
        this.maskedPan = maskedPan;
        this.note = note;
        this.rate = rate;
        this.rateRev = rateRev;
        this.stateId = stateId;
        this.stateMsg = stateMsg;
        this.stateName = stateName;
        this.tranTypeId = tranTypeId;
        this.kind = kind;
        this.trnAmount = trnAmount;
        this.trnCurrencyCode = trnCurrencyCode;
        this.feeAmount = feeAmount;
        this.feeCurrencyCode = feeCurrencyCode;
        this.ecbMarkup = ecbMarkup;
    }

    public Long getAccAmount() {
        return accAmount;
    }

    public void setAccAmount(Long accAmount) {
        this.accAmount = accAmount;
    }

    public String getAccCurrencyCode() {
        return accCurrencyCode;
    }

    public void setAccCurrencyCode(String accCurrencyCode) {
        this.accCurrencyCode = accCurrencyCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getConvFeeAmount() {
        return convFeeAmount;
    }

    public void setConvFeeAmount(Long convFeeAmount) {
        this.convFeeAmount = convFeeAmount;
    }

    public String getConvFeeCurrencyCode() {
        return convFeeCurrencyCode;
    }

    public void setConvFeeCurrencyCode(String convFeeCurrencyCode) {
        this.convFeeCurrencyCode = convFeeCurrencyCode;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRateRev() {
        return rateRev;
    }

    public void setRateRev(String rateRev) {
        this.rateRev = rateRev;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateMsg() {
        return stateMsg;
    }

    public void setStateMsg(String stateMsg) {
        this.stateMsg = stateMsg;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Integer getTranTypeId() {
        return tranTypeId;
    }

    public void setTranTypeId(Integer tranTypeId) {
        this.tranTypeId = tranTypeId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
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

    public Double getEcbMarkup() {
        return ecbMarkup;
    }

    public void setEcbMarkup(Double ecbMarkup) {
        this.ecbMarkup = ecbMarkup;
    }
}
