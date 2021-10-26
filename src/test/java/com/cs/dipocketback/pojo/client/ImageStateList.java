package com.cs.dipocketback.pojo.client;

import com.cs.dipocketback.pojo.registration.RegImageData;

import java.util.List;

public class ImageStateList {
    
    private List<RegImageData> images;
    
    public ImageStateList() {
    }

    public ImageStateList(List<RegImageData> images) {
        this.images = images;
    }

    public void setImages(List<RegImageData> images) {
        this.images = images;
    }

    public List<RegImageData> getImages() {
        return images;
    }

}
