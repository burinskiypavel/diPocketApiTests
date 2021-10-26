package com.cs.dipocketback.pojo.limit.incontrol;

import java.util.Map;

public class TestLimitTypeInDbContainer {
    
    private Map<Integer, IncDefLimit> mapIncDefLimit;
    
    public TestLimitTypeInDbContainer() {
    }

    public TestLimitTypeInDbContainer(Map<Integer, IncDefLimit> mapIncDefLimit) {
        this.mapIncDefLimit = mapIncDefLimit;
    }

    public void setMapIncDefLimit(Map<Integer, IncDefLimit> mapIncDefLimit) {
        this.mapIncDefLimit = mapIncDefLimit;
    }

    public Map<Integer, IncDefLimit> getMapIncDefLimit() {
        return mapIncDefLimit;
    }
}
