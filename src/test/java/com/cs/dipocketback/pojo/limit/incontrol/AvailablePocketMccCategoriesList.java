package com.cs.dipocketback.pojo.limit.incontrol;

import java.util.List;

public class AvailablePocketMccCategoriesList {
    
    private List<IncDiPocketMccCategory> availableMccCategories;
    
    public AvailablePocketMccCategoriesList() {
    }
    
    public AvailablePocketMccCategoriesList(List<IncDiPocketMccCategory> availableMccCategories) {
        this.availableMccCategories = availableMccCategories;
    }

    public void setAvailableMccCategories(List<IncDiPocketMccCategory> availableMccCategories) {
        this.availableMccCategories = availableMccCategories;
    }

    public List<IncDiPocketMccCategory> getAvailableMccCategories() {
        return availableMccCategories;
    }
}
