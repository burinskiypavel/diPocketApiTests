package com.cs.dipocketback.pojo.references;

import java.util.List;
import java.util.Map;

public class AvailTopupAmountsContainer {
    private Map<Long, List<Long>>  availTopupAmounts;

    public AvailTopupAmountsContainer() {
    }

    public AvailTopupAmountsContainer(Map<Long, List<Long>> availTopupAmounts) {
        this.availTopupAmounts = availTopupAmounts;
    }

    public Map<Long, List<Long>> getAvailTopupAmounts() {
        return availTopupAmounts;
    }

    public void setAvailTopupAmounts(Map<Long, List<Long>> availTopupAmounts) {
        this.availTopupAmounts = availTopupAmounts;
    }
}
