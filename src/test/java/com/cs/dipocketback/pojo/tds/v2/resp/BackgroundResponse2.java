
package com.cs.dipocketback.pojo.tds.v2.resp;

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
 *           &lt;element name="backgroundARes" type="{https://www.todouri.com/resp}backgroundARes"/&gt;
 *           &lt;element name="backgroundCRes" type="{https://www.todouri.com/resp}backgroundCRes"/&gt;
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
    "backgroundARes",
    "backgroundCRes"
})
@XmlRootElement(name = "backgroundResponse2")
public class BackgroundResponse2 {

    protected BackgroundARes backgroundARes;
    protected BackgroundCRes backgroundCRes;

    /**
     * Gets the value of the backgroundARes property.
     * 
     * @return
     *     possible object is
     *     {@link BackgroundARes }
     *     
     */
    public BackgroundARes getBackgroundARes() {
        return backgroundARes;
    }

    /**
     * Sets the value of the backgroundARes property.
     * 
     * @param value
     *     allowed object is
     *     {@link BackgroundARes }
     *     
     */
    public void setBackgroundARes(BackgroundARes value) {
        this.backgroundARes = value;
    }

    /**
     * Gets the value of the backgroundCRes property.
     * 
     * @return
     *     possible object is
     *     {@link BackgroundCRes }
     *     
     */
    public BackgroundCRes getBackgroundCRes() {
        return backgroundCRes;
    }

    /**
     * Sets the value of the backgroundCRes property.
     * 
     * @param value
     *     allowed object is
     *     {@link BackgroundCRes }
     *     
     */
    public void setBackgroundCRes(BackgroundCRes value) {
        this.backgroundCRes = value;
    }

}
