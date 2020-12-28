package model;

public class FinalCResDecline extends FinalCRes{

    private String transStatusReason;
    FinalCRes finalCRes = new FinalCRes();

    public String getTransStatusReason() {
        return transStatusReason;
    }

    public void setTransStatusReason(String transStatusReason) {
        this.transStatusReason = transStatusReason;
    }
}
