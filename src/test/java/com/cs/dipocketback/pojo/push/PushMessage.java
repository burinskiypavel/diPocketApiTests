package com.cs.dipocketback.pojo.push;

import com.cs.dipocketback.base.data.Site;

import java.util.List;

public class PushMessage {
    
    private Long id;
    private Long typeId;
    private String channel;
    private String message;
    private String typeStr;
    private String deviceUUID;
    private String deviceType;
    private String pushToken;
    private Integer urgency;
    private Long clientId;
    private String mainPhone;
    private String site;
    private Site siteEnum;
    private String recipient;
    private List<PushMessageParam> paramList;

    public PushMessage() {
    }

    public PushMessage(Long id, 
                       Long typeId, 
                       String channel, 
                       String message, 
                       String typeStr, 
                       String deviceUUID,
                       String deviceType, 
                       String pushToken, 
                       Integer urgency, 
                       Long clientId, 
                       String mainPhone,
                       String site,
                       Site siteEnum,
                       String recipient) {
        this.id = id;
        this.typeId = typeId;
        this.channel = channel;
        this.message = message;
        this.typeStr = typeStr;
        this.deviceUUID = deviceUUID;
        this.deviceType = deviceType;
        this.pushToken = pushToken;
        this.urgency = urgency;
        this.clientId = clientId;
        this.mainPhone = mainPhone;
        this.site = site;
        this.siteEnum = siteEnum;
        this.recipient = recipient;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannel() {
        return channel;
    }
    
    public PushChannelType getChannelType() {
        return PushChannelType.findByChannel(channel);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }

    public String getTypeStr() {
        return typeStr;
    }

    public void setDeviceUUID(String deviceUUID) {
        this.deviceUUID = deviceUUID;
    }

    public String getDeviceUUID() {
        return deviceUUID;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

    public String getPushToken() {
        return pushToken;
    }

    public void setUrgency(Integer urgency) {
        this.urgency = urgency;
    }

    public Integer getUrgency() {
        return urgency;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    public String getMainPhone() {
        return mainPhone;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSite() {
        return site;
    }

    public void setSiteEnum(Site siteEnum) {
        this.siteEnum = siteEnum;
    }

    public Site getSiteEnum() {
        return siteEnum;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setParamList(List<PushMessageParam> paramList) {
        this.paramList = paramList;
    }

    public List<PushMessageParam> getParamList() {
        return paramList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PushMessage{");
        sb.append("id=").append(id);
        sb.append(", typeId=").append(typeId);
        sb.append(", channel='").append(channel).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", typeStr='").append(typeStr).append('\'');
        sb.append(", deviceUUID='").append(deviceUUID).append('\'');
        sb.append(", deviceType='").append(deviceType).append('\'');
        sb.append(", pushToken='").append(pushToken).append('\'');
        sb.append(", urgency=").append(urgency);
        sb.append(", clientId=").append(clientId);
        sb.append(", mainPhone='").append(mainPhone).append('\'');
        sb.append(", site='").append(site).append('\'');
        sb.append(", siteEnum=").append(siteEnum);
        sb.append(", recipient='").append(recipient).append('\'');

        if (paramList != null) {
            sb.append(", paramList=[").append(paramList);
            for (PushMessageParam pushMessageParam : paramList) {
                if (pushMessageParam != null) {
                    sb.append("\n\t").append(pushMessageParam.toString());
                }
            }
            sb.append("]");
        } else {
            sb.append(", paramList=null").append(paramList);
        }

        sb.append('}');
        return sb.toString();
    }

}
