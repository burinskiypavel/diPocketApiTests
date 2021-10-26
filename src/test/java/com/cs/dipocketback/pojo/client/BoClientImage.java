package com.cs.dipocketback.pojo.client;

import com.cs.dipocketback.pojo.registration.RegImageData;

public class BoClientImage {
    
    private Long clientId;
    private String base64data;
    private RegImageData.ImageType type;
    
    public BoClientImage() {
    }

    public BoClientImage(Long clientId, String base64data, RegImageData.ImageType type) {
        this.clientId = clientId;
        this.base64data = base64data;
        this.type = type;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setBase64data(String base64data) {
        this.base64data = base64data;
    }

    public String getBase64data() {
        return base64data;
    }

    public void setType(RegImageData.ImageType type) {
        this.type = type;
    }

    public RegImageData.ImageType getType() {
        return type;
    }
}
