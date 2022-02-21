package model.bo.boClient;

public class Client_pushMsgs {

    private int id;
    private int clientId;
    private String channel;
    private String created;
    private String sent;
    private String message;
    private String formattedCreated;

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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getSent() {
        return sent;
    }

    public void setSent(String sent) {
        this.sent = sent;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFormattedCreated() {
        return formattedCreated;
    }

    public void setFormattedCreated(String formattedCreated) {
        this.formattedCreated = formattedCreated;
    }
}
