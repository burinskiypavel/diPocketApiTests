package com.cs.dipocketback.pojo.references;

import java.util.List;

public class SysParamList {
    
    private List<SysParam> params;
    
    public SysParamList() {
    }

    public SysParamList(List<SysParam> params) {
        this.params = params;
    }

    public void setParams(List<SysParam> params) {
        this.params = params;
    }

    public List<SysParam> getParams() {
        return params;
    }
}
