package com.cs.dipocketback.pojo.notification;

public class TransactionFee {

    private Long feeAccountId;
    private Long feeAmount;
    private String feeCurrencyCode;
    private Long trnFeeAmount;
    private String trnFeeCurrencyCode;
    private Long convFeeAmount;
    private String convFeeCurrencyCode;

    public TransactionFee() {
    }

    public TransactionFee(Long feeAccountId, Long feeAmount, String feeCurrencyCode, Long trnFeeAmount,
                          String trnFeeCurrencyCode, Long convFeeAmount, String convFeeCurrencyCode) {
        this.feeAccountId = feeAccountId;
        this.feeAmount = feeAmount;
        this.feeCurrencyCode = feeCurrencyCode;
        this.trnFeeAmount = trnFeeAmount;
        this.trnFeeCurrencyCode = trnFeeCurrencyCode;
        this.convFeeAmount = convFeeAmount;
        this.convFeeCurrencyCode = convFeeCurrencyCode;
    }

    public Long getFeeAccountId() {
        return feeAccountId;
    }

    public void setFeeAccountId(Long feeAccountId) {
        this.feeAccountId = feeAccountId;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getFeeCurrencyCode() {
        return feeCurrencyCode;
    }

    public void setFeeCurrencyCode(String feeCurrencyCode) {
        this.feeCurrencyCode = feeCurrencyCode;
    }

    public Long getTrnFeeAmount() {
        return trnFeeAmount;
    }

    public void setTrnFeeAmount(Long trnFeeAmount) {
        this.trnFeeAmount = trnFeeAmount;
    }

    public String getTrnFeeCurrencyCode() {
        return trnFeeCurrencyCode;
    }

    public void setTrnFeeCurrencyCode(String trnFeeCurrencyCode) {
        this.trnFeeCurrencyCode = trnFeeCurrencyCode;
    }

    public Long getConvFeeAmount() {
        return convFeeAmount;
    }

    public void setConvFeeAmount(Long convFeeAmount) {
        this.convFeeAmount = convFeeAmount;
    }

    public String getConvFeeCurrencyCode() {
        return convFeeCurrencyCode;
    }

    public void setConvFeeCurrencyCode(String convFeeCurrencyCode) {
        this.convFeeCurrencyCode = convFeeCurrencyCode;
    }

    @Override
    public String toString() {
        return "TransactionFee{" +
                "feeAccountId=" + feeAccountId +
                ", feeAmount=" + feeAmount +
                ", feeCurrencyCode='" + feeCurrencyCode + '\'' +
                ", trnFeeAmount=" + trnFeeAmount +
                ", trnFeeCurrencyCode='" + trnFeeCurrencyCode + '\'' +
                ", convFeeAmount=" + convFeeAmount +
                ", convFeeCurrencyCode='" + convFeeCurrencyCode + '\'' +
                '}';
    }
}
