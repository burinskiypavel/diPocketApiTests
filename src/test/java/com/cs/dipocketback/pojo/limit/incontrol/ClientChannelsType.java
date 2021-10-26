package com.cs.dipocketback.pojo.limit.incontrol;

public enum ClientChannelsType {
    
    POS(1),
    ECOM(2),
    CONTACTLESS(3),
    CASH(4);
    
    private Integer id;
    
    private ClientChannelsType(Integer id) {
        this.id = id;
    }
    
}
