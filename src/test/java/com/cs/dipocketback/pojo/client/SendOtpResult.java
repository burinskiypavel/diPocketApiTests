package com.cs.dipocketback.pojo.client;

public class SendOtpResult {
    private Long powId;
    private Integer codeNo;

    public SendOtpResult() {
    }

    public SendOtpResult(Long powId, Integer codeNo) {
        this.powId = powId;
        this.codeNo = codeNo;
    }

    public Long getPowId() {
        return powId;
    }

    public void setPowId(Long powId) {
        this.powId = powId;
    }

    public Integer getCodeNo() {
        return codeNo;
    }

    public void setCodeNo(Integer codeNo) {
        this.codeNo = codeNo;
    }
}
