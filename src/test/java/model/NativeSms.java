package model;

public class NativeSms extends OOBBackgroundCRes {

    private String challengeInfoLabel;
    private String submitAuthenticationLabel;

    public String getChallengeInfoLabel() {
        return challengeInfoLabel;
    }

    public void setChallengeInfoLabel(String challengeInfoLabel) {
        this.challengeInfoLabel = challengeInfoLabel;
    }

    public String getSubmitAuthenticationLabel() {
        return submitAuthenticationLabel;
    }

    public void setSubmitAuthenticationLabel(String submitAuthenticationLabel) {
        this.submitAuthenticationLabel = submitAuthenticationLabel;
    }
}
