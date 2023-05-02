package model.clientServices;

public class DashBoardNotifyDetails3Request {
    private int typeId;
    private int notifyId;
    private String detailsRef;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(int notifyId) {
        this.notifyId = notifyId;
    }

    public String getDetailsRef() {
        return detailsRef;
    }

    public void setDetailsRef(String detailsRef) {
        this.detailsRef = detailsRef;
    }
}