package com.cs.dipocketback.pojo.cellum;

public class ReceiveImNotif {

    private ReceiveImNotifReq receiveImNotifReq;
    private ReceiveImNotifReqHeader header;
    private ReceiveImNotifResp receiveImNotifResp;
    
    public ReceiveImNotif() {
    }

    public void setReceiveImNotifReq(ReceiveImNotifReq receiveImNotifReq) {
        this.receiveImNotifReq = receiveImNotifReq;
    }

    public ReceiveImNotifReq getReceiveImNotifReq() {
        return receiveImNotifReq;
    }

    public void setHeader(ReceiveImNotifReqHeader header) {
        this.header = header;
    }

    public ReceiveImNotifReqHeader getHeader() {
        return header;
    }

    public void setReceiveImNotifResp(ReceiveImNotifResp receiveImNotifResp) {
        this.receiveImNotifResp = receiveImNotifResp;
    }

    public ReceiveImNotifResp getReceiveImNotifResp() {
        return receiveImNotifResp;
    }
}
