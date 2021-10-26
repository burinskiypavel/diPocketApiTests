package com.cs.dipocketback.pojo.dippal;

import java.util.List;

public class ClientPalData {

    private List<String> clientPalPhones;
    private List<String> clientPalNames;

    public void setClientPalPhones(List<String> clientPalPhones) {
        this.clientPalPhones = clientPalPhones;
    }

    public List<String> getClientPalPhones() {
        return clientPalPhones;
    }

    public void setClientPalNames(List<String> clientPalNames) {
        this.clientPalNames = clientPalNames;
    }

    public List<String> getClientPalNames() {
        return clientPalNames;
    }

    public ClientPalData() {
    }

}
