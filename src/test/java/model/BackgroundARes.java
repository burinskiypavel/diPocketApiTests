package model;

public class BackgroundARes {
    private String acsTransID;
    private String acsChallengeMandated;
    private String authenticationType;
    private String messageType;
    private String messageVersion;
    private String transStatus;

    public String getAcsTransID() {
        return acsTransID;
    }

    public String getAcsChallengeMandated() {
        return acsChallengeMandated;
    }

    public String getAuthenticationType() {
        return authenticationType;
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

    public void setAcsTransID(String acsTransID) {
        this.acsTransID = acsTransID;
    }

    public void setAcsChallengeMandated(String acsChallengeMandated) {
        this.acsChallengeMandated = acsChallengeMandated;
    }

    public void setAuthenticationType(String authenticationType) {
        this.authenticationType = authenticationType;
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

    @Override
    public String toString() {
        return "BackgroundARes{" +
                "acsTransID='" + acsTransID + '\'' +
                ", acsChallengeMandated='" + acsChallengeMandated + '\'' +
                ", authenticationType='" + authenticationType + '\'' +
                ", messageType='" + messageType + '\'' +
                ", messageVersion='" + messageVersion + '\'' +
                ", transStatus='" + transStatus + '\'' +
                '}';
    }
}
