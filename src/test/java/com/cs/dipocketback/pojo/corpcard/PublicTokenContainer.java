package com.cs.dipocketback.pojo.corpcard;

public class PublicTokenContainer {
    
    private String publicToken;
    
    public PublicTokenContainer() {
    }

    public PublicTokenContainer(String publictoken) {
        this.publicToken = publictoken;
    }

    public void setPublicToken(String publictoken) {
        this.publicToken = publictoken;
    }

    public String getPublicToken() {
        return publicToken;
    }
    
}
