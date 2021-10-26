package com.cs.dipocketback.pojo.customer;

import java.util.HashMap;
import java.util.Map;

public class CardCreateResponse {

    public static enum CardCreateResponseField {

        TOKEN("token"),
        ACCOUNT_ID("accountId"),
        PAN("pan"),
        EXP_DATE("expDate"),
        CVV("cvv"),
        ALL("*"),
        UNDEFINED(null);

        private static Map<String, CardCreateResponseField> map = new HashMap<>(CardCreateResponseField.values().length);

        static {
            for (CardCreateResponseField cardCreateResponseField : values()) {
                map.put(
                        cardCreateResponseField.name,
                        cardCreateResponseField
                );
            }
        }

        private final String name;

        CardCreateResponseField(String name) {
            this.name = name;
        }

        public static CardCreateResponseField getByName(String name) {
            CardCreateResponseField cardCreateResponseField = map.get(name);
            if (cardCreateResponseField != null) {
                return cardCreateResponseField;
            } else {
                return UNDEFINED;
            }
        }

    }

    private Long powId;
    private String token;
    private String pan;
    private String expDate; //MM/YY
    private String cvv;
    private Long accountId;
    
    public CardCreateResponse() {
    }

    public CardCreateResponse(Long powId, String token, Long accountId) {
        this.powId = powId;
        this.token = token;
        this.accountId = accountId;
    }

    public CardCreateResponse(String token, String pan, String expDate, String cvv, Long accountId) {
        this.token = token;
        this.pan = pan;
        this.expDate = expDate;
        this.cvv = cvv;
        this.accountId = accountId;
    }

    public Long receivePowId() {
        return powId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPan() {
        return pan;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCvv() {
        return cvv;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

}
