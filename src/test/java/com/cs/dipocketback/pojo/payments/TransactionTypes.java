package com.cs.dipocketback.pojo.payments;

import java.util.HashMap;
import java.util.Map;

public enum TransactionTypes {
    
    FACE_TO_FACE,
    DIP_TRANSFER,
    BANKTRAN_IN,
    CARD_TRAN,
    BANK_TRANSFER,
    MOVE_MY_FUNDS,
    TOPUP_3D_CARD,
    CROWD_CONTR,
    CROWD_REWARD,
    FEE;
    
    private static final Map<Integer, TransactionTypes> matrix;
    static {
        matrix = new HashMap<>();
        matrix.put(1, FACE_TO_FACE);
        matrix.put(2, DIP_TRANSFER);
        matrix.put(3, BANKTRAN_IN);
        matrix.put(4, CARD_TRAN);
        matrix.put(5, BANK_TRANSFER);
        matrix.put(6, MOVE_MY_FUNDS);
        matrix.put(7, TOPUP_3D_CARD);
        matrix.put(8, CROWD_CONTR);
        matrix.put(9, CROWD_REWARD);
        matrix.put(10, FEE);
    }
    
    public static TransactionTypes valueOf(Integer value) {
        return matrix.get(value);
    }
}
