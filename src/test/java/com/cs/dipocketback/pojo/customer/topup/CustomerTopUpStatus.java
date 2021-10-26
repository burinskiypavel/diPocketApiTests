package com.cs.dipocketback.pojo.customer.topup;

import java.util.HashMap;
import java.util.Map;

public enum CustomerTopUpStatus {

    SUCCESS("SUCCESS"),
    DECLINED("DECLINED"),
    FAILURE("FAILURE"),
    PENDING("PENDING"),
    NEED_THREE_DS("NEEDTHREEDS"),
    RECURRING_ID_PURGED("RECURRINGIDPURGED");

    private String status;
    private static Map<String, CustomerTopUpStatus> statusMap = new HashMap<>();
    static {
        for (CustomerTopUpStatus st : values()) {
            statusMap.put(st.getStatus(), st);
        }
    }

    CustomerTopUpStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static CustomerTopUpStatus findByStatusName(String status) {
        return statusMap.get(status);
    }
}
