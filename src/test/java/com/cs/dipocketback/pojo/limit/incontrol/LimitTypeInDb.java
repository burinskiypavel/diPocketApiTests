package com.cs.dipocketback.pojo.limit.incontrol;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum LimitTypeInDb {

    PURCHASE(1),
    CASH(2);

    private static final Logger LOGGER = LoggerFactory.getLogger(LimitTypeInDb.class);

    private final Integer id;
    
    private final static Map<Integer, LimitTypeInDb> map = new HashMap<>(2);
    
    static {
        for (LimitTypeInDb l : values()) {
            map.put(l.id, l); 
        }
    }
    
    private LimitTypeInDb(Integer id) {
        this.id = id;
    }
    
    public static LimitTypeInDb getById(Integer id) {
        LimitTypeInDb limitTypeInDb = map.get(id);
        LOGGER.info("limitTypeInDb == null {}", (limitTypeInDb == null));
        LOGGER.info("LimitTypeInDb getById(Integer id)");
        return limitTypeInDb;
    }

    public Integer getId() {
        return id;
    }

}
