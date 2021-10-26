package com.cs.dipocketback.pojo.client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum CheckboxType {

    BASE_TAC,
    BASE_DATA_PROCESSING,

    MC_PLS_MARKETING,
    MC_PLS_STATS,
    MC_PLS_TNC,

    SANTANDER_PERSONAL_DATA,
    SANTANDER_CONTACT_BY_ECOMM,
    SANTANDER_CONTACT_BY_PHONE,

    BPLUSCLUB_TRANSACTION_DATA,

    TERMS_AND_CONDITIONS_PL,
    ELECTRONIC_COMMUNICATION_WEB,
    MARKETING_PROPOSITION_POPUP,
    MARKETING_PROPOSITION_PLAYIT,
    MARKETING_PROPOSITION,
    ELECTRONIC_COMMUNICATION,
    DATA_PROCESSING,
    FESTIVAL_BAND_LINK_TO_DIPOCKET,
    AGREE_TARIFFS_LABEL,
    TERMS_AND_CONDITIONS_GB,
    AGREE_TERMS_LABEL,
    AGREE_MAIL_DISCLOSURE_PLAYIT,
    AGREE_MAIL_DISCLOSURE,
    AGREE_A_PAY_DIPOCKET,
    ELECTRONIC_COMMUNICATION_NL,

    SODEXO_CONTACT_BY_EMAIL,
    SODEXO_CONTACT_BY_PHONE,
    SODEXO_PROFILING,

    GETSBY_TRANSACTION_DATA;

    private static final Set<CheckboxType> MANDATORY_SET = new HashSet<>(4);

    static {
        MANDATORY_SET.add(BASE_TAC);
        MANDATORY_SET.add(BASE_DATA_PROCESSING);
        MANDATORY_SET.add(MC_PLS_STATS);
        MANDATORY_SET.add(MC_PLS_TNC);
    }

    private static final Map<String, CheckboxType> MAP;

    static {
        MAP = new HashMap<>(values().length);
        for (CheckboxType cb : values()) {
            MAP.put(cb.name().toUpperCase(), cb);
        }
    }

    public Boolean isMandatory() {
        return MANDATORY_SET.contains(this);
    }

    public static CheckboxType getByName(String name) {
        return MAP.get(name.toUpperCase());
    }

}
