package com.cs.dipocketback.pojo.payments;

import java.util.List;

public class BankTransferReasonList {
    
    private List<BankTransferReason> reasonList;
    private String bankTransferReasonHash;

    public BankTransferReasonList() {
    }
    
    public BankTransferReasonList(List<BankTransferReason> reasonList, String bankTransferReasonHash) {
        this.reasonList = reasonList;
        this.bankTransferReasonHash = bankTransferReasonHash;
    }

    public void setReasonList(List<BankTransferReason> reasonList) {
        this.reasonList = reasonList;
    }

    public List<BankTransferReason> getReasonList() {
        return reasonList;
    }

    public void setBankTransferReasonHash(String bankTransferReasonHash) {
        this.bankTransferReasonHash = bankTransferReasonHash;
    }

    public String getBankTransferReasonHash() {
        return bankTransferReasonHash;
    }
    
}
