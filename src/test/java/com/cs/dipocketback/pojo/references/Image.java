package com.cs.dipocketback.pojo.references;

public class Image {

    private String imageKey;
    private String imageRef;
    private String imageData;

    public Image() {
    }

    public Image(String imageKey, String imageRef, String imageData) {
        this.imageKey = imageKey;
        this.imageRef = imageRef;
        this.imageData = imageData;
    }

    public String getImageKey() {
        return imageKey;
    }

    public void setImageKey(String imageKey) {
        this.imageKey = imageKey;
    }

    public String getImageRef() {
        return imageRef;
    }

    public void setImageRef(String imageRef) {
        this.imageRef = imageRef;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }
}
