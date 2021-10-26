
package com.cs.dipocketback.pojo.tds.v2.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for threeDSRequestorPriorAuthenticationInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="threeDSRequestorPriorAuthenticationInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="threeDSReqPriorRef" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="threeDSReqPriorAuthMethod" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="threeDSReqPriorAuthTimestamp" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="threeDSReqPriorAuthData" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "threeDSRequestorPriorAuthenticationInfo", propOrder = {
    "threeDSReqPriorRef",
    "threeDSReqPriorAuthMethod",
    "threeDSReqPriorAuthTimestamp",
    "threeDSReqPriorAuthData"
})
public class ThreeDSRequestorPriorAuthenticationInfo {

    @XmlElement(required = true)
    protected String threeDSReqPriorRef;
    @XmlElement(required = true)
    protected String threeDSReqPriorAuthMethod;
    @XmlElement(required = true)
    protected String threeDSReqPriorAuthTimestamp;
    @XmlElement(required = true)
    protected String threeDSReqPriorAuthData;

    /**
     * Gets the value of the threeDSReqPriorRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeDSReqPriorRef() {
        return threeDSReqPriorRef;
    }

    /**
     * Sets the value of the threeDSReqPriorRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeDSReqPriorRef(String value) {
        this.threeDSReqPriorRef = value;
    }

    /**
     * Gets the value of the threeDSReqPriorAuthMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeDSReqPriorAuthMethod() {
        return threeDSReqPriorAuthMethod;
    }

    /**
     * Sets the value of the threeDSReqPriorAuthMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeDSReqPriorAuthMethod(String value) {
        this.threeDSReqPriorAuthMethod = value;
    }

    /**
     * Gets the value of the threeDSReqPriorAuthTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeDSReqPriorAuthTimestamp() {
        return threeDSReqPriorAuthTimestamp;
    }

    /**
     * Sets the value of the threeDSReqPriorAuthTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeDSReqPriorAuthTimestamp(String value) {
        this.threeDSReqPriorAuthTimestamp = value;
    }

    /**
     * Gets the value of the threeDSReqPriorAuthData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThreeDSReqPriorAuthData() {
        return threeDSReqPriorAuthData;
    }

    /**
     * Sets the value of the threeDSReqPriorAuthData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThreeDSReqPriorAuthData(String value) {
        this.threeDSReqPriorAuthData = value;
    }

}
