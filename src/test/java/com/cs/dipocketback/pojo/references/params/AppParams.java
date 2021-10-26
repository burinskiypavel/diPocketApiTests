package com.cs.dipocketback.pojo.references.params;

import com.cs.dipocketback.pojo.references.AppParamsEngagingConfig;
import com.cs.dipocketback.pojo.references.Language;

public class AppParams {
    
    private Boolean isAccountCreationEnabled;
    private Boolean isPrivacyPolicyAsDoc;
    private Boolean isSecretQuestionActive;
    private Boolean isVideoCallsEnabled;
    private String loginSuffix;
    private String loginType;
    private Integer lowestAge;
    private Boolean googlePayPushProvisioning;
    private AppParamLinks links;
    private AppParamsPayments payments;
    private ParamsWallet wallet;
    private Language defaultLanguage;
    private AppParamsEngagingConfig engagingConfig;
    private ParamsThemes paramsThemes;
    private ParamsRegistration registration;
    private TransactionDetailsParams transactionDetails;
    private String mainScreenBannerUrl;
    private Boolean isLinkingCardEnabled;
    private Phones phones;
    private CardProvisioningConfig cardProvisioningConfig;
    private LabelModule labelModule;

    public AppParams() {
    }

    public void setIsAccountCreationEnabled(Boolean isAccountCreationEnabled) {
        this.isAccountCreationEnabled = isAccountCreationEnabled;
    }

    public Boolean getIsAccountCreationEnabled() {
        return isAccountCreationEnabled;
    }

    public void setIsPrivacyPolicyAsDoc(Boolean isPrivacyPolicyAsDoc) {
        this.isPrivacyPolicyAsDoc = isPrivacyPolicyAsDoc;
    }

    public Boolean getIsPrivacyPolicyAsDoc() {
        return isPrivacyPolicyAsDoc;
    }

    public void setIsSecretQuestionActive(Boolean isSecretQuestionActive) {
        this.isSecretQuestionActive = isSecretQuestionActive;
    }

    public Boolean getIsSecretQuestionActive() {
        return isSecretQuestionActive;
    }

    public void setLoginSuffix(String loginSuffix) {
        this.loginSuffix = loginSuffix;
    }

    public String getLoginSuffix() {
        return loginSuffix;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLowestAge(Integer lowestAge) {
        this.lowestAge = lowestAge;
    }

    public Integer getLowestAge() {
        return lowestAge;
    }

    public void setGooglePayPushProvisioning(Boolean googlePayPushProvisioning) {
        this.googlePayPushProvisioning = googlePayPushProvisioning;
    }

    public Boolean getGooglePayPushProvisioning() {
        return googlePayPushProvisioning;
    }

    public void setIsVideoCallsEnabled(Boolean isVideoCallsEnabled) {
        this.isVideoCallsEnabled = isVideoCallsEnabled;
    }

    public Boolean getIsVideoCallsEnabled() {
        return isVideoCallsEnabled;
    }

    public void setLinks(AppParamLinks links) {
        this.links = links;
    }

    public AppParamLinks getLinks() {
        return links;
    }

    public void setPayments(AppParamsPayments payments) {
        this.payments = payments;
    }

    public AppParamsPayments getPayments() {
        return payments;
    }

    public void setWallet(ParamsWallet wallet) {
        this.wallet = wallet;
    }

    public ParamsWallet getWallet() {
        return wallet;
    }

    public void setDefaultLanguage(Language defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public Language getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setEngagingConfig(AppParamsEngagingConfig engagingConfig) {
        this.engagingConfig = engagingConfig;
    }

    public AppParamsEngagingConfig getEngagingConfig() {
        return engagingConfig;
    }

    public void setParamsThemes(ParamsThemes paramsThemes) {
        this.paramsThemes = paramsThemes;
    }

    public ParamsThemes getParamsThemes() {
        return paramsThemes;
    }

    public void setRegistration(ParamsRegistration registration) {
        this.registration = registration;
    }

    public ParamsRegistration getRegistration() {
        return registration;
    }

    public void setTransactionDetails(TransactionDetailsParams transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public TransactionDetailsParams getTransactionDetails() {
        return transactionDetails;
    }

    public String getMainScreenBannerUrl() {
        return mainScreenBannerUrl;
    }

    public void setMainScreenBannerUrl(String mainScreenBannerUrl) {
        this.mainScreenBannerUrl = mainScreenBannerUrl;
    }

    public Boolean getIsLinkingCardEnabled() {
        return isLinkingCardEnabled;
    }

    public void setLinkingCardEnabled(Boolean linkingCardEnabled) {
        isLinkingCardEnabled = linkingCardEnabled;
    }

    public Phones getPhones() {
        return phones;
    }

    public void setPhones(Phones phones) {
        this.phones = phones;
    }

    public CardProvisioningConfig getCardProvisioningConfig() {
        return cardProvisioningConfig;
    }

    public void setCardProvisioningConfig(CardProvisioningConfig cardProvisioningConfig) {
        this.cardProvisioningConfig = cardProvisioningConfig;
    }

    public LabelModule getLabelModule() {
        return labelModule;
    }

    public void setLabelModule(LabelModule labelModule) {
        this.labelModule = labelModule;
    }

}
