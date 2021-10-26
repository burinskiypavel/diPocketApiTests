package com.cs.dipocketback.pojo.tds.v2;

public class TdsTranV2 {
    private Long id;
    private String transId;
    private Long clientId;
    private Integer stateId;
    private String stateMsg;
    private String challengeType;
    private Long verifyCodeId;

    public TdsTranV2() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
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

    public Long getVerifyCodeId() {
        return verifyCodeId;
    }

    public void setVerifyCodeId(Long verifyCodeId) {
        this.verifyCodeId = verifyCodeId;
    }
}
