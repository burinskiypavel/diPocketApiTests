package com.cs.dipocketback.pojo.gps;

import java.sql.Timestamp;

public class GpsCardToConvert {
    
    private Long wsId;
    private Long id;
    private Long accountId;
    private Integer typeId;
    private String publicToken;
    private Timestamp convertDate;
    private Long applyFee;
    private Integer securityCode;
    private Integer activateIfnot;
    private Integer authType;
    private Boolean generatePin;
    private Long clientId;
    
    public GpsCardToConvert() {
    }

    public GpsCardToConvert(Long wsId, 
                            Long id, 
                            Long accountId, 
                            Integer typeId, 
                            String publicToken,
                            Timestamp convertDate, 
                            Long applyFee, 
                            Integer securityCode, 
                            Integer activateIfnot,
                            Integer authType, 
                            Boolean generatePin,
                            Long clientId) {
        this.wsId = wsId;
        this.id = id;
        this.accountId = accountId;
        this.typeId = typeId;
        this.publicToken = publicToken;
        this.convertDate = convertDate;
        this.applyFee = applyFee;
        this.securityCode = securityCode;
        this.activateIfnot = activateIfnot;
        this.authType = authType;
        this.generatePin = generatePin;
        this.clientId = clientId;
    }

    public Long getWsId() {
        return wsId;
    }

    public Long getId() {
        return id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public Timestamp getConvertDate() {
        return convertDate;
    }

    public Long getApplyFee() {
        return applyFee;
    }

    public Integer getSecurityCode() {
        return securityCode;
    }

    public Integer getActivateIfnot() {
        return activateIfnot;
    }

    public Integer getAuthType() {
        return authType;
    }

    public Boolean isGeneratePin() {
        return generatePin;
    }

    public Long getClientId() {
        return clientId;
    }

}
