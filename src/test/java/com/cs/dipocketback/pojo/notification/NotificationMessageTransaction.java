package com.cs.dipocketback.pojo.notification;



public class NotificationMessageTransaction {

    private String detailsRef;
    private Long accountId;
    private String accountName;
    private String token;

    private String kind;
    private Integer stateId;
    private String stateName;
    private String declineReason;
    private String note;
    private String eventDate;
    private String finishDate;
    private Long trnAmount;
    private String trnCurrencyCode;
    private Long accAmount;
    private String accCurrencyCode;
    private String maskedPan;
    private Boolean impactsFinancialBalance;
    private Boolean impactsAvailableBalance;
    private Long trnRef;
    private Integer ecbMarkup;
    private TransactionFee transactionFee;
    private TransactionSender transactionSender;
    private TransactionBeneficiary transactionBeneficiary;
    private TransactionCardNetworkData transactionCardNetworkData;

    public NotificationMessageTransaction() {
    }

    public NotificationMessageTransaction(String detailsRef, Long accountId, String accountName, String token,
                                          String kind, Integer stateId, String stateName, String declineReason,
                                          String note, String eventDate, String finishDate, Long trnAmount,
                                          String trnCurrencyCode, Long accAmount, String accCurrencyCode,
                                          String maskedPan, Boolean impactsFinancialBalance,
                                          Boolean impactsAvailableBalance, Long trnRef, Integer ecbMarkup,
                                          TransactionFee transactionFee, TransactionSender transactionSender,
                                          TransactionBeneficiary transactionBeneficiary,
                                          TransactionCardNetworkData transactionCardNetworkData) {
        this.detailsRef = detailsRef;
        this.accountId = accountId;
        this.accountName = accountName;
        this.token = token;
        this.kind = kind;
        this.stateId = stateId;
        this.stateName = stateName;
        this.declineReason = declineReason;
        this.note = note;
        this.eventDate = eventDate;
        this.finishDate = finishDate;
        this.trnAmount = trnAmount;
        this.trnCurrencyCode = trnCurrencyCode;
        this.accAmount = accAmount;
        this.accCurrencyCode = accCurrencyCode;
        this.maskedPan = maskedPan;
        this.impactsFinancialBalance = impactsFinancialBalance;
        this.impactsAvailableBalance = impactsAvailableBalance;
        this.trnRef = trnRef;
        this.ecbMarkup = ecbMarkup;
        this.transactionFee = transactionFee;
        this.transactionSender = transactionSender;
        this.transactionBeneficiary = transactionBeneficiary;
        this.transactionCardNetworkData = transactionCardNetworkData;
    }

    public String getDetailsRef() {
        return detailsRef;
    }

    public void setDetailsRef(String detailsRef) {
        this.detailsRef = detailsRef;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getDeclineReason() {
        return declineReason;
    }

    public void setDeclineReason(String declineReason) {
        this.declineReason = declineReason;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public Boolean getImpactsFinancialBalance() {
        return impactsFinancialBalance;
    }

    public void setImpactsFinancialBalance(Boolean impactsFinancialBalance) {
        this.impactsFinancialBalance = impactsFinancialBalance;
    }

    public Boolean getImpactsAvailableBalance() {
        return impactsAvailableBalance;
    }

    public void setImpactsAvailableBalance(Boolean impactsAvailableBalance) {
        this.impactsAvailableBalance = impactsAvailableBalance;
    }

    public Long getTrnRef() {
        return trnRef;
    }

    public void setTrnRef(Long trnRef) {
        this.trnRef = trnRef;
    }

    public Integer getEcbMarkup() {
        return ecbMarkup;
    }

    public void setEcbMarkup(Integer ecbMarkup) {
        this.ecbMarkup = ecbMarkup;
    }

    public TransactionFee getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(TransactionFee transactionFee) {
        this.transactionFee = transactionFee;
    }

    public TransactionSender getTransactionSender() {
        return transactionSender;
    }

    public void setTransactionSender(TransactionSender transactionSender) {
        this.transactionSender = transactionSender;
    }

    public TransactionBeneficiary getTransactionBeneficiary() {
        return transactionBeneficiary;
    }

    public void setTransactionBeneficiary(TransactionBeneficiary transactionBeneficiary) {
        this.transactionBeneficiary = transactionBeneficiary;
    }

    public TransactionCardNetworkData getTransactionCardNetworkData() {
        return transactionCardNetworkData;
    }

    public void setTransactionCardNetworkData(TransactionCardNetworkData transactionCardNetworkData) {
        this.transactionCardNetworkData = transactionCardNetworkData;
    }

    @Override
    public String toString() {
        return "NotificationMessageTransaction{" +
                "detailsRef='" + detailsRef + '\'' +
                ", accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", token='" + token + '\'' +
                ", kind='" + kind + '\'' +
                ", stateId=" + stateId +
                ", stateName='" + stateName + '\'' +
                ", declineReason='" + declineReason + '\'' +
                ", note='" + note + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", finishDate='" + finishDate + '\'' +
                ", trnAmount=" + trnAmount +
                ", trnCurrencyCode='" + trnCurrencyCode + '\'' +
                ", accAmount=" + accAmount +
                ", accCurrencyCode='" + accCurrencyCode + '\'' +
                ", maskedPan='" + maskedPan + '\'' +
                ", impactsFinancialBalance=" + impactsFinancialBalance +
                ", impactsAvailableBalance=" + impactsAvailableBalance +
                ", trnRef=" + trnRef +
                ", ecbMarkup=" + ecbMarkup +
                ", transactionFee=" + transactionFee +
                ", transactionSender=" + transactionSender +
                ", transactionBeneficiary=" + transactionBeneficiary +
                ", transactionCardNetworkData=" + transactionCardNetworkData +
                '}';
    }
}
