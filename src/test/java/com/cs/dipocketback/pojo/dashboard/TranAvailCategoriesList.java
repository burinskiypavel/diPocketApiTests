package com.cs.dipocketback.pojo.dashboard;

import java.util.List;

public class TranAvailCategoriesList {
    
    private List<TranAvailCategories> availCategoriesList;
    private String availCategoriesHash;
    
    public TranAvailCategoriesList() {
    }

    public TranAvailCategoriesList(List<TranAvailCategories> availCategoriesList) {
        this.availCategoriesList = availCategoriesList;
    }

    public TranAvailCategoriesList(List<TranAvailCategories> availCategoriesList, String availCategoriesHash) {
        this.availCategoriesList = availCategoriesList;
        this.availCategoriesHash = availCategoriesHash;
    }

    public void setAvailCategoriesList(List<TranAvailCategories> availCategoriesList) {
        this.availCategoriesList = availCategoriesList;
    }

    public List<TranAvailCategories> getAvailCategoriesList() {
        return availCategoriesList;
    }

    public void setAvailCategoriesHash(String availCategoriesHash) {
        this.availCategoriesHash = availCategoriesHash;
    }

    public String getAvailCategoriesHash() {
        return availCategoriesHash;
    }
}
