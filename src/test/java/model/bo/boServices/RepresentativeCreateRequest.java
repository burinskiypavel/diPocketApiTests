package model.bo.boServices;

public class RepresentativeCreateRequest {
    private String corpClientId;
    private String firstName;
    private String lastName;
    private String cardholderName;
    private String birthDate;
    private String phoneNumber;
    private String email;
    private String ddStatus;
    private int currencyId;
    private int langId;
    private long identifyCode;
    private int citizenshipCountryId;
    private int residenceCountryId;
    private String streetLine1;
    private String streetLine2;
    private String city;
    private long zip;

    public String getCorpClientId() {
        return corpClientId;
    }

    public void setCorpClientId(String corpClientId) {
        this.corpClientId = corpClientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDdStatus() {
        return ddStatus;
    }

    public void setDdStatus(String ddStatus) {
        this.ddStatus = ddStatus;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    public long getIdentifyCode() {
        return identifyCode;
    }

    public void setIdentifyCode(long identifyCode) {
        this.identifyCode = identifyCode;
    }

    public int getCitizenshipCountryId() {
        return citizenshipCountryId;
    }

    public void setCitizenshipCountryId(int citizenshipCountryId) {
        this.citizenshipCountryId = citizenshipCountryId;
    }

    public int getResidenceCountryId() {
        return residenceCountryId;
    }

    public void setResidenceCountryId(int residenceCountryId) {
        this.residenceCountryId = residenceCountryId;
    }

    public String getStreetLine1() {
        return streetLine1;
    }

    public void setStreetLine1(String streetLine1) {
        this.streetLine1 = streetLine1;
    }

    public String getStreetLine2() {
        return streetLine2;
    }

    public void setStreetLine2(String streetLine2) {
        this.streetLine2 = streetLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }
}