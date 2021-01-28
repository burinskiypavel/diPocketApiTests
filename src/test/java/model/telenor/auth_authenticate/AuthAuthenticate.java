
package model.telenor.auth_authenticate;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthAuthenticate {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("clientFirstName")
    @Expose
    private String clientFirstName;
    @SerializedName("clientLastName")
    @Expose
    private String clientLastName;
    @SerializedName("presentedLogin")
    @Expose
    private String presentedLogin;
    @SerializedName("countryId")
    @Expose
    private Integer countryId;
    @SerializedName("residenceCountryId")
    @Expose
    private Integer residenceCountryId;
    @SerializedName("langId")
    @Expose
    private Integer langId;
    @SerializedName("mainPhone")
    @Expose
    private String mainPhone;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("emailIsVerified")
    @Expose
    private Boolean emailIsVerified;
    @SerializedName("currencyId")
    @Expose
    private Integer currencyId;
    @SerializedName("secQuestion")
    @Expose
    private String secQuestion;
    @SerializedName("secAnswerAttemptCnt")
    @Expose
    private Integer secAnswerAttemptCnt;
    @SerializedName("stateId")
    @Expose
    private Integer stateId;
    @SerializedName("addDocsAvail")
    @Expose
    private Boolean addDocsAvail;
    @SerializedName("ccyCode")
    @Expose
    private String ccyCode;
    @SerializedName("addresses")
    @Expose
    private List<Address> addresses = null;
    @SerializedName("birthDate")
    @Expose
    private String birthDate;
    @SerializedName("birthDateAsDate")
    @Expose
    private String birthDateAsDate;
    @SerializedName("ddStatus")
    @Expose
    private String ddStatus;
    @SerializedName("cardholderName")
    @Expose
    private String cardholderName;
    @SerializedName("registeredAddrAsmail")
    @Expose
    private Boolean registeredAddrAsmail;
    @SerializedName("clientIsNew")
    @Expose
    private Boolean clientIsNew;
    @SerializedName("cardholderNameState")
    @Expose
    private String cardholderNameState;
    @SerializedName("imagesStatus")
    @Expose
    private List<Imagesstatus> imagesStatus = null;
    @SerializedName("site")
    @Expose
    private String site;
    @SerializedName("siteEnum")
    @Expose
    private String siteEnum;
    @SerializedName("regAddress")
    @Expose
    private RegAddress regAddress;
    @SerializedName("mailAddress")
    @Expose
    private MailAddress mailAddress;
    @SerializedName("isStrongPassword")
    @Expose
    private Boolean isStrongPassword;
    @SerializedName("clientType")
    @Expose
    private String clientType;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("clientBlocked")
    @Expose
    private Boolean clientBlocked;
    @SerializedName("clientBanned")
    @Expose
    private Boolean clientBanned;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getResidenceCountryId() {
        return residenceCountryId;
    }

    public void setResidenceCountryId(Integer residenceCountryId) {
        this.residenceCountryId = residenceCountryId;
    }

    public Integer getLangId() {
        return langId;
    }

    public void setLangId(Integer langId) {
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

    public Boolean getEmailIsVerified() {
        return emailIsVerified;
    }

    public void setEmailIsVerified(Boolean emailIsVerified) {
        this.emailIsVerified = emailIsVerified;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public String getSecQuestion() {
        return secQuestion;
    }

    public void setSecQuestion(String secQuestion) {
        this.secQuestion = secQuestion;
    }

    public Integer getSecAnswerAttemptCnt() {
        return secAnswerAttemptCnt;
    }

    public void setSecAnswerAttemptCnt(Integer secAnswerAttemptCnt) {
        this.secAnswerAttemptCnt = secAnswerAttemptCnt;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Boolean getAddDocsAvail() {
        return addDocsAvail;
    }

    public void setAddDocsAvail(Boolean addDocsAvail) {
        this.addDocsAvail = addDocsAvail;
    }

    public String getCcyCode() {
        return ccyCode;
    }

    public void setCcyCode(String ccyCode) {
        this.ccyCode = ccyCode;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
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

    public Boolean getRegisteredAddrAsmail() {
        return registeredAddrAsmail;
    }

    public void setRegisteredAddrAsmail(Boolean registeredAddrAsmail) {
        this.registeredAddrAsmail = registeredAddrAsmail;
    }

    public Boolean getClientIsNew() {
        return clientIsNew;
    }

    public void setClientIsNew(Boolean clientIsNew) {
        this.clientIsNew = clientIsNew;
    }

    public String getCardholderNameState() {
        return cardholderNameState;
    }

    public void setCardholderNameState(String cardholderNameState) {
        this.cardholderNameState = cardholderNameState;
    }

    public List<Imagesstatus> getImagesStatus() {
        return imagesStatus;
    }

    public void setImagesStatus(List<Imagesstatus> imagesStatus) {
        this.imagesStatus = imagesStatus;
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

    public RegAddress getRegAddress() {
        return regAddress;
    }

    public void setRegAddress(RegAddress regAddress) {
        this.regAddress = regAddress;
    }

    public MailAddress getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(MailAddress mailAddress) {
        this.mailAddress = mailAddress;
    }

    public Boolean getIsStrongPassword() {
        return isStrongPassword;
    }

    public void setIsStrongPassword(Boolean isStrongPassword) {
        this.isStrongPassword = isStrongPassword;
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

    public Boolean getClientBlocked() {
        return clientBlocked;
    }

    public void setClientBlocked(Boolean clientBlocked) {
        this.clientBlocked = clientBlocked;
    }

    public Boolean getClientBanned() {
        return clientBanned;
    }

    public void setClientBanned(Boolean clientBanned) {
        this.clientBanned = clientBanned;
    }

}
