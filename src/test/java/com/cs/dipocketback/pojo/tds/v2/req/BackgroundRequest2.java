package com.cs.dipocketback.pojo.tds.v2.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;choice&gt;
 *           &lt;element name="backgroundAReq" type="{https://www.todouri.com/req}backgroundAReq"/&gt;
 *           &lt;element name="backgroundCReq" type="{https://www.todouri.com/req}backgroundCReq"/&gt;
 *         &lt;/choice&gt;
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
        "backgroundAReq",
        "backgroundCReq"
})
@XmlRootElement(name = "backgroundRequest2")
public class BackgroundRequest2 {

    protected BackgroundAReq backgroundAReq;
    protected BackgroundCReq backgroundCReq;

    /**
     * Gets the value of the backgroundAReq property.
     * 
     * @return
     *     possible object is
     *     {@link BackgroundAReq }
     *     
     */
    public BackgroundAReq getBackgroundAReq() {
        return backgroundAReq;
    }

    /**
     * Sets the value of the backgroundAReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link BackgroundAReq }
     *     
     */
    public void setBackgroundAReq(BackgroundAReq value) {
        this.backgroundAReq = value;
    }

    /**
     * Gets the value of the backgroundCReq property.
     * 
     * @return
     *     possible object is
     *     {@link BackgroundCReq }
     *     
     */
    public BackgroundCReq getBackgroundCReq() {
        return backgroundCReq;
    }

    /**
     * Sets the value of the backgroundCReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link BackgroundCReq }
     *     
     */
    public void setBackgroundCReq(BackgroundCReq value) {
        this.backgroundCReq = value;
    }

}
