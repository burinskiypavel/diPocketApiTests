package com.cs.dipocketback.pojo.incontrol.core.type;

/**
 *
 * @author Artur
 */
public enum ActionType {

    A(""),
    D("");
    
    private String description;
    
    private ActionType(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }

}
