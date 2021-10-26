package com.cs.dipocketback.pojo.cellum;

public class ReceiveImNotifReqMessage {
    
    private Long authCode;
    private Long bankTrxId;
    private Long bankTrxResult;
    private Long merchTermId;
    private Long merchTrxId;
    private Long mpiCat;
    private Boolean isRepeated;
    private Long trxType;
    private String trxDate;
    
    public ReceiveImNotifReqMessage() {
    }

    public void setAuthCode(Long authCode) {
        this.authCode = authCode;
    }

    public Long getAuthCode() {
        return authCode;
    }

    public void setBankTrxId(Long bankTrxId) {
        this.bankTrxId = bankTrxId;
    }

    public Long getBankTrxId() {
        return bankTrxId;
    }

    public void setBankTrxResult(Long bankTrxResult) {
        this.bankTrxResult = bankTrxResult;
    }

    public Long getBankTrxResult() {
        return bankTrxResult;
    }

    public void setMerchTermId(Long merchTermId) {
        this.merchTermId = merchTermId;
    }

    public Long getMerchTermId() {
        return merchTermId;
    }

    public void setMerchTrxId(Long merchTrxId) {
        this.merchTrxId = merchTrxId;
    }

    public Long getMerchTrxId() {
        return merchTrxId;
    }

    public void setMpiCat(Long mpiCat) {
        this.mpiCat = mpiCat;
    }

    public Long getMpiCat() {
        return mpiCat;
    }

    public void setIsRepeated(Boolean isRepeated) {
        this.isRepeated = isRepeated;
    }

    public Boolean getIsRepeated() {
        return isRepeated;
    }

    public void setTrxType(Long trxType) {
        this.trxType = trxType;
    }

    public Long getTrxType() {
        return trxType;
    }

    public void setTrxDate(String trxDate) {
        this.trxDate = trxDate;
    }

    public String getTrxDate() {
        return trxDate;
    }
}
