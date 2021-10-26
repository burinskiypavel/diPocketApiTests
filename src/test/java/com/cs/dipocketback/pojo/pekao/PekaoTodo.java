package com.cs.dipocketback.pojo.pekao;

public class PekaoTodo {
    
    private Long id;
    private Long tranId;
    private Integer paymentType;
    
    public PekaoTodo() {
    }

    public PekaoTodo(Long id, 
                     Long tranId, 
                     Integer paymentType) {
        this.id = id;
        this.tranId = tranId;
        this.paymentType = paymentType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTranId(Long tranId) {
        this.tranId = tranId;
    }

    public Long getTranId() {
        return tranId;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getPaymentType() {
        return paymentType;
    }
    
}
