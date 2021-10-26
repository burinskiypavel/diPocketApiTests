package com.cs.dipocketback.pojo.client;

import com.cs.dipocketback.base.data.Site;
import com.cs.dipocketback.constants.TextConstants;
//import com.cs.dipocketback.base.data.Site;
import com.cs.dipocketback.pojo.registration.RegImageData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlTransient;

public class ClientInfo {
       
    public static final int CLIENT_STATE_ACTIVE = 1;
    public static final Integer CLIENT_STATE_BLOCKED = -1;
    public static final Integer CLIENT_STATE_BANNED = -100;
    public static final String FDD_STATUS = "FDD";
    
    public static final int ADULT_AGE = 18;

    /*
    CT_INDIVIDUAL         CONSTANT  Client.ClientType%TYPE := 'I';
    CT_CORPORATE          CONSTANT  Client.ClientType%TYPE := 'C';
    CT_HIDDEN_INDIVIDUAL  CONSTANT  Client.ClientType%TYPE := 'H';
    CT_INTERNAL           CONSTANT  Client.ClientType%TYPE := '.';
    CT_TECHNICAL          CONSTANT  Client.ClientType%TYPE := '.';
    */

    public enum ClientType {
        INDIVIDUAL("I"),
        CORPORATE("C"),
        HIDDEN_INDIVIDUAL("H"),
        INTERNAL(".");

        private String name;

        private static final Map<String, ClientType> CLIENT_TYPE_MAP;
        static {
            CLIENT_TYPE_MAP = new HashMap<>(values().length);
            for (ClientType type : values()) {
                CLIENT_TYPE_MAP.put(type.getName(), type);
            }
        }

        ClientType(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public static ClientType getClientTypeByName(String name) {
            return CLIENT_TYPE_MAP.get(name);
        }
    }

    /**
     * PSDD-->SDD-->PFDD-->FDD
     * For kids PSDD-->SDD-->SFDD
     */
    public static enum ClientStatus {

        PSDD,
        SDD,
        SFDD,
        PFDD,
        FDD;

        private static final Map<String, ClientStatus> CLIENT_STATUS_MAP = new HashMap<>(5);

        static {
            for (ClientStatus cs : values()) {
                CLIENT_STATUS_MAP.put(cs.name(), cs);
            }
        }
        
        public static ClientStatus getClientStatusByName(String name) {
            return CLIENT_STATUS_MAP.get(name);
        }

    }

    private Long id;
    private String clientFirstName;
    private String clientMiddleName;
    private String clientLastName;
    private String presentedLogin;
    private Integer countryId;
    private Integer residenceCountryId;
    private Integer langId;
    private String mainPhone;
    private String email;
    private Boolean emailIsVerified;
    private Integer currencyId;
    private String secQuestion;
    private Integer secAnswerAttemptCnt;
    private Integer stateId;
    private String blockReason;
    private Boolean addDocsAvail;
    private String ccyCode;
    private List<ClientAddress> addresses;
    private String birthDate;
    private String birthDateAsDate;
    private String ddStatus;
    private String cardholderName;
    private BankCredentials bankCredentials;
    protected List<RegImageData> images;
    private RegImageData avatar;
    private Boolean registeredAddrAsmail;
    private Boolean clientIsNew;
    private CardholderNameState cardholderNameState;
    private List<RegImageData> imagesStatus;
    private String site;
    private Site siteEnum;

    private Boolean migrated;
    private Boolean canConvert;
    private Boolean canReLink;

    private String externalNo;
    private String identifyCode;
    
    private Long powId;
    private String programNickName;
    
    private ClientAddress regAddress;
    private ClientAddress mailAddress;

    private Boolean isStrongPassword;

    private ClientType clientType;



    public void setImages(List<RegImageData> images) {
        this.images = images;
    }

    public List<RegImageData> getImages() {
        return images;
    }

    public void setAddresses(List<ClientAddress> addresses) {
        this.addresses = addresses;
    }

