package com.cs.dipocketback.pojo.currencycloud;

public class TccSettlementToRelease {
    
    private Long id;
    private String guId;
    
    public TccSettlementToRelease() {
    }

    public TccSettlementToRelease(Long id, String guId) {
        this.id = id;
        this.guId = guId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setGuId(String guId) {
        this.guId = guId;
    }

    public String getGuId() {
        return guId;
    }

}
