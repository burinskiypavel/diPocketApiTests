package com.cs.dipocketback.pojo.accounts;

import com.cs.dipocketback.pojo.card.CardType;

import java.util.HashMap;
import java.util.Map;

public class DiPocketCard {
    
    /*
    ANDROID 1.0.7   WHITE   BACCA
    IOS     1.0.8   WHITE   BACCA
    ANDROID 1.5.5   WHITE   DIPOCKET
    IOS     1.4.5   WHITE   DIPOCKET
    ANDROID 1.2.0   WHITE   PLAYIT
    IOS     1.4.7   WHITE   PLAYIT
    ANDROID 1.1.3   WHITE   PZT
    IOS     1.0.11  WHITE   PZT
    ANDROID 1.0.0   WHITE   UPANDGO
    IOS     1.0.0   WHITE   UPANDGO
     */
    @Deprecated
    public enum DiPocketCardType {
        
        CARD_TYPE_NONE(0),
        CARD_TYPE_VIRTUAL(10),
        CARD_TYPE_PLASTIC(20);
        
        private Integer id;
        
        private DiPocketCardType(Integer id) {
            this.id = id;
        }
        
        private static final Map<Integer, DiPocketCardType> CARD_TYPE_BY_ID;
        private static final Map<String, DiPocketCardType> CARD_TYPE_BY_NAME;
        static {
            int size = values().length;
            CARD_TYPE_BY_ID = new HashMap<>(size);
            CARD_TYPE_BY_NAME = new HashMap<>(size);
            for (DiPocketCardType type : values()) {
                CARD_TYPE_BY_ID.put(type.getId(), type);
                CARD_TYPE_BY_NAME.put(type.name(), type);
            }
        }
        
        public static DiPocketCardType valueOf(Integer value) {
            return CARD_TYPE_BY_ID.get(value);
        }
        
        public static DiPocketCardType getCardTypeByName(String name) {
            DiPocketCardType cardType = null;
            if (name != null) {
                cardType = CARD_TYPE_BY_NAME.get(name.toUpperCase());
            }
            return cardType;
        }

        public Integer getId() {
            return id;
        }
        
    }
    
    public enum DiPocketCardStatus {

        EXPIRED(-80),
        CANCELLED(-5),
        BLOCKED(-10),
        TOCONFIRM(0),
        TOOPEN(5),
        TOCONVERT(10),
        INACTIVE(15),
        ACTIVE(20);
        
        private Integer id;
        
        private DiPocketCardStatus(Integer id) {
            this.id = id;
        }

        private static final Map<Integer, DiPocketCardStatus> matrix;
        static {
            matrix = new HashMap<>(values().length);
            for (DiPocketCardStatus status : values()) {
                matrix.put(status.getId(), status);
            }
        }

        public static DiPocketCardStatus valueOf(Integer value) {
            return matrix.get(value);
        }
        
        public Integer getId() {
            return id;
        }
    }
    
    private Long id;
    private Long accountId;
    private String typeName;
    private String firstName;
    private String lastName;
    private String expDate;
    private String maskedPan;
    private String publicToken;
    private String dipToken;
    private String primaryToken;
    private Long clientId;
    private Boolean canActivate;
    private Boolean noName;
    private Long incontrolCpnId;
    private DiPocketCardStatus state;
    @Deprecated
    private DiPocketCardType type;
    private CardType cardType;
    private Boolean isSupervised;
    private Boolean pinIsSet;
    private String cardholderName;
    
    public DiPocketCard() {
    }

    public DiPocketCard(Long id,
                        Long accountId,
                        Integer typeId,
                        String typeName,
                        String firstName,
                        String lastName,
                        String expDate,
                        String maskedPan,
                        String publicToken,
                        String dipToken,
                        String primaryToken,
                        Integer stateId,
                        Long clientId,
                        Boolean canActivate,
                        Boolean noName,
                        Long incontrolCpnId,
                        Boolean pinIsSet) {
        this.id = id;
        this.accountId = accountId;
        this.typeName = typeName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.expDate = expDate;
        this.maskedPan = maskedPan;
        this.publicToken = publicToken;
        this.dipToken = dipToken;
        this.primaryToken = primaryToken;
        this.clientId = clientId;
        this.canActivate = canActivate;
        this.noName = noName;
        this.incontrolCpnId = incontrolCpnId;
        this.pinIsSet = pinIsSet;
        setState(DiPocketCardStatus.valueOf(stateId));
        setType(DiPocketCardType.valueOf(typeId));
        setCardType(CardType.valueOf(typeId));
    }

    public DiPocketCard(Long id, 
                        Long accountId, 
                        Integer typeId, 
                        String typeName, 
                        String firstName, 
                        String lastName,
                        String expDate, 
                        String maskedPan, 
                        String publicToken, 
                        String dipToken, 
                        String primaryToken, 
                        Integer stateId, 
                        Long clientId, 
                        Boolean canActivate, 
                        Boolean noName, 
                        Long incontrolCpnId,
                        Boolean pinIsSet,
                        String cardholderName) {
        this.id = id;
        this.accountId = accountId;
        this.typeName = typeName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.expDate = expDate;
        this.maskedPan = maskedPan;
        this.publicToken = publicToken;
        this.dipToken = dipToken;
        this.primaryToken = primaryToken;
        this.clientId = clientId;
        this.canActivate = canActivate;
        this.noName = noName;
        this.incontrolCpnId = incontrolCpnId;
        this.pinIsSet = pinIsSet;
        setState(DiPocketCardStatus.valueOf(stateId));
        setType(DiPocketCardType.valueOf(typeId));
        setCardType(CardType.valueOf(typeId));
        this.cardholderName = cardholderName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setDipToken(String dipToken) {
        this.dipToken = dipToken;
    }

    public String getDipToken() {
        return dipToken;
    }

    public void setPrimaryToken(String primaryToken) {
        this.primaryToken = primaryToken;
    }

    public String getPrimaryToken() {
        return primaryToken;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setCanActivate(Boolean canActivate) {
        this.canActivate = canActivate;
    }

    public Boolean getCanActivate() {
        return canActivate;
    }

    public void setNoName(Boolean noName) {
        this.noName = noName;
    }

    public Boolean getNoName() {
        return noName;
    }

    public void setIncontrolCpnId(Long incontrolCpnId) {
        this.incontrolCpnId = incontrolCpnId;
    }

    public Long getIncontrolCpnId() {
        return incontrolCpnId;
    }

    public void setState(DiPocketCardStatus status) {
        this.state = status;
    }

    public DiPocketCardStatus getState() {
        return state;
    }

    public void setType(DiPocketCardType type) {
        this.type = type;
    }

    public DiPocketCardType getType() {
        return type;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setIsSupervised(Boolean isSupervised) {
        this.isSupervised = isSupervised;
    }

    public Boolean getIsSupervised() {
        return isSupervised;
    }

    public void setPinIsSet(Boolean pinIsSet) {
        this.pinIsSet = pinIsSet;
    }

    public Boolean getPinIsSet() {
        return pinIsSet;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }
}
