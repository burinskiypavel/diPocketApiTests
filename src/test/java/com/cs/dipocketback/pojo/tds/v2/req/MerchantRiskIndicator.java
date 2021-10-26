
package com.cs.dipocketback.pojo.tds.v2.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for merchantRiskIndicator complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="merchantRiskIndicator"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="deliveryEmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="deliveryTimeframe" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="giftCardAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="giftCardCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="giftCardCurr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="preOrderDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="preOrderPurchaseInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reorderItemsInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="shipIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "merchantRiskIndicator", propOrder = {
    "deliveryEmailAddress",
    "deliveryTimeframe",
    "giftCardAmount",
    "giftCardCount",
    "giftCardCurr",
    "preOrderDate",
    "preOrderPurchaseInd",
    "reorderItemsInd",
    "shipIndicator"
})
public class MerchantRiskIndicator {

    protected String deliveryEmailAddress;
    protected String deliveryTimeframe;
    protected String giftCardAmount;
    protected String giftCardCount;
    protected String giftCardCurr;
    protected String preOrderDate;
    protected String preOrderPurchaseInd;
    protected String reorderItemsInd;
    protected String shipIndicator;

    /**
     * Gets the value of the deliveryEmailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryEmailAddress() {
        return deliveryEmailAddress;
    }

    /**
     * Sets the value of the deliveryEmailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryEmailAddress(String value) {
        this.deliveryEmailAddress = value;
    }

    /**
     * Gets the value of the deliveryTimeframe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryTimeframe() {
        return deliveryTimeframe;
    }

    /**
     * Sets the value of the deliveryTimeframe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryTimeframe(String value) {
        this.deliveryTimeframe = value;
    }

    /**
     * Gets the value of the giftCardAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGiftCardAmount() {
        return giftCardAmount;
    }

    /**
     * Sets the value of the giftCardAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGiftCardAmount(String value) {
        this.giftCardAmount = value;
    }

    /**
     * Gets the value of the giftCardCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGiftCardCount() {
        return giftCardCount;
    }

    /**
     * Sets the value of the giftCardCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGiftCardCount(String value) {
        this.giftCardCount = value;
    }

    /**
     * Gets the value of the giftCardCurr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGiftCardCurr() {
        return giftCardCurr;
    }

    /**
     * Sets the value of the giftCardCurr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGiftCardCurr(String value) {
        this.giftCardCurr = value;
    }

    /**
     * Gets the value of the preOrderDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreOrderDate() {
        return preOrderDate;
    }

    /**
     * Sets the value of the preOrderDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreOrderDate(String value) {
        this.preOrderDate = value;
    }

    /**
     * Gets the value of the preOrderPurchaseInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreOrderPurchaseInd() {
        return preOrderPurchaseInd;
    }

    /**
     * Sets the value of the preOrderPurchaseInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreOrderPurchaseInd(String value) {
        this.preOrderPurchaseInd = value;
    }

    /**
     * Gets the value of the reorderItemsInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReorderItemsInd() {
        return reorderItemsInd;
    }

    /**
     * Sets the value of the reorderItemsInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReorderItemsInd(String value) {
        this.reorderItemsInd = value;
    }

    /**
     * Gets the value of the shipIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipIndicator() {
        return shipIndicator;
    }

    /**
     * Sets the value of the shipIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipIndicator(String value) {
        this.shipIndicator = value;
    }

}
