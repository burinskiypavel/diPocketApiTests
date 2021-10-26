package com.cs.dipocketback.pojo.push;

public class PushMessageParam {
    
    private Long pushMsgId;
    private String name;
    private String value;
    
    public PushMessageParam() {
    }

    public PushMessageParam(Long pushMsgId, String name, String value) {
        this.pushMsgId = pushMsgId;
        this.name = name;
        this.value = value;
    }

    public void setPushMsgId(Long pushMsgId) {
        this.pushMsgId = pushMsgId;
    }

    public Long getPushMsgId() {
        return pushMsgId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PushMessageParam{");
        sb.append("pushMsgId=").append(pushMsgId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", value='").append(value).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
