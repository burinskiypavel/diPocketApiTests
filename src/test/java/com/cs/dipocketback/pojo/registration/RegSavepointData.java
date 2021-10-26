package com.cs.dipocketback.pojo.registration;

import com.cs.dipocketback.base.data.Site;
import com.cs.dipocketback.pojo.client.CheckboxContainer;
import com.cs.dipocketback.pojo.client.ClientAddress;

import java.util.ArrayList;
import java.util.List;

public class RegSavepointData {
    
    private Long id;
    private String deviceUUID;
    private Integer langId;
    private String firstName;
    private String lastName;
    private String mainPhone;
    private String email;
    private Integer countryId;
    private Integer currencyId;
    private String ccy;
    private String birthDate;
    private String birthDateAsDate;
    private Integer residenceCountryId;
    private String secQuestion;
    private String secAnswer;
    private String pin;
    private String confirmPin;
    private Integer stepNo;
    private Integer iIDAlerts;
    private Integer iidSpfMatches;
    private Integer iidSanMatches;
    private Integer iidIIDMatches;
    private Long gbgScore;
    private String gbgBandText;
    private String gbgAuthenticationID;
    private Boolean registeredAddrAsmail;
    private Boolean receiveAds;

    private ClientAddress address;
    private ClientAddress regAddress;
    private List<RegImageData> images;
    private String token;

    private String activationQRCode;  
    private String publicToken;
    private Boolean isInvited;
    
    private Boolean agreeAds;
    private Boolean agreeMail;
    private Boolean agreeTariffs;
    private Boolean agreeTerms;
    private Boolean agreeProcessInfo;
    
    private String supervisedPhone;
    
    // for zmotyvovani
    private List<AttachedCard> attachedCardsList = new ArrayList<>(1);
    
    private String site;
    private Site siteEnum;
    private String smsCode;
    private Boolean isSkipped;
    private String programNickName;
    //for webSite
    private String embeddedRedirectUrl;
    
    private List<CheckboxContainer> checkboxList;
    private Boolean isStrongPassword;

    public RegSavepointData() {
    }

    public RegSavepointData(String mainPhone, String email, String pin) {
        this.mainPhone = mainPhone;
        this.email = email;
        this.pin = pin;
    }

