package com.cs.dipocketback.pojo.tds.v1.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "backgroundVereq",
        "backgroundPareq",
        "backgroundPageResponse"
})
@XmlRootElement(name = "backgroundRequest")
public class BackgroundRequest {

    protected BackgroundVereq backgroundVereq;
    protected BackgroundPareq backgroundPareq;
    protected BackgroundPageResponse backgroundPageResponse;

    public BackgroundVereq getBackgroundVereq() {
        return backgroundVereq;
    }

    public void setBackgroundVereq(BackgroundVereq backgroundVereq) {
        this.backgroundVereq = backgroundVereq;
    }

    public BackgroundPareq getBackgroundPareq() {
        return backgroundPareq;
    }

    public void setBackgroundPareq(BackgroundPareq backgroundPareq) {
        this.backgroundPareq = backgroundPareq;
    }

    public BackgroundPageResponse getBackgroundPageResponse() {
        return backgroundPageResponse;
    }

    public void setBackgroundPageResponse(BackgroundPageResponse backgroundPageResponse) {
        this.backgroundPageResponse = backgroundPageResponse;
    }
}
