
package com.cs.dipocketback.pojo.tds.v2.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for backgroundCRes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="backgroundCRes"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="InProgressCRes" type="{https://www.todouri.com/resp}InProgressCRes"/&gt;
 *           &lt;element name="FinalCRes" type="{https://www.todouri.com/resp}FinalCRes"/&gt;
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
@XmlType(name = "backgroundCRes", propOrder = {
    "inProgressCRes",
    "finalCRes"
})
public class BackgroundCRes {

    @XmlElement(name = "InProgressCRes")
    protected InProgressCRes inProgressCRes;
    @XmlElement(name = "FinalCRes")
    protected FinalCRes finalCRes;

    /**
     * Gets the value of the inProgressCRes property.
     * 
     * @return
     *     possible object is
     *     {@link InProgressCRes }
     *     
     */
    public InProgressCRes getInProgressCRes() {
        return inProgressCRes;
    }

    /**
     * Sets the value of the inProgressCRes property.
     * 
     * @param value
     *     allowed object is
     *     {@link InProgressCRes }
     *     
     */
    public void setInProgressCRes(InProgressCRes value) {
        this.inProgressCRes = value;
    }

    /**
     * Gets the value of the finalCRes property.
     * 
     * @return
     *     possible object is
     *     {@link FinalCRes }
     *     
     */
    public FinalCRes getFinalCRes() {
        return finalCRes;
    }

    /**
     * Sets the value of the finalCRes property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinalCRes }
     *     
     */
    public void setFinalCRes(FinalCRes value) {
        this.finalCRes = value;
    }

}
