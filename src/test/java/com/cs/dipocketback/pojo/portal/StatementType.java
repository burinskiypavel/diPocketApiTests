package com.cs.dipocketback.pojo.portal;

public enum StatementType {
    
    CARD,
    MAINACCOUNT,
    MAINACCOUNTCARDS;

    public static StatementType find(String type) {
        if (type != null) {
            for (StatementType formatType : values()) {
                if (formatType.name().equals(type.toUpperCase())) {
                    return formatType;
                }
            }
        }
        return null;
    }

}
