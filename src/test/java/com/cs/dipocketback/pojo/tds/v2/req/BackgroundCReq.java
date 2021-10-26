
package com.cs.dipocketback.pojo.tds.v2.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for backgroundCReq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="backgroundCReq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="acsTransID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="challengeCancel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="challengeDataEntry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="challengeHTMLDataEntry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="challengeWindowSize" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="messageExtension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="messageType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="messageVersion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="oobContinue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="resendChallenge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sdkTransID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sdkCounterStoA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="backgroundPageResponse" type="{https://www.todouri.com/req}backgroundPageResponse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "backgroundCReq", propOrder = {
    "acsTransID",
    "challengeCancel",
    "challengeDataEntry",
    "challengeHTMLDataEntry",
    "challengeWindowSize",
    "messageExtension",
    "messageType",
    "messageVersion",
    "oobContinue",
    "resendChallenge",
    "sdkTransID",
    "sdkCounterStoA",
    "backgroundPageResponse"
})
public class BackgroundCReq {

    @XmlElement(required = true)
    protected String acsTransID;
    protected String challengeCancel;
    protected String challengeDataEntry;
    protected String challengeHTMLDataEntry;
    protected String challengeWindowSize;
//    protected String messageExtension;
    protected MessageExtension messageExtension;
    @XmlElement(required = true)
    protected String messageType;
    @XmlElement(required = true)
    protected String messageVersion;
    protected String oobContinue;
    protected String resendChallenge;
    protected String sdkTransID;
    protected String sdkCounterStoA;
    protected BackgroundPageResponse backgroundPageResponse;

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
     * Gets the value of the challengeCancel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChallengeCancel() {
        return challengeCancel;
    }

    /**
     * Sets the value of the challengeCancel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChallengeCancel(String value) {
        this.challengeCancel = value;
    }

    /**
     * Gets the value of the challengeDataEntry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChallengeDataEntry() {
        return challengeDataEntry;
    }

    /**
     * Sets the value of the challengeDataEntry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChallengeDataEntry(String value) {
        this.challengeDataEntry = value;
    }

    /**
     * Gets the value of the challengeHTMLDataEntry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChallengeHTMLDataEntry() {
        return challengeHTMLDataEntry;
    }

    /**
     * Sets the value of the challengeHTMLDataEntry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChallengeHTMLDataEntry(String value) {
        this.challengeHTMLDataEntry = value;
    }

    /**
     * Gets the value of the challengeWindowSize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChallengeWindowSize() {
        return challengeWindowSize;
    }

    /**
     * Sets the value of the challengeWindowSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChallengeWindowSize(String value) {
        this.challengeWindowSize = value;
    }

    /**
     * Gets the value of the messageExtension property.
     * 
     * @return
     *     possible object is
     *     {@link String }
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
     *     {@link String }
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
     * Gets the value of the oobContinue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOobContinue() {
        return oobContinue;
    }

    /**
     * Sets the value of the oobContinue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOobContinue(String value) {
        this.oobContinue = value;
    }

    /**
     * Gets the value of the resendChallenge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResendChallenge() {
        return resendChallenge;
    }

    /**
     * Sets the value of the resendChallenge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResendChallenge(String value) {
        this.resendChallenge = value;
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
     * Gets the value of the sdkCounterStoA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSdkCounterStoA() {
        return sdkCounterStoA;
    }

    /**
     * Sets the value of the sdkCounterStoA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSdkCounterStoA(String value) {
        this.sdkCounterStoA = value;
    }

    /**
     * Gets the value of the backgroundPageResponse property.
     * 
     * @return
     *     possible object is
     *     {@link BackgroundPageResponse }
     *     
     */
    public BackgroundPageResponse getBackgroundPageResponse() {
        return backgroundPageResponse;
    }

    /**
     * Sets the value of the backgroundPageResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link BackgroundPageResponse }
     *     
     */
    public void setBackgroundPageResponse(BackgroundPageResponse value) {
        this.backgroundPageResponse = value;
    }

}
