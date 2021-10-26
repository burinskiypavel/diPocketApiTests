
package com.cs.dipocketback.pojo.tds.v2.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for psImage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="psImage"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="medium" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="high" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="extraHigh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "psImage", propOrder = {
    "medium",
    "high",
    "extraHigh"
})
public class PsImage {

    protected String medium;
    protected String high;
    protected String extraHigh;

    /**
     * Gets the value of the medium property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedium() {
        return medium;
    }

    /**
     * Sets the value of the medium property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedium(String value) {
        this.medium = value;
    }

    /**
     * Gets the value of the high property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHigh() {
        return high;
    }

    /**
     * Sets the value of the high property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHigh(String value) {
        this.high = value;
    }

    /**
     * Gets the value of the extraHigh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtraHigh() {
        return extraHigh;
    }

    /**
     * Sets the value of the extraHigh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtraHigh(String value) {
        this.extraHigh = value;
    }

}
