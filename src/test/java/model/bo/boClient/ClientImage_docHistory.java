package model.bo.boClient;

public class ClientImage_docHistory {

    private int id;
    private int clientId;
    private int typeId;
    private String imageInBase64;
    private String added;
    private int stateId;
    private String stateName;

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

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getImageInBase64() {
        return imageInBase64;
    }

    public void setImageInBase64(String imageInBase64) {
        this.imageInBase64 = imageInBase64;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
