package model;

public class FinalCRes {

    private String acsTransID;
    private String messageType;
    private String messageVersion;
    private String transStatus;
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

    public String getTransStatus() {
        return transStatus;
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

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    public void setChallengeCompletionInd(String challengeCompletionInd) {
        this.challengeCompletionInd = challengeCompletionInd;
    }

    @Override
    public String toString() {
        return "FinalCRes{" +
                "acsTransID='" + acsTransID + '\'' +
                ", messageType='" + messageType + '\'' +
                ", messageVersion='" + messageVersion + '\'' +
                ", transStatus='" + transStatus + '\'' +
                ", challengeCompletionInd='" + challengeCompletionInd + '\'' +
                '}';
    }

}


