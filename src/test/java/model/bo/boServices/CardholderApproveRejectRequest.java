package model.bo.boServices;

public class CardholderApproveRejectRequest {
    private String reason;
    private int ticketId;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
}