package com.cs.dipocketback.pojo.tds.v1.req;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "backgroundPareq", propOrder = {
        "txId",
        "pan",
        "panSha256",
        "expiry",
        "acqBIN",
        "merchant",
        "merID",
        "merchantUrl",
        "merCountry",
        "purchaseAmount",
        "formattedAmount",
        "currencyCode",
        "numericCurrencyCode",
        "exponent",
        "purchaseDesc",
        "purchaseRecurFreq",
        "purchaseRecurEnd",
        "purchaseInstallments",
        "purchaseDate",
        "channel",
        "sid",
        "xid",
        "httpAccept",
        "httpAgent",
        "cardholderIp",
        "acsKey",
        "extension"
})
public class BackgroundPareq {
    @XmlElement(required = true)
    protected String txId;
    protected String pan;
    protected String panSha256;
    @XmlElement(required = true)
    protected String expiry;
    @XmlElement(required = true)
    protected String acqBIN;
    @XmlElement(required = true)
    protected String merchant;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String merID;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String merchantUrl;
    @XmlElement(required = true)
    protected String merCountry;
    @XmlElement(required = true)
    protected String purchaseAmount;
    @XmlElement(required = true)
    protected String formattedAmount;
    @XmlElement(required = true)
    protected String currencyCode;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String numericCurrencyCode;
    @XmlElement(required = true)
    protected String exponent;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String purchaseDesc;
    @XmlElement(required = true)
    protected String purchaseRecurFreq;
    @XmlElement(required = true)
    protected String purchaseRecurEnd;
    @XmlElement(required = true)
    protected String purchaseInstallments;
    @XmlElement(required = true)
    protected String purchaseDate;
    @XmlElement(required = true)
    protected String channel;
    @XmlElement(name = "sID", required = true)
    protected String sid;
    @XmlElement(required = true)
    protected String xid;
    @XmlElement(required = true)
    protected String httpAccept;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String httpAgent;
    @XmlElement(required = true)
    protected String cardholderIp;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String acsKey;
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

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getAcqBIN() {
        return acqBIN;
    }

    public void setAcqBIN(String acqBIN) {
        this.acqBIN = acqBIN;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getMerID() {
        return merID;
    }

    public void setMerID(String merID) {
        this.merID = merID;
    }

    public String getMerchantUrl() {
        return merchantUrl;
    }

    public void setMerchantUrl(String merchantUrl) {
        this.merchantUrl = merchantUrl;
    }

    public String getMerCountry() {
        return merCountry;
    }

    public void setMerCountry(String merCountry) {
        this.merCountry = merCountry;
    }

    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public String getFormattedAmount() {
        return formattedAmount;
    }

    public void setFormattedAmount(String formattedAmount) {
        this.formattedAmount = formattedAmount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getNumericCurrencyCode() {
        return numericCurrencyCode;
    }

    public void setNumericCurrencyCode(String numericCurrencyCode) {
        this.numericCurrencyCode = numericCurrencyCode;
    }

    public String getExponent() {
        return exponent;
    }

    public void setExponent(String exponent) {
        this.exponent = exponent;
    }

    public String getPurchaseDesc() {
        return purchaseDesc;
    }

    public void setPurchaseDesc(String purchaseDesc) {
        this.purchaseDesc = purchaseDesc;
    }

    public String getPurchaseRecurFreq() {
        return purchaseRecurFreq;
    }

    public void setPurchaseRecurFreq(String purchaseRecurFreq) {
        this.purchaseRecurFreq = purchaseRecurFreq;
    }

    public String getPurchaseRecurEnd() {
        return purchaseRecurEnd;
    }

    public void setPurchaseRecurEnd(String purchaseRecurEnd) {
        this.purchaseRecurEnd = purchaseRecurEnd;
    }

    public String getPurchaseInstallments() {
        return purchaseInstallments;
    }

    public void setPurchaseInstallments(String purchaseInstallments) {
        this.purchaseInstallments = purchaseInstallments;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getHttpAccept() {
        return httpAccept;
    }

    public void setHttpAccept(String httpAccept) {
        this.httpAccept = httpAccept;
    }

    public String getHttpAgent() {
        return httpAgent;
    }

    public void setHttpAgent(String httpAgent) {
        this.httpAgent = httpAgent;
    }

    public String getCardholderIp() {
        return cardholderIp;
    }

    public void setCardholderIp(String cardholderIp) {
        this.cardholderIp = cardholderIp;
    }

    public String getAcsKey() {
        return acsKey;
    }

    public void setAcsKey(String acsKey) {
        this.acsKey = acsKey;
    }

    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }
}
