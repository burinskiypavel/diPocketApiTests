package com.cs.dipocketback.pojo.notification;





public class NotificationMessage {


    private Long requestId;

    private Integer attemptNo;

    private Long messageId;

    private String messageDate;
    private String avlActions;

    private Long clientId;
    private NotificationMessageTransaction notificationMessageTransaction;


    private String siteEndpoint;

    public NotificationMessage() {
    }

    public NotificationMessage(Long requestId, Integer attemptNo, Long messageId, String messageDate, String avlActions,
                               Long clientId, NotificationMessageTransaction notificationMessageTransaction) {
        this.requestId = requestId;
        this.attemptNo = attemptNo;
        this.messageId = messageId;
        this.messageDate = messageDate;
        this.avlActions = avlActions;
        this.clientId = clientId;
        this.notificationMessageTransaction = notificationMessageTransaction;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Integer getAttemptNo() {
        return attemptNo;
    }

    public void setAttemptNo(Integer attemptNo) {
        this.attemptNo = attemptNo;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    public String getAvlActions() {
        return avlActions;
    }

    public void setAvlActions(String avlActions) {
        this.avlActions = avlActions;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public NotificationMessageTransaction getNotificationMessageTransaction() {
        return notificationMessageTransaction;
    }

    public void setNotificationMessageTransaction(NotificationMessageTransaction notificationMessageTransaction) {
        this.notificationMessageTransaction = notificationMessageTransaction;
    }

    public String getSiteEndpoint() {
        return siteEndpoint;
    }

    public void setSiteEndpoint(String siteEndpoint) {
        this.siteEndpoint = siteEndpoint;
    }

    @Override
    public String toString() {
        return "NotificationMessage{" +
                "requestId=" + requestId +
                ", attemptNo=" + attemptNo +
                ", messageId=" + messageId +
                ", messageDate='" + messageDate + '\'' +
                ", avlActions='" + avlActions + '\'' +
                ", clientId=" + clientId +
                ", notificationMessageTransaction=" + notificationMessageTransaction +
                ", siteEndpoint='" + siteEndpoint + '\'' +
                '}';
    }
}
