package com.cs.dipocketback.pojo.currencycloud;

public class TccCoversionToSettlement {

    Long conversionId;
    Long settlementId;
    String conversionGuId;
    String settlementGuId;

    public TccCoversionToSettlement() {
    }

    public TccCoversionToSettlement(Long conversionId, 
                                    Long settlementId, 
                                    String conversionGuId,
                                    String settlementGuId) {
        this.conversionId = conversionId;
        this.settlementId = settlementId;
        this.conversionGuId = conversionGuId;
        this.settlementGuId = settlementGuId;
    }

    public void setConversionId(Long conversionId) {
        this.conversionId = conversionId;
    }

    public Long getConversionId() {
        return conversionId;
    }

    public void setSettlementId(Long settlementId) {
        this.settlementId = settlementId;
    }

    public Long getSettlementId() {
        return settlementId;
    }

    public void setConversionGuId(String conversionGuId) {
        this.conversionGuId = conversionGuId;
    }

    public String getConversionGuId() {
        return conversionGuId;
    }

    public void setSettlementGuId(String settlementGuId) {
        this.settlementGuId = settlementGuId;
    }

    public String getSettlementGuId() {
        return settlementGuId;
    }
    
}
