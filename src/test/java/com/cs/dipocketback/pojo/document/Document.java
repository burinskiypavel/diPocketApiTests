package com.cs.dipocketback.pojo.document;



public class Document {


    private Integer typeId;
    private String type; // typeName
    private String nameForClient;
    private String nameForEmail;

    private String path;
    private boolean selected;
    
    public Document() {
    }

    public Document(String type, String nameForClient) {
        this.type = type;
        this.nameForClient = nameForClient;
    }

    public Document(String type, String nameForClient, String nameForEmail, String path) {
        this.type = type;
        this.nameForClient = nameForClient;
        this.nameForEmail = nameForEmail;
        this.path = path;
    }

    public Document(Integer typeId, String type, String nameForClient, String nameForEmail, String path) {
        this.typeId = typeId;
        this.type = type;
        this.nameForClient = nameForClient;
        this.nameForEmail = nameForEmail;
        this.path = path;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setNameForClient(String nameForClient) {
        this.nameForClient = nameForClient;
    }

    public String getNameForClient() {
        return nameForClient;
    }

    public void setNameForEmail(String nameForEmail) {
        this.nameForEmail = nameForEmail;
    }

    public String getNameForEmail() {
        return nameForEmail;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public String toString() {
        return "Document {" +
                " typeId=" + typeId +
                ", type='" + type + '\'' +
                ", nameForClient='" + nameForClient + '\'' +
                ", nameForEmail='" + nameForEmail + '\'' +
                ", path='" + path + '\'' +
                ", selected=" + selected +
                '}';
    }

}
