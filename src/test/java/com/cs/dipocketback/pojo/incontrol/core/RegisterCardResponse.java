package com.cs.dipocketback.pojo.incontrol.core;

public class RegisterCardResponse {

    private Long cpnId;

    public RegisterCardResponse() {
    }

    public RegisterCardResponse(Long cpnId) {
        this.cpnId = cpnId;
    }

    public Long getCpnId() {
        return cpnId;
    }

    public void setCpnId(Long cpnId) {
        this.cpnId = cpnId;
    }

}
