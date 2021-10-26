package com.cs.dipocketback.pojo.santander;

import java.util.ArrayList;
import java.util.List;

public class EinHistoryResponse {
    
    private List<EinHistoryTran> trans;
    private Long totalPages;
    
    public EinHistoryResponse() {
    }

    public EinHistoryResponse(List<EinHistoryTran> trans) {
        this.trans = trans;
    }

    public List<EinHistoryTran> getTrans() {
        if (trans == null) {
            trans = new ArrayList<>();
        }
        return trans;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }
}
