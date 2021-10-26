package com.cs.dipocketback.pojo.cms.pgs;

import java.sql.Timestamp;

public class GPSOutsideTransactionInfo {

    private String acquirerIdDE32;
    private double actBal;
    private String additionalAmtDE54;
    private String amtTranFeeDE28;
    private String authCodeDE38;
    private double avlBal;
    private double billAmt;
    private String billCcy;
    private double blkAmt;
    private String custRef;
    private double fxPad;
    private double feeFixed;
    private double feeRate;
    private String loadSRC;
    private String loadType;
    private String mccCode;
    private String mccDesc;
    private double mccPad;
    private String merchIDDE42;
    private String merchNameDE43;
    private String note;
    private String posDataDE22;
    private String posDataDE61;
    private String posTermnlDE41;
    private String posTimeDE12;
    private String procCode;
    private String respCodeDE39;
    private String retRefNoDE37;
    private double settleAmt;
    private String settleCcy;
    private String statusCode;
    private String token;
    private String transLink;
    private double txnAmt;
    private String txnCCy;
    private String txnCtry;
    private String txnDesc;
    private String txnGPSDate;
    private String tXnID;
    private String txnStatCode;
    private String txnTimeDE07;
    private String txnType;

    private String additionalDataDE48;
    private String authorisedByGPS;
    private String avsResult;
    private String cuGroup;
    private String instCode;
    private String mtId;
    private String productId;
    private String recordDataDE120;
    private String subBIN;
    private String tLogIdOrg;
    private String vlGroup;
    
    private String additionalDataDE124;
    
    private String traceidLifecycle;
    private String domFeeFixed;
    private String nonDomFeeFixed;
    private String fxFeeFixed;
    private String otherFeeAmt;
    private String fxFeeRate;
    private String domFeeRate;
    private String nonDomFeeRate;
    private String acquirerReferenceData031;
    private String iccSystemRelatedDataDE55;
    
    private String messageSource;
    private Integer messageWhy;

    private String payTokenId;
    private Timestamp payTokenExpDate;
    private String payTokenType;
    private String payTokenStatus;
    private String payTokenCreatorStatus;
    private String payTokenWallet;
    private String payTokenDeviceType;
    private String payTokenLang;
    private String payTokenDeviceTelnum;
    private String payTokenDeviceIp;
    private String payTokenDeviceId;
    private String payTokenDeviceName;
    private String payTokenActivCode;
    private Timestamp payTokenActivExpiry;
    private Integer payTokenActivMethod;
    private String payTokenActivMethodData;
    private Integer sendingAttemptCount;
    private String gpsPosCapability;
    private String gpsPosData;
    private String merchName;
    private String merchStreet;
    private String merchCity;
    private String merchRegion;
    private String merchPostcode;
    private String merchCountry;

    private Long id;
    private String extSystemId;

    public void setAcquirerIdDE32(String acquirerIdDE32) {
        this.acquirerIdDE32 = acquirerIdDE32;
    }

    public String getAcquirerIdDE32() {
        return acquirerIdDE32;
    }

    public void setActBal(double actBal) {
        this.actBal = actBal;
    }

    public double getActBal() {
        return actBal;
    }

    public void setAdditionalAmtDE54(String additionalAmtDE54) {
        this.additionalAmtDE54 = additionalAmtDE54;
    }

    public String getAdditionalAmtDE54() {
        return additionalAmtDE54;
    }

    public void setAmtTranFeeDE28(String amtTranFeeDE28) {
        this.amtTranFeeDE28 = amtTranFeeDE28;
    }

    public String getAmtTranFeeDE28() {
        return amtTranFeeDE28;
    }

    public void setAuthCodeDE38(String authCodeDE38) {
        this.authCodeDE38 = authCodeDE38;
    }

    public String getAuthCodeDE38() {
        return authCodeDE38;
    }

    public void setAvlBal(double avlBal) {
        this.avlBal = avlBal;
    }

    public double getAvlBal() {
        return avlBal;
    }

    public void setBillAmt(double billAmt) {
        this.billAmt = billAmt;
    }

    public double getBillAmt() {
        return billAmt;
    }

    public void setBillCcy(String billCcy) {
        this.billCcy = billCcy;
    }

