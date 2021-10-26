package com.cs.dipocketback.base.data;

public enum TransactionLimitGroup {

    TOP_UP("TOPUP"),
    CASH_LOAD("CASHLOAD");

    public final String nameForDb;

    TransactionLimitGroup(String nameForDb) {
        this.nameForDb = nameForDb;
    }

    public String getNameForDb() {
        return this.nameForDb;
    }

}
