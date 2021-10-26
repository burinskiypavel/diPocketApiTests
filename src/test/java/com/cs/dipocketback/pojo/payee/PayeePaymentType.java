package com.cs.dipocketback.pojo.payee;

public class PayeePaymentType {

    public static enum PayeeCountry {

        UNITED_KINGDOM(826, "GB"),
        POLAND(616, "PL"),
        HUNGARY(348, "HU");

        private Integer id;
        private String code;

        PayeeCountry(Integer id, String code) {
            this.id = id;
            this.code = code;
        }

        public Integer getId() {
            return id;
        }

        public String getCode() {
            return code;
        }
    }

    public static enum PayeeCurrency {
        PLN(985),
        GBP(826),
        HUF(348),
        EUR(978);

        private Integer currencyId;

        PayeeCurrency(Integer currencyId) {
            this.currencyId = currencyId;
        }

        public Integer getCurrencyId() {
            return currencyId;
        }
    }
    
    private PaymentType type;
    private String name;
    private String defaultCcy;
    private Integer defaultCcyId;
    private String defaultCountry;
    private Integer defaultCountryId;
    private Boolean currencyEditable;
    private Boolean countryEditable;
    
    public PayeePaymentType() {
    }

    public PayeePaymentType(PaymentType type, String name) {
        this.type = type;
        this.name = name;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }

    public PaymentType getType() {
        return type;
    }

    public void setDefaultCcy(String defaultCcy) {
        this.defaultCcy = defaultCcy;
    }

    public String getDefaultCcy() {
        return defaultCcy;
    }

    public void setDefaultCountry(String defaultCountry) {
        this.defaultCountry = defaultCountry;
    }

    public String getDefaultCountry() {
        return defaultCountry;
    }

    public void setCurrencyEditable(Boolean currencyEditable) {
        this.currencyEditable = currencyEditable;
    }

    public Boolean getCurrencyEditable() {
        return currencyEditable;
    }

    public void setCountryEditable(Boolean countryEditable) {
        this.countryEditable = countryEditable;
    }

    public Boolean getCountryEditable() {
        return countryEditable;
    }

    public void setDefaultCcyId(Integer defaultCcyId) {
        this.defaultCcyId = defaultCcyId;
    }

    public Integer getDefaultCcyId() {
        return defaultCcyId;
    }

    public void setDefaultCountryId(Integer defaultCountryId) {
        this.defaultCountryId = defaultCountryId;
    }

    public Integer getDefaultCountryId() {
        return defaultCountryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
