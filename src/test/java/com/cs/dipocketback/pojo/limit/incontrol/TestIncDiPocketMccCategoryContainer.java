package com.cs.dipocketback.pojo.limit.incontrol;

import java.util.List;

public class TestIncDiPocketMccCategoryContainer {
    
    List<IncDiPocketMccCategory> listRestrictedCategories;
    
    public TestIncDiPocketMccCategoryContainer() {
    }

    public TestIncDiPocketMccCategoryContainer(List<IncDiPocketMccCategory> listRestrictedCategories) {
        this.listRestrictedCategories = listRestrictedCategories;
    }

    public void setListRestrictedCategories(List<IncDiPocketMccCategory> listRestrictedCategories) {
        this.listRestrictedCategories = listRestrictedCategories;
    }

    public List<IncDiPocketMccCategory> getListRestrictedCategories() {
        return listRestrictedCategories;
    }
    
}
