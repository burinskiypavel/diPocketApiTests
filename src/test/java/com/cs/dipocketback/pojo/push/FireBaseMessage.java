package com.cs.dipocketback.pojo.push;

import java.util.Map;

public class FireBaseMessage {

    private static final String MSG_PARAM = "alert";

    private String to;
    private Map<String, Object> data;

    public FireBaseMessage() {
    }

    public FireBaseMessage(String to, Map<String, Object> data, String message) {
        this.to = to;
        this.data = data;
        if (data != null) {
            this.data.put(MSG_PARAM, message);
        }
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Map<String, Object> getData() {
        return data;
    }

}
