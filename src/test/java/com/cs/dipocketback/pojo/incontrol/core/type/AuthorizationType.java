package com.cs.dipocketback.pojo.incontrol.core.type;

public enum AuthorizationType {
    
    All("All"),
    Approved("Approved"),
    Partial_Approved("Partial-Approved"),
    Declined("Declined"),
    Issuer_Declined("Issuer-Declined"),
    Request_Response("Request-Response"),
    Advice_Response("Advice-Response"),
    Reversal_Response("Reversal-Response");

    private String type;

    private AuthorizationType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return type;
    }
}
