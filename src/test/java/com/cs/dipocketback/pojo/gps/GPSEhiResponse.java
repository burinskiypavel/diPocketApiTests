package com.cs.dipocketback.pojo.gps;

public class GPSEhiResponse {

    private Long ehiId;
    private String responsestatus;
    private Long curBalance;
    private Long avlbalance;
    private String acknowledgement;
    private Long loadAmount;
    private Long billAmtApproved;
    private Integer updateBalance;
    
    public GPSEhiResponse() {
    }

    public GPSEhiResponse(Long ehiId, String responsestatus, Long curBalance, Long avlbalance, String acknowledgement,
                          Long loadAmount, Long billAmtApproved, Integer updateBalance) {
        this.ehiId = ehiId;
        this.responsestatus = responsestatus;
        this.curBalance = curBalance;
        this.avlbalance = avlbalance;
        this.acknowledgement = acknowledgement;
        this.loadAmount = loadAmount;
        this.billAmtApproved = billAmtApproved;
        this.updateBalance = updateBalance;
    }

    public Long getEhiId() {
        return ehiId;
    }

    public void setEhiId(Long ehiId) {
        this.ehiId = ehiId;
    }

    public void setResponsestatus(String responsestatus) {
        this.responsestatus = responsestatus;
    }

    public String getResponsestatus() {
        return responsestatus;
    }

    public void setCurBalance(Long curBalance) {
        this.curBalance = curBalance;
    }

    public Long getCurBalance() {
        return curBalance;
    }

    public void setAvlbalance(Long avlbalance) {
        this.avlbalance = avlbalance;
    }

    public Long getAvlbalance() {
        return avlbalance;
    }

    public void setAcknowledgement(String acknowledgement) {
        this.acknowledgement = acknowledgement;
    }

    public String getAcknowledgement() {
        return acknowledgement;
    }

    public void setLoadAmount(Long loadAmount) {
        this.loadAmount = loadAmount;
    }

    public Long getLoadAmount() {
        return loadAmount;
    }

    public void setBillAmtApproved(Long billAmtApproved) {
        this.billAmtApproved = billAmtApproved;
    }

    public Long getBillAmtApproved() {
        return billAmtApproved;
    }

    public void setUpdateBalance(Integer updateBalance) {
        this.updateBalance = updateBalance;
    }

    public Integer getUpdateBalance() {
        return updateBalance;
    }

    @Override
    public String toString() {
        return "GPSEhiResponse{" +
                "ehiId=" + ehiId +
                ", responsestatus='" + responsestatus + '\'' +
                ", curBalance=" + curBalance +
                ", avlbalance=" + avlbalance +
                ", acknowledgement='" + acknowledgement + '\'' +
                ", loadAmount=" + loadAmount +
                ", billAmtApproved=" + billAmtApproved +
                ", updateBalance=" + updateBalance +
                '}';
    }
}
