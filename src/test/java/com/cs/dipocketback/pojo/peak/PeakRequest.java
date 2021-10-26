package com.cs.dipocketback.pojo.peak;

public class PeakRequest {
    
    private String requestId;
    private String lang;
    private String ddStatus;
    private Long feeTarifPlanId;
    private String program;
    private String firstName;
    private String lastName;
    private String dob;
    private String cardHolderName;
    private String companyName;
    private String email;
    private String mainPhone;
    private String idType;
    private String idNumber;
    private Integer currencyId;
    private String mCity;
    private Integer mCountryId;
    private String mStreetLine1;
    private String mStreetLine2;
    private String mZip;
    private String mState;
    private String rCity;
    private Integer rCountryId;
    private String rStreetLine1;
    private String rStreetLine2;
    private String rZip;
    private String rState;
    private String barCode;
    private String iban;
    private String cardType;
    
    //
    private Long powId;
    private Long cardId;
    private String publicToken;
    
    public PeakRequest() {
    }

    public PeakRequest(String requestId, String lang, String ddStatus, Long feeTarifPlanId, String program,
                            String firstName, String lastName, String dob, String cardHolderName, String companyName,
                            String email, String mainPhone, String idType, String idNumber, Integer currencyId,
                            String mCity, Integer mCountryId, String mStreetLine1, String mStreetLine2, String mZip,
                            String mState, String rCity, Integer rCountryId, String rStreetLine1, String rStreetLine2,
                            String rZip, String rState, String barCode, String iban, String cardType) {
        this.requestId = requestId;
        this.lang = lang;
        this.ddStatus = ddStatus;
        this.feeTarifPlanId = feeTarifPlanId;
        this.program = program;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.cardHolderName = cardHolderName;
        this.companyName = companyName;
        this.email = email;
        this.mainPhone = mainPhone;
        this.idType = idType;
        this.idNumber = idNumber;
        this.currencyId = currencyId;
        this.mCity = mCity;
        this.mCountryId = mCountryId;
        this.mStreetLine1 = mStreetLine1;
        this.mStreetLine2 = mStreetLine2;
        this.mZip = mZip;
        this.mState = mState;
        this.rCity = rCity;
        this.rCountryId = rCountryId;
        this.rStreetLine1 = rStreetLine1;
        this.rStreetLine2 = rStreetLine2;
        this.rZip = rZip;
        this.rState = rState;
        this.barCode = barCode;
        this.iban = iban;
        this.cardType = cardType;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }

    public void setDdStatus(String ddStatus) {
        this.ddStatus = ddStatus;
    }

    public String getDdStatus() {
        return ddStatus;
    }

    public void setFeeTarifPlanId(Long feeTarifPlanId) {
        this.feeTarifPlanId = feeTarifPlanId;
    }

    public Long getFeeTarifPlanId() {
        return feeTarifPlanId;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getProgram() {
        return program;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDob() {
        return dob;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
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

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setMCity(String mCity) {
        this.mCity = mCity;
    }

    public String getMCity() {
        return mCity;
    }

    public void setMCountryId(Integer mCountryId) {
        this.mCountryId = mCountryId;
    }

    public Integer getMCountryId() {
        return mCountryId;
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

    public void setMZip(String mZip) {
        this.mZip = mZip;
    }

    public String getMZip() {
        return mZip;
    }

    public void setMState(String mState) {
        this.mState = mState;
    }

    public String getMState() {
        return mState;
    }

    public void setRCity(String rCity) {
        this.rCity = rCity;
    }

    public String getRCity() {
        return rCity;
    }

    public void setRCountryId(Integer rCountryId) {
        this.rCountryId = rCountryId;
    }

    public Integer getRCountryId() {
        return rCountryId;
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

    public void setRZip(String rZip) {
        this.rZip = rZip;
    }

    public String getRZip() {
        return rZip;
    }

    public void setRState(String rState) {
        this.rState = rState;
    }

    public String getRState() {
        return rState;
    }

    public void setPowId(Long powId) {
        this.powId = powId;
    }

    public Long getPowId() {
        return powId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }

}
