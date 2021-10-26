package com.cs.dipocketback.pojo.dippal;

import java.util.List;

public class ClientPalList {

    private List<ClientPal> clientPalList;

    public void setClientPalList(List<ClientPal> clientPalList) {
        this.clientPalList = clientPalList;
    }

    public List<ClientPal> getClientPalList() {
        return clientPalList;
    }

    public ClientPalList() {
    }

    public ClientPalList(List<ClientPal> clientPalList) {
        this.clientPalList = clientPalList;
    }

}
