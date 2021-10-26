package com.cs.dipocketback.pojo.references;

public class SysParam {
    
    private String name;
    private String value;
    
    public SysParam() {
    }

    public SysParam(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public Boolean getBooleanValue() {
        return Boolean.valueOf(getValue());
    }
    
    public Integer getIntegerValue() {
        return Integer.valueOf(getValue());
    }
    
    public Double getDoubleValue() {
        return Double.valueOf(getValue());
    }
    
}
