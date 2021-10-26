package com.cs.dipocketback.pojo.client;

//import com.cs.dipocketback.base.data.Site;

import com.cs.dipocketback.base.data.Site;

public class BlockClientAccount {

    public static enum State {
        SUCCESS,
        ERROR,
        REDIRECT_ERROR
    }

    private Integer clientLangId;
    private Site site;
    private State state;

    public BlockClientAccount(State state) {
        this.state = state;
    }

    public BlockClientAccount(Integer clientLangId, Site site, State state) {
        this.clientLangId = clientLangId;
        this.site = site;
        this.state = state;
    }

    public Integer getClientLangId() {
        return clientLangId;
    }

    public Site getSite() {
        return site;
    }

    public State getState() {
        return state;
    }

}
