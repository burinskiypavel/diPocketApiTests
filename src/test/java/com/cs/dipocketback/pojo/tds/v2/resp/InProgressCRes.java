
package com.cs.dipocketback.pojo.tds.v2.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InProgressCRes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InProgressCRes"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="acsTransID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="acsCounterAtoS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="acsUiType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="challengeAddInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="challengeInfoHeader" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="challengeInfoLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="challengeInfoText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="challengeInfoTextIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="challengeSelectInfo" type="{https://www.todouri.com/resp}challengeSelectInfo" minOccurs="0"/&gt;
 *         &lt;element name="expandInfoLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="expandInfoText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="issuerImage" type="{https://www.todouri.com/resp}issuerImage" minOccurs="0"/&gt;
 *         &lt;element name="psImage" type="{https://www.todouri.com/resp}psImage" minOccurs="0"/&gt;
 *         &lt;element name="messageExtension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="messageType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="messageVersion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="oobAppURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="oobAppLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="oobContinueLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="resendInformationLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="submitAuthenticationLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="whyInfoLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="whyInfoText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="backgroundPageRequest" type="{https://www.todouri.com/resp}backgroundPageRequest" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InProgressCRes", propOrder = {
    "acsTransID",
    "acsCounterAtoS",
    "acsUiType",
    "challengeAddInfo",
    "challengeInfoHeader",
    "challengeInfoLabel",
    "challengeInfoText",
    "challengeInfoTextIndicator",
    "challengeSelectInfo",
    "expandInfoLabel",
    "expandInfoText",
    "issuerImage",
    "psImage",
    "messageExtension",
    "messageType",
    "messageVersion",
    "oobAppURL",
    "oobAppLabel",
    "oobContinueLabel",
    "resendInformationLabel",
    "submitAuthenticationLabel",
    "whyInfoLabel",
    "whyInfoText",
    "backgroundPageRequest",
    "challengeCompletionInd"
})
public class InProgressCRes {

    @XmlElement(required = true)
    protected String acsTransID;
    protected String acsCounterAtoS;
    protected String acsUiType;
    protected String challengeAddInfo;
    protected String challengeInfoHeader;
    protected String challengeInfoLabel;
    protected String challengeInfoText;
    protected String challengeInfoTextIndicator;
    protected ChallengeSelectInfo challengeSelectInfo;
    protected String expandInfoLabel;
    protected String expandInfoText;
    protected IssuerImage issuerImage;
    protected PsImage psImage;
    protected MessageExtension messageExtension;
    @XmlElement(required = true)
    protected String messageType;
    @XmlElement(required = true)
    protected String messageVersion;
    protected String oobAppURL;
    protected String oobAppLabel;
    protected String oobContinueLabel;
    protected String resendInformationLabel;
    protected String submitAuthenticationLabel;
    protected String whyInfoLabel;
    protected String whyInfoText;
    protected BackgroundPageRequest backgroundPageRequest;

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
     * Gets the value of the acsCounterAtoS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcsCounterAtoS() {
        return acsCounterAtoS;
    }

    /**
     * Sets the value of the acsCounterAtoS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcsCounterAtoS(String value) {
        this.acsCounterAtoS = value;
    }

    /**
     * Gets the value of the acsUiType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcsUiType() {
        return acsUiType;
    }

    /**
     * Sets the value of the acsUiType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcsUiType(String value) {
        this.acsUiType = value;
    }

    /**
     * Gets the value of the challengeAddInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChallengeAddInfo() {
        return challengeAddInfo;
    }

    /**
     * Sets the value of the challengeAddInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChallengeAddInfo(String value) {
        this.challengeAddInfo = value;
    }

    /**
     * Gets the value of the challengeInfoHeader property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChallengeInfoHeader() {
        return challengeInfoHeader;
    }

    /**
     * Sets the value of the challengeInfoHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChallengeInfoHeader(String value) {
        this.challengeInfoHeader = value;
    }

    /**
     * Gets the value of the challengeInfoLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChallengeInfoLabel() {
        return challengeInfoLabel;
    }

    /**
     * Sets the value of the challengeInfoLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChallengeInfoLabel(String value) {
        this.challengeInfoLabel = value;
    }

    /**
     * Gets the value of the challengeInfoText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChallengeInfoText() {
        return challengeInfoText;
    }

    /**
     * Sets the value of the challengeInfoText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChallengeInfoText(String value) {
        this.challengeInfoText = value;
    }

    /**
     * Gets the value of the challengeInfoTextIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChallengeInfoTextIndicator() {
        return challengeInfoTextIndicator;
    }

    /**
     * Sets the value of the challengeInfoTextIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChallengeInfoTextIndicator(String value) {
        this.challengeInfoTextIndicator = value;
    }

    /**
     * Gets the value of the challengeSelectInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ChallengeSelectInfo }
     *     
     */
    public ChallengeSelectInfo getChallengeSelectInfo() {
        return challengeSelectInfo;
    }

