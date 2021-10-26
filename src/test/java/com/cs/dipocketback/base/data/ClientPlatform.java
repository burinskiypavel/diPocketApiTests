package com.cs.dipocketback.base.data;

import java.util.HashMap;
import java.util.Map;

public enum ClientPlatform {

    ANDROID("android"),
    IOS("ios"),
    WINDOWS("winphone"),
    UNKNOWN("");

    private static final Map<String, ClientPlatform> CLIENT_PLATFORM_MAP = new HashMap<>(3);

    static {
        for (ClientPlatform cp : values()) {
            CLIENT_PLATFORM_MAP.put(cp.name(), cp);
        }
    }

    private String name;

    private ClientPlatform(String name) {
        this.name = name;
    }

    public static ClientPlatform getClientStatusByName(String platformName) {
        if (platformName == null) {
            return UNKNOWN;
        }
        if (CLIENT_PLATFORM_MAP.containsKey(platformName.toLowerCase())) {
            return CLIENT_PLATFORM_MAP.get(platformName.toLowerCase());
        }
        return UNKNOWN;
    }

}
