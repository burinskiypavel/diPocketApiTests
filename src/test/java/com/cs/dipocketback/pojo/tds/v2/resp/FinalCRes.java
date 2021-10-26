
package com.cs.dipocketback.pojo.tds.v2.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FinalCRes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FinalCRes"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="acsTransID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="messageExtension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="messageType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="messageVersion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="transStatus" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="transStatusReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="authenticationMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="authenticationType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinalCRes", propOrder = {
    "acsTransID",
    "messageExtension",
    "messageType",
    "messageVersion",
    "transStatus",
    "transStatusReason",
    "challengeCompletionInd",
    "authenticationMethod",
    "authenticationType"
})
public class FinalCRes {

    @XmlElement(required = true)
    protected String acsTransID;
    protected MessageExtension messageExtension;
//    protected String messageExtension;
    @XmlElement(required = true)
    protected String messageType;
    @XmlElement(required = true)
    protected String messageVersion;
    @XmlElement(required = true)
    protected String transStatus;
    protected String transStatusReason;
    protected String authenticationMethod;
    protected String authenticationType;

    // custom field
    protected String challengeCompletionInd;

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

    /**
     * Gets the value of the authenticationMethod property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAuthenticationMethod() {
        return authenticationMethod;
    }

    /**
     * Sets the value of the authenticationMethod property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAuthenticationMethod(String value) {
        this.authenticationMethod = value;
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

    public String getChallengeCompletionInd() {
        return challengeCompletionInd;
    }

    public void setChallengeCompletionInd(String challengeCompletionInd) {
        this.challengeCompletionInd = challengeCompletionInd;
    }
}
