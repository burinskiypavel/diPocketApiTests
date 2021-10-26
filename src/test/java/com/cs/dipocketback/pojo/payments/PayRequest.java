package com.cs.dipocketback.pojo.payments;

import com.cs.dipocketback.pojo.accounts.Account;
import java.util.List;

public class PayRequest {
    
    public enum PayRequestStatus {
        ERROR,
        WRONG_AMOUNT,
        AMOUNTS_CHANGED,
        READY,
        COMPLETED;
    }

    public static final String FX_FIXED_SIDE_BUY = "buy";
    public static final String FX_FIXED_SIDE_SELL = "sell";

    public static final Integer STATUS_CODE_DONE = Integer.valueOf(100);

    private Long id;
    //
    private String dstId; // means phone number
    private String destName;
    private Long dstAccountId;
    private Integer dstCurrencyId;
    private Long dstAmount;
    private Integer dstFeeCurrencyId;
    private String dstFeeCurrencyCode;
    private Long dstFeeAmount;
    private Long dstClientId;
    private String dstMainPhone;
    //
    private Long srcAccountId;
    private Integer srcCurrencyId;
    private Long srcAmount;
    private Integer srcFeeCurrencyId;
    private Long srcFeeAmount;
    private Boolean isEnoughFunds;
    private Boolean isFeeEnoughFunds;
    //
    private String fxFixedSide;
    //
    private Double dipFXRate;
    private Double dipFXRateRev;
    private Boolean dipFXRateChanged;
    //
    private String note;
    private Long transactionId;
    private Long fxCalcId;
    private String newCalcReason;
    //
    private PayRequestStatus status;

    private List<SuitableAccount> suitableAccounts;

    private String qrCode;

    private Account srcAccount;
    
    private String srcPhone;
    private String srcPalName;
    private Long srcClientId;
    private String payeeName;

    //move my funds
    private String cardCVV;
    private Integer statusCode;
    private String paReq;
    private String termUrl;
    private String successUrl;
    private String errorUrl;
    private String crossReference; // MD
    private String acsURL;
    private Account dstAccount;
    private String threeDSToken;

    //bankTransfer
    private Long paymentReasonId;
    
    private Long payeeId;
    
    //Report
    private Boolean isSendReport;
    private Long powId;
    
    public PayRequest() {
    }