    public String getBillCcy() {
        return billCcy;
    }

    public void setBlkAmt(double blkAmt) {
        this.blkAmt = blkAmt;
    }

    public double getBlkAmt() {
        return blkAmt;
    }

    public void setCustRef(String custRef) {
        this.custRef = custRef;
    }

    public String getCustRef() {
        return custRef;
    }

    public void setFxPad(double fxPad) {
        this.fxPad = fxPad;
    }

    public double getFxPad() {
        return fxPad;
    }

    public void setFeeFixed(double feeFixed) {
        this.feeFixed = feeFixed;
    }

    public double getFeeFixed() {
        return feeFixed;
    }

    public void setFeeRate(double feeRate) {
        this.feeRate = feeRate;
    }

    public double getFeeRate() {
        return feeRate;
    }

    public void setLoadSRC(String loadSRC) {
        this.loadSRC = loadSRC;
    }

    public String getLoadSRC() {
        return loadSRC;
    }

    public void setLoadType(String loadType) {
        this.loadType = loadType;
    }

    public String getLoadType() {
        return loadType;
    }

    public void setMccCode(String mccCode) {
        this.mccCode = mccCode;
    }

    public String getMccCode() {
        return mccCode;
    }

    public void setMccDesc(String mccDesc) {
        this.mccDesc = mccDesc;
    }

    public String getMccDesc() {
        return mccDesc;
    }

    public void setMccPad(double mccPad) {
        this.mccPad = mccPad;
    }

    public double getMccPad() {
        return mccPad;
    }

    public void setMerchIDDE42(String merchIDDE42) {
        this.merchIDDE42 = merchIDDE42;
    }

    public String getMerchIDDE42() {
        return merchIDDE42;
    }

    public void setMerchNameDE43(String merchNameDE43) {
        this.merchNameDE43 = merchNameDE43;
    }

