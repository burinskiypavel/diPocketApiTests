package com.cs.dipocketback.pojo.client;

public class ClientDocs {
       
    private String photoID;
    private String photoIDBack;
    private String proofOfAddress;
    private Boolean savePhotoIDBack;
    private Boolean saveProofOfAddress;
    private String secondId;
    
    public ClientDocs() {
    }

    public void setPhotoID(String photoID) {
        this.photoID = photoID;
    }

    public String getPhotoID() {
        return photoID;
    }

    public void setPhotoIDBack(String photoIDBack) {
        this.photoIDBack = photoIDBack;
    }

    public String getPhotoIDBack() {
        return photoIDBack;
    }

    public void setProofOfAddress(String proofOfAddress) {
        this.proofOfAddress = proofOfAddress;
    }

    public String getProofOfAddress() {
        return proofOfAddress;
    }

    public void setSavePhotoIDBack(Boolean savePhotoIDBack) {
        this.savePhotoIDBack = savePhotoIDBack;
    }

    public Boolean getSavePhotoIDBack() {
        return photoIDBack == null ? false : true;
    }

    public void setSaveProofOfAddress(Boolean saveProofOfAddress) {
        this.saveProofOfAddress = saveProofOfAddress;
    }

    public Boolean getSaveProofOfAddress() {
        return proofOfAddress == null ? false : true;
    }

    public void setSecondId(String secondId) {
        this.secondId = secondId;
    }

    public String getSecondId() {
        return secondId;
    }

}
