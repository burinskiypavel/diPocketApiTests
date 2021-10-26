package com.cs.dipocketback.pojo.tds.v1.req;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Extension", propOrder = {
    "value"
})
public class Extension {
    @XmlValue
    protected String value;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "critical")
    protected String critical;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    //    public Boolean getCritical() {
//        return critical;
//    }
//
//    public void setCritical(Boolean critical) {
//        this.critical = critical;
//    }
}