    public List<ClientAddress> getAddresses() {
        return addresses;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBankCredentials(BankCredentials bankCredentials) {
        this.bankCredentials = bankCredentials;
    }

    public BankCredentials getBankCredentials() {
        return bankCredentials;
    }

    public void setAddDocsAvail(Boolean addDocsAvail) {
        this.addDocsAvail = addDocsAvail;
    }

    public Boolean getAddDocsAvail() {
        return addDocsAvail;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

    public Integer getLangId() {
        return langId;
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

    public void setEmailIsVerified(Boolean emailIsVerified) {
        this.emailIsVerified = emailIsVerified;
    }

    public Boolean getEmailIsVerified() {
        return emailIsVerified;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
        // TODO BAD ? setCcyCode(CommonUtils.currencyCodeById(currencyId));
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setSecQuestion(String secQuestion) {
        this.secQuestion = secQuestion;
    }

    public String getSecQuestion() {
        return secQuestion;
    }

    public void setSecAnswerAttemptCnt(Integer secAnswerAttemptCnt) {
        this.secAnswerAttemptCnt = secAnswerAttemptCnt;
    }

    public Integer getSecAnswerAttemptCnt() {
        return secAnswerAttemptCnt;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setPresentedLogin(String presentedLogin) {
        this.presentedLogin = presentedLogin;
    }

    public String getPresentedLogin() {
        return presentedLogin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientMiddleName(String clientMiddleName) {
        this.clientMiddleName = clientMiddleName;
    }

    public String getClientMiddleName() {
        return clientMiddleName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setCcyCode(String ccyCode) {
        this.ccyCode = ccyCode;
    }

    public String getCcyCode() {
        return ccyCode;
    }

    public void setDdStatus(String ddStatus) {
        this.ddStatus = ddStatus;
    }

    public String getDdStatus() {
        return ddStatus;
    }

    public void setResidenceCountryId(Integer residenceCountryId) {
        this.residenceCountryId = residenceCountryId;
    }

    public Integer getResidenceCountryId() {
        return residenceCountryId;
    }

    public void setCardholderName(String cardholderMame) {
        this.cardholderName = cardholderMame;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setBirthDateAsDate(String birthDateAsDate) {
        this.birthDateAsDate = birthDateAsDate;
    }

    public String getBirthDateAsDate() {
        return birthDateAsDate;
    }

    public void setRegisteredAddrAsmail(Boolean registeredAddrAsmail) {
        this.registeredAddrAsmail = registeredAddrAsmail;
    }

    public Boolean getRegisteredAddrAsmail() {
        return registeredAddrAsmail;
    }

    public void setCardholderNameState(CardholderNameState cardholderNameState) {
        this.cardholderNameState = cardholderNameState;
    }

    public CardholderNameState getCardholderNameState() {
        return cardholderNameState;
    }

    public void setImagesStatus(List<RegImageData> imagesStatus) {
        this.imagesStatus = imagesStatus;
    }

    public List<RegImageData> getImagesStatus() {
        return imagesStatus;
    }

    public void setAvatar(RegImageData avatar) {
        this.avatar = avatar;
    }

    public RegImageData getAvatar() {
        return avatar;
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

    public void setExternalNo(String externalNo) {
        this.externalNo = externalNo;
    }

    @XmlTransient
    public String getExternalNo() {
        return externalNo;
    }

    public void setIdentifyCode(String identifyCode) {
        this.identifyCode = identifyCode;
    }

    public String getIdentifyCode() {
        return identifyCode;
    }

    public ClientInfo() {
    }

    public ClientInfo(Long id, Integer langId) {
        this.id = id;
        this.langId = langId;
    }

    public ClientInfo(Long id, Integer langId, String ddStatus) {
        this.id = id;
        this.langId = langId;
        this.ddStatus = ddStatus;
    }

    public ClientInfo(String email, 
                      String mainPhone, 
                      Integer langId, 
                      Integer countryId, 
                      String clientFirstName, 
                      Integer currencyId, 
                      String site,
                      Site siteEnum) {
        this.email = email;
        this.mainPhone = mainPhone;
        this.langId = langId;
        this.countryId = countryId;
        this.clientFirstName = clientFirstName;
        this.currencyId = currencyId;
        this.site = site;
        this.siteEnum = siteEnum;
        
    }
    
    public ClientInfo(Long id, String clientFirstName, String clientMiddleName, String clientLastName,
                      String presentedLogin, Integer countryId, Integer residenceCountryId, Integer langId,
                      String mainPhone, String email, Boolean emailIsVerified, Integer currencyId, String secQuestion,
                      Integer secAnswerAttemptCnt, Integer stateId, Boolean addDocsAvail, String ccyCode,
                      String birthDate, String birthDateAsDate, String ddStatus, String cardholderName,
                      Boolean registeredAddrAsmail, CardholderNameState cardholderNameState, String site, Site siteEnum,
                      String externalNo, String identifyCode, Boolean isStrongPassword, ClientType clientType,
                      String blockReason) {
        this.id = id;
        this.clientFirstName = clientFirstName;
        this.clientMiddleName = clientMiddleName;
        this.clientLastName = clientLastName;
        this.presentedLogin = presentedLogin;
        this.countryId = countryId;
        this.langId = langId;
        this.mainPhone = mainPhone;
        this.email = email;
        this.emailIsVerified = emailIsVerified;
        this.currencyId = currencyId;
        this.residenceCountryId = residenceCountryId;
        this.secQuestion = secQuestion;
        this.secAnswerAttemptCnt = secAnswerAttemptCnt;
        this.stateId = stateId;
        this.blockReason = blockReason;
        this.addDocsAvail = addDocsAvail;
        this.ccyCode = ccyCode;
        this.birthDate = birthDate;
        this.birthDateAsDate = birthDateAsDate;
        this.ddStatus = ddStatus;
        this.cardholderName = cardholderName;
        this.registeredAddrAsmail = registeredAddrAsmail;
        this.cardholderNameState = cardholderNameState;
        this.site = site;
        this.siteEnum = siteEnum;
        this.externalNo = externalNo;
        this.identifyCode = identifyCode;
        this.isStrongPassword = isStrongPassword;
        this.clientType = clientType;
    }

    public String getFullName() {
        if (clientFirstName != null && clientLastName != null) {
            StringBuilder result = new StringBuilder(clientFirstName).append(" ");
            if (!isEmptyString(clientMiddleName)) {
                result.append(clientMiddleName).append(" ");
            }

            return result.append(clientLastName).toString();
        }
        return TextConstants.EMPTY_STRING;
    }

    // TODO R
    private boolean isEmptyString(Object str) {
        return ((str == null) || str.toString().trim().isEmpty());
    }

    public boolean isClientBlocked() {
        return CLIENT_STATE_BLOCKED.equals(stateId);
    }

    public boolean isClientBanned() {
        return CLIENT_STATE_BANNED.equals(stateId);
    }

    public void setClientIsNew(Boolean clientIsNew) {
        this.clientIsNew = clientIsNew;
    }

    public Boolean getClientIsNew() {
        return clientIsNew;
    }

    public void setMigrated(Boolean migrated) {
        this.migrated = migrated;
    }

    public Boolean getMigrated() {
        return migrated;
    }

    public void setCanConvert(Boolean canConvert) {
        this.canConvert = canConvert;
    }

    public Boolean getCanConvert() {
        return canConvert;
    }

    public void setCanReLink(Boolean canReLink) {
        this.canReLink = canReLink;
    }

    public Boolean getCanReLink() {
        return canReLink;
    }

    public void setPowId(Long powId) {
        this.powId = powId;
    }

    public Long getPowId() {
        return powId;
    }

    public void setProgramNickName(String programNickName) {
        this.programNickName = programNickName;
    }

    public String getProgramNickName() {
        return programNickName;
    }

    public void setIsStrongPassword(Boolean isStrongPassword) {
        this.isStrongPassword = isStrongPassword;
    }

    public Boolean getIsStrongPassword() {
        return isStrongPassword;
    }

    @XmlTransient
    public String getBlockReason() {
        return blockReason;
    }

    public void setBlockReason(String blockReason) {
        this.blockReason = blockReason;
    }

    @XmlTransient
    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public void setRegAddress(ClientAddress regAddress) {
        this.regAddress = regAddress;
    }

    @XmlTransient
    public ClientAddress getRegAddress() {
        return regAddress;
    }

    public void setMailAddress(ClientAddress mailAddress) {
        this.mailAddress = mailAddress;
    }

    @XmlTransient
    public ClientAddress getMailAddress() {
        return mailAddress;
    }

    public static class BankCredentials {
        private String bic;
        private Map<String, String> ibans = new HashMap<>();

        public void setBic(String bic) {
            this.bic = bic;
        }

        public String getBic() {
            return bic;
        }

        public void setIbans(Map<String, String> ibans) {
            this.ibans = ibans;
        }

        public Map<String, String> getIbans() {
            return ibans;
        }
    }
    
}