    /**
     * Sets the value of the challengeSelectInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChallengeSelectInfo }
     *     
     */
    public void setChallengeSelectInfo(ChallengeSelectInfo value) {
        this.challengeSelectInfo = value;
    }

    /**
     * Gets the value of the expandInfoLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpandInfoLabel() {
        return expandInfoLabel;
    }

    /**
     * Sets the value of the expandInfoLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpandInfoLabel(String value) {
        this.expandInfoLabel = value;
    }

    /**
     * Gets the value of the expandInfoText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpandInfoText() {
        return expandInfoText;
    }

    /**
     * Sets the value of the expandInfoText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpandInfoText(String value) {
        this.expandInfoText = value;
    }

    /**
     * Gets the value of the issuerImage property.
     * 
     * @return
     *     possible object is
     *     {@link IssuerImage }
     *     
     */
    public IssuerImage getIssuerImage() {
        return issuerImage;
    }

    /**
     * Sets the value of the issuerImage property.
     * 
     * @param value
     *     allowed object is
     *     {@link IssuerImage }
     *     
     */
    public void setIssuerImage(IssuerImage value) {
        this.issuerImage = value;
    }

    /**
     * Gets the value of the psImage property.
     * 
     * @return
     *     possible object is
     *     {@link PsImage }
     *     
     */
    public PsImage getPsImage() {
        return psImage;
    }

    /**
     * Sets the value of the psImage property.
     * 
     * @param value
     *     allowed object is
     *     {@link PsImage }
     *     
     */
    public void setPsImage(PsImage value) {
        this.psImage = value;
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
     * Gets the value of the oobAppURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOobAppURL() {
        return oobAppURL;
    }

    /**
     * Sets the value of the oobAppURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOobAppURL(String value) {
        this.oobAppURL = value;
    }

    /**
     * Gets the value of the oobAppLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOobAppLabel() {
        return oobAppLabel;
    }

    /**
     * Sets the value of the oobAppLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOobAppLabel(String value) {
        this.oobAppLabel = value;
    }

    /**
     * Gets the value of the oobContinueLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOobContinueLabel() {
        return oobContinueLabel;
    }

    /**
     * Sets the value of the oobContinueLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOobContinueLabel(String value) {
        this.oobContinueLabel = value;
    }

    /**
     * Gets the value of the resendInformationLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResendInformationLabel() {
        return resendInformationLabel;
    }

    /**
     * Sets the value of the resendInformationLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResendInformationLabel(String value) {
        this.resendInformationLabel = value;
    }

    /**
     * Gets the value of the submitAuthenticationLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmitAuthenticationLabel() {
        return submitAuthenticationLabel;
    }

    /**
     * Sets the value of the submitAuthenticationLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmitAuthenticationLabel(String value) {
        this.submitAuthenticationLabel = value;
    }

    /**
     * Gets the value of the whyInfoLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWhyInfoLabel() {
        return whyInfoLabel;
    }

    /**
     * Sets the value of the whyInfoLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWhyInfoLabel(String value) {
        this.whyInfoLabel = value;
    }

    /**
     * Gets the value of the whyInfoText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWhyInfoText() {
        return whyInfoText;
    }

    /**
     * Sets the value of the whyInfoText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWhyInfoText(String value) {
        this.whyInfoText = value;
    }

    /**
     * Gets the value of the backgroundPageRequest property.
     * 
     * @return
     *     possible object is
     *     {@link BackgroundPageRequest }
     *     
     */
    public BackgroundPageRequest getBackgroundPageRequest() {
        return backgroundPageRequest;
    }

    /**
     * Sets the value of the backgroundPageRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link BackgroundPageRequest }
     *     
     */
    public void setBackgroundPageRequest(BackgroundPageRequest value) {
        this.backgroundPageRequest = value;
    }

    public String getChallengeCompletionInd() {
        return challengeCompletionInd;
    }

    public void setChallengeCompletionInd(String challengeCompletionInd) {
        this.challengeCompletionInd = challengeCompletionInd;
    }
}
