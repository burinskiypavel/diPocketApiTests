package com.cs.dipocketback.pojo.qr;

import java.util.HashMap;
import java.util.Map;

public class QrCode {
    
    public enum QrCodeType {
        CARD_ACTIVATE,
        F2F_SEND,
        F2F_RECEIVE;
        
        private static final Map<Integer, QrCodeType> matrix;
        static {
            matrix = new HashMap<>();
            matrix.put(Integer.valueOf(100), CARD_ACTIVATE);
            matrix.put(Integer.valueOf(200), F2F_SEND);
            matrix.put(Integer.valueOf(210), F2F_RECEIVE);
        }
        
        public static QrCodeType valueOf(Integer value) {
          return matrix.get(value);
        }
    }
    
    private QrCodeType qrType;
    
    public QrCode() {
    }

    public QrCode(QrCodeType type) {
        this.qrType = type;
    }

    public void setQrType(QrCodeType type) {
        this.qrType = type;
    }

    public QrCodeType getQrType() {
        return qrType;
    }
}
