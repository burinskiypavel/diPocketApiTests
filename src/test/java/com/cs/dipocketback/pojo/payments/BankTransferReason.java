package com.cs.dipocketback.pojo.payments;

public class BankTransferReason {
    
    private Long id;
    private String name;
    
    public BankTransferReason() {
    }

    public BankTransferReason(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
