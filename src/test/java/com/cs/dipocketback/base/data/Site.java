package com.cs.dipocketback.base.data;

import appmanager.Language;
import com.cs.dipocketback.constants.TextConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static com.cs.dipocketback.base.data.EmailSessionProperties.*;
import static appmanager.Language.*;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public enum Site {

    //                      phone   bundle                  android hash   isFest  !has  has     supported language    Email Session  Has push
    //                      prefix  path                    for sms                SA    invite  first is default      Properties
    DIPOCKET                ("",    "dipocket",             "xKe4MT3FQGG",  null,  null,  null,  arr(EN, PL, RU, UK),  DIPOCKET_SMTP, TRUE), //APIUSER Y+Cy8a8UKy6
    DIPOCKET_FROM_FESTIVAL  ("",    "dipocketFromFestival", null,           null,  null,  null,  arr(EN, PL, RU, UK),  DIPOCKET_SMTP, FALSE),
    BACCA                   ("2_",  "bacca",                null,           null,  null,  null,  arr(PL, EN, RU, UK),  DIPOCKET_SMTP, TRUE),
    PZT                     ("3_",  "pzt",                  null,           null,  null,  null,  arr(PL, EN, RU, UK),  DIPOCKET_SMTP, TRUE),
    FESTIVAL                ("4_",  "festival",             null,           TRUE,  TRUE,  null,  arr(EN, PL, HU),      DIPOCKET_SMTP, FALSE),
    TELENOR                 ("5_",  "telenor",              null,           TRUE,  null,  null,  arr(HU, EN),          DIPOCKET_SMTP, FALSE),
    FESTIVAL_HUF            ("6_",  "festival",             null,           TRUE,  TRUE,  null,  arr(HU, EN, PL),      DIPOCKET_SMTP, FALSE),
    CREDISSIMO              ("7_",  "credissimo",           null,           TRUE,  TRUE,  null,  arr(BG, EN),          DIPOCKET_SMTP, FALSE),
    EFFIE                   ("8_",  "festival",             null,           TRUE,  TRUE,  null,  arr(EN, PL, HU),      DIPOCKET_SMTP, FALSE),
    PLAYIT                  ("9_",  "playit",               "6wlNiuz39/R",  TRUE,  TRUE,  TRUE,  arr(HU, EN),          DIPOCKET_SMTP, TRUE), // "ZWIwOTRkOGF" //android hash for sms
    UPANDGO                 ("10_", "upandgo",              "We8l+mM9Y4a",  TRUE,  TRUE,  TRUE,  arr(PL, EN, RU, UK),  UPANDGO_SMTP,  TRUE),
    SNOW_ATTACK             ("11_", "snowattack",           null,           TRUE,  TRUE,  null,  arr(EN, PL, HU),      DIPOCKET_SMTP, FALSE),
    DISCONTU                ("12_", "discontu",             "X6JqPe4AZaD",  TRUE,  TRUE,  TRUE,  arr(PL, EN),          DIPOCKET_SMTP, TRUE),
    BILLON                  (null,  "dipocket",             null,           FALSE, FALSE, FALSE, arr(EN),              DIPOCKET_SMTP, FALSE),
    NEXO                    (null,  "dipocket",             null,           FALSE, FALSE, FALSE, arr(EN),              DIPOCKET_SMTP, FALSE),
    FESTIVAL_NL             ("14_", "festival_nl",          null,           TRUE,  TRUE,  null,  arr(EN, NL),          DIPOCKET_SMTP, FALSE),
    BPLUSCLUB               ("15_", "bplusclub",            null,           TRUE,  TRUE,  null,  arr(EN, HU),          DIPOCKET_SMTP, FALSE),
    PUSKASARENA             ("16_", "puskasarena",          null,           TRUE,  TRUE,  null,  arr(EN, HU),          DIPOCKET_SMTP, FALSE),
    PEAK                    (null,  "dipocket",             null,           FALSE, FALSE, FALSE, arr(EN),              DIPOCKET_SMTP, FALSE),
    PEAKVISA                (null,  "dipocket",             null,           FALSE, FALSE, FALSE, arr(EN),              DIPOCKET_SMTP, FALSE),
    AIQLABS                 (null,  "dipocket",             null,           FALSE, FALSE, FALSE, arr(EN),              DIPOCKET_SMTP, FALSE),
    TWINO                   (null,  "dipocket",             null,           FALSE, FALSE, FALSE, arr(EN),              DIPOCKET_SMTP, FALSE),
    SODEXO                  ("17_", "sodexo",               null,           TRUE,  TRUE,  null,  arr(EN, PL),          SODEXO_SMTP,   FALSE),
    PROVEMA                 (null,  "dipocket",             null,           FALSE, FALSE, FALSE, arr(EN),              DIPOCKET_SMTP, FALSE),
    GETSBY                  ("18_", "getsby",               null,           TRUE,  TRUE,  null,  arr(EN, NL),          DIPOCKET_SMTP, FALSE),
    SIRO                    (null,  "siro",                 null,           FALSE, TRUE,  FALSE, arr(EN, RO),          DIPOCKET_SMTP, FALSE),
    AWAS                    (null,  "awas",                 null,           FALSE, TRUE,  FALSE, arr(EN),              DIPOCKET_SMTP, FALSE),
    INTERTICKET             (null,  "dipocket",             null,           FALSE, TRUE,  FALSE, arr(EN),              DIPOCKET_SMTP, FALSE),
    REVO                    (null,  "dipocket",             null,           FALSE, TRUE,  FALSE, arr(EN),              DIPOCKET_SMTP, FALSE),
    CM                      ("19_", "festival",             null,           TRUE,  TRUE,  FALSE, arr(EN, NL),          DIPOCKET_SMTP, FALSE),
    GETSBYCARD              ("20_", "dipocket",             null,           TRUE,  TRUE,  FALSE, arr(EN, NL),          DIPOCKET_SMTP, FALSE),
    SODEXO_BG               ("21_", "sodexo",               null,           TRUE,  TRUE,  null,  arr(EN, BG),          SODEXO_SMTP,   FALSE);

    private static final Logger LOGGER = LoggerFactory.getLogger(Site.class);

    public static final Map<String, Site> SITES;
    public static final Map<String, Site> SITES_BY_PHONE_PREFIX;
    static {
        Map<String, Site> sites = new HashMap<>(values().length);
        Map<String, Site> sitesByPhonePrefix = new HashMap<>(values().length);
        LOGGER.info("Sites:");
        for (Site site : values()) {
            LOGGER.info("\t{}", site);
            sites.put(site.name(), site);
            if (site.getPhonePrefix() != null) {
                sitesByPhonePrefix.put(site.getPhonePrefix(), site);
            } else {
                sitesByPhonePrefix.put(TextConstants.EMPTY_STRING, DIPOCKET);
            }

        }
        SITES = Collections.unmodifiableMap(sites);
        SITES_BY_PHONE_PREFIX = Collections.unmodifiableMap(sitesByPhonePrefix);
    }

    private String phonePrefix;
    private String bundlePath;
    private String androidHashForSms;
    private boolean isFestival;
    private boolean isSiteWithoutSecretAnswer;
    private boolean supportsInvitation;
    private List<Language> supportedLanguages;
    private EmailSessionProperties emailSessionProperties;
    private boolean hasPush;

    private Site(String phonePrefix,
                 String bundlePath,
                 String androidHashForSms,
                 Boolean isFestival,
                 Boolean isSiteWithoutSecretAnswer,
                 Boolean supportsInvitation,
                 List<Language> supportedLanguages,
                 EmailSessionProperties emailSessionProperties,
                 boolean hasPush) {
        this.phonePrefix = phonePrefix;
        this.bundlePath = bundlePath;
        this.androidHashForSms = androidHashForSms;
        this.isFestival = isFestival == null ? false : isFestival;
        this.isSiteWithoutSecretAnswer = isSiteWithoutSecretAnswer == null ? false : isSiteWithoutSecretAnswer;
        this.supportsInvitation = supportsInvitation == null ? false : supportsInvitation;
        this.supportedLanguages = supportedLanguages;
        this.emailSessionProperties = emailSessionProperties;
        this.hasPush = hasPush;
    }

    //public static String getPathForSite(String siteName) {
      //  return getSiteByName(siteName).getBundlePath();
   // }

    public static Site getSiteByName(String siteName) {
        Site site = DIPOCKET;

        if (siteName != null) {
            siteName = siteName.toUpperCase();
        } else {
            return site;
        }

        if (SITES.containsKey(siteName)) {
            site = SITES.get(siteName);
        }
        return site;
    }

//    public static Site getSiteByNameOrNull(String siteName) {
//        Site site = null;
//
//        if (siteName != null) {
//            siteName = siteName.toUpperCase();
//        } else {
//            return site;
//        }
//
//        if (SITES.containsKey(siteName)) {
//            site = SITES.get(siteName);
//        }
//        return site;
//    }

//    public static Site getSiteByOriginalLogin(String originalLogin) {
//        if (originalLogin.contains(TextConstants.UNDERLINE)) {
//            int end = originalLogin.indexOf(TextConstants.UNDERLINE) + 1;
//            String sitePrefix = originalLogin.substring(0, end);
//            LOGGER.info("getSiteByOriginalLogin. site prefix: {}", sitePrefix);
//            return SITES_BY_PHONE_PREFIX.get(sitePrefix);
//        } else {
//            return DIPOCKET;
//        }
//    }

    public boolean isFestivalSite() {
        return isFestival;
    }

    public String getPhonePrefix() {
        return phonePrefix;
    }

    public String getBundlePath() {
        return bundlePath;
    }

    public String getAndroidHashForSms() {
        return androidHashForSms;
    }

    public boolean isSiteWithoutSecretAnswer() {
        return isSiteWithoutSecretAnswer;
    }

    public boolean supportsInvitation() {
        return supportsInvitation;
    }

    public List<Language> getSupportedLanguages() {
        return supportedLanguages;
    }

    public Language getDefaultLanguage() {
        return supportedLanguages.get(0);
    }

    public EmailSessionProperties getEmailSessionProperties() {
        return emailSessionProperties;
    }

    public boolean isHasPush() {
        return hasPush;
    }

    @Override
    public String toString() {
        return name();
    }

    private static List<Language> arr(Language ...langs) {
        int size = langs.length;
        List<Language> tmpList = new ArrayList<>(size);
        for (Language lang : langs) {
            tmpList.add(lang);
        }
        return Collections.unmodifiableList(tmpList);
    }

    public static void main(String[] args) {
        System.out.println(FESTIVAL.isFestivalSite());
        System.out.println(DIPOCKET.isFestivalSite());
        System.out.println(FESTIVAL.isSiteWithoutSecretAnswer);
        System.out.println(DIPOCKET.isSiteWithoutSecretAnswer());
        System.out.println(DIPOCKET.equals(DIPOCKET));
        System.out.println(DIPOCKET.equals(FESTIVAL));
    }

}
