package com.cs.dipocketback.pojo.payments;

import java.util.HashMap;
import java.util.Map;

public enum DetailsType {

    TRANITEM(10),
    MOVEMENT(11),
    ACCOUNT_SHARING(20),
    MESSAGE(40),
    TDS_TRAN(50);

    private static final Map<Integer, DetailsType> matrix = new HashMap<>();
    static {
        for (DetailsType detailsType : values()) {
            matrix.put(detailsType.getId(), detailsType);
        }
    }
    private Integer id;

    private DetailsType(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public static DetailsType valueOf(Integer value) {
        return matrix.get(value);
    }
}
