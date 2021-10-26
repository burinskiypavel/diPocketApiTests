package com.cs.dipocketback.pojo.notification;



public class NotificationAction {


    private Long messageId;

    private String action;

    private String authenticationMethod;

    public NotificationAction() {
    }

    public NotificationAction(Long messageId, String action, String authenticationMethod) {
        this.messageId = messageId;
        this.action = action;
        this.authenticationMethod = authenticationMethod;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAuthenticationMethod() {
        return authenticationMethod;
    }

    public void setAuthenticationMethod(String authenticationMethod) {
        this.authenticationMethod = authenticationMethod;
    }

    @Override
    public String toString() {
        return "NotificationAction{" +
                "messageId=" + messageId +
                ", action='" + action + '\'' +
                ", authenticationMethod='" + authenticationMethod + '\'' +
                '}';
    }
}
