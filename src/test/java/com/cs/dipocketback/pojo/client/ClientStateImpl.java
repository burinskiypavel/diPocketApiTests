package com.cs.dipocketback.pojo.client;

public class ClientStateImpl implements ClientState {

    private final Long clientId;
    private final Boolean blocked;
    private final Boolean banned;
    private final Integer secAnswerAttemptCnt;

    public ClientStateImpl(Long clientId,
                           Boolean blocked,
                           Boolean banned,
                           Integer secAnswerAttemptCnt) {
        this.clientId = clientId;
        this.blocked = blocked;
        this.banned = banned;
        this.secAnswerAttemptCnt = secAnswerAttemptCnt;
    }

    @Override
    public Long getClientId() {
        return clientId;
    }

    @Override
    public Boolean isBlocked() {
        return blocked;
    }

    @Override
    public Boolean isBanned() {
        return banned;
    }

    @Override
    public Integer getSecAnswerAttemptCnt() {
        return secAnswerAttemptCnt;
    }

}
