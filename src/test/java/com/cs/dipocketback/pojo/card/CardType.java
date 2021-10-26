package com.cs.dipocketback.pojo.card;

import java.util.HashMap;
import java.util.Map;

public enum CardType {
    
    NONE(0),
    VIRTUAL(10),
    PLASTIC(20);
    
    private Integer id;
    
    private CardType(Integer id) {
        this.id = id;
    }
    
    private static final Map<Integer, CardType> CARD_TYPE_BY_ID;
    private static final Map<String, CardType> CARD_TYPE_BY_NAME;
    static {
        int size = values().length;
        CARD_TYPE_BY_ID = new HashMap<>(size);
        CARD_TYPE_BY_NAME = new HashMap<>(size);
        for (CardType type : values()) {
            CARD_TYPE_BY_ID.put(type.getId(), type);
            CARD_TYPE_BY_NAME.put(type.name(), type);
        }
    }
    
    public static CardType valueOf(Integer value) {
        return CARD_TYPE_BY_ID.get(value);
    }
    
    public static CardType getCardTypeByName(String name) {
        CardType cardType = null;
        if (name != null) {
            cardType = CARD_TYPE_BY_NAME.get(name.toUpperCase());
        }
        return cardType;
    }

    public Integer getId() {
        return id;
    }
    
}
