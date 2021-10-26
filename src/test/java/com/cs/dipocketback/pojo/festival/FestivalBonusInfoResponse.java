package com.cs.dipocketback.pojo.festival;

public class FestivalBonusInfoResponse {
    
    private Boolean bonusEnabled;
    private Long bonusAmount;
    private String bonusCcy;
    private Long bonusTopupAmount;
    private String bonusTopupCcy;
    
    public FestivalBonusInfoResponse() {
    }

    public FestivalBonusInfoResponse(Boolean bonusEnabled, Long bonusAmount, Long bonusTopupAmount) {
        this.bonusEnabled = bonusEnabled;
        this.bonusAmount = bonusAmount;
        this.bonusTopupAmount = bonusTopupAmount;
    }

    public void setBonusEnabled(Boolean bonusEnabled) {
        this.bonusEnabled = bonusEnabled;
    }

    public Boolean getBonusEnabled() {
        return bonusEnabled;
    }

    public void setBonusAmount(Long bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public Long getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusTopupAmount(Long bonusTopupAmount) {
        this.bonusTopupAmount = bonusTopupAmount;
    }

    public Long getBonusTopupAmount() {
        return bonusTopupAmount;
    }

    public void setBonusCcy(String bonusCcy) {
        this.bonusCcy = bonusCcy;
    }

    public String getBonusCcy() {
        return bonusCcy;
    }

    public void setBonusTopupCcy(String bonusTopupCcy) {
        this.bonusTopupCcy = bonusTopupCcy;
    }

    public String getBonusTopupCcy() {
        return bonusTopupCcy;
    }
}
