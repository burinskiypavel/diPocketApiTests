package com.cs.dipocketback.pojo.references.params;

public class LabelModule {

    private Boolean shouldShowInMenu;
    private Boolean shouldShowInTopUp;
    private Boolean shouldShowOnMainScreen;

    public LabelModule() {
    }

    public LabelModule(Boolean shouldShowInMenu, Boolean shouldShowInTopUp, Boolean shouldShowOnMainScreen) {
        this.shouldShowInMenu = shouldShowInMenu;
        this.shouldShowInTopUp = shouldShowInTopUp;
        this.shouldShowOnMainScreen = shouldShowOnMainScreen;
    }

    public Boolean getShouldShowInMenu() {
        return shouldShowInMenu;
    }

    public void setShouldShowInMenu(Boolean shouldShowInMenu) {
        this.shouldShowInMenu = shouldShowInMenu;
    }

    public Boolean getShouldShowInTopUp() {
        return shouldShowInTopUp;
    }

    public void setShouldShowInTopUp(Boolean shouldShowInTopUp) {
        this.shouldShowInTopUp = shouldShowInTopUp;
    }

    public Boolean getShouldShowOnMainScreen() {
        return shouldShowOnMainScreen;
    }

    public void setShouldShowOnMainScreen(Boolean shouldShowOnMainScreen) {
        this.shouldShowOnMainScreen = shouldShowOnMainScreen;
    }

}
