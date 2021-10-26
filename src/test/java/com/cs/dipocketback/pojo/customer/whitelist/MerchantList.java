package com.cs.dipocketback.pojo.customer.whitelist;

import java.util.List;

public class MerchantList {

    private List<BaseMerchantRequest> merchants;

    public MerchantList() {
    }

    public MerchantList(List<BaseMerchantRequest> merchants) {
        this.merchants = merchants;
    }

    public List<BaseMerchantRequest> getMerchants() {
        return merchants;
    }

    public void setMerchants(List<BaseMerchantRequest> merchants) {
        this.merchants = merchants;
    }
}
