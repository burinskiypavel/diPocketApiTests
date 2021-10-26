package com.cs.dipocketback.pojo.references;

import com.cs.dipocketback.pojo.references.params.AppParams;

public class AppConfig {

    private String versionColor;
    private String countryHash;
    private String langHash;
    private String topCountriesHash;
    private AppParams appParams;
    private String queryValidator;

    public AppConfig() {
    }

    public AppConfig(String versionColor,
                     String countryHash,
                     String langHash,
                     String topCountriesHash,
                     AppParams appParams) {
        this.versionColor = versionColor;
        this.countryHash = countryHash;
        this.langHash = langHash;
        this.appParams = appParams;
        this.topCountriesHash = topCountriesHash;
    }

    public void setVersionColor(String versionColor) {
        this.versionColor = versionColor;
    }

    public String getVersionColor() {
        return versionColor;
    }

    public void setCountryHash(String countryHash) {
        this.countryHash = countryHash;
    }

    public String getCountryHash() {
        return countryHash;
    }

    public void setLangHash(String langHash) {
        this.langHash = langHash;
    }

    public String getLangHash() {
        return langHash;
    }

    public void setTopCountriesHash(String topCountriesHash) {
        this.topCountriesHash = topCountriesHash;
    }

    public String getTopCountriesHash() {
        return topCountriesHash;
    }

    public void setAppParams(AppParams appParams) {
        this.appParams = appParams;
    }

    public AppParams getAppParams() {
        return appParams;
    }

    public void setQueryValidator(String queryValidator) {
        this.queryValidator = queryValidator;
    }

    public String getQueryValidator() {
        return queryValidator;
    }
}
