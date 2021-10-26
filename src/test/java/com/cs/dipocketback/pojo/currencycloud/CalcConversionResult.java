package com.cs.dipocketback.pojo.currencycloud;

import java.util.Date;

public class CalcConversionResult {
    
    private Date conversionDate;
    private Date dipCutOff;
    private Long payeeId;
    private Date sellAvlDate;
    private Date buyAvlDate;
    
    public CalcConversionResult() {
    }

    public CalcConversionResult(Date conversionDate, Date dipCutOff, Long payeeId, 
                                Date sellAvlDate, Date buyAvlDate) {
        this.conversionDate = conversionDate;
        this.dipCutOff = dipCutOff;
        this.payeeId = payeeId;
        this.sellAvlDate = sellAvlDate;
        this.buyAvlDate = buyAvlDate;
    }

    public void setConversionDate(Date conversionDate) {
        this.conversionDate = conversionDate;
    }

    public Date getConversionDate() {
        return conversionDate;
    }

    public void setDipCutOff(Date dipCutOff) {
        this.dipCutOff = dipCutOff;
    }

    public Date getDipCutOff() {
        return dipCutOff;
    }

    public void setPayeeId(Long payeeId) {
        this.payeeId = payeeId;
    }

    public Long getPayeeId() {
        return payeeId;
    }

    public void setSellAvlDate(Date sellAvlDate) {
        this.sellAvlDate = sellAvlDate;
    }

    public Date getSellAvlDate() {
        return sellAvlDate;
    }

    public void setBuyAvlDate(Date buyAvlDate) {
        this.buyAvlDate = buyAvlDate;
    }

    public Date getBuyAvlDate() {
        return buyAvlDate;
    }
}
