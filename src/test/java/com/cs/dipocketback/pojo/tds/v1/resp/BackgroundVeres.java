//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.01.09 at 01:24:14 PM EET 
//


package com.cs.dipocketback.pojo.tds.v1.resp;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "backgroundVeres", propOrder = {
    "chName",
    "enrollStatus",
    "enrollStatusCode",
    "error",
    "extension"
})
public class BackgroundVeres {

    @XmlElement(required = true)
    protected String chName;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String enrollStatus;
    @XmlElement(required = true)
    protected String enrollStatusCode;
    @XmlElement(required = true)
    protected Error error;
    @XmlElement(name = "Extension")
    protected Extension extension;

    public String getChName() {
        return chName;
    }

    public void setChName(String value) {
        this.chName = value;
    }

    public String getEnrollStatus() {
        return enrollStatus;
    }

    public void setEnrollStatus(String value) {
        this.enrollStatus = value;
    }

    public String getEnrollStatusCode() {
        return enrollStatusCode;
    }

    public void setEnrollStatusCode(String value) {
        this.enrollStatusCode = value;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error value) {
        this.error = value;
    }

    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension value) {
        this.extension = value;
    }
}
