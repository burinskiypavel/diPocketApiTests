package com.cs.dipocketback.pojo.references;

import java.util.HashMap;
import java.util.Map;

public enum SysParamType {

    /*Links*/
    CONTACT_US("ContactUs"),
    FAQ("FAQ"),
    PRIVACY_POLICY("PrivacyPolicy"),
    VENDOR_SITE_LINK("link.vendor.site"),
    LEGAL_LINK("link.legal"),
    
    IS_ACCOUNT_CREATION_ENABLED("IsAccountCreationEnabled"),
    IS_PRIVACY_POLICY_AS_DOC("IsPrivacyPolicyAsDoc"),
    IS_SECRET_QUESTION_ACTIVE("IsSecretQuestionActive"),
    IS_VIDEOCALLS_ENABLED("IsVideoCallsEnabled"),
    LOGIN_SUFFIX("LoginSuffix"),
    LOGIN_TYPE("LoginType"),
    LOWEST_AGE("LowestAge"),
    GOOGLE_PAY_PUSH_PROVISIONING("googlePayPushProvisioning"),
    PAYMENTS_REQUESTMONEY_IS_DIPTRANSFER_ENABLED("payments.requestMoney.isDipTransferEnabled"),
    PAYMENTS_REQUESTMONEY_IS_FACETOFACE_ENABLED("payments.requestMoney.isFaceToFaceEnabled"),
    PAYMENTS_SENDMONEY_IS_BANKTRANSFER_ENABLED("payments.sendMoney.isBankTransferEnabled"),
    PAYMENTS_SENDMONEY_IS_DIPTRANSFER_ENABLED("payments.sendMoney.isDipTransferEnabled"),
    PAYMENTS_SENDMONEY_IS_FACETOFACE_ENABLED("payments.sendMoney.isFaceToFaceEnabled"),
    PAYMENTS_TOPUP_IS_BANKTRANSFER_ENABLED("payments.topUp.isBankTransferEnabled"),
    PAYMENTS_TOPUP_IS_QUICKPAY_ENABLED("payments.topUp.isQuickPayEnabled"),
    PAYMENTS_TOPUP_IS_QUICKPAY_ENABLED_FOR_POLES("payments.topUp.isQuickPayEnabledForPoles"),
    PAYMENTS_TOPUP_IS_THIRDPARTY_ENABLED("payments.topUp.isThirdPartyEnabled"),
    WALLET_CREATIONACCOUNTLIMIT("wallet.creationAccountLimit"),
    
    ENGAGING_DAYS_BETWEEN_REVIEWS("engaging.daysBetweenReviews"),
    ENGAGING_DAYS_FOR_REVIEW("engaging.daysForReview"),
    ENGAGING_IS_NEW_VERSION_ENABLED("engaging.isNewVersionEnabled"),
    ENGAGING_IS_REVIEW_ENABLED("engaging.isReviewEnabled"),
    
    THEMES_DEFAULT_TYPE("themes.defaultType"),
    THEMES_IS_SWITCH_SUPPORTED("themes.isSwitchSupported"),
    
    REGISTRATION_IS_USING_CARD("registration.isUsingCard"),
    REGISTRATION_IS_USING_CARD_REQUIRED("registration.isUsingCardRequired"),
    
    TRANSACTION_DETAILS_IS_CATEGORY_CHANGEABLE("transactionDetails.isCategoryChangeable"),
    TRANSACTION_DETAILS_IS_PAYMENTS_REPEATABLE("transactionDetails.isPaymentsRepeatable"),

    LINK_CARD_ENABLED("isLinkingCardEnabled"),

    INFO_LINE("phones.infoLine"),

    CARD_PROVISIONING_CONFIG_IS_APPLE_PAY_ENABLED("cardProvisioningConfig.isApplePayEnabled"),

    APPLE_PAY_WHITELISTED_USERS("cardProvisioningConfig.ApplePayWhitelistedUsers"),

    LABEL_MODULE_SHOULD_SHOW_IN_MENU("labelModule.shouldShowInMenu"),
    LABEL_MODULE_SHOULD_SHOW_IN_TOP_UP("labelModule.shouldShowInTopUp"),
    LABEL_MODULE_SHOULD_SHOW_ON_MAIN_SCREEN("labelModule.shouldShowOnMainScreen");

    private String paramName;

    private static final Map<String, SysParamType> matrix = new HashMap<>();
    static {
        for (SysParamType type : values()) {
            matrix.put(type.getParamName(), type);
        }
    }

    public static SysParamType findByParamName(String value) {
        return matrix.get(value);
    }

    SysParamType(String paramName) {
        this.paramName = paramName;
    }

    public String getParamName() {
        return paramName;
    }

}
