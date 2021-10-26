package com.cs.dipocketback.pojo.customer;

public class IdByPhoneResponse {

    private Long id;
    private Integer stateId;
    private String state;

    public IdByPhoneResponse(Long id, Integer stateId, String state) {
        this.id = id;
        this.stateId = stateId;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
