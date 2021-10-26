
package com.cs.dipocketback.pojo.tds.v2.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for threeDSRequestorAuthenticationInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="threeDSRequestorAuthenticationInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="threeDSReqAuthMethod" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="threeDSReqAuthTimestamp" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="threeDSReqAuthData" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "threeDSRequestorAuthenticationInfo", propOrder = {
    "threeDSReqAuthMethod",
    "threeDSReqAuthTimestamp",
    "threeDSReqAuthData"
})
public class ThreeDSRequestorAuthenticationInfo {

    @XmlElement(required = true)
    protected String threeDSReqAuthMethod;
    @XmlElement(required = true)
    protected String threeDSReqAuthTimestamp;
    @XmlElement(required = true)
    protected String threeDSReqAuthData;

    /**
     * Gets the value of the threeDSReqAuthMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeDSReqAuthMethod() {
        return threeDSReqAuthMethod;
    }

    /**
     * Sets the value of the threeDSReqAuthMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeDSReqAuthMethod(String value) {
        this.threeDSReqAuthMethod = value;
    }

    /**
     * Gets the value of the threeDSReqAuthTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeDSReqAuthTimestamp() {
        return threeDSReqAuthTimestamp;
    }

    /**
     * Sets the value of the threeDSReqAuthTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeDSReqAuthTimestamp(String value) {
        this.threeDSReqAuthTimestamp = value;
    }

    /**
     * Gets the value of the threeDSReqAuthData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeDSReqAuthData() {
        return threeDSReqAuthData;
    }

    /**
     * Sets the value of the threeDSReqAuthData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeDSReqAuthData(String value) {
        this.threeDSReqAuthData = value;
    }

}
