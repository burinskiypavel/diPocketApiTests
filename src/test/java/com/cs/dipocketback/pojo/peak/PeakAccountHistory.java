package com.cs.dipocketback.pojo.peak;

public class PeakAccountHistory {
    
    private Long id;
    private String trnTypeName;
    private Integer trnTypeId;
    private String trnState;
    private String trnDate;
    
    private Long trnAmount;
    private Integer trnCurrencyId;
    
    private Long feeAmount;
    private Integer feeCurrencyId;
    
    private String fullName;
    private Long accAmount;
    
    public PeakAccountHistory() {
    }

    public PeakAccountHistory(Long id,
                              String trnTypeName,
                              Integer trnTypeId,
                              String trnState,
                              String trnDate,
                              Long trnAmount,
                              Integer trnCurrencyId,
                              Long feeAmount,
                              Integer feeCurrencyId) {
        this.id = id;
        this.trnTypeName = trnTypeName;
        this.trnTypeId = trnTypeId;
        this.trnState = trnState;
        this.trnDate = trnDate;
        this.trnAmount = trnAmount;
        this.trnCurrencyId = trnCurrencyId;
        this.feeAmount = feeAmount;
        this.feeCurrencyId = feeCurrencyId;
    }

    public PeakAccountHistory(Long id,
                              String trnTypeName,
                              Integer trnTypeId,
                              String trnState,
                              String trnDate,
                              Long trnAmount,
                              Integer trnCurrencyId,
                              Long feeAmount,
                              Integer feeCurrencyId,
                              String fullName,
                              Long accAmount) {
        this.id = id;
        this.trnTypeName = trnTypeName;
        this.trnTypeId = trnTypeId;
        this.trnState = trnState;
        this.trnDate = trnDate;
        this.trnAmount = trnAmount;
        this.trnCurrencyId = trnCurrencyId;
        this.feeAmount = feeAmount;
        this.feeCurrencyId = feeCurrencyId;
        this.fullName = fullName;
        this.accAmount = accAmount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTrnTypeName(String trnTypeName) {
        this.trnTypeName = trnTypeName;
    }

    public String getTrnTypeName() {
        return trnTypeName;
    }

    public void setTrnTypeId(Integer trnTypeId) {
        this.trnTypeId = trnTypeId;
    }

    public Integer getTrnTypeId() {
        return trnTypeId;
    }

    public void setTrnState(String trnState) {
        this.trnState = trnState;
    }

    public String getTrnState() {
        return trnState;
    }

    public void setTrnDate(String trnDate) {
        this.trnDate = trnDate;
    }

    public String getTrnDate() {
        return trnDate;
    }

    public void setTrnAmount(Long trnAmount) {
        this.trnAmount = trnAmount;
    }

    public Long getTrnAmount() {
        return trnAmount;
    }

    public void setTrnCurrencyId(Integer trnCurrencyId) {
        this.trnCurrencyId = trnCurrencyId;
    }

    public Integer getTrnCurrencyId() {
        return trnCurrencyId;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setFeeCurrencyId(Integer feeCurrencyId) {
        this.feeCurrencyId = feeCurrencyId;
    }

    public Integer getFeeCurrencyId() {
        return feeCurrencyId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setAccAmount(Long accAmount) {
        this.accAmount = accAmount;
    }

    public Long getAccAmount() {
        return accAmount;
    }

}
