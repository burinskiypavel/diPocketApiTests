package com.cs.dipocketback.pojo.push;

public enum PushChannelType {
    
    SMS("S"),
    PUSH("P"),
    CREDISSIMO("C"),
    PEAK("PEAK"),
    API("API"),
    UNKNOWN("UNKNOWN"); 
    
    private String channel;
    
    private PushChannelType(String channel) {
        this.channel = channel;
    }
    
    public static PushChannelType findByChannel(String channel) {
        for (PushChannelType pc : values()) {
            if (pc.channel.equals(channel)) {
                return pc;
            }
        }
        return UNKNOWN;
    }
    
}
