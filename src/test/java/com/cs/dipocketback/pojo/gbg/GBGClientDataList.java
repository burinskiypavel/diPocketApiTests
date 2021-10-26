package com.cs.dipocketback.pojo.gbg;

import java.util.List;

public class GBGClientDataList {
    
    private List<GBGClientData> dataList;
    
    public GBGClientDataList() {
    }

    public GBGClientDataList(List<GBGClientData> dataList) {
        this.dataList = dataList;
    }

    public void setDataList(List<GBGClientData> dataList) {
        this.dataList = dataList;
    }

    public List<GBGClientData> getDataList() {
        return dataList;
    }
}
