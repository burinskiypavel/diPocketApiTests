package com.cs.dipocketback.pojo.push;

public class PushRequest {

    private String payLoadStr;
    private String message;
    private String token;
    private Boolean productionMode;
    private Integer msgCount;
    private String keyBase64;
    private String keyPwd;

    public PushRequest() {
    }

    public void setPayLoadStr(String payLoadStr) {
        this.payLoadStr = payLoadStr;
    }

    public String getPayLoadStr() {
        return payLoadStr;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setProductionMode(Boolean productionMode) {
        this.productionMode = productionMode;
    }

    public Boolean getProductionMode() {
        return productionMode;
    }

    public void setMsgCount(Integer msgCount) {
        this.msgCount = msgCount;
    }

    public Integer getMsgCount() {
        return msgCount;
    }

    public void setKeyBase64(String keyBase64) {
        this.keyBase64 = keyBase64;
    }

    public String getKeyBase64() {
        return keyBase64;
    }

    public void setKeyPwd(String keyPwd) {
        this.keyPwd = keyPwd;
    }

    public String getKeyPwd() {
        return keyPwd;
    }
}
