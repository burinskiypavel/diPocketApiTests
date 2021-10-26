package com.cs.dipocketback.pojo.portal;

public enum StatementFormatType {

    PDF,
    CSV;

    public static StatementFormatType find(String type) {
        if (type != null) {
            for (StatementFormatType formatType : values()) {
                if (formatType.name().equals(type.toUpperCase())) {
                    return formatType;
                }
            }
        }
        return PDF;
    }
}
