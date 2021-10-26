package com.cs.dipocketback.pojo.communicationtile;

import java.util.List;

public class MarkedTileList {
    
    private List<Long> tileIds;
    
    public MarkedTileList() {
    }

    public void setTileIds(List<Long> tileIds) {
        this.tileIds = tileIds;
    }

    public List<Long> getTileIds() {
        return tileIds;
    }
    
}
