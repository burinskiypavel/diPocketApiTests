package com.cs.dipocketback.pojo.rsa;

import java.util.List;

public class AddUpdLineList {
    
    private List<AddUpdLine> lineList;
    
    public AddUpdLineList() {
    }

    public AddUpdLineList(List<AddUpdLine> lineList) {
        this.lineList = lineList;
    }

    public void setLineList(List<AddUpdLine> lineList) {
        this.lineList = lineList;
    }

    public List<AddUpdLine> getLineList() {
        return lineList;
    }
}
