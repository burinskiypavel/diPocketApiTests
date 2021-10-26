package com.cs.dipocketback.pojo.rsa;

public class OobLine {
    
    private Long fileId;
    private String publicToken;
    private String oobType;
    private String countryCode;
    private String oobNumber;
    private Long updateDat;
    
    public OobLine() {
    }

    public OobLine(Long fileId, 
                   String publicToken, 
                   String oobType, 
                   String countryCode, 
                   String oobNumber,
                   Long updateDat) {
        this.fileId = fileId;
        this.publicToken = publicToken;
        this.oobType = oobType;
        this.countryCode = countryCode;
        this.oobNumber = oobNumber;
        this.updateDat = updateDat;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setOobType(String oobType) {
        this.oobType = oobType;
    }

    public String getOobType() {
        return oobType;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setOobNumber(String oobNumber) {
        this.oobNumber = oobNumber;
    }

    public String getOobNumber() {
        return oobNumber;
    }

    public void setUpdateDat(Long updateDat) {
        this.updateDat = updateDat;
    }

    public Long getUpdateDat() {
        return updateDat;
    }
    
}
