package com.cs.dipocketback.pojo.push;

import java.util.List;

public class PushMessageParamList {
    
    private List<PushMessageParam> paramList;
    
    public PushMessageParamList() {
    }

    public PushMessageParamList(List<PushMessageParam> paramList) {
        this.paramList = paramList;
    }

    public void setParamList(List<PushMessageParam> paramList) {
        this.paramList = paramList;
    }

    public List<PushMessageParam> getParamList() {
        return paramList;
    }
}
