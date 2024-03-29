
package com.cs.dipocketback.pojo.tds.v2.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for acsRenderingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="acsRenderingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="acsInterface" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="acsUiTemplate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acsRenderingType", propOrder = {
    "acsInterface",
    "acsUiTemplate"
})
public class AcsRenderingType {

    @XmlElement(required = true)
    protected String acsInterface;
    @XmlElement(required = true)
    protected String acsUiTemplate;

    /**
     * Gets the value of the acsInterface property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcsInterface() {
        return acsInterface;
    }

    /**
     * Sets the value of the acsInterface property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcsInterface(String value) {
        this.acsInterface = value;
    }

    /**
     * Gets the value of the acsUiTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcsUiTemplate() {
        return acsUiTemplate;
    }

    /**
     * Sets the value of the acsUiTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcsUiTemplate(String value) {
        this.acsUiTemplate = value;
    }

}
