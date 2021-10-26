package com.cs.dipocketback.pojo.communicationtile;

import java.util.List;

public class CommunicationTileList {
    
    private List<CommunicationTile> communicationTileList;
    private Long unreadMessageCount;
    
    public CommunicationTileList() {
    }

    public CommunicationTileList(List<CommunicationTile> communicationTileList) {
        this.communicationTileList = communicationTileList;
    }

    public void setCommunicationTileList(List<CommunicationTile> communicationTileList) {
        this.communicationTileList = communicationTileList;
    }

    public List<CommunicationTile> getCommunicationTileList() {
        return communicationTileList;
    }

    public void setUnreadMessageCount(Long unreadMessageCount) {
        this.unreadMessageCount = unreadMessageCount;
    }

    public Long getUnreadMessageCount() {
        return unreadMessageCount;
    }
}
