package com.cs.dipocketback.pojo.client;

public class ClientDbSession {

    private Long sessionId;
    private Long clientId;

    public ClientDbSession(Long sessionId, Long clientId) {
        this.sessionId = sessionId;
        this.clientId = clientId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public Long getClientId() {
        return clientId;
    }

}
