
package com.cs.dipocketback.pojo.tds.v2.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for acctInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="acctInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="chAccAgeInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="chAccChange" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="chAccChangeInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="chAccDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="chAccPwChange" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="chAccPwChangeInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nbPurchaseAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="provisionAttemptsDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="txnActivityDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="txnActivityYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paymentAccAge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paymentAccInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="shipAddressUsage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="shipAddressUsageInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="shipNameIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="suspiciousAccActivity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acctInfo", propOrder = {
    "chAccAgeInd",
    "chAccChange",
    "chAccChangeInd",
    "chAccDate",
    "chAccPwChange",
    "chAccPwChangeInd",
    "nbPurchaseAccount",
    "provisionAttemptsDay",
    "txnActivityDay",
    "txnActivityYear",
    "paymentAccAge",
    "paymentAccInd",
    "shipAddressUsage",
    "shipAddressUsageInd",
    "shipNameIndicator",
    "suspiciousAccActivity"
})
public class AcctInfo {

    protected String chAccAgeInd;
    protected String chAccChange;
    protected String chAccChangeInd;
    protected String chAccDate;
    protected String chAccPwChange;
    protected String chAccPwChangeInd;
    protected String nbPurchaseAccount;
    protected String provisionAttemptsDay;
    protected String txnActivityDay;
    protected String txnActivityYear;
    protected String paymentAccAge;
    protected String paymentAccInd;
    protected String shipAddressUsage;
    protected String shipAddressUsageInd;
    protected String shipNameIndicator;
    protected String suspiciousAccActivity;

    /**
     * Gets the value of the chAccAgeInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChAccAgeInd() {
        return chAccAgeInd;
    }

    /**
     * Sets the value of the chAccAgeInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChAccAgeInd(String value) {
        this.chAccAgeInd = value;
    }

    /**
     * Gets the value of the chAccChange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChAccChange() {
        return chAccChange;
    }

    /**
     * Sets the value of the chAccChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChAccChange(String value) {
        this.chAccChange = value;
    }

    /**
     * Gets the value of the chAccChangeInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChAccChangeInd() {
        return chAccChangeInd;
    }

    /**
     * Sets the value of the chAccChangeInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChAccChangeInd(String value) {
        this.chAccChangeInd = value;
    }

    /**
     * Gets the value of the chAccDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChAccDate() {
        return chAccDate;
    }

    /**
     * Sets the value of the chAccDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChAccDate(String value) {
        this.chAccDate = value;
    }

    /**
     * Gets the value of the chAccPwChange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChAccPwChange() {
        return chAccPwChange;
    }

    /**
     * Sets the value of the chAccPwChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChAccPwChange(String value) {
        this.chAccPwChange = value;
    }

    /**
     * Gets the value of the chAccPwChangeInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChAccPwChangeInd() {
        return chAccPwChangeInd;
    }

    /**
     * Sets the value of the chAccPwChangeInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChAccPwChangeInd(String value) {
        this.chAccPwChangeInd = value;
    }

    /**
     * Gets the value of the nbPurchaseAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbPurchaseAccount() {
        return nbPurchaseAccount;
    }

    /**
     * Sets the value of the nbPurchaseAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbPurchaseAccount(String value) {
        this.nbPurchaseAccount = value;
    }

    /**
     * Gets the value of the provisionAttemptsDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvisionAttemptsDay() {
        return provisionAttemptsDay;
    }

    /**
     * Sets the value of the provisionAttemptsDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvisionAttemptsDay(String value) {
        this.provisionAttemptsDay = value;
    }

    /**
     * Gets the value of the txnActivityDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnActivityDay() {
        return txnActivityDay;
    }

    /**
     * Sets the value of the txnActivityDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnActivityDay(String value) {
        this.txnActivityDay = value;
    }

    /**
     * Gets the value of the txnActivityYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnActivityYear() {
        return txnActivityYear;
    }

    /**
     * Sets the value of the txnActivityYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnActivityYear(String value) {
        this.txnActivityYear = value;
    }

    /**
     * Gets the value of the paymentAccAge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentAccAge() {
        return paymentAccAge;
    }

    /**
     * Sets the value of the paymentAccAge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentAccAge(String value) {
        this.paymentAccAge = value;
    }

    /**
     * Gets the value of the paymentAccInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentAccInd() {
        return paymentAccInd;
    }

    /**
     * Sets the value of the paymentAccInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentAccInd(String value) {
        this.paymentAccInd = value;
    }

    /**
     * Gets the value of the shipAddressUsage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipAddressUsage() {
        return shipAddressUsage;
    }

    /**
     * Sets the value of the shipAddressUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipAddressUsage(String value) {
        this.shipAddressUsage = value;
    }

    /**
     * Gets the value of the shipAddressUsageInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipAddressUsageInd() {
        return shipAddressUsageInd;
    }

    /**
     * Sets the value of the shipAddressUsageInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipAddressUsageInd(String value) {
        this.shipAddressUsageInd = value;
    }

    /**
     * Gets the value of the shipNameIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipNameIndicator() {
        return shipNameIndicator;
    }

    /**
     * Sets the value of the shipNameIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipNameIndicator(String value) {
        this.shipNameIndicator = value;
    }

    /**
     * Gets the value of the suspiciousAccActivity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuspiciousAccActivity() {
        return suspiciousAccActivity;
    }

    /**
     * Sets the value of the suspiciousAccActivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuspiciousAccActivity(String value) {
        this.suspiciousAccActivity = value;
    }

}
