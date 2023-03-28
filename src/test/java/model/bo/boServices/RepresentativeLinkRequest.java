package model.bo.boServices;

public class RepresentativeLinkRequest {

    private int clientId;
    private int corpClientId;


    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getCorpClientId() {
        return corpClientId;
    }

    public void setCorpClientId(int corpClientId) {
        this.corpClientId = corpClientId;
    }

}