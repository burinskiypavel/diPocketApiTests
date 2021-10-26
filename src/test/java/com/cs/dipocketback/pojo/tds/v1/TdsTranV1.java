package com.cs.dipocketback.pojo.tds.v1;

public class TdsTranV1 {
    private Long id;
    private Long transId;
    private Long clientId;
    private Integer stateId;
    private String stateMsg;
    private String challengeType;
    private Long verifyCode;

    public TdsTranV1() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransId() {
        return transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateMsg() {
        return stateMsg;
    }

    public void setStateMsg(String stateMsg) {
        this.stateMsg = stateMsg;
    }

    public String getChallengeType() {
        return challengeType;
    }

    public void setChallengeType(String challengeType) {
        this.challengeType = challengeType;
    }

    public Long getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(Long verifyCode) {
        this.verifyCode = verifyCode;
    }
}
