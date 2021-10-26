package com.cs.dipocketback.pojo.communicationtile;

////import com.fasterxml.jackson.annotation.JsonProperty;

public class CommunicationTile {
    
    public static final Long SUPERVISOR_INVITATION_TILE = 200L;
    
    private Long reqTypeId;
    private Long priority;
    private Long doBlock;
    private String message;
    private String shortName;
    private Long linkId;
    private Boolean isRead;
    private Long cTileId;
    
    public CommunicationTile() {
    }

    public CommunicationTile(Long reqTypeId,
                             Long priority,
                             Long doBlock,
                             String message,
                             String shortName,
                             Long linkId,
                             Boolean isRead,
                             Long cTileId) {
        this.reqTypeId = reqTypeId;
        this.priority = priority;
        this.doBlock = doBlock;
        this.message = message;
        this.shortName = shortName;
        this.linkId = linkId;
        this.isRead = isRead;
        this.cTileId = cTileId;
    }

    public void setReqTypeId(Long reqTypeId) {
        this.reqTypeId = reqTypeId;
    }

    public Long getReqTypeId() {
        return reqTypeId;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Long getPriority() {
        return priority;
    }

    public void setDoBlock(Long doBlock) {
        this.doBlock = doBlock;
    }

    public Long getDoBlock() {
        return doBlock;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    public Long getLinkId() {
        return linkId;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setCTileId(Long ctileId) {
        this.cTileId = ctileId;
    }

    ////@JsonProperty("cTileId")
    public Long getCTileId() {
        return cTileId;
    }

}
