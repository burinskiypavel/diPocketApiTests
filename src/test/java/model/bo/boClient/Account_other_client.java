package model.bo.boClient;

public class Account_other_client {

    private int id;
    private int clientId;
    private String cardName;
    private String created;
    private String maskedPan;
    private String accountStateName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getAccountStateName() {
        return accountStateName;
    }

    public void setAccountStateName(String accountStateName) {
        this.accountStateName = accountStateName;
    }
}
