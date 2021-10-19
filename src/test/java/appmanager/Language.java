package appmanager;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public enum Language {

    EN("ENGLISH",    1, "en"),
    UK("UKRAINIAN",  2, "uk"),
    PL("POLISH",     3, "pl"),
    RU("RUSSIAN",    4, "ru"),
    HU("HUNGARIAN",  5, "hu"),
    BG("BULGARIAN",  6, "bg"),
    NL("DUTCH",      7, "nl"),
    RO("ROMANIAN",   8, "ro");
    
    private static final Map<Integer, Language> LANGS;
    private static final Map<String, Language> LANGS_BY_ISO_639_6;
    
    static {
        LANGS = new HashMap<>(values().length);
        LANGS_BY_ISO_639_6 = new HashMap<>(values().length);
        for (Language lang : values()) {
            LANGS.put(lang.getOurId(), lang);
            LANGS_BY_ISO_639_6.put(lang.getIso639(), lang);
        }
    }
    
    private String langName;
    private int ourId;
    private String iso_639_6;
    
    private Language(String langName, int ourId, String iso_639_6) {
        this.langName = langName;
        this.ourId = ourId;
        this.iso_639_6 = iso_639_6;
    }
    
    public static String getLocaleName(Integer ourLangId) {
        if (LANGS.containsKey(ourLangId)) {
            return LANGS.get(ourLangId).getIso639();
        }
        return EN.getIso639();
    }
    
    public static Language getLangById(Integer ourLangId) {
        if (LANGS.containsKey(ourLangId)) {
            return LANGS.get(ourLangId);
        }
        return EN;
    }

    public static Language getLangByIsoCode(String iso639) {
        if (LANGS_BY_ISO_639_6.containsKey(iso639)) {
            return LANGS_BY_ISO_639_6.get(iso639);
        }
        return EN;
    }
    
    public static Locale getLocaleByLangId(Integer ourLangId) {
        Language language = getLangById(ourLangId);
        return new Locale(language.getIso639());
    }
    
    public Locale getLocale() {
        return new Locale(iso_639_6);
    }

    public String getLangName() {
        return langName;
    }

    public int getOurId() {
        return ourId;
    }

    public String getOurIdS() {
        return String.valueOf(ourId);
    }
    
    public String getIso639() {
        return iso_639_6;
    }

}
