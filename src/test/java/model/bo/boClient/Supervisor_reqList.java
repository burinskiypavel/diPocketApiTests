package model.bo.boClient;

public class Supervisor_reqList {

    private int reqId;
    private int clientId;
    private String role;
    private int rClientId;
    private String rClientPhone;
    private String rFullName;
    private int stateId;
    private String stateName;
    private String createdAt;
    private String approvedAt;

    public int getReqId() {
        return reqId;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getrClientId() {
        return rClientId;
    }

    public void setrClientId(int rClientId) {
        this.rClientId = rClientId;
    }

    public String getrClientPhone() {
        return rClientPhone;
    }

    public void setrClientPhone(String rClientPhone) {
        this.rClientPhone = rClientPhone;
    }

    public String getrFullName() {
        return rFullName;
    }

    public void setrFullName(String rFullName) {
        this.rFullName = rFullName;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(String approvedAt) {
        this.approvedAt = approvedAt;
    }
}
