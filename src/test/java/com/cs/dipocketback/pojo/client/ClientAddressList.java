package com.cs.dipocketback.pojo.client;


import java.util.List;

public class ClientAddressList {
    
    private List<ClientAddress> addressList;
    
    public ClientAddressList() {
    }

    public ClientAddressList(List<ClientAddress> addressList) {
        this.addressList = addressList;
    }


    public void setAddressList(List<ClientAddress> addressList) {
        this.addressList = addressList;
    }

    public List<ClientAddress> getAddressList() {
        return addressList;
    }
}
