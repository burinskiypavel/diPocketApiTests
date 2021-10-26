
package com.cs.dipocketback.pojo.tds.v2.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for backgroundARes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="backgroundARes"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="acsTransID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="acsChallengeMandated" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="acsRenderingType" type="{https://www.todouri.com/resp}acsRenderingType" minOccurs="0"/&gt;
 *         &lt;element name="authenticationType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="broadInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cardholderInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="messageExtension" type="{https://www.todouri.com/resp}messageExtension" minOccurs="0"/&gt;
 *         &lt;element name="messageType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="messageVersion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="transStatus" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="transStatusReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "backgroundARes", propOrder = {
    "acsTransID",
    "acsChallengeMandated",
    "acsRenderingType",
    "authenticationType",
    "broadInfo",
    "cardholderInfo",
    "messageExtension",
    "messageType",
    "messageVersion",
    "transStatus",
    "transStatusReason"
})
public class BackgroundARes {

    @XmlElement(required = true)
    protected String acsTransID;                    // Required
    protected String acsChallengeMandated;          // Required if transStatus = C
    protected AcsRenderingType acsRenderingType;    // Required if transStatus = C and deviceChannel = 01
    protected String authenticationType;            // Required if transStatus = C
    protected String broadInfo;                     // Optional
    protected String cardholderInfo;                // Optional
    protected MessageExtension messageExtension;    // Optional
    @XmlElement(required = true)
    protected String messageType;                   // Required
    @XmlElement(required = true)
    protected String messageVersion;                // Required
    @XmlElement(required = true)
    protected String transStatus;                   // Required
    protected String transStatusReason;             // Required if transStatus = N, U or R and messageCategory = 01

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
     * Gets the value of the acsChallengeMandated property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcsChallengeMandated() {
        return acsChallengeMandated;
    }

    /**
     * Sets the value of the acsChallengeMandated property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcsChallengeMandated(String value) {
        this.acsChallengeMandated = value;
    }

    /**
     * Gets the value of the acsRenderingType property.
     * 
     * @return
     *     possible object is
     *     {@link AcsRenderingType }
     *     
     */
    public AcsRenderingType getAcsRenderingType() {
        return acsRenderingType;
    }

    /**
     * Sets the value of the acsRenderingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcsRenderingType }
     *     
     */
    public void setAcsRenderingType(AcsRenderingType value) {
        this.acsRenderingType = value;
    }

    /**
     * Gets the value of the authenticationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthenticationType() {
        return authenticationType;
    }

    /**
     * Sets the value of the authenticationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthenticationType(String value) {
        this.authenticationType = value;
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
     * Gets the value of the cardholderInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardholderInfo() {
        return cardholderInfo;
    }

    /**
     * Sets the value of the cardholderInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardholderInfo(String value) {
        this.cardholderInfo = value;
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
     * Gets the value of the transStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransStatus() {
        return transStatus;
    }

    /**
     * Sets the value of the transStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransStatus(String value) {
        this.transStatus = value;
    }

    /**
     * Gets the value of the transStatusReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransStatusReason() {
        return transStatusReason;
    }

    /**
     * Sets the value of the transStatusReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransStatusReason(String value) {
        this.transStatusReason = value;
    }

}
