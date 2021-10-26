package com.cs.dipocketback.pojo.payments;

import java.util.ArrayList;
import java.util.List;

public class ConvertedAmountList {

    private Integer ccyId;
    private Long amount;
    private List<ConvertedAmount> convertedAmountList;

    public ConvertedAmountList() {
    }

    public ConvertedAmountList(Integer ccyId, Long amount, List<ConvertedAmount> convertedAmountList) {
      this.ccyId = ccyId;
      this.amount = amount;
      this.convertedAmountList = (convertedAmountList != null) ? convertedAmountList : new ArrayList<>();
    }

    public void setCcyId(Integer ccyId) {
        this.ccyId = ccyId;
    }

    public Integer getCcyId() {
        return ccyId;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setConvertedAmountList(List<ConvertedAmount> convertedAmountList) {
        this.convertedAmountList = convertedAmountList;
    }

    public List<ConvertedAmount> getConvertedAmountList() {
        return convertedAmountList;
    }

    public void addConvertedAmount(ConvertedAmount ca) {
        convertedAmountList.add(ca);
    }

}
