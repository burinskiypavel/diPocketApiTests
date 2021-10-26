package com.cs.dipocketback.pojo.limit.incontrol;

public class IncCardActionToDo {
    
    private final Long actionId;
    private final Integer typeId;
    private final Long cardId;

    public IncCardActionToDo(Long actionId, Integer typeId, Long cardId) {
        this.actionId = actionId;
        this.typeId = typeId;
        this.cardId = cardId;
    }

    public Long getActionId() {
        return actionId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public Long getCardId() {
        return cardId;
    }

}
