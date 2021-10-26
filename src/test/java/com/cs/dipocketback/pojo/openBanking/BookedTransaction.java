package com.cs.dipocketback.pojo.openBanking;

import java.util.List;

public class BookedTransaction {

    private List<AccountTransaction> booked;

    public BookedTransaction() {
    }

    public BookedTransaction(List<AccountTransaction> booked) {
        this.booked = booked;
    }

    public List<AccountTransaction> getBooked() {
        return booked;
    }

    public void setBooked(List<AccountTransaction> booked) {
        this.booked = booked;
    }
}
