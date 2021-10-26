package com.cs.dipocketback.pojo.tds.v1.resp;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "backgroundVeres",
    "backgroundPares",
    "backgroundPageRequest"
})
@XmlRootElement(name = "backgroundResponse")
public class BackgroundResponse {

    @XmlElement(required = true)
    protected BackgroundVeres backgroundVeres;
    @XmlElement(required = true)
    protected BackgroundPares backgroundPares;
    @XmlElement(required = true)
    protected BackgroundPageRequest backgroundPageRequest;

    public BackgroundVeres getBackgroundVeres() {
        return backgroundVeres;
    }

    public void setBackgroundVeres(BackgroundVeres value) {
        this.backgroundVeres = value;
    }

    public BackgroundPares getBackgroundPares() {
        return backgroundPares;
    }

    public void setBackgroundPares(BackgroundPares value) {
        this.backgroundPares = value;
    }

    public BackgroundPageRequest getBackgroundPageRequest() {
        return backgroundPageRequest;
    }

    public void setBackgroundPageRequest(BackgroundPageRequest value) {
        this.backgroundPageRequest = value;
    }

}
