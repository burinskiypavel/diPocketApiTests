package com.cs.dipocketback.pojo.limit.incontrol;

public class IncChannel {
    
    private Long id;
    private String sName;   //Online shopping
    private String envList; //ECOM, MOTO

    public IncChannel(Long id, String sName, String envList) {
        this.id = id;
        this.sName = sName;
        this.envList = envList;
    }

    public Long getId() {
        return id;
    }

    public String getSName() {
        return sName;
    }

    public String getEnvList() {
        return envList;
    }
    
}
