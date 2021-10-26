package com.cs.dipocketback.pojo.push;

import java.util.List;

public class PushMessageList {
    
    private List<PushMessage> messageList;
    
    public PushMessageList() {
    }

    public PushMessageList(List<PushMessage> messageList) {
        this.messageList = messageList;
    }

    public void setMessageList(List<PushMessage> messageList) {
        this.messageList = messageList;
    }

    public List<PushMessage> getMessageList() {
        return messageList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PushMessageList{");
        if (messageList != null) {
            sb.append("messageList=[");
            for (PushMessage pushMessage : messageList) {
                if (pushMessage != null) {
                    sb.append("\n\t").append(pushMessage.toString());
                }
            }
            sb.append("]");
        } else {
            sb.append("messageList=null").append(messageList);
        }

        sb.append('}');
        return sb.toString();
    }

}
