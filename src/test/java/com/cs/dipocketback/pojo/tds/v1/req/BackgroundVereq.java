package com.cs.dipocketback.pojo.tds.v1.req;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "backgroundVereq", propOrder = {
    "txId",
    "pan",
    "panSha256",
    "acqBIN",
    "merID",
    "deviceCategory",
    "userAgent",
    "messageId",
    "extension"
})
public class BackgroundVereq {

//    protected String txId;
//    protected String pan;
//    protected String panSha256;
//    protected String acqBIN;
//    protected String merID;
//    protected String deviceCategory;
//    protected String userAgent;
//    protected String messageId;
//    @XmlElement(name = "Extension")
//    protected Extension extension;

    @XmlElement(required = true)
    protected String txId;
    protected String pan;
//    @XmlElement(type = String.class)
//    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
//    @XmlSchemaType(name = "hexBinary")
//    protected byte[] panSha256;

    protected String panSha256;
    @XmlElement(required = true)
    protected String acqBIN;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String merID;
    @XmlElement(required = true)
    protected String deviceCategory;
    @XmlElement(required = true)
    protected String userAgent;
    @XmlElement(required = true)
    protected String messageId;
    @XmlElement(name = "Extension")
    protected Extension extension;

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPanSha256() {
        return panSha256;
    }

    public void setPanSha256(String panSha256) {
        this.panSha256 = panSha256;
    }

    public String getAcqBIN() {
        return acqBIN;
    }

    public void setAcqBIN(String acqBIN) {
        this.acqBIN = acqBIN;
    }

    public String getMerID() {
        return merID;
    }

    public void setMerID(String merID) {
        this.merID = merID;
    }

    public String getDeviceCategory() {
        return deviceCategory;
    }

    public void setDeviceCategory(String deviceCategory) {
        this.deviceCategory = deviceCategory;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }
}
