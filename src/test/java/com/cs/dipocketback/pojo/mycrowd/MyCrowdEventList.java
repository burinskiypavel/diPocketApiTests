package com.cs.dipocketback.pojo.mycrowd;

import com.cs.dipocketback.pojo.dippal.ClientPal;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MyCrowdEventList {
    
//    public static final MyCrowdEventList stub = new MyCrowdEventList(Arrays.asList(new MyCrowdEvent[] {
//                        new MyCrowdEvent(1L, "Test My Event", "GBP", 826, 120000L,
//                            new Date(new Date().getTime() + twoDays), 10, Boolean.TRUE,
//                            12000L, MyCrowdEvent.ACCESS_PUBLIC, ParticipantList.getStub().getParticipants(), Boolean.TRUE),
//                        new MyCrowdEvent(2L, "Test Event", "EUR", 978, 140000L,
//                            new Date(new Date().getTime() + twoDays), 20, Boolean.TRUE,
//                            7000L, MyCrowdEvent.ACCESS_PALS, null, Boolean.FALSE)
//        }));
    
    public static final MyCrowdEventList stub = new MyCrowdEventList(Arrays.asList(new MyCrowdEvent[] {
                        new MyCrowdEvent(1L, "Test My Event", Boolean.TRUE),
                        new MyCrowdEvent(2L, "Test Event", Boolean.FALSE)
        }));
    
    private List<MyCrowdEvent> events;
    
    public MyCrowdEventList() {
    }

    public MyCrowdEventList(List<MyCrowdEvent> events) {
        this.events = events;
    }

    public void setEvents(List<MyCrowdEvent> events) {
        this.events = events;
    }

    public List<MyCrowdEvent> getEvents() {
        return events;
    }
    
    public static MyCrowdEventList getStub() {
        return stub;
    }
}
