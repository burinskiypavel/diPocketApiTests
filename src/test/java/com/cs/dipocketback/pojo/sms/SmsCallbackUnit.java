package com.cs.dipocketback.pojo.sms;

public class SmsCallbackUnit {

    private String msgId;
    private String status;
    private String gate;

    public SmsCallbackUnit(String gate) {
        this.gate = gate;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public SmsCallbackUnit updateWithinGate(String msgId, String status) {
        this.msgId = msgId;
        this.status = status;
        return this;
    }
}
