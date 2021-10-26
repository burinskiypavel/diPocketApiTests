package com.cs.dipocketback.pojo.email;

import com.cs.dipocketback.base.data.Site;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

import static com.cs.dipocketback.base.data.Site.*;

public enum EmailType {

    // Need to remove after sending
    DIPOCKET_UAB("dipocket_uab", "/email/base/closing_pekao",
            map(
                    couple(DISCONTU, "/email/site/discontu/closing_pekao"),
                    couple(FESTIVAL_NL, "/email/site/moneycomb/closing_pekao")
            )
    ),

    BANK_TRANSFER("bank_transfer", "/email/base/bank_transfer"),
    CHANGE_EMAIL("change_email", "/email/base/change_email"),
    CHANGE_PHONE("change_phone", "/email/base/change_phone"),
    LEGAL("legal", "/email/base/legal"),
    RESET_PASSWORD("reset_password", "/email/base/reset_password",
            map(couple(TELENOR, "/email/site/telenor/reset_password"))
    ),
    STATEMENT("statement", "/email/base/statement"),
    STRONG_PASS("strong_pass", "/email/base/strong_pass"),
    SUPERVISOR("supervisor", "/email/base/supervisor"),
    TAC("tac", "/email/base/tac",
            map(
                    couple(TELENOR, "/email/site/telenor/tac"),
                    couple(GETSBY, "/email/site/getsby/tac"),
                    couple(GETSBYCARD, "/email/site/getsby/tac")
            )
    ),

    // Apple Pay
    APPLE_PAY_INACTIVE("a_pay_inactive", "/email/base/apple_pay/a_pay_inactive",
            map(couple(SODEXO, "/email/site/sodexo/apple_pay/a_pay_inactive"))
    ),
    APPLE_PAY_LAUNCH("a_pay_launch", "/email/base/apple_google_pay/a_g_pay_launch",
            map(couple(SODEXO, "/email/site/sodexo/apple_pay/a_pay_launch"))
    ),
    APPLE_PAY_PENDING("a_pay_pending", "/email/base/apple_pay/a_pay_pending",
            map(couple(SODEXO, "/email/site/sodexo/apple_pay/a_pay_pending"))
    ),
    APPLE_PAY_REORDER("a_pay_reorder", "/email/base/apple_pay/a_pay_reorder"),
    APPLE_PAY_TOKENIZATION("a_pay_tokenisation", "/email/base/apple_pay/a_pay_tokenization",
            map(couple(SODEXO, "/email/site/sodexo/apple_pay/a_pay_tokenization"))
    ),

    // Link card case
    LINK_ACCOUNT_OTP("link_account_otp", "/email/base/link_account/link_account_otp",
            map(couple(SODEXO, "/email/site/sodexo/link_account/link_account_otp"))
    ),
    LINK_ACCOUNT_TERMS("link_account_terms", "/email/base/link_account/link_account_terms",
            map(couple(SODEXO, "/email/site/sodexo/link_account/link_account_terms"))
    ),
    BULK_TOP_UP("bulk_top_up", "/email/site/sodexo/sodexo_bulk_top_up",
            map(couple(SODEXO, "/email/site/sodexo/sodexo_bulk_top_up"))
    ),

    GETSBY_ACTIVATION("getsby_activation", "/email/site/getsby/getsby_activation"),
    GETSBY_CREATE_GREEN("getsby_create_green", "/email/site/getsby/getsby_create_green"),
    GETSBY_CREATE_BLACK("getsby_create_black", "/email/site/getsby/getsby_create_black"),

    SODEXO_GIFT("sodexo_gift", "/email/site/sodexo/sodexo_gift"),
    SODEXO_PREMIUM("sodexo_premium", "/email/site/sodexo/sodexo_premium"),
    SODEXO_MEAL_VOUCHER("sodexo_meal_voucher", "/email/site/sodexo/sodexo_meal_voucher"),
    SODEXO_CLASSIC("sodexo_classic", "/email/site/sodexo/xmas/gift_xmas_classic"),
    SODEXO_SANTA("sodexo_santa", "/email/site/sodexo/xmas/gift_xmas_santa_claus"),
    SODEXO_WINTER("sodexo_winter", "/email/site/sodexo/xmas/gift_xmas_winter"),

    NOT_IMPLEMENTED("not_implemented", "/email/base/notImplemented");

    public static Map<String, EmailType> getMap() {
        return EMAIL_TYPE_MAP;
    }

    private static Map<String, EmailType> EMAIL_TYPE_MAP;

    private Map<Site, String> mapOfOtherTemplates = null;

    static {
        EMAIL_TYPE_MAP = new HashMap<>(values().length);
        for (EmailType emailType : values()) {
            EMAIL_TYPE_MAP.put(emailType.getName(), emailType);
        }
    }

    private String name;
    private String defaultPathToTemplate;

    private EmailType(String name, String pathToTemplate) {
        this.name = name;
        this.defaultPathToTemplate = pathToTemplate;
    }

    private EmailType(String name, String pathToTemplate, Map<Site, String> mapOfOtherTemplates) {
        this.name = name;
        this.defaultPathToTemplate = pathToTemplate;
        this.mapOfOtherTemplates = mapOfOtherTemplates;
    }

    public String getName() {
        return name;
    }

    public String getPathToTemplate(Site site) {
        if (mapOfOtherTemplates != null && site != null && mapOfOtherTemplates.containsKey(site)) {
            return mapOfOtherTemplates.get(site);
        }
        return defaultPathToTemplate;
    }

    public static EmailType getEmailTypeByName(String name) {
        EmailType emailType = EMAIL_TYPE_MAP.get(name);
        if (emailType == null) {
            emailType = NOT_IMPLEMENTED;
        }
        return emailType;
    }

    private static TPC couple(Site site, String pathToTemplate) {
        return new TPC(site, pathToTemplate);
    }

    private static Map<Site, String> map(TPC ...pathes) {
        int size = pathes.length;
        Map<Site, String> map = new HashMap<>(size);
        for (TPC paths : pathes) {
            map.put(paths.getSite(), paths.getPathToTemplate());
        }
        return Collections.unmodifiableMap(map);
    }

    private static class TPC {

        private Site site;
        private String pathToTemplate;

        public TPC(Site site, String pathToTemplate) {
            this.site = site;
            this.pathToTemplate = pathToTemplate;
        }

        public Site getSite() {
            return site;
        }

        public void setSite(Site site) {
            this.site = site;
        }

        public String getPathToTemplate() {
            return pathToTemplate;
        }

        public void setPathToTemplate(String pathToTemplate) {
            this.pathToTemplate = pathToTemplate;
        }

    }

}
