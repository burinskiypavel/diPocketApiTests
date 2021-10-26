
package com.cs.dipocketback.pojo.tds.v2.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for backgroundAReq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="backgroundAReq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="acsTransID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="threeDSCompInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="threeDSRequestorAuthenticationInd" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="threeDSRequestorAuthenticationInfo" type="{https://www.todouri.com/req}threeDSRequestorAuthenticationInfo" minOccurs="0"/&gt;
 *         &lt;element name="threeDSRequestorChallengeInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="threeDSRequestorID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="threeDSRequestorName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="threeDSRequestorPriorAuthenticationInfo" type="{https://www.todouri.com/req}threeDSRequestorPriorAuthenticationInfo" minOccurs="0"/&gt;
 *         &lt;element name="threeDSRequestorURL" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="threeDSServerRefNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="threeDSServerOperatorID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="threeDSServerTransID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="threeDSServerURL" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="threeRIInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="acctType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="acquirerBIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="acquirerMerchantID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="addrMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="broadInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="browserAcceptHeader" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="browserIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="browserJavaEnabled" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="browserLanguage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="browserColorDepth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="browserScreenHeight" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="browserScreenWidth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="browserTZ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="browserUserAgent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cardExpiryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="acctInfo" type="{https://www.todouri.com/req}acctInfo" minOccurs="0"/&gt;
 *         &lt;element name="acctNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="acctID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="billAddrCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="billAddrCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="billAddrLine1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="billAddrLine2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="billAddrLine3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="billAddrPostCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="billAddrState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="homePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="mobilePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cardholderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="shipAddrCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="shipAddrCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="shipAddrLine1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="shipAddrLine2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="shipAddrLine3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="shipAddrPostCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="shipAddrState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="workPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="deviceChannel" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="deviceInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="deviceRenderOptions" type="{https://www.todouri.com/req}deviceRenderOptions" minOccurs="0"/&gt;
 *         &lt;element name="dsReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dsTransID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dsURL" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="payTokenInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="purchaseInstalData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="mcc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="merchantCountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="merchantName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="merchantRiskIndicator" type="{https://www.todouri.com/req}merchantRiskIndicator" minOccurs="0"/&gt;
 *         &lt;element name="messageCategory" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="messageExtension" type="{https://www.todouri.com/req}messageExtension" minOccurs="0"/&gt;
 *         &lt;element name="messageType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="messageVersion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="notificationURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="purchaseAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="purchaseCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="purchaseExponent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="purchaseDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="recurringExpiry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="recurringFrequency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sdkAppID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sdkMaxTimeout" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sdkReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sdkTransID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="transType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "backgroundAReq", propOrder = {
    "acsTransID",
    "threeDSCompInd",
    "threeDSRequestorAuthenticationInd",
    "threeDSRequestorAuthenticationInfo",
    "threeDSRequestorChallengeInd",
    "threeDSRequestorID",
    "threeDSRequestorName",
    "threeDSRequestorPriorAuthenticationInfo",
    "threeDSRequestorURL",
    "threeDSServerRefNumber",
    "threeDSServerOperatorID",
    "threeDSServerTransID",
    "threeDSServerURL",
    "threeRIInd",
    "acctType",
    "acquirerBIN",
    "acquirerMerchantID",
    "addrMatch",
    "broadInfo",
    "browserAcceptHeader",
    "browserIP",
    "browserJavaEnabled",
    "browserLanguage",
    "browserColorDepth",
    "browserScreenHeight",
    "browserScreenWidth",
    "browserTZ",
    "browserUserAgent",
    "cardExpiryDate",
    "acctInfo",
    "acctNumber",
    "acctID",
    "billAddrCity",
    "billAddrCountry",
    "billAddrLine1",
    "billAddrLine2",
    "billAddrLine3",
    "billAddrPostCode",
    "billAddrState",
    "email",
    "homePhone",
    "mobilePhone",
    "cardholderName",
    "shipAddrCity",
    "shipAddrCountry",
    "shipAddrLine1",
    "shipAddrLine2",
    "shipAddrLine3",
    "shipAddrPostCode",
    "shipAddrState",
    "workPhone",
    "deviceChannel",
    "deviceInfo",
    "deviceRenderOptions",
    "dsReferenceNumber",
    "dsTransID",
    "dsURL",
    "payTokenInd",
    "purchaseInstalData",
    "mcc",
    "merchantCountryCode",
    "merchantName",
    "merchantRiskIndicator",
    "messageCategory",
    "messageExtension",
    "messageType",
    "messageVersion",
    "notificationURL",
    "purchaseAmount",
    "purchaseCurrency",
    "purchaseExponent",
    "purchaseDate",
    "recurringExpiry",
    "recurringFrequency",
    "sdkAppID",
    "sdkMaxTimeout",
    "sdkReferenceNumber",
    "sdkTransID",
    "transType"
})
public class BackgroundAReq {

    @XmlElement(required = true)
    protected String acsTransID;
    protected String threeDSCompInd;
    @XmlElement(required = true)
    protected String threeDSRequestorAuthenticationInd;
    protected ThreeDSRequestorAuthenticationInfo threeDSRequestorAuthenticationInfo;
    protected String threeDSRequestorChallengeInd;
    @XmlElement(required = true)
    protected String threeDSRequestorID;
    @XmlElement(required = true)
    protected String threeDSRequestorName;
    protected ThreeDSRequestorPriorAuthenticationInfo threeDSRequestorPriorAuthenticationInfo;
    @XmlElement(required = true)
    protected String threeDSRequestorURL;
    @XmlElement(required = true)
    protected String threeDSServerRefNumber;
    protected String threeDSServerOperatorID;
    @XmlElement(required = true)
    protected String threeDSServerTransID;
    @XmlElement(required = true)
    protected String threeDSServerURL;
    protected String threeRIInd;
    protected String acctType;
    protected String acquirerBIN;
    @XmlElement(required = true)
    protected String acquirerMerchantID;
    protected String addrMatch;
    protected String broadInfo;
    protected String browserAcceptHeader;
    protected String browserIP;
    protected String browserJavaEnabled;
    protected String browserLanguage;
    protected String browserColorDepth;
    protected String browserScreenHeight;
    protected String browserScreenWidth;
    protected String browserTZ;
    protected String browserUserAgent;
    protected String cardExpiryDate;
    protected AcctInfo acctInfo;
    @XmlElement(required = true)
    protected String acctNumber;
    protected String acctID;
    protected String billAddrCity;
    protected String billAddrCountry;
    protected String billAddrLine1;
    protected String billAddrLine2;
    protected String billAddrLine3;
    protected String billAddrPostCode;
    protected String billAddrState;
    protected String email;
    protected PhoneNumber homePhone;
    protected PhoneNumber mobilePhone;
    protected String cardholderName;
    protected String shipAddrCity;
    protected String shipAddrCountry;
    protected String shipAddrLine1;
    protected String shipAddrLine2;
    protected String shipAddrLine3;
    protected String shipAddrPostCode;
    protected String shipAddrState;
    protected PhoneNumber workPhone;
    @XmlElement(required = true)
    protected String deviceChannel;
    protected String deviceInfo;
    protected DeviceRenderOptions deviceRenderOptions;
    @XmlElement(required = true)
    protected String dsReferenceNumber;
    @XmlElement(required = true)
    protected String dsTransID;
    @XmlElement(required = true)
    protected String dsURL;
    protected String payTokenInd;
    protected String purchaseInstalData;
    protected String mcc;
    protected String merchantCountryCode;
    protected String merchantName;
    protected MerchantRiskIndicator merchantRiskIndicator;
    @XmlElement(required = true)
    protected String messageCategory;
    protected MessageExtension messageExtension;
    @XmlElement(required = true)
    protected String messageType;
    @XmlElement(required = true)
    protected String messageVersion;
    protected String notificationURL;
    protected String purchaseAmount;
    protected String purchaseCurrency;
    protected String purchaseExponent;
    protected String purchaseDate;
    protected String recurringExpiry;
    protected String recurringFrequency;
    protected String sdkAppID;
    protected String sdkMaxTimeout;
    protected String sdkReferenceNumber;
    protected String sdkTransID;
    protected String transType;

    /**
     * Gets the value of the acsTransID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcsTransID() {
        return acsTransID;
    }

    /**
     * Sets the value of the acsTransID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcsTransID(String value) {
        this.acsTransID = value;
    }

    /**
     * Gets the value of the threeDSCompInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeDSCompInd() {
        return threeDSCompInd;
    }

    /**
     * Sets the value of the threeDSCompInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeDSCompInd(String value) {
        this.threeDSCompInd = value;
    }

    /**
     * Gets the value of the threeDSRequestorAuthenticationInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeDSRequestorAuthenticationInd() {
        return threeDSRequestorAuthenticationInd;
    }

    /**
     * Sets the value of the threeDSRequestorAuthenticationInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeDSRequestorAuthenticationInd(String value) {
        this.threeDSRequestorAuthenticationInd = value;
    }

    /**
     * Gets the value of the threeDSRequestorAuthenticationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ThreeDSRequestorAuthenticationInfo }
     *     
     */
    public ThreeDSRequestorAuthenticationInfo getThreeDSRequestorAuthenticationInfo() {
        return threeDSRequestorAuthenticationInfo;
    }

    /**
     * Sets the value of the threeDSRequestorAuthenticationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThreeDSRequestorAuthenticationInfo }
     *     
     */
    public void setThreeDSRequestorAuthenticationInfo(ThreeDSRequestorAuthenticationInfo value) {
        this.threeDSRequestorAuthenticationInfo = value;
    }

    /**
     * Gets the value of the threeDSRequestorChallengeInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeDSRequestorChallengeInd() {
        return threeDSRequestorChallengeInd;
    }

    /**
     * Sets the value of the threeDSRequestorChallengeInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeDSRequestorChallengeInd(String value) {
        this.threeDSRequestorChallengeInd = value;
    }

    /**
     * Gets the value of the threeDSRequestorID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeDSRequestorID() {
        return threeDSRequestorID;
    }

    /**
     * Sets the value of the threeDSRequestorID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeDSRequestorID(String value) {
        this.threeDSRequestorID = value;
    }

    /**
     * Gets the value of the threeDSRequestorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeDSRequestorName() {
        return threeDSRequestorName;
    }

    /**
     * Sets the value of the threeDSRequestorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeDSRequestorName(String value) {
        this.threeDSRequestorName = value;
    }

    /**
     * Gets the value of the threeDSRequestorPriorAuthenticationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ThreeDSRequestorPriorAuthenticationInfo }
     *     
     */
    public ThreeDSRequestorPriorAuthenticationInfo getThreeDSRequestorPriorAuthenticationInfo() {
        return threeDSRequestorPriorAuthenticationInfo;
    }

    /**
     * Sets the value of the threeDSRequestorPriorAuthenticationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThreeDSRequestorPriorAuthenticationInfo }
     *     
     */
    public void setThreeDSRequestorPriorAuthenticationInfo(ThreeDSRequestorPriorAuthenticationInfo value) {
        this.threeDSRequestorPriorAuthenticationInfo = value;
    }

    /**
     * Gets the value of the threeDSRequestorURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeDSRequestorURL() {
        return threeDSRequestorURL;
    }

    /**
     * Sets the value of the threeDSRequestorURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeDSRequestorURL(String value) {
        this.threeDSRequestorURL = value;
    }

    /**
     * Gets the value of the threeDSServerRefNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeDSServerRefNumber() {
        return threeDSServerRefNumber;
    }

    /**
     * Sets the value of the threeDSServerRefNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeDSServerRefNumber(String value) {
        this.threeDSServerRefNumber = value;
    }

    /**
     * Gets the value of the threeDSServerOperatorID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeDSServerOperatorID() {
        return threeDSServerOperatorID;
    }

    /**
     * Sets the value of the threeDSServerOperatorID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeDSServerOperatorID(String value) {
        this.threeDSServerOperatorID = value;
    }

    /**
     * Gets the value of the threeDSServerTransID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeDSServerTransID() {
        return threeDSServerTransID;
    }

    /**
     * Sets the value of the threeDSServerTransID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeDSServerTransID(String value) {
        this.threeDSServerTransID = value;
    }

    /**
     * Gets the value of the threeDSServerURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeDSServerURL() {
        return threeDSServerURL;
    }

    /**
     * Sets the value of the threeDSServerURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeDSServerURL(String value) {
        this.threeDSServerURL = value;
    }

    /**
     * Gets the value of the threeRIInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeRIInd() {
        return threeRIInd;
    }

    /**
     * Sets the value of the threeRIInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeRIInd(String value) {
        this.threeRIInd = value;
    }

    /**
     * Gets the value of the acctType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctType() {
        return acctType;
    }

    /**
     * Sets the value of the acctType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctType(String value) {
        this.acctType = value;
    }

    /**
     * Gets the value of the acquirerBIN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcquirerBIN() {
        return acquirerBIN;
    }

    /**
     * Sets the value of the acquirerBIN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcquirerBIN(String value) {
        this.acquirerBIN = value;
    }

    /**
     * Gets the value of the acquirerMerchantID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcquirerMerchantID() {
        return acquirerMerchantID;
    }

    /**
     * Sets the value of the acquirerMerchantID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcquirerMerchantID(String value) {
        this.acquirerMerchantID = value;
    }

    /**
     * Gets the value of the addrMatch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrMatch() {
        return addrMatch;
    }

    /**
     * Sets the value of the addrMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrMatch(String value) {
        this.addrMatch = value;
    }

    /**
     * Gets the value of the broadInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBroadInfo() {
        return broadInfo;
    }

    /**
     * Sets the value of the broadInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBroadInfo(String value) {
        this.broadInfo = value;
    }

    /**
     * Gets the value of the browserAcceptHeader property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrowserAcceptHeader() {
        return browserAcceptHeader;
    }

    /**
     * Sets the value of the browserAcceptHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrowserAcceptHeader(String value) {
        this.browserAcceptHeader = value;
    }

    /**
     * Gets the value of the browserIP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrowserIP() {
        return browserIP;
    }

    /**
     * Sets the value of the browserIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrowserIP(String value) {
        this.browserIP = value;
    }

    /**
     * Gets the value of the browserJavaEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrowserJavaEnabled() {
        return browserJavaEnabled;
    }

    /**
     * Sets the value of the browserJavaEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrowserJavaEnabled(String value) {
        this.browserJavaEnabled = value;
    }

    /**
     * Gets the value of the browserLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrowserLanguage() {
        return browserLanguage;
    }

    /**
     * Sets the value of the browserLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrowserLanguage(String value) {
        this.browserLanguage = value;
    }

    /**
     * Gets the value of the browserColorDepth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrowserColorDepth() {
        return browserColorDepth;
    }

    /**
     * Sets the value of the browserColorDepth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrowserColorDepth(String value) {
        this.browserColorDepth = value;
    }

    /**
     * Gets the value of the browserScreenHeight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrowserScreenHeight() {
        return browserScreenHeight;
    }

    /**
     * Sets the value of the browserScreenHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrowserScreenHeight(String value) {
        this.browserScreenHeight = value;
    }

    /**
     * Gets the value of the browserScreenWidth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrowserScreenWidth() {
        return browserScreenWidth;
    }

    /**
     * Sets the value of the browserScreenWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrowserScreenWidth(String value) {
        this.browserScreenWidth = value;
    }

    /**
     * Gets the value of the browserTZ property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBrowserTZ() {
        return browserTZ;
    }

    /**
     * Sets the value of the browserTZ property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrowserTZ(String value) {
        this.browserTZ = value;
    }

    /**
     * Gets the value of the browserUserAgent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrowserUserAgent() {
        return browserUserAgent;
    }

    /**
     * Sets the value of the browserUserAgent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrowserUserAgent(String value) {
        this.browserUserAgent = value;
    }

    /**
     * Gets the value of the cardExpiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    /**
     * Sets the value of the cardExpiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardExpiryDate(String value) {
        this.cardExpiryDate = value;
    }

    /**
     * Gets the value of the acctInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AcctInfo }
     *     
     */
    public AcctInfo getAcctInfo() {
        return acctInfo;
    }

    /**
     * Sets the value of the acctInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcctInfo }
     *     
     */
    public void setAcctInfo(AcctInfo value) {
        this.acctInfo = value;
    }

    /**
     * Gets the value of the acctNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctNumber() {
        return acctNumber;
    }

    /**
     * Sets the value of the acctNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctNumber(String value) {
        this.acctNumber = value;
    }

    /**
     * Gets the value of the acctID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctID() {
        return acctID;
    }

    /**
     * Sets the value of the acctID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctID(String value) {
        this.acctID = value;
    }

    /**
     * Gets the value of the billAddrCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillAddrCity() {
        return billAddrCity;
    }

    /**
     * Sets the value of the billAddrCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillAddrCity(String value) {
        this.billAddrCity = value;
    }

    /**
     * Gets the value of the billAddrCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillAddrCountry() {
        return billAddrCountry;
    }

    /**
     * Sets the value of the billAddrCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillAddrCountry(String value) {
        this.billAddrCountry = value;
    }

    /**
     * Gets the value of the billAddrLine1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillAddrLine1() {
        return billAddrLine1;
    }

    /**
     * Sets the value of the billAddrLine1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillAddrLine1(String value) {
        this.billAddrLine1 = value;
    }

    /**
     * Gets the value of the billAddrLine2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillAddrLine2() {
        return billAddrLine2;
    }

    /**
     * Sets the value of the billAddrLine2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillAddrLine2(String value) {
        this.billAddrLine2 = value;
    }

    /**
     * Gets the value of the billAddrLine3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillAddrLine3() {
        return billAddrLine3;
    }

    /**
     * Sets the value of the billAddrLine3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillAddrLine3(String value) {
        this.billAddrLine3 = value;
    }

    /**
     * Gets the value of the billAddrPostCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillAddrPostCode() {
        return billAddrPostCode;
    }

    /**
     * Sets the value of the billAddrPostCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillAddrPostCode(String value) {
        this.billAddrPostCode = value;
    }

    /**
     * Gets the value of the billAddrState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillAddrState() {
        return billAddrState;
    }

    /**
     * Sets the value of the billAddrState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillAddrState(String value) {
        this.billAddrState = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the homePhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public PhoneNumber getHomePhone() {
        return homePhone;
    }

    /**
     * Sets the value of the homePhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomePhone(PhoneNumber value) {
        this.homePhone = value;
    }

    /**
     * Gets the value of the mobilePhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public PhoneNumber getMobilePhone() {
        return mobilePhone;
    }

    /**
     * Sets the value of the mobilePhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobilePhone(PhoneNumber value) {
        this.mobilePhone = value;
    }

    /**
     * Gets the value of the cardholderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardholderName() {
        return cardholderName;
    }

    /**
     * Sets the value of the cardholderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardholderName(String value) {
        this.cardholderName = value;
    }

    /**
     * Gets the value of the shipAddrCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipAddrCity() {
        return shipAddrCity;
    }

    /**
     * Sets the value of the shipAddrCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipAddrCity(String value) {
        this.shipAddrCity = value;
    }

    /**
     * Gets the value of the shipAddrCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipAddrCountry() {
        return shipAddrCountry;
    }

    /**
     * Sets the value of the shipAddrCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipAddrCountry(String value) {
        this.shipAddrCountry = value;
    }

    /**
     * Gets the value of the shipAddrLine1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipAddrLine1() {
        return shipAddrLine1;
    }

    /**
     * Sets the value of the shipAddrLine1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipAddrLine1(String value) {
        this.shipAddrLine1 = value;
    }

    /**
     * Gets the value of the shipAddrLine2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipAddrLine2() {
        return shipAddrLine2;
    }

    /**
     * Sets the value of the shipAddrLine2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipAddrLine2(String value) {
        this.shipAddrLine2 = value;
    }

    /**
     * Gets the value of the shipAddrLine3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipAddrLine3() {
        return shipAddrLine3;
    }

    /**
     * Sets the value of the shipAddrLine3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipAddrLine3(String value) {
        this.shipAddrLine3 = value;
    }

    /**
     * Gets the value of the shipAddrPostCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipAddrPostCode() {
        return shipAddrPostCode;
    }

    /**
     * Sets the value of the shipAddrPostCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipAddrPostCode(String value) {
        this.shipAddrPostCode = value;
    }

    /**
     * Gets the value of the shipAddrState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipAddrState() {
        return shipAddrState;
    }

    /**
     * Sets the value of the shipAddrState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipAddrState(String value) {
        this.shipAddrState = value;
    }

    /**
     * Gets the value of the workPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public PhoneNumber getWorkPhone() {
        return workPhone;
    }

    /**
     * Sets the value of the workPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkPhone(PhoneNumber value) {
        this.workPhone = value;
    }

    /**
     * Gets the value of the deviceChannel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceChannel() {
        return deviceChannel;
    }

    /**
     * Sets the value of the deviceChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceChannel(String value) {
        this.deviceChannel = value;
    }

    /**
     * Gets the value of the deviceInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceInfo() {
        return deviceInfo;
    }

    /**
     * Sets the value of the deviceInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceInfo(String value) {
        this.deviceInfo = value;
    }

    /**
     * Gets the value of the deviceRenderOptions property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceRenderOptions }
     *     
     */
    public DeviceRenderOptions getDeviceRenderOptions() {
        return deviceRenderOptions;
    }

    /**
     * Sets the value of the deviceRenderOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceRenderOptions }
     *     
     */
    public void setDeviceRenderOptions(DeviceRenderOptions value) {
        this.deviceRenderOptions = value;
    }

    /**
     * Gets the value of the dsReferenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsReferenceNumber() {
        return dsReferenceNumber;
    }

    /**
     * Sets the value of the dsReferenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsReferenceNumber(String value) {
        this.dsReferenceNumber = value;
    }

    /**
     * Gets the value of the dsTransID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsTransID() {
        return dsTransID;
    }

    /**
     * Sets the value of the dsTransID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsTransID(String value) {
        this.dsTransID = value;
    }

    /**
     * Gets the value of the dsURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsURL() {
        return dsURL;
    }

    /**
     * Sets the value of the dsURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsURL(String value) {
        this.dsURL = value;
    }

    /**
     * Gets the value of the payTokenInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayTokenInd() {
        return payTokenInd;
    }

    /**
     * Sets the value of the payTokenInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayTokenInd(String value) {
        this.payTokenInd = value;
    }

    /**
     * Gets the value of the purchaseInstalData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseInstalData() {
        return purchaseInstalData;
    }

    /**
     * Sets the value of the purchaseInstalData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseInstalData(String value) {
        this.purchaseInstalData = value;
    }

    /**
     * Gets the value of the mcc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMcc() {
        return mcc;
    }

    /**
     * Sets the value of the mcc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMcc(String value) {
        this.mcc = value;
    }

    /**
     * Gets the value of the merchantCountryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantCountryCode() {
        return merchantCountryCode;
    }

    /**
     * Sets the value of the merchantCountryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantCountryCode(String value) {
        this.merchantCountryCode = value;
    }

    /**
     * Gets the value of the merchantName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * Sets the value of the merchantName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantName(String value) {
        this.merchantName = value;
    }

    /**
     * Gets the value of the merchantRiskIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link MerchantRiskIndicator }
     *     
     */
    public MerchantRiskIndicator getMerchantRiskIndicator() {
        return merchantRiskIndicator;
    }

    /**
     * Sets the value of the merchantRiskIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link MerchantRiskIndicator }
     *     
     */
    public void setMerchantRiskIndicator(MerchantRiskIndicator value) {
        this.merchantRiskIndicator = value;
    }

    /**
     * Gets the value of the messageCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageCategory() {
        return messageCategory;
    }

    /**
     * Sets the value of the messageCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageCategory(String value) {
        this.messageCategory = value;
    }

    /**
     * Gets the value of the messageExtension property.
     * 
     * @return
     *     possible object is
     *     {@link MessageExtension }
     *     
     */
    public MessageExtension getMessageExtension() {
        return messageExtension;
    }

    /**
     * Sets the value of the messageExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageExtension }
     *     
     */
    public void setMessageExtension(MessageExtension value) {
        this.messageExtension = value;
    }

    /**
     * Gets the value of the messageType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageType() {
        return messageType;
    }

    /**
     * Sets the value of the messageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageType(String value) {
        this.messageType = value;
    }

    /**
     * Gets the value of the messageVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageVersion() {
        return messageVersion;
    }

    /**
     * Sets the value of the messageVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageVersion(String value) {
        this.messageVersion = value;
    }

    /**
     * Gets the value of the notificationURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotificationURL() {
        return notificationURL;
    }

    /**
     * Sets the value of the notificationURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotificationURL(String value) {
        this.notificationURL = value;
    }

    /**
     * Gets the value of the purchaseAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    /**
     * Sets the value of the purchaseAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseAmount(String value) {
        this.purchaseAmount = value;
    }

    /**
     * Gets the value of the purchaseCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseCurrency() {
        return purchaseCurrency;
    }

    /**
     * Sets the value of the purchaseCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseCurrency(String value) {
        this.purchaseCurrency = value;
    }

    /**
     * Gets the value of the purchaseExponent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseExponent() {
        return purchaseExponent;
    }

    /**
     * Sets the value of the purchaseExponent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseExponent(String value) {
        this.purchaseExponent = value;
    }

    /**
     * Gets the value of the purchaseDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Sets the value of the purchaseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseDate(String value) {
        this.purchaseDate = value;
    }

    /**
     * Gets the value of the recurringExpiry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecurringExpiry() {
        return recurringExpiry;
    }

    /**
     * Sets the value of the recurringExpiry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecurringExpiry(String value) {
        this.recurringExpiry = value;
    }

    /**
     * Gets the value of the recurringFrequency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecurringFrequency() {
        return recurringFrequency;
    }

    /**
     * Sets the value of the recurringFrequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecurringFrequency(String value) {
        this.recurringFrequency = value;
    }

    /**
     * Gets the value of the sdkAppID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSdkAppID() {
        return sdkAppID;
    }

    /**
     * Sets the value of the sdkAppID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSdkAppID(String value) {
        this.sdkAppID = value;
    }

    /**
     * Gets the value of the sdkMaxTimeout property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSdkMaxTimeout() {
        return sdkMaxTimeout;
    }

    /**
     * Sets the value of the sdkMaxTimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSdkMaxTimeout(String value) {
        this.sdkMaxTimeout = value;
    }

    /**
     * Gets the value of the sdkReferenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSdkReferenceNumber() {
        return sdkReferenceNumber;
    }

    /**
     * Sets the value of the sdkReferenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSdkReferenceNumber(String value) {
        this.sdkReferenceNumber = value;
    }

    /**
     * Gets the value of the sdkTransID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSdkTransID() {
        return sdkTransID;
    }

    /**
     * Sets the value of the sdkTransID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSdkTransID(String value) {
        this.sdkTransID = value;
    }

    /**
     * Gets the value of the transType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransType() {
        return transType;
    }

    /**
     * Sets the value of the transType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransType(String value) {
        this.transType = value;
    }

}
