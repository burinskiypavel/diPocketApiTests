package com.cs.dipocketback.pojo.client;

public interface ClientState {

    Long getClientId();

    Boolean isBlocked();

    Boolean isBanned();

    Integer getSecAnswerAttemptCnt();

}