    public String getMerchNameDE43() {
        return merchNameDE43;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setPosDataDE22(String posDataDE22) {
        this.posDataDE22 = posDataDE22;
    }

    public String getPosDataDE22() {
        return posDataDE22;
    }

    public void setPosDataDE61(String posDataDE61) {
        this.posDataDE61 = posDataDE61;
    }

    public String getPosDataDE61() {
        return posDataDE61;
    }

    public void setPosTermnlDE41(String posTermnlDE41) {
        this.posTermnlDE41 = posTermnlDE41;
    }

    public String getPosTermnlDE41() {
        return posTermnlDE41;
    }

    public void setPosTimeDE12(String posTimeDE12) {
        this.posTimeDE12 = posTimeDE12;
    }

    public String getPosTimeDE12() {
        return posTimeDE12;
    }

    public void setProcCode(String procCode) {
        this.procCode = procCode;
    }

    public String getProcCode() {
        return procCode;
    }

    public void setRespCodeDE39(String respCodeDE39) {
        this.respCodeDE39 = respCodeDE39;
    }

    public String getRespCodeDE39() {
        return respCodeDE39;
    }

    public void setRetRefNoDE37(String retRefNoDE37) {
        this.retRefNoDE37 = retRefNoDE37;
    }

    public String getRetRefNoDE37() {
        return retRefNoDE37;
    }

    public void setSettleAmt(double settleAmt) {
        this.settleAmt = settleAmt;
    }

    public double getSettleAmt() {
        return settleAmt;
    }

    public void setSettleCcy(String settleCcy) {
        this.settleCcy = settleCcy;
    }

    public String getSettleCcy() {
        return settleCcy;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setTransLink(String transLink) {
        this.transLink = transLink;
    }

    public String getTransLink() {
        return transLink;
    }

    public void setTxnAmt(double txnAmt) {
        this.txnAmt = txnAmt;
    }

    public double getTxnAmt() {
        return txnAmt;
    }

    public void setTxnCCy(String txnCCy) {
        this.txnCCy = txnCCy;
    }

    public String getTxnCCy() {
        return txnCCy;
    }

    public void setTxnCtry(String txnCtry) {
        this.txnCtry = txnCtry;
    }

    public String getTxnCtry() {
        return txnCtry;
    }

    public void setTxnDesc(String txnDesc) {
        this.txnDesc = txnDesc;
    }

    public String getTxnDesc() {
        return txnDesc;
    }

    public void setTxnGPSDate(String txnGPSDate) {
        this.txnGPSDate = txnGPSDate;
    }

    public String getTxnGPSDate() {
        return txnGPSDate;
    }

    public void setTXnID(String tXnID) {
        this.tXnID = tXnID;
    }

    public String getTXnID() {
        return tXnID;
    }

    public void setTxnStatCode(String txnStatCode) {
        this.txnStatCode = txnStatCode;
    }

    public String getTxnStatCode() {
        return txnStatCode;
    }

    public void setTxnTimeDE07(String txnTimeDE07) {
        this.txnTimeDE07 = txnTimeDE07;
    }

    public String getTxnTimeDE07() {
        return txnTimeDE07;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setAdditionalDataDE48(String additionalDataDE48) {
        this.additionalDataDE48 = additionalDataDE48;
    }

    public String getAdditionalDataDE48() {
        return additionalDataDE48;
    }

    public void setAuthorisedByGPS(String authorisedByGPS) {
        this.authorisedByGPS = authorisedByGPS;
    }

    public String getAuthorisedByGPS() {
        return authorisedByGPS;
    }

    public void setAvsResult(String avsResult) {
        this.avsResult = avsResult;
    }

    public String getAvsResult() {
        return avsResult;
    }

    public void setCuGroup(String cuGroup) {
        this.cuGroup = cuGroup;
    }

    public String getCuGroup() {
        return cuGroup;
    }

    public void setInstCode(String instCode) {
        this.instCode = instCode;
    }

    public String getInstCode() {
        return instCode;
    }

    public void setMtId(String mtId) {
        this.mtId = mtId;
    }

    public String getMtId() {
        return mtId;
    }

    public void setProductId(String productionId) {
        this.productId = productionId;
    }

    public String getProductId() {
        return productId;
    }

    public void setRecordDataDE120(String recordDataDE120) {
        this.recordDataDE120 = recordDataDE120;
    }

    public String getRecordDataDE120() {
        return recordDataDE120;
    }

    public void setSubBIN(String subBIN) {
        this.subBIN = subBIN;
    }

    public String getSubBIN() {
        return subBIN;
    }

    public void setTLogIdOrg(String tLogIdOrg) {
        this.tLogIdOrg = tLogIdOrg;
    }

    public String getTLogIdOrg() {
        return tLogIdOrg;
    }

    public void setVlGroup(String vlGroup) {
        this.vlGroup = vlGroup;
    }

    public String getVlGroup() {
        return vlGroup;
    }

    public GPSOutsideTransactionInfo() {
    }

    public void setAdditionalDataDE124(String additionalDataDE124) {
        this.additionalDataDE124 = additionalDataDE124;
    }

    public String getAdditionalDataDE124() {
        return additionalDataDE124;
    }

    public void setTraceidLifecycle(String traceidLifecycle) {
        this.traceidLifecycle = traceidLifecycle;
    }

    public String getTraceidLifecycle() {
        return traceidLifecycle;
    }

    public void setDomFeeFixed(String domFeeFixed) {
        this.domFeeFixed = domFeeFixed;
    }

    public String getDomFeeFixed() {
        return domFeeFixed;
    }

    public void setNonDomFeeFixed(String nonDomFeeFixed) {
        this.nonDomFeeFixed = nonDomFeeFixed;
    }

    public String getNonDomFeeFixed() {
        return nonDomFeeFixed;
    }

    public void setFxFeeFixed(String fxFeeFixed) {
        this.fxFeeFixed = fxFeeFixed;
    }

    public String getFxFeeFixed() {
        return fxFeeFixed;
    }

    public void setOtherFeeAmt(String otherFeeAmt) {
        this.otherFeeAmt = otherFeeAmt;
    }

    public String getOtherFeeAmt() {
        return otherFeeAmt;
    }

    public void setFxFeeRate(String fxFeeRate) {
        this.fxFeeRate = fxFeeRate;
    }

    public String getFxFeeRate() {
        return fxFeeRate;
    }

    public void setDomFeeRate(String domFeeRate) {
        this.domFeeRate = domFeeRate;
    }

    public String getDomFeeRate() {
        return domFeeRate;
    }

    public void setNonDomFeeRate(String nonDomFeeRate) {
        this.nonDomFeeRate = nonDomFeeRate;
    }

    public String getNonDomFeeRate() {
        return nonDomFeeRate;
    }

    public void setAcquirerReferenceData031(String acquirerReferenceData031) {
        this.acquirerReferenceData031 = acquirerReferenceData031;
    }

    public String getAcquirerReferenceData031() {
        return acquirerReferenceData031;
    }

    public void setIccSystemRelatedDataDE55(String iccSystemRelatedDataDE55) {
        this.iccSystemRelatedDataDE55 = iccSystemRelatedDataDE55;
    }

    public String getIccSystemRelatedDataDE55() {
        return iccSystemRelatedDataDE55;
    }

    public void setMessageSource(String messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessageSource() {
        return messageSource;
    }

    public void setMessageWhy(Integer messageWhy) {
        this.messageWhy = messageWhy;
    }

    public Integer getMessageWhy() {
        return messageWhy;
    }

    public String getPayTokenId() {
        return payTokenId;
    }

    public void setPayTokenId(String payTokenId) {
        this.payTokenId = payTokenId;
    }

    public Timestamp getPayTokenExpDate() {
        return payTokenExpDate;
    }

    public void setPayTokenExpDate(Timestamp payTokenExpDate) {
        this.payTokenExpDate = payTokenExpDate;
    }

    public String getPayTokenType() {
        return payTokenType;
    }

    public void setPayTokenType(String payTokenType) {
        this.payTokenType = payTokenType;
    }

    public String getPayTokenStatus() {
        return payTokenStatus;
    }

    public void setPayTokenStatus(String payTokenStatus) {
        this.payTokenStatus = payTokenStatus;
    }

    public String getPayTokenCreatorStatus() {
        return payTokenCreatorStatus;
    }

    public void setPayTokenCreatorStatus(String payTokenCreatorStatus) {
        this.payTokenCreatorStatus = payTokenCreatorStatus;
    }

    public String getPayTokenWallet() {
        return payTokenWallet;
    }

    public void setPayTokenWallet(String payTokenWallet) {
        this.payTokenWallet = payTokenWallet;
    }

    public String getPayTokenDeviceType() {
        return payTokenDeviceType;
    }

    public void setPayTokenDeviceType(String payTokenDeviceType) {
        this.payTokenDeviceType = payTokenDeviceType;
    }

    public String getPayTokenLang() {
        return payTokenLang;
    }

    public void setPayTokenLang(String payTokenLang) {
        this.payTokenLang = payTokenLang;
    }

    public String getPayTokenDeviceTelnum() {
        return payTokenDeviceTelnum;
    }

    public void setPayTokenDeviceTelnum(String payTokenDeviceTelnum) {
        this.payTokenDeviceTelnum = payTokenDeviceTelnum;
    }

    public String getPayTokenDeviceIp() {
        return payTokenDeviceIp;
    }

    public void setPayTokenDeviceIp(String payTokenDeviceIp) {
        this.payTokenDeviceIp = payTokenDeviceIp;
    }

    public String getPayTokenDeviceId() {
        return payTokenDeviceId;
    }

    public void setPayTokenDeviceId(String payTokenDeviceId) {
        this.payTokenDeviceId = payTokenDeviceId;
    }

    public String getPayTokenDeviceName() {
        return payTokenDeviceName;
    }

    public void setPayTokenDeviceName(String payTokenDeviceName) {
        this.payTokenDeviceName = payTokenDeviceName;
    }

    public String getPayTokenActivCode() {
        return payTokenActivCode;
    }

    public void setPayTokenActivCode(String payTokenActivCode) {
        this.payTokenActivCode = payTokenActivCode;
    }

    public Timestamp getPayTokenActivExpiry() {
        return payTokenActivExpiry;
    }

    public void setPayTokenActivExpiry(Timestamp payTokenActivExpiry) {
        this.payTokenActivExpiry = payTokenActivExpiry;
    }

    public Integer getPayTokenActivMethod() {
        return payTokenActivMethod;
    }

    public void setPayTokenActivMethod(Integer payTokenActivMethod) {
        this.payTokenActivMethod = payTokenActivMethod;
    }

    public String getPayTokenActivMethodData() {
        return payTokenActivMethodData;
    }

    public void setPayTokenActivMethodData(String payTokenActivMethodData) {
        this.payTokenActivMethodData = payTokenActivMethodData;
    }

    public Integer getSendingAttemptCount() {
        return sendingAttemptCount;
    }

    public void setSendingAttemptCount(Integer sendingAttemptCount) {
        this.sendingAttemptCount = sendingAttemptCount;
    }

    public String getGpsPosCapability() {
        return gpsPosCapability;
    }

    public void setGpsPosCapability(String gpsPosCapability) {
        this.gpsPosCapability = gpsPosCapability;
    }

    public String getGpsPosData() {
        return gpsPosData;
    }

    public void setGpsPosData(String gpsPosData) {
        this.gpsPosData = gpsPosData;
    }

    public String getMerchName() {
        return merchName;
    }

    public void setMerchName(String merchName) {
        this.merchName = merchName;
    }

    public String getMerchStreet() {
        return merchStreet;
    }

    public void setMerchStreet(String merchStreet) {
        this.merchStreet = merchStreet;
    }

    public String getMerchCity() {
        return merchCity;
    }

    public void setMerchCity(String merchCity) {
        this.merchCity = merchCity;
    }

    public String getMerchRegion() {
        return merchRegion;
    }

    public void setMerchRegion(String merchRegion) {
        this.merchRegion = merchRegion;
    }

    public String getMerchPostcode() {
        return merchPostcode;
    }

    public void setMerchPostcode(String merchPostcode) {
        this.merchPostcode = merchPostcode;
    }

    public String getMerchCountry() {
        return merchCountry;
    }

    public void setMerchCountry(String merchCountry) {
        this.merchCountry = merchCountry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExtSystemId() {
        return extSystemId;
    }

    public void setExtSystemId(String extSystemId) {
        this.extSystemId = extSystemId;
    }

    public GPSOutsideTransactionInfo(String acquirerIdDE32, double actBal, String additionalAmtDE54,
                                     String amtTranFeeDE28, String authCodeDE38, double avlBal, double billAmt,
                                     String billCcy, double blkAmt, String custRef, double fxPad, double feeFixed,
                                     double feeRate, String loadSRC, String loadType, String mccCode, String mccDesc,
                                     double mccPad, String merchIDDE42, String merchNameDE43, String note,
                                     String posDataDE22, String posDataDE61, String posTermnlDE41, String posTimeDE12,
                                     String procCode, String respCodeDE39, String retRefNoDE37, double settleAmt,
                                     String settleCcy, String statusCode, String token, String transLink, double txnAmt,
                                     String txnCCy, String txnCtry, String txnDesc, String txnGPSDate, String tXnID,
                                     String txnStatCode, String txnTimeDE07, String txnType, String additionalDataDE48,
                                     String authorisedByGPS, String avsResult, String cuGroup, String instCode,
                                     String mtId, String productId, String recordDataDE120, String subBIN,
                                     String tLogIdOrg, String vlGroup, String additionalDataDE124) {
        this.acquirerIdDE32 = acquirerIdDE32;
        this.actBal = actBal;
        this.additionalAmtDE54 = additionalAmtDE54;
        this.amtTranFeeDE28 = amtTranFeeDE28;
        this.authCodeDE38 = authCodeDE38;
        this.avlBal = avlBal;
        this.billAmt = billAmt;
        this.billCcy = billCcy;
        this.blkAmt = blkAmt;
        this.custRef = custRef;
        this.fxPad = fxPad;
        this.feeFixed = feeFixed;
        this.feeRate = feeRate;
        this.loadSRC = loadSRC;
        this.loadType = loadType;
        this.mccCode = mccCode;
        this.mccDesc = mccDesc;
        this.mccPad = mccPad;
        this.merchIDDE42 = merchIDDE42;
        this.merchNameDE43 = merchNameDE43;
        this.note = note;
        this.posDataDE22 = posDataDE22;
        this.posDataDE61 = posDataDE61;
        this.posTermnlDE41 = posTermnlDE41;
        this.posTimeDE12 = posTimeDE12;
        this.procCode = procCode;
        this.respCodeDE39 = respCodeDE39;
        this.retRefNoDE37 = retRefNoDE37;
        this.settleAmt = settleAmt;
        this.settleCcy = settleCcy;
        this.statusCode = statusCode;
        this.token = token;
        this.transLink = transLink;
        this.txnAmt = txnAmt;
        this.txnCCy = txnCCy;
        this.txnCtry = txnCtry;
        this.txnDesc = txnDesc;
        this.txnGPSDate = txnGPSDate;
        this.tXnID = tXnID;
        this.txnStatCode = txnStatCode;
        this.txnTimeDE07 = txnTimeDE07;
        this.txnType = txnType;

        this.additionalDataDE48 = additionalDataDE48;
        this.authorisedByGPS = authorisedByGPS;
        this.avsResult = avsResult;
        this.cuGroup = cuGroup;
        this.instCode = instCode;
        this.mtId = mtId;
        this.productId = productId;
        this.recordDataDE120 = recordDataDE120;
        this.subBIN = subBIN;
        this.tLogIdOrg = tLogIdOrg;
        this.vlGroup = vlGroup;
        
        this.additionalDataDE124 = additionalDataDE124;

    }
    
    public GPSOutsideTransactionInfo(String acquirerIdDE32, double actBal, String additionalAmtDE54,
                                     String amtTranFeeDE28, String authCodeDE38, double avlBal, double billAmt,
                                     String billCcy, double blkAmt, String custRef, double fxPad, double feeFixed,
                                     double feeRate, String loadSRC, String loadType, String mccCode, String mccDesc,
                                     double mccPad, String merchIDDE42, String merchNameDE43, String note,
                                     String posDataDE22, String posDataDE61, String posTermnlDE41, String posTimeDE12,
                                     String procCode, String respCodeDE39, String retRefNoDE37, double settleAmt,
                                     String settleCcy, String statusCode, String token, String transLink, double txnAmt,
                                     String txnCCy, String txnCtry, String txnDesc, String txnGPSDate, String tXnID,
                                     String txnStatCode, String txnTimeDE07, String txnType, String additionalDataDE48,
                                     String authorisedByGPS, String avsResult, String cuGroup, String instCode,
                                     String mtId, String productId, String recordDataDE120, String subBIN,
                                     String tLogIdOrg, String vlGroup, String additionalDataDE124,
                                     String traceidLifecycle, String domFeeFixed, String nonDomFeeFixed,
                                     String fxFeeFixed, String otherFeeAmt, String fxFeeRate, String domFeeRate,
                                     String nonDomFeeRate, String acquirerReferenceData031,
                                     String iccSystemRelatedDataDE55, String messageSource, Integer messageWhy,
                                     String payTokenId, Timestamp payTokenExpDate, String payTokenType, String payTokenStatus,
                                     String payTokenCreatorStatus, String payTokenWallet, String payTokenDeviceType,
                                     String payTokenLang, String payTokenDeviceTelnum, String payTokenDeviceIp,
                                     String payTokenDeviceId, String payTokenDeviceName, String payTokenActivCode,
                                     Timestamp payTokenActivExpiry, Integer payTokenActivMethod, String payTokenActivMethodData,
                                     Integer sendingAttemptCount, String gpsPosCapability, String gpsPosData, String merchName,
                                     String merchStreet, String merchCity, String merchRegion, String merchPostcode, String merchCountry) {
        this.acquirerIdDE32 = acquirerIdDE32;
        this.actBal = actBal;
        this.additionalAmtDE54 = additionalAmtDE54;
        this.amtTranFeeDE28 = amtTranFeeDE28;
        this.authCodeDE38 = authCodeDE38;
        this.avlBal = avlBal;
        this.billAmt = billAmt;
        this.billCcy = billCcy;
        this.blkAmt = blkAmt;
        this.custRef = custRef;
        this.fxPad = fxPad;
        this.feeFixed = feeFixed;
        this.feeRate = feeRate;
        this.loadSRC = loadSRC;
        this.loadType = loadType;
        this.mccCode = mccCode;
        this.mccDesc = mccDesc;
        this.mccPad = mccPad;
        this.merchIDDE42 = merchIDDE42;
        this.merchNameDE43 = merchNameDE43;
        this.note = note;
        this.posDataDE22 = posDataDE22;
        this.posDataDE61 = posDataDE61;
        this.posTermnlDE41 = posTermnlDE41;
        this.posTimeDE12 = posTimeDE12;
        this.procCode = procCode;
        this.respCodeDE39 = respCodeDE39;
        this.retRefNoDE37 = retRefNoDE37;
        this.settleAmt = settleAmt;
        this.settleCcy = settleCcy;
        this.statusCode = statusCode;
        this.token = token;
        this.transLink = transLink;
        this.txnAmt = txnAmt;
        this.txnCCy = txnCCy;
        this.txnCtry = txnCtry;
        this.txnDesc = txnDesc;
        this.txnGPSDate = txnGPSDate;
        this.tXnID = tXnID;
        this.txnStatCode = txnStatCode;
        this.txnTimeDE07 = txnTimeDE07;
        this.txnType = txnType;

        this.additionalDataDE48 = additionalDataDE48;
        this.authorisedByGPS = authorisedByGPS;
        this.avsResult = avsResult;
        this.cuGroup = cuGroup;
        this.instCode = instCode;
        this.mtId = mtId;
        this.productId = productId;
        this.recordDataDE120 = recordDataDE120;
        this.subBIN = subBIN;
        this.tLogIdOrg = tLogIdOrg;
        this.vlGroup = vlGroup;
        
        this.additionalDataDE124 = additionalDataDE124;
        
        this.traceidLifecycle = traceidLifecycle;
        this.domFeeFixed = domFeeFixed;
        this.nonDomFeeFixed = nonDomFeeFixed;
        this.fxFeeFixed = fxFeeFixed;
        this.otherFeeAmt = otherFeeAmt;
        this.fxFeeRate = fxFeeRate;
        this.domFeeRate = domFeeRate;
        this.nonDomFeeRate = nonDomFeeRate;
        this.acquirerReferenceData031 = acquirerReferenceData031;
        this.iccSystemRelatedDataDE55 = iccSystemRelatedDataDE55;
        this.messageSource = messageSource;
        this.messageWhy = messageWhy;

        this.payTokenId = payTokenId;

        this.payTokenExpDate = payTokenExpDate;

        this.payTokenType = payTokenType;
        this.payTokenStatus = payTokenStatus;
        this.payTokenCreatorStatus = payTokenCreatorStatus;
        this.payTokenWallet = payTokenWallet;
        this.payTokenDeviceType = payTokenDeviceType;
        this.payTokenLang = payTokenLang;
        this.payTokenDeviceTelnum = payTokenDeviceTelnum;
        this.payTokenDeviceIp = payTokenDeviceIp;
        this.payTokenDeviceId = payTokenDeviceId;
        this.payTokenDeviceName = payTokenDeviceName;
        this.payTokenActivCode = payTokenActivCode;

        this.payTokenActivExpiry = payTokenActivExpiry;
        this.payTokenActivMethod = payTokenActivMethod;

        this.payTokenActivMethodData = payTokenActivMethodData;
        this.sendingAttemptCount = sendingAttemptCount;
        this.gpsPosCapability = gpsPosCapability;
        this.gpsPosData = gpsPosData;
        this.merchName = merchName;
        this.merchStreet = merchStreet;
        this.merchCity = merchCity;
        this.merchRegion = merchRegion;
        this.merchPostcode = merchPostcode;
        this.merchCountry = merchCountry;
    }

    @Override
    public String toString() {
        return "GPSOutsiteTransactionInfo{" +
                "acquirerIdDE32='" + acquirerIdDE32 + '\'' +
                ", actBal=" + actBal +
                ", additionalAmtDE54='" + additionalAmtDE54 + '\'' +
                ", amtTranFeeDE28='" + amtTranFeeDE28 + '\'' +
                ", authCodeDE38='" + authCodeDE38 + '\'' +
                ", avlBal=" + avlBal +
                ", billAmt=" + billAmt +
                ", billCcy='" + billCcy + '\'' +
                ", blkAmt=" + blkAmt +
                ", custRef='" + custRef + '\'' +
                ", fxPad=" + fxPad +
                ", feeFixed=" + feeFixed +
                ", feeRate=" + feeRate +
                ", loadSRC='" + loadSRC + '\'' +
                ", loadType='" + loadType + '\'' +
                ", mccCode='" + mccCode + '\'' +
                ", mccDesc='" + mccDesc + '\'' +
                ", mccPad=" + mccPad +
                ", merchIDDE42='" + merchIDDE42 + '\'' +
                ", merchNameDE43='" + merchNameDE43 + '\'' +
                ", note='" + note + '\'' +
                ", posDataDE22='" + posDataDE22 + '\'' +
                ", posDataDE61='" + posDataDE61 + '\'' +
                ", posTermnlDE41='" + posTermnlDE41 + '\'' +
                ", posTimeDE12='" + posTimeDE12 + '\'' +
                ", procCode='" + procCode + '\'' +
                ", respCodeDE39='" + respCodeDE39 + '\'' +
                ", retRefNoDE37='" + retRefNoDE37 + '\'' +
                ", settleAmt=" + settleAmt +
                ", settleCcy='" + settleCcy + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", token='" + token + '\'' +
                ", transLink='" + transLink + '\'' +
                ", txnAmt=" + txnAmt +
                ", txnCCy='" + txnCCy + '\'' +
                ", txnCtry='" + txnCtry + '\'' +
                ", txnDesc='" + txnDesc + '\'' +
                ", txnGPSDate='" + txnGPSDate + '\'' +
                ", tXnID='" + tXnID + '\'' +
                ", txnStatCode='" + txnStatCode + '\'' +
                ", txnTimeDE07='" + txnTimeDE07 + '\'' +
                ", txnType='" + txnType + '\'' +
                ", additionalDataDE48='" + additionalDataDE48 + '\'' +
                ", authorisedByGPS='" + authorisedByGPS + '\'' +
                ", avsResult='" + avsResult + '\'' +
                ", cuGroup='" + cuGroup + '\'' +
                ", instCode='" + instCode + '\'' +
                ", mtId='" + mtId + '\'' +
                ", productId='" + productId + '\'' +
                ", recordDataDE120='" + recordDataDE120 + '\'' +
                ", subBIN='" + subBIN + '\'' +
                ", tLogIdOrg='" + tLogIdOrg + '\'' +
                ", vlGroup='" + vlGroup + '\'' +
                ", additionalDataDE124='" + additionalDataDE124 + '\'' +
                ", traceidLifecycle='" + traceidLifecycle + '\'' +
                ", domFeeFixed='" + domFeeFixed + '\'' +
                ", nonDomFeeFixed='" + nonDomFeeFixed + '\'' +
                ", fxFeeFixed='" + fxFeeFixed + '\'' +
                ", otherFeeAmt='" + otherFeeAmt + '\'' +
                ", fxFeeRate='" + fxFeeRate + '\'' +
                ", domFeeRate='" + domFeeRate + '\'' +
                ", nonDomFeeRate='" + nonDomFeeRate + '\'' +
                ", acquirerReferenceData031='" + acquirerReferenceData031 + '\'' +
                ", iccSystemRelatedDataDE55='" + iccSystemRelatedDataDE55 + '\'' +
                ", messageSource='" + messageSource + '\'' +
                ", messageWhy='" + messageWhy + '\'' +
                ", payTokenId='" + payTokenId + '\'' +
                ", payTokenExpDate='" + payTokenExpDate + '\'' +
                ", payTokenType='" + payTokenType + '\'' +
                ", payTokenStatus='" + payTokenStatus + '\'' +
                ", payTokenCreatorStatus='" + payTokenCreatorStatus + '\'' +
                ", payTokenWallet='" + payTokenWallet + '\'' +
                ", payTokenDeviceType='" + payTokenDeviceType + '\'' +
                ", payTokenLang='" + payTokenLang + '\'' +
                ", payTokenDeviceTelnum='" + payTokenDeviceTelnum + '\'' +
                ", payTokenDeviceIp='" + payTokenDeviceIp + '\'' +
                ", payTokenDeviceId='" + payTokenDeviceId + '\'' +
                ", payTokenDeviceName='" + payTokenDeviceName + '\'' +
                ", payTokenActivCode='" + payTokenActivCode + '\'' +
                ", payTokenActivExpiry='" + payTokenActivExpiry + '\'' +
                ", payTokenActivMethod='" + payTokenActivMethod + '\'' +
                ", payTokenActivMethodData='" + payTokenActivMethodData + '\'' +
                '}';
    }

}
