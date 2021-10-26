package com.cs.dipocketback.pojo.mycrowd;

import java.util.HashMap;
import java.util.Map;

public class Participant {
    
    public enum ParticipantStatus {
        INVITED,
        ACCEPTING,
        ACCEPTED,
        CANCELING,
        CANCELED;
        
        private static final Map<Integer,ParticipantStatus> matrix;
        static {
            matrix = new HashMap<>();
            matrix.put(Integer.valueOf(0), INVITED);
            matrix.put(Integer.valueOf(9), ACCEPTING);
            matrix.put(Integer.valueOf(10), ACCEPTED);
            matrix.put(Integer.valueOf(19), CANCELING);
            matrix.put(Integer.valueOf(20), CANCELED);
        }
        
        public static ParticipantStatus valueOf(Integer value) {
            return matrix.get(value);
        }
    }
    
    private Long eventId;
    private String name;
    private String phone;
    private Long contributionAmount;
    private String ccy;
    private Integer ccyId;
    private Long clientId;
    
//    private ParticipantStatus status;
    private Integer status;
    
    public Participant() {
    }

    public Participant(String name, String phone, Integer status, Long contributionAmount, Long clientId) {
        this.name = name;
        this.phone = phone;
        this.status = status;
        this.contributionAmount = contributionAmount;
        this.clientId = clientId;
    }

    public Participant(String name, String phone, Long contributionAmount, String ccy, Integer status, Long clientId) {
        this.name = name;
        this.phone = phone;
        this.contributionAmount = contributionAmount;
        this.ccy = ccy;
        this.status = status;
        this.clientId = clientId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setContributionAmount(Long contributionAmount) {
        this.contributionAmount = contributionAmount;
    }

    public Long getContributionAmount() {
        return contributionAmount;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcyId(Integer ccyId) {
        this.ccyId = ccyId;
    }

    public Integer getCcyId() {
        return ccyId;
    }

//    public void setStatus(Participant.ParticipantStatus status) {
//        this.status = status;
//    }
//
//    public Participant.ParticipantStatus getStatus() {
//        return status;
//    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }
}
