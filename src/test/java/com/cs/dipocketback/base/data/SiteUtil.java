package com.cs.dipocketback.base.data;

public class SiteUtil {

    private static final String TELENOR_GATE = "Telenor";
    private static final String SMS_API_GATE = "SMS API";

    public static String getSmsGateBySite(Site site) {
        if (site == Site.TELENOR || site == Site.FESTIVAL_HUF) {
            return TELENOR_GATE;
        }
        return SMS_API_GATE;
    }

}
