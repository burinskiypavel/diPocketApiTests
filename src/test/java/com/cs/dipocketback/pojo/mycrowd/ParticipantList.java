package com.cs.dipocketback.pojo.mycrowd;

import java.util.Arrays;
import java.util.List;

public class ParticipantList {
    
    
    private List<Participant> participants;
    
    private static final ParticipantList stub = new ParticipantList(Arrays.asList(new Participant[]{
                                                                    new Participant("Test1", "380505217132", 0, 0L, 1L),
                                                                    new Participant("Test2", "380503086433", 0, 0L, 1L)                                                                    
                                                                    }));
    
    public ParticipantList() {
    }

    public ParticipantList(List<Participant> participants) {
        this.participants = participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<Participant> getParticipants() {
        return participants;
    }
    
    public static ParticipantList getStub() {
        return stub;
    }
}