    public RegSavepointData(Long id, String deviceUUID, Integer langId, String firstName, String lastName, String mainPhone,
                            String email, Integer countryId, Integer currencyId, String birthDate,
                            Integer residenceCountryId, Integer stepNo, String secQuestion, String secAnswer,
                            String pin, ClientAddress address, ClientAddress regAddress, List<RegImageData> images,
                            Boolean registeredAddrAsmail, String activationQRCode, String publicToken, String site, Site siteEnum) {
        this.id = id;
        this.deviceUUID = deviceUUID;
        this.langId = langId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mainPhone = mainPhone;
        this.email = email;
        this.countryId = countryId;
        this.currencyId = currencyId;
        this.birthDate = birthDate;
        this.residenceCountryId = residenceCountryId;
        this.secQuestion = secQuestion;
        this.secAnswer = secAnswer;
        this.pin = pin;
        this.stepNo = stepNo;
        this.address = address;
        this.regAddress = regAddress;
        this.images = images;
        this.registeredAddrAsmail = registeredAddrAsmail;
        this.activationQRCode = activationQRCode;
        this.publicToken = publicToken;
        this.site = site;
        this.siteEnum = siteEnum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImages(List<RegImageData> images) {
        this.images = images;
    }

    public List<RegImageData> getImages() {
        return images;
    }

    public void setSecQuestion(String secQuestion) {
        this.secQuestion = secQuestion;
    }

    public String getSecQuestion() {
        return secQuestion;
    }

    public void setSecAnswer(String secAnswer) {
        this.secAnswer = secAnswer;
    }

    public String getSecAnswer() {
        return secAnswer;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public void setAddress(ClientAddress address) {
        this.address = address;
    }

    public ClientAddress getAddress() {
        return (address != null) ? address : new ClientAddress();
    }

    public void setDeviceUUID(String deviceUUID) {
        this.deviceUUID = deviceUUID;
    }

    public String getDeviceUUID() {
        return deviceUUID;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

    public Integer getLangId() {
        return langId;
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

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    public String getMainPhone() {
        return mainPhone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setResidenceCountryId(Integer residenceCountryId) {
        this.residenceCountryId = residenceCountryId;
    }

    public Integer getResidenceCountryId() {
        return residenceCountryId;
    }

    public void setStepNo(Integer stepNo) {
        this.stepNo = stepNo;
    }

    public Integer getStepNo() {
        return stepNo;
    }

    public void setIIDAlerts(Integer iIDAlerts) {
        this.iIDAlerts = iIDAlerts;
    }

    public Integer getIIDAlerts() {
        return iIDAlerts;
    }

    public void setIidSpfMatches(Integer iidSpfMatches) {
        this.iidSpfMatches = iidSpfMatches;
    }

    public Integer getIidSpfMatches() {
        return iidSpfMatches;
    }

    public void setIidSanMatches(Integer iidSanMatches) {
        this.iidSanMatches = iidSanMatches;
    }

    public Integer getIidSanMatches() {
        return iidSanMatches;
    }

    public void setIidIIDMatches(Integer iidIIDMatches) {
        this.iidIIDMatches = iidIIDMatches;
    }

    public Integer getIidIIDMatches() {
        return iidIIDMatches;
    }

    public void setGbgScore(Long gbgScore) {
        this.gbgScore = gbgScore;
    }

    public Long getGbgScore() {
        return gbgScore;
    }

    public void setGbgBandText(String gbgBandText) {
        this.gbgBandText = gbgBandText;
    }

    public String getGbgBandText() {
        return gbgBandText;
    }

    public void setGbgAuthenticationID(String gbgAuthenticationID) {
        this.gbgAuthenticationID = gbgAuthenticationID;
    }

    public String getGbgAuthenticationID() {
        return gbgAuthenticationID;
    }

    public void setRegAddress(ClientAddress regAddress) {
        this.regAddress = regAddress;
    }

    public ClientAddress getRegAddress() {
        return regAddress;
    }

    public void setRegisteredAddrAsmail(Boolean registeredAddrAsmail) {
        this.registeredAddrAsmail = registeredAddrAsmail;
    }

    public Boolean getRegisteredAddrAsmail() {
        return registeredAddrAsmail;
    }

    public void setBirthDateAsDate(String birthDateAsDate) {
        this.birthDateAsDate = birthDateAsDate;
    }

    public String getBirthDateAsDate() {
        return birthDateAsDate;
    }

    public void setReceiveAds(Boolean receiveAds) {
        this.receiveAds = receiveAds;
    }

    public Boolean getReceiveAds() {
        return receiveAds;
    }

    public void setActivationQRCode(String activationQRCode) {
        this.activationQRCode = activationQRCode;
    }

    public String getActivationQRCode() {
        return activationQRCode;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setIsInvited(Boolean isInvited) {
        this.isInvited = isInvited;
    }

    public Boolean getIsInvited() {
        return isInvited;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSite() {
        return site;
    }

    public void setSiteEnum(Site siteEnum) {
        this.siteEnum = siteEnum;
    }

    public Site getSiteEnum() {
        return siteEnum;
    }

    public void setAgreeAds(Boolean agreeAds) {
        this.agreeAds = agreeAds;
    }

    public Boolean getAgreeAds() {
        return agreeAds;
    }

    public void setAgreeMail(Boolean agreeMail) {
        this.agreeMail = agreeMail;
    }

    public Boolean getAgreeMail() {
        return agreeMail;
    }

    public void setAgreeTariffs(Boolean agreeTariffs) {
        this.agreeTariffs = agreeTariffs;
    }

    public Boolean getAgreeTariffs() {
        return agreeTariffs;
    }

    public void setAgreeTerms(Boolean agreeTerms) {
        this.agreeTerms = agreeTerms;
    }

    public Boolean getAgreeTerms() {
        return agreeTerms;
    }

    public void setAgreeProcessInfo(Boolean agreeProcessInfo) {
        this.agreeProcessInfo = agreeProcessInfo;
    }

    public Boolean getAgreeProcessInfo() {
        return agreeProcessInfo;
    }

    public void setConfirmPin(String confirmPin) {
        this.confirmPin = confirmPin;
    }

    public String getConfirmPin() {
        return confirmPin;
    }

    public void setAttachedCardsList(List<AttachedCard> attachedCardsList) {
        this.attachedCardsList = attachedCardsList;
    }

    public List<AttachedCard> getAttachedCardsList() {
        return attachedCardsList;
    }

    public ClientAddress getAddress1() {
        return address;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setIsSkipped(Boolean isSkipped) {
        this.isSkipped = isSkipped;
    }

    public Boolean getIsSkipped() {
        return isSkipped;
    }

    public void setProgramNickName(String programNickName) {
        this.programNickName = programNickName;
    }

    public String getProgramNickName() {
        return programNickName;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getCcy() {
        return ccy;
    }

    public void setEmbeddedRedirectUrl(String embeddedRedirectUrl) {
        this.embeddedRedirectUrl = embeddedRedirectUrl;
    }

    public String getEmbeddedRedirectUrl() {
        return embeddedRedirectUrl;
    }

    public void setSupervisedPhone(String supervisedPhone) {
        this.supervisedPhone = supervisedPhone;
    }

    public String getSupervisedPhone() {
        return supervisedPhone;
    }

    public void setCheckboxList(List<CheckboxContainer> checkboxList) {
        this.checkboxList = checkboxList;
    }

    public List<CheckboxContainer> getCheckboxList() {
        return checkboxList;
    }

    public void setIsStrongPassword(Boolean isStrongPassword) {
        this.isStrongPassword = isStrongPassword;
    }

    public Boolean getIsStrongPassword() {
        return isStrongPassword;
    }

    public List<Long> getAttachedCardIds() {
        List<Long> listCardIds = new ArrayList<>();
        if (attachedCardsList != null) {
            for (AttachedCard attachedCard : attachedCardsList) {
                if (attachedCard != null) {
                    listCardIds.add(attachedCard.getId());
                }
            }
        }
        return listCardIds;
    }

}
