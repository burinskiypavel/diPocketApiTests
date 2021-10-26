package com.cs.dipocketback.pojo.customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//
public class CardInfoResponse {

    public static enum CardInfoResponseField {

        TOKEN("token"),
        PUBLIC_TOKEN("publicToken"),
        CARD_HOLDER_NAME("cardHolderName"),
        CLIENT_ID("clientId"),
        ACCOUNT_ID("accountId"),
        CURRENCY_CODE("currencyCode"),
        PAN("pan"),
        CARD_STATUS("cardStatus"),
        EXP_DATE("expDate"),
        CVV("cvv"),
        AVL_BALANCE("avlBalance"),
        FIN_BALANCE("finBalance"),
        PROGRAM("program"),
        ACC_FEE_TARIFF_PLAN_ID("accFeeTariffPlanId"),
        PAYMENT_TOKENS("paymentTokens"),
        CORP_CLIENT_ID("corpClientId"),
        ALL("*"),
        UNDEFINED(null);

        private static Map<String, CardInfoResponseField> map = new HashMap<>(CardInfoResponseField.values().length);

        static {
            for (CardInfoResponseField cardInfoResponseField : values()) {
                map.put(
                        cardInfoResponseField.name,
                        cardInfoResponseField
                );
            }
        }

        private final String name;

        CardInfoResponseField(String name) {
            this.name = name;
        }

        public static CardInfoResponseField getByName(String name) {
            CardInfoResponseField cardInfoResponseField = map.get(name);
            if (cardInfoResponseField != null) {
                return cardInfoResponseField;
            } else {
                return UNDEFINED;
            }
        }

    }

    private String token;
    private String publicToken;
    private String cardHolderName;
    private Long clientId;
    private Long accountId;
    private String currencyCode;
    private String pan;
    private String cardStatus;
    private String expDate;
    private String cvv;
    private Long avlBalance;
    private Long finBalance;
    private String program;
    private Long accFeeTariffPlanId;
    private List<CardPaymentToken> paymentTokens;
    private Long corpClientId;

    public CardInfoResponse() {
    }

    public CardInfoResponse(String token,
                            String publicToken,
                            Long clientId,
                            String cardHolderName,
                            Long accountId,
                            String currencyCode,
                            String cardStatus,
                            Long avlBalance,
                            Long finBalance,
                            String program,
                            List<CardPaymentToken> paymentTokens,
                            Long accFeeTariffPlanId,
                            Long corpClientId) {
        this.token = token;
        this.publicToken = publicToken;
        this.clientId = clientId;
        this.cardHolderName = cardHolderName;
        this.accountId = accountId;
        this.currencyCode = currencyCode;
        this.cardStatus = cardStatus;
        this.avlBalance = avlBalance;
        this.finBalance = finBalance;
        this.program = program;
        this.paymentTokens = paymentTokens;
        this.accFeeTariffPlanId = accFeeTariffPlanId;
        this.corpClientId = corpClientId;
    }

    public CardInfoResponse(String token,
                            Long clientId,
                            String cardHolderName,
                            Long accountId,
                            String currencyCode,
                            String pan,
                            String cardStatus,
                            String expDate,
                            String cvv,
                            Long avlBalance,
                            Long finBalance,
                            String program) {
        this.token = token;
        this.clientId = clientId;
        this.cardHolderName = cardHolderName;
        this.accountId = accountId;
        this.currencyCode = currencyCode;
        this.pan = pan;
        this.cardStatus = cardStatus;
        this.expDate = expDate;
        this.cvv = cvv;
        this.avlBalance = avlBalance;
        this.finBalance = finBalance;
        this.program = program;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPan() {
        return pan;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getCardStatus() {
        return cardStatus;
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

    public void setAvlBalance(Long avlBalance) {
        this.avlBalance = avlBalance;
    }

    public Long getAvlBalance() {
        return avlBalance;
    }

    public void setFinBalance(Long finBalance) {
        this.finBalance = finBalance;
    }

    public Long getFinBalance() {
        return finBalance;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getProgram() {
        return program;
    }

    public List<CardPaymentToken> getPaymentTokens() {
        return paymentTokens;
    }

    public void setPaymentTokens(List<CardPaymentToken> paymentTokens) {
        this.paymentTokens = paymentTokens;
    }

    public Long getAccFeeTariffPlanId() {
        return accFeeTariffPlanId;
    }

    public void setAccFeeTariffPlanId(Long accFeeTariffPlanId) {
        this.accFeeTariffPlanId = accFeeTariffPlanId;
    }

    public Long getCorpClientId() {
        return corpClientId;
    }

    public void setCorpClientId(Long corpClientId) {
        this.corpClientId = corpClientId;
    }
}
