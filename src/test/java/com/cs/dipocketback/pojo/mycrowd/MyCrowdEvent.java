package com.cs.dipocketback.pojo.mycrowd;

import java.util.Date;
import java.util.List;

public class MyCrowdEvent {
    
    public static final int ACCESS_PUBLIC = 1;
    public static final int ACCESS_PALS = 2;
    public static final int ACCESS_INVITEES = 3;
    
    private static Long twoDays = 172800000l;
    private static final MyCrowdEvent stubEvent = new MyCrowdEvent(2L, "Test Event", "EUR", 978, 140000L,
                            new Date(new Date().getTime() + twoDays).getTime(), 20, Boolean.TRUE,
                            7000L, MyCrowdEvent.ACCESS_PALS, ParticipantList.getStub().getParticipants(), Boolean.FALSE,
                            70000L, 50, "ZZZ", 1L);
    
    private Long eventId;
    private String eventName;
    private String targetCcy;
    private Integer targetCcyId;
    private Long targetAmount;
    private Long collectedAmount;
    private Integer collectedPercentage;
    private Long deadLine;
    private Integer numberOfParticipants;
    private Boolean isFixedContribution;
    private Long contributionAmount;
    private Integer accessType;
    private List<Participant> participants;
    private Boolean isMyEvent;
    private String ownerName;
    private Long ownerId;
    
    public MyCrowdEvent() {
    }

    public MyCrowdEvent(Long eventId, String eventName, Boolean isMyEvent) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.isMyEvent = isMyEvent;
    }

    public MyCrowdEvent(Long eventId, String eventName, String targetCcy, Integer targetCcyId, Long targetAmount,
                        Long deadLine, Integer numberOfParticipants, Boolean isFixedContribution,
                        Long contributionAmount, Integer accessType, List<Participant> participants, Boolean isMyEvent,
                        Long collectedAmount, Integer collectedPercentage, String ownerName, Long ownerId) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.targetCcy = targetCcy;
        this.targetCcyId = targetCcyId;
        this.targetAmount = targetAmount;
        this.deadLine = deadLine;
        this.numberOfParticipants = numberOfParticipants;
        this.isFixedContribution = isFixedContribution;
        this.contributionAmount = contributionAmount;
        this.accessType = accessType;
        this.participants = participants;
        this.isMyEvent = isMyEvent;
        this.collectedAmount = collectedAmount;
        this.collectedPercentage = collectedPercentage;
        this.ownerName = ownerName;
        this.ownerId = ownerId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setTargetCcy(String targetCcy) {
        this.targetCcy = targetCcy;
    }

    public String getTargetCcy() {
        return targetCcy;
    }

    public void setTargetAmount(Long targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Long getTargetAmount() {
        return targetAmount;
    }

    public void setDeadLine(Long deadLine) {
        this.deadLine = deadLine;
    }

    public Long getDeadLine() {
        return deadLine;
    }

    public void setNumberOfParticipants(Integer numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public Integer getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setContributionAmount(Long contributionAmount) {
        this.contributionAmount = contributionAmount;
    }

    public Long getContributionAmount() {
        return contributionAmount;
    }

    public void setAccessType(Integer accessType) {
        this.accessType = accessType;
    }

    public Integer getAccessType() {
        return accessType;
    }

    public void setIsFixedContribution(Boolean isFixedContribution) {
        this.isFixedContribution = isFixedContribution;
    }

    public Boolean getIsFixedContribution() {
        return isFixedContribution;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setCollectedAmount(Long collectedAmount) {
        this.collectedAmount = collectedAmount;
    }

    public Long getCollectedAmount() {
        return collectedAmount;
    }

    public void setCollectedPercentage(Integer collectedPercentage) {
        this.collectedPercentage = collectedPercentage;
    }

    public Integer getCollectedPercentage() {
        return collectedPercentage;
    }

    public void setTargetCcyId(Integer targetCcyId) {
        this.targetCcyId = targetCcyId;
    }

    public Integer getTargetCcyId() {
        return targetCcyId;
    }

    public void setIsMyEvent(Boolean isMyEvent) {
        this.isMyEvent = isMyEvent;
    }

    public Boolean getIsMyEvent() {
        return isMyEvent;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public static MyCrowdEvent getStub() {
        return stubEvent;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void cleanOnComplete() {
        this.eventName = null;
        this.targetCcy = null;
        this.targetCcyId = null;
        this.targetAmount = null;
        this.deadLine = null;
        this.numberOfParticipants = null;
        this.isFixedContribution = null;
        this.contributionAmount = null;
        this.accessType = null;
        this.participants = null;
        this.isMyEvent = null;
        this.collectedAmount = null;
        this.collectedPercentage = null;
        this.ownerId = null;
    }

}
