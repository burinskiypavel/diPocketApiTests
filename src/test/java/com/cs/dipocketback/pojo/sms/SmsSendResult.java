package com.cs.dipocketback.pojo.sms;

public class SmsSendResult {

    private String status;
    private String externalId;
    private String gate;
    private Double point;

    public SmsSendResult(String status, String externalId, Double point) {
        this.status = status;
        this.externalId = externalId;
        this.point = point;
    }

    public SmsSendResult(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }
}
