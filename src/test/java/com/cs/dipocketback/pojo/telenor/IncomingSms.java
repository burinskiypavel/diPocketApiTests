package com.cs.dipocketback.pojo.telenor;

public class IncomingSms {
    
    private String sourceAddress;
    private String destinationAddress;
    private Long dataCoding;
    private String message;
    
    public IncomingSms() {
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDataCoding(Long dataCoding) {
        this.dataCoding = dataCoding;
    }

    public Long getDataCoding() {
        return dataCoding;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
