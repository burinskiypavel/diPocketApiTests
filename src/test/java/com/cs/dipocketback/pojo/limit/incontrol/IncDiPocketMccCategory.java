package com.cs.dipocketback.pojo.limit.incontrol;

public class IncDiPocketMccCategory {
    
    private Integer id;
    private String name;
    private boolean allowed;
    
    public IncDiPocketMccCategory() {
    }

    public IncDiPocketMccCategory(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public IncDiPocketMccCategory(Integer id, String name, boolean allowed) {
        this.id = id;
        this.name = name;
        this.allowed = allowed;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    public boolean isAllowed() {
        return allowed;
    }
    
}
