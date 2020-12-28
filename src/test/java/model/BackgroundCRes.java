package model;

public class BackgroundCRes {

    private String acsTransID;
    private String messageType;
    private String messageVersion;
    private String pageId;
    private String challengeCompletionInd;

    public String getAcsTransID() {
        return acsTransID;
    }

    public String getMessageType() {
        return messageType;
    }

    public String getMessageVersion() {
        return messageVersion;
    }

    public String getPageId() {
        return pageId;
    }

    public String getChallengeCompletionInd() {
        return challengeCompletionInd;
    }

    public void setAcsTransID(String acsTransID) {
        this.acsTransID = acsTransID;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public void setMessageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public void setChallengeCompletionInd(String challengeCompletionInd) {
        this.challengeCompletionInd = challengeCompletionInd;
    }

    @Override
    public String toString() {
        return "BackgroundCRes{" +
                "acsTransID='" + acsTransID + '\'' +
                ", messageType='" + messageType + '\'' +
                ", messageVersion='" + messageVersion + '\'' +
                ", pageId='" + pageId + '\'' +
                ", challengeCompletionInd='" + challengeCompletionInd + '\'' +
                '}';
    }
}