    public PayRequest(Integer dstCurrencyId, Long dstAmount, Integer srcCurrencyId, Long srcAmount, String fxFixedSide) {
        this.dstCurrencyId = dstCurrencyId;
        this.dstAmount = dstAmount;
        this.srcCurrencyId = srcCurrencyId;
        this.srcAmount = srcAmount;
        this.fxFixedSide = fxFixedSide;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDstId(String dstId) {
        this.dstId = dstId;
    }

    public String getDstId() {
        return dstId;
    }

    public void setDestName(String destName) {
        this.destName = destName;
    }

    public String getDestName() {
        return destName;
    }

    public void setDstAccountId(Long dstAccountId) {
        this.dstAccountId = dstAccountId;
    }

    public Long getDstAccountId() {
        return dstAccountId;
    }

    public void setDstCurrencyId(Integer dstCurrencyId) {
        this.dstCurrencyId = dstCurrencyId;
    }

    public Integer getDstCurrencyId() {
        return dstCurrencyId;
    }

    public void setDstAmount(Long dstAmount) {
        this.dstAmount = dstAmount;
    }

    public Long getDstAmount() {
        return dstAmount;
    }

    public void setDstFeeCurrencyId(Integer dstFeeCurrencyId) {
        this.dstFeeCurrencyId = dstFeeCurrencyId;
    }

    public Integer getDstFeeCurrencyId() {
        return dstFeeCurrencyId;
    }

    public void setDstFeeAmount(Long dstFeeAmount) {
        this.dstFeeAmount = dstFeeAmount;
    }

    public Long getDstFeeAmount() {
        return dstFeeAmount;
    }

    public void setDstClientId(Long dstClientId) {
        this.dstClientId = dstClientId;
    }

    public Long getDstClientId() {
        return dstClientId;
    }

    public void setDstMainPhone(String dstMainPhone) {
        this.dstMainPhone = dstMainPhone;
    }

    public String getDstMainPhone() {
        return dstMainPhone;
    }


    public void setSrcAccountId(Long srcAccountId) {
        this.srcAccountId = srcAccountId;
    }

    public Long getSrcAccountId() {
        return srcAccountId;
    }

    public void setSrcCurrencyId(Integer srcCurrencyId) {
        this.srcCurrencyId = srcCurrencyId;
    }

    public Integer getSrcCurrencyId() {
        return srcCurrencyId;
    }

    public void setSrcAmount(Long srcAmount) {
        this.srcAmount = srcAmount;
    }

    public Long getSrcAmount() {
        return srcAmount;
    }

    public void setSrcFeeCurrencyId(Integer srcFeeCurrencyId) {
        this.srcFeeCurrencyId = srcFeeCurrencyId;
    }

    public Integer getSrcFeeCurrencyId() {
        return srcFeeCurrencyId;
    }

    public void setSrcFeeAmount(Long srcFeeAmount) {
        this.srcFeeAmount = srcFeeAmount;
    }

    public Long getSrcFeeAmount() {
        return srcFeeAmount;
    }

    public void setIsEnoughFunds(Boolean isEnoughFunds) {
        this.isEnoughFunds = isEnoughFunds;
    }

    public Boolean getIsEnoughFunds() {
        return isEnoughFunds;
    }

    public void setIsFeeEnoughFunds(Boolean isFeeEnoughFunds) {
        this.isFeeEnoughFunds = isFeeEnoughFunds;
    }

    public Boolean getIsFeeEnoughFunds() {
        return isFeeEnoughFunds;
    }

    public void setFxFixedSide(String fxFixedSide) {
        this.fxFixedSide = fxFixedSide;
    }

    public String getFxFixedSide() {
        return fxFixedSide;
    }

    public void setDipFXRate(Double dipFXRate) {
        this.dipFXRate = dipFXRate;
    }

    public Double getDipFXRate() {
        return dipFXRate;
    }

    public void setDipFXRateChanged(Boolean dipFXRateChanged) {
        this.dipFXRateChanged = dipFXRateChanged;
    }

    public Boolean getDipFXRateChanged() {
        return dipFXRateChanged;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setFxCalcId(Long fxCalcId) {
        this.fxCalcId = fxCalcId;
    }

    public Long getFxCalcId() {
        return fxCalcId;
    }

    public void setNewCalcReason(String newCalcReason) {
        this.newCalcReason = newCalcReason;
    }

    public String getNewCalcReason() {
        return newCalcReason;
    }

    public void setStatus(PayRequestStatus status) {
        this.status = status;
    }

    public PayRequestStatus getStatus() {
        return status;
    }

    public void setupStatusCode(Integer statusCode) {
        if (STATUS_CODE_DONE.equals(statusCode)) {
            setStatus(PayRequestStatus.COMPLETED);
        }
    }

    public void setSuitableAccounts(List<SuitableAccount> suitableAccounts) {
        this.suitableAccounts = suitableAccounts;
    }

    public List<SuitableAccount> getSuitableAccounts() {
        //    if (suitableAccounts == null)
        //      suitableAccounts = new ArrayList<>();

        return suitableAccounts;
    }

    public void setSrcAccount(Account srcAccount) {
        this.srcAccount = srcAccount;
    }

    public Account getSrcAccount() {
        return srcAccount;
    }

    public void setPayeeId(Long payeeId) {
        this.payeeId = payeeId;
    }

    public Long getPayeeId() {
        return payeeId;
    }

    public void setCardCVV(String cardCVV) {
        this.cardCVV = cardCVV;
    }

    public String getCardCVV() {
        return cardCVV;
    }

    public void setDstAccount(Account dstAccount) {
        this.dstAccount = dstAccount;
    }

    public Account getDstAccount() {
        return dstAccount;
    }

    public void setDipFXRateRev(Double dipFXRateRev) {
        this.dipFXRateRev = dipFXRateRev;
    }

    public Double getDipFXRateRev() {
        return dipFXRateRev;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setPaReq(String paReq) {
        this.paReq = paReq;
    }

    public String getPaReq() {
        return paReq;
    }

    public void setTermUrl(String termUrl) {
        this.termUrl = termUrl;
    }

    public String getTermUrl() {
        return termUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setErrorUrl(String errorUrl) {
        this.errorUrl = errorUrl;
    }

    public String getErrorUrl() {
        return errorUrl;
    }

    public void setCrossReference(String crossReference) {
        this.crossReference = crossReference;
    }

    public String getCrossReference() {
        return crossReference;
    }

    public void setAcsURL(String acsURL) {
        this.acsURL = acsURL;
    }

    public String getAcsURL() {
        return acsURL;
    }

    public void setPaymentReasonId(Long paymentReasonId) {
        this.paymentReasonId = paymentReasonId;
    }

    public Long getPaymentReasonId() {
        return paymentReasonId;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setSrcPhone(String srcPhone) {
        this.srcPhone = srcPhone;
    }

    public String getSrcPhone() {
        return srcPhone;
    }

    public void setSrcPalName(String srcPalName) {
        this.srcPalName = srcPalName;
    }

    public String getSrcPalName() {
        return srcPalName;
    }

    public void setDstFeeCurrencyCode(String dstFeeCurrencyCode) {
        this.dstFeeCurrencyCode = dstFeeCurrencyCode;
    }

    public String getDstFeeCurrencyCode() {
        return dstFeeCurrencyCode;
    }

    public void setSrcClientId(Long srcClientId) {
        this.srcClientId = srcClientId;
    }

    public Long getSrcClientId() {
        return srcClientId;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setIsSendReport(Boolean isSendReport) {
        this.isSendReport = isSendReport;
    }

    public Boolean getIsSendReport() {
        return isSendReport;
    }

    public void setThreeDSToken(String threeDSToken) {
        this.threeDSToken = threeDSToken;
    }

    public String getThreeDSToken() {
        return threeDSToken;
    }

    public void setPowId(Long powId) {
        this.powId = powId;
    }

    public Long getPowId() {
        return powId;
    }

    public void cleanOnComplete() {
        id = null;
        //
        dstId = null; // means phone number
        destName = null;
        dstAccountId = null;
        dstCurrencyId = null;
        dstAmount = null;
        dstFeeCurrencyId = null;
        dstFeeAmount = null;
        dstClientId = null;
        //
        srcAccountId = null;
        srcCurrencyId = null;
        srcAmount = null;
        srcFeeCurrencyId = null;
        srcFeeAmount = null;
        isEnoughFunds = null;
        isFeeEnoughFunds = null;
        //
        fxFixedSide = null;
        //
        dipFXRate = null;
        dipFXRateRev = null;
        dipFXRateChanged = null;
        //
        note = null;
        fxCalcId = null;
        newCalcReason = null;
        //
        suitableAccounts = null;
        //
        payeeId = null;

        cardCVV = null;
        crossReference = null;
        //statusCode = null;
        qrCode = null;
        
        srcPhone = null;
        srcPalName = null;
        srcClientId = null;
        payeeName = null;
        
        isSendReport = null;
        powId = null;
    }

//    public static Boolean getSrcLegFixed(PayRequest payRequest) {
//        return FX_FIXED_SIDE_SELL.equals(payRequest.getFxFixedSide());
//    }
//
//    public static Integer getSrcLegFixedAsInt(PayRequest payRequest) {
//        return Integer.valueOf(CommonUtils.booleanToInt(getSrcLegFixed(payRequest)));
//    }

    @Override
    public String toString() {
        return "PayRequest{" + "id=" + id + ", dstId=" + dstId + ", destName=" + destName + ", dstAccountId=" +
               dstAccountId + ", dstCurrencyId=" + dstCurrencyId + ", dstAmount=" + dstAmount + ", dstFeeCurrencyId=" +
               dstFeeCurrencyId + ", dstFeeAmount=" + dstFeeAmount + ", dstClientId=" + dstClientId +
               ", dstMainPhone=" + dstMainPhone + ", srcAccountId=" + srcAccountId + ", srcCurrencyId=" +
               srcCurrencyId + ", srcAmount=" + srcAmount + ", srcFeeCurrencyId=" + srcFeeCurrencyId +
               ", srcFeeAmount=" + srcFeeAmount + ", isEnoughFunds=" + isEnoughFunds + ", fxFixedSide=" + fxFixedSide +
               ", dipFXRate=" + dipFXRate + ", dipFXRateChanged=" + dipFXRateChanged + ", note=" + note +
               ", transactionId=" + transactionId + ", fxCalcId=" + fxCalcId + ", newCalcReason=" + newCalcReason +
               ", status=" + status + ", suitableAccounts=" + suitableAccounts + ", srcAccount=" + srcAccount +
               ", payeeId=" + payeeId + ", cardCVV=" + cardCVV + ", isSendReport=" + isSendReport + ", powId=" + powId + '}';
    }

}
