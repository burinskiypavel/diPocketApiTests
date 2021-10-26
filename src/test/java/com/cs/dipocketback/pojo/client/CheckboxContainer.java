package com.cs.dipocketback.pojo.client;

public class CheckboxContainer {
    
    private CheckboxType typeId;
    private boolean selected;
    private Boolean mandatory;
    private String name;
    private String description;
    private String note;

    public CheckboxContainer() {
    }

    public CheckboxContainer(CheckboxType typeId, boolean selected) {
        this.typeId = typeId;
        this.selected = selected;
    }

    public CheckboxContainer(CheckboxType typeId, boolean selected, String name, String description) {
        this.typeId = typeId;
        this.selected = selected;
        this.name = name;
        this.description = description;
    }

    public void setTypeId(CheckboxType typeId) {
        this.typeId = typeId;
    }

    public CheckboxType getTypeId() {
        return typeId;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    public Boolean getMandatory() {
        return mandatory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "CheckboxContainer{" +
                "typeId=" + typeId +
                ", selected=" + selected +
                ", mandatory=" + mandatory +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
