package com.cs.dipocketback.pojo.gps;

public enum CardStatus {
    
    /*
    00 All Good
    01 Refer to card issuer – RETIRED – DO NOT USE
    05 Do not honor
    41 Lost card
    43 Stolen card
    54 Expired card
    62 Restricted card
    63 Security Violation
    70 Cardholder to contact issuer
    83 Card Destroyed
    98 Refund given to Customer
    99 Card Voided
    */
    
    ALL_GOOD("00", "All Good"),
    DO_NOT_HONOR("05", "Do not honor"),
    LOST("41", "Lost card"),
    STOLEN("43", "Stolen card"),
    RESTRICTED_CARD("62", "Restricted card"),
    SECURITY_VIOLATION("63", "Security Violation"),
    DESTROYED("83", "Card Destroyed"),
    UNKNOWN("UNKNOWN", "UNKNOWN");                        
    
    private String code;
    private String reason;
    
    private CardStatus(String code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    public String getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }
    
    public static CardStatus findByCode(String code) {
        for (CardStatus cs : values()) {
            if (cs.getCode().equals(code)) {
                return cs;
            }
        }
        return UNKNOWN;
    }
}
