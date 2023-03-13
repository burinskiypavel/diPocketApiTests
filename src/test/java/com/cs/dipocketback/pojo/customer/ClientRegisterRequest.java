package com.cs.dipocketback.pojo.customer;

//import com.fasterxml.jackson.annotation.JsonProperty;

////@JsonPropertyOrder(
//            {
//                "requestId",
//                "langCode",
//                "firstName",
//                "lastName",
//                "rStreetLine1",
//                "rStreetLine2",
//                "rCity",
//                "rState",
//                "rZip",
//                "rCountryCode",
//                "mStreetLine1",
//                "mStreetLine2",
//                "mCity",
//                "mState",
//                "mZip",
//                "mCountryCode",
//                "cardHolderName",
//                "email",
//                "mainPhone",
//                "dob",
//                "ddStatus",
//                "private Long feeTariffPlanId",
//                "currencyCode"
//            }
//        )
public class ClientRegisterRequest {
    
    private String requestId;
    private String langCode;
    private String firstName;
    private String lastName;
    //@JsonProperty(value = "rStreetLine1")
    private String rStreetLine1;
    //@JsonProperty(value = "rStreetLine2")
    private String rStreetLine2;
    //@JsonProperty(value = "rCity")
    private String rCity;
    //@JsonProperty(value = "rState")
    private String rState;
    //@JsonProperty(value = "rZip")
    private String rZip;
    //@JsonProperty(value = "rCountryCode")
    private String rCountryCode;
    //@JsonProperty(value = "mStreetLine1")
    private String mStreetLine1;
    //@JsonProperty(value = "mStreetLine2")
    private String mStreetLine2;
    //@JsonProperty(value = "mCity")
    private String mCity;
    //@JsonProperty(value = "mState")
    private String mState;
    //@JsonProperty(value = "mZip")
    private String mZip;
    //@JsonProperty(value = "mCountryCode")
    private String mCountryCode;
    private String citizenship;
    private String cardHolderName;
    private String email;
    private String mainPhone;
    private String dob; //YYYY-MM-DD
    private String ddStatus;
    private String currencyCode;
    private String supervisorId;
        
    public ClientRegisterRequest() {
    }

    public ClientRegisterRequest(String requestId, String langCode, String firstName, String lastName,
                                 String rStreetLine1, String rStreetLine2, String rCity, String rState, String rZip,
                                 String rCountryCode, String mStreetLine1, String mStreetLine2, String mCity,
                                 String mState, String mZip, String mCountryCode, String cardHolderName, String email,
                                 String mainPhone, String dob, String ddStatus, String currencyCode, String supervisorId) {
        this.requestId = requestId;
        this.langCode = langCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rStreetLine1 = rStreetLine1;
        this.rStreetLine2 = rStreetLine2;
        this.rCity = rCity;
        this.rState = rState;
        this.rZip = rZip;
        this.rCountryCode = rCountryCode;
        this.mStreetLine1 = mStreetLine1;
        this.mStreetLine2 = mStreetLine2;
        this.mCity = mCity;
        this.mState = mState;
        this.mZip = mZip;
        this.mCountryCode = mCountryCode;
        this.cardHolderName = cardHolderName;
        this.email = email;
        this.mainPhone = mainPhone;
        this.dob = dob;
        this.ddStatus = ddStatus;
        this.currencyCode = currencyCode;
        this.supervisorId = supervisorId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setRStreetLine1(String rStreetLine1) {
        this.rStreetLine1 = rStreetLine1;
    }

    public String getRStreetLine1() {
        return rStreetLine1;
    }

    public void setRStreetLine2(String rStreetLine2) {
        this.rStreetLine2 = rStreetLine2;
    }

    public String getRStreetLine2() {
        return rStreetLine2;
    }

    public void setRCity(String rCity) {
        this.rCity = rCity;
    }

    public String getRCity() {
        return rCity;
    }

    public void setRState(String rState) {
        this.rState = rState;
    }

    public String getRState() {
        return rState;
    }

    public void setRZip(String rZip) {
        this.rZip = rZip;
    }

    public String getRZip() {
        return rZip;
    }

    public void setRCountryCode(String rCountryCode) {
        this.rCountryCode = rCountryCode;
    }

    public String getRCountryCode() {
        return rCountryCode;
    }

    public void setMStreetLine1(String mStreetLine1) {
        this.mStreetLine1 = mStreetLine1;
    }

    public String getMStreetLine1() {
        return mStreetLine1;
    }

    public void setMStreetLine2(String mStreetLine2) {
        this.mStreetLine2 = mStreetLine2;
    }

    public String getMStreetLine2() {
        return mStreetLine2;
    }

    public void setMCity(String mCity) {
        this.mCity = mCity;
    }

    public String getMCity() {
        return mCity;
    }

    public void setMState(String mState) {
        this.mState = mState;
    }

    public String getMState() {
        return mState;
    }

    public void setMZip(String mZip) {
        this.mZip = mZip;
    }

    public String getMZip() {
        return mZip;
    }

    public void setMCountryCode(String mCountryCode) {
        this.mCountryCode = mCountryCode;
    }

    public String getMCountryCode() {
        return mCountryCode;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    public String getMainPhone() {
        return mainPhone;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDob() {
        return dob;
    }

    public void setDdStatus(String ddStatus) {
        this.ddStatus = ddStatus;
    }

    public String getDdStatus() {
        return ddStatus;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }
}
