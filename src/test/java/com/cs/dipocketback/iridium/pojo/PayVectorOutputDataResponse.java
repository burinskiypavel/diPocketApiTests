package com.cs.dipocketback.iridium.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayVectorOutputDataResponse {

    public enum PayVectorStatusResponse {
        SUCCESS(0),
        THREE_D_SECURE(3),
        DECLINED(5),
        DUPLICATE(20),
        ERROR(30);

        private static final Map<Integer, PayVectorStatusResponse> matrix;

        static {
            matrix = new HashMap<>(values().length);
            for (PayVectorStatusResponse eCardStatusResponse : values()) {
                matrix.put(eCardStatusResponse.code, eCardStatusResponse);
            }
        }

        private int code;

        PayVectorStatusResponse(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public static PayVectorStatusResponse valueOf(Integer value) {
            return matrix.get(value);
        }
    }

    private String paREQ;
    private String aCSURL;
    private String crossReference;
    private Integer statusCode;
    private List<String> errorMessages = new ArrayList<>();
    private Map<Integer, String> entryPoints = new HashMap<>();
    private String message;

    private Boolean need3DS;

    private Boolean authorisationAttempted;
    private String authCode;
    private String addressNumericCheckResult;
    private String threeDSecureAuthenticationCheckResult;
    private String postCodeCheckResult;
    private String cv2CheckResult;
    private String cardType;
    private String cardClass; //removed
    private String issuer;
    private Integer issuerISOCode;
    private Long amountReceived;

    public PayVectorOutputDataResponse() {
    }

    public void setPaREQ(String paREQ) {
        this.paREQ = paREQ;
    }

    public String getPaREQ() {
        return paREQ;
    }

    public void setACSURL(String aCSURL) {
        this.aCSURL = aCSURL;
    }

    public String getACSURL() {
        return aCSURL;
    }

    public void setCrossReference(String crossReference) {
        this.crossReference = crossReference;
    }

    public String getCrossReference() {
        return crossReference;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setAuthorisationAttempted(Boolean authorisationAttempted) {
        this.authorisationAttempted = authorisationAttempted;
    }

    public Boolean getAuthorisationAttempted() {
        return authorisationAttempted;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAddressNumericCheckResult(String addressNumericCheckResult) {
        this.addressNumericCheckResult = addressNumericCheckResult;
    }

    public String getAddressNumericCheckResult() {
        return addressNumericCheckResult;
    }

    public void setPostCodeCheckResult(String postCodeCheckResult) {
        this.postCodeCheckResult = postCodeCheckResult;
    }

    public String getPostCodeCheckResult() {
        return postCodeCheckResult;
    }

    public void setCv2CheckResult(String cv2CheckResult) {
        this.cv2CheckResult = cv2CheckResult;
    }

    public String getCv2CheckResult() {
        return cv2CheckResult;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardClass(String cardClass) {
        this.cardClass = cardClass;
    }

    public String getCardClass() {
        return cardClass;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuerISOCode(Integer issuerISOCode) {
        this.issuerISOCode = issuerISOCode;
    }

    public Integer getIssuerISOCode() {
        return issuerISOCode;
    }

    public void setAmountReceived(Long amountReceived) {
        this.amountReceived = amountReceived;
    }

    public Long getAmountReceived() {
        return amountReceived;
    }

    public void setNeed3DS(Boolean need3DS) {
        this.need3DS = need3DS;
    }

    public Boolean getNeed3DS() {
        return need3DS;
    }

    public void setEntryPoints(Map<Integer, String> entryPoints) {
        this.entryPoints = entryPoints;
    }

    public Map<Integer, String> getEntryPoints() {
        return entryPoints;
    }

    public void setThreeDSecureAuthenticationCheckResult(String threeDSecureAuthenticationCheckResult) {
        this.threeDSecureAuthenticationCheckResult = threeDSecureAuthenticationCheckResult;
    }

    public String getThreeDSecureAuthenticationCheckResult() {
        return threeDSecureAuthenticationCheckResult;
    }

    @Override
    public String toString() {
        return "PayVectorOutputDataResponse{" +
                "paREQ='" + paREQ + '\'' +
                ", aCSURL='" + aCSURL + '\'' +
                ", crossReference='" + crossReference + '\'' +
                ", statusCode=" + statusCode +
                ", errorMessages=" + errorMessages +
                ", entryPoints=" + entryPoints +
                ", message='" + message + '\'' +
                ", need3DS=" + need3DS +
                ", authorisationAttempted=" + authorisationAttempted +
                ", authCode='" + authCode + '\'' +
                ", addressNumericCheckResult='" + addressNumericCheckResult + '\'' +
                ", threeDSecureAuthenticationCheckResult='" + threeDSecureAuthenticationCheckResult + '\'' +
                ", postCodeCheckResult='" + postCodeCheckResult + '\'' +
                ", cv2CheckResult='" + cv2CheckResult + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardClass='" + cardClass + '\'' +
                ", issuer='" + issuer + '\'' +
                ", issuerISOCode=" + issuerISOCode +
                ", amountReceived=" + amountReceived +
                '}';
    }
}
