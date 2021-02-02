package model.telenor.login.clientInfo;

public class ClientInfo {
    private int id;
    private  String clientFirstName;
    private  String clientLastName;
    private  String presentedLogin;
    private  int countryId;
    private  int residenceCountryId;
    private  int langId;
    private  String mainPhone;
    private  String email;
    private  boolean emailIsVerified;
    private  int currencyId;
    private  String secQuestion;
    private  int secAnswerAttemptCnt;
    private  int stateId;
    private  boolean addDocsAvail;
    private  String ccyCode;
    private  String birthDate;
    private  String birthDateAsDate;
    private  String ddStatus;
    private  String cardholderName;
    private  boolean registeredAddrAsmail;
    private  String cardholderNameState;
    private  String site;
    private String siteEnum;
    private boolean isStrongPassword;
    private String clientType;
    private String fullName;
    private boolean clientBlocked;
    private boolean clientBanned;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getPresentedLogin() {
        return presentedLogin;
    }

    public void setPresentedLogin(String presentedLogin) {
        this.presentedLogin = presentedLogin;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getResidenceCountryId() {
        return residenceCountryId;
    }

    public void setResidenceCountryId(int residenceCountryId) {
        this.residenceCountryId = residenceCountryId;
    }

    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    public String getMainPhone() {
        return mainPhone;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailIsVerified() {
        return emailIsVerified;
    }

    public void setEmailIsVerified(boolean emailIsVerified) {
        this.emailIsVerified = emailIsVerified;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public String getSecQuestion() {
        return secQuestion;
    }

    public void setSecQuestion(String secQuestion) {
        this.secQuestion = secQuestion;
    }

    public int getSecAnswerAttemptCnt() {
        return secAnswerAttemptCnt;
    }

    public void setSecAnswerAttemptCnt(int secAnswerAttemptCnt) {
        this.secAnswerAttemptCnt = secAnswerAttemptCnt;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public boolean isAddDocsAvail() {
        return addDocsAvail;
    }

    public void setAddDocsAvail(boolean addDocsAvail) {
        this.addDocsAvail = addDocsAvail;
    }

    public String getCcyCode() {
        return ccyCode;
    }

    public void setCcyCode(String ccyCode) {
        this.ccyCode = ccyCode;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDateAsDate() {
        return birthDateAsDate;
    }

    public void setBirthDateAsDate(String birthDateAsDate) {
        this.birthDateAsDate = birthDateAsDate;
    }

    public String getDdStatus() {
        return ddStatus;
    }

    public void setDdStatus(String ddStatus) {
        this.ddStatus = ddStatus;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public boolean isRegisteredAddrAsmail() {
        return registeredAddrAsmail;
    }

    public void setRegisteredAddrAsmail(boolean registeredAddrAsmail) {
        this.registeredAddrAsmail = registeredAddrAsmail;
    }

    public String getCardholderNameState() {
        return cardholderNameState;
    }

    public void setCardholderNameState(String cardholderNameState) {
        this.cardholderNameState = cardholderNameState;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSiteEnum() {
        return siteEnum;
    }

    public void setSiteEnum(String siteEnum) {
        this.siteEnum = siteEnum;
    }

    public boolean isStrongPassword() {
        return isStrongPassword;
    }

    public void setStrongPassword(boolean strongPassword) {
        isStrongPassword = strongPassword;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isClientBlocked() {
        return clientBlocked;
    }

    public void setClientBlocked(boolean clientBlocked) {
        this.clientBlocked = clientBlocked;
    }

    public boolean isClientBanned() {
        return clientBanned;
    }

    public void setClientBanned(boolean clientBanned) {
        this.clientBanned = clientBanned;
    }
}
