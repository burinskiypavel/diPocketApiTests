package com.cs.dipocketback.pojo.pekao;

import java.util.List;

public class PekaoTransferStatusList {

    private List<PekaoTransferStatus> pekaoTransferRequestList;
    
    public PekaoTransferStatusList() {
    }

    public PekaoTransferStatusList(List<PekaoTransferStatus> pekaoTransferRequestList) {
        this.pekaoTransferRequestList = pekaoTransferRequestList;
    }

    public void setPekaoTransferRequestList(List<PekaoTransferStatus> pekaoTransferRequestList) {
        this.pekaoTransferRequestList = pekaoTransferRequestList;
    }

    public List<PekaoTransferStatus> getPekaoTransferRequestList() {
        return pekaoTransferRequestList;
    }

}
