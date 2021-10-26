package com.cs.dipocketback.pojo.tds.v1.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "backgroundPageRequest", propOrder = {
    "dataStatus",
    "pageId",
    "values",
    "error"
})
public class BackgroundPageRequest {

    @XmlElement(required = true)
    protected String dataStatus;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String pageId;
    @XmlElement(required = true)
    protected Values values;
    @XmlElement(required = true)
    protected Error error;

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String value) {
        this.dataStatus = value;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String value) {
        this.pageId = value;
    }

    public Values getValues() {
        return values;
    }

    public void setValues(Values value) {
        this.values = value;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error value) {
        this.error = value;
    }
}
