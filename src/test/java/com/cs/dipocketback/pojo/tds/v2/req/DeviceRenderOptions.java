
package com.cs.dipocketback.pojo.tds.v2.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for deviceRenderOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deviceRenderOptions"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sdkInterface" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sdkUiType"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="uiType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deviceRenderOptions", propOrder = {
    "sdkInterface",
    "sdkUiType"
})
public class DeviceRenderOptions {

    @XmlElement(required = true)
    protected String sdkInterface;
    @XmlElement(required = true)
    protected SdkUiType sdkUiType;

    /**
     * Gets the value of the sdkInterface property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSdkInterface() {
        return sdkInterface;
    }

    /**
     * Sets the value of the sdkInterface property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSdkInterface(String value) {
        this.sdkInterface = value;
    }

    /**
     * Gets the value of the sdkUiType property.
     * 
     * @return
     *     possible object is
     *     {@link SdkUiType }
     *     
     */
    public SdkUiType getSdkUiType() {
        return sdkUiType;
    }

    /**
     * Sets the value of the sdkUiType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SdkUiType }
     *     
     */
    public void setSdkUiType(SdkUiType value) {
        this.sdkUiType = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="uiType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "uiType"
    })
    public static class SdkUiType {

        @XmlElement(required = true)
        protected List<String> uiType;

        /**
         * Gets the value of the uiType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the uiType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUiType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getUiType() {
            if (uiType == null) {
                uiType = new ArrayList<String>();
            }
            return this.uiType;
        }

    }

}
