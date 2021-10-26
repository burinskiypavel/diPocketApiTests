package com.cs.dipocketback.pojo.payments;

@Deprecated // can be deleted
public class SimpleTransferOld {
    
    private Long id;
    private Long srcClientID;
    private Long srcAccountID;
    private Integer srcCcyID;
    private Long srcAmount;
    private Long feeAmount;
    private Long dstClientID;
    private Long dstAccountID;
    private Integer dstCcyID;
    private Long dstAmount;
    private String note;
    private String destinationLogin;
    private String dstClientFullName;
    private Boolean srcLegFixed;
    private Boolean fxRateChanged;

    public SimpleTransferOld() {
    }

    public SimpleTransferOld(Long id, Long srcClientID, Long srcAccountID, Integer srcCcyID, Long srcAmount,
                             Long feeAmount, Long dstClientID, Long dstAccountID, Integer dstCcyID, Long dstAmount,
                             String note, String destinationLogin, String dstClientFullName, Boolean srcLegFixed,
                             Boolean fxRateChanged) {
        this.id = id;
        this.srcClientID = srcClientID;
        this.srcAccountID = srcAccountID;
        this.srcCcyID = srcCcyID;
        this.srcAmount = srcAmount;
        this.feeAmount = feeAmount;
        this.dstClientID = dstClientID;
        this.dstAccountID = dstAccountID;
        this.dstCcyID = dstCcyID;
        this.dstAmount = dstAmount;
        this.note = note;
        this.destinationLogin = destinationLogin;
        this.dstClientFullName = dstClientFullName;
        this.srcLegFixed = srcLegFixed;
        this.fxRateChanged = fxRateChanged;
    }

    public SimpleTransferOld(SimpleTransferOld other) {
        this.id = other.id;
        this.srcClientID = other.srcClientID;
        this.srcAccountID = other.srcAccountID;
        this.srcCcyID = other.srcCcyID;
        this.srcAmount = other.srcAmount;
        this.feeAmount = other.feeAmount;
        this.dstClientID = other.dstClientID;
        this.dstAccountID = other.dstAccountID;
        this.dstCcyID = other.dstCcyID;
        this.dstAmount = other.dstAmount;
        this.note = other.note;
        this.destinationLogin = other.destinationLogin;
        this.dstClientFullName = other.dstClientFullName;
        this.srcLegFixed = other.srcLegFixed;
        this.fxRateChanged = other.fxRateChanged;
    }

    public void setFxRateChanged(Boolean fxRateChanged) {
        this.fxRateChanged = fxRateChanged;
    }

    public Boolean getFxRateChanged() {
        return fxRateChanged;
    }

    public void setSrcLegFixed(Boolean srcLegFixed) {
        this.srcLegFixed = srcLegFixed;
    }

    public Boolean getSrcLegFixed() {
        return srcLegFixed;
    }

    public void setSrcCcyID(Integer srcCcyID) {
        this.srcCcyID = srcCcyID;
    }

    public Integer getSrcCcyID() {
        return srcCcyID;
    }

    public void setSrcAmount(Long srcAmount) {
        this.srcAmount = srcAmount;
    }

    public Long getSrcAmount() {
        return srcAmount;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setDstCcyID(Integer dstCcyID) {
        this.dstCcyID = dstCcyID;
    }

    public Integer getDstCcyID() {
        return dstCcyID;
    }

    public void setDstAmount(Long dstAmount) {
        this.dstAmount = dstAmount;
    }

    public Long getDstAmount() {
        return dstAmount;
    }

    public void setDstClientFullName(String dstClientFullName) {
        this.dstClientFullName = dstClientFullName;
    }

    public String getDstClientFullName() {
        return dstClientFullName;
    }

    public void setDstClientID(Long dstClientID) {
        this.dstClientID = dstClientID;
    }

    public Long getDstClientID() {
        return dstClientID;
    }

    public void setDstAccountID(Long dstAccountID) {
        this.dstAccountID = dstAccountID;
    }

    public Long getDstAccountID() {
        return dstAccountID;
    }

    public void setDestinationLogin(String destinationLogin) {
        this.destinationLogin = destinationLogin;
    }

    public String getDestinationLogin() {
        return destinationLogin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setSrcClientID(Long srcClientID) {
        this.srcClientID = srcClientID;
    }

    public Long getSrcClientID() {
        return srcClientID;
    }

    public void setSrcAccountID(Long srcAccountID) {
        this.srcAccountID = srcAccountID;
    }

    public Long getSrcAccountID() {
        return srcAccountID;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public boolean isTheSameCurrencies() {
        Integer srcCcyID = getSrcCcyID();
        Integer dstCcyID = getDstCcyID();

        return (srcCcyID == null) ? (dstCcyID == null) : srcCcyID.equals(dstCcyID);
    }

}
