package com.cs.dipocketback.pojo.festival;

import java.util.ArrayList;
import java.util.List;

public class FestivalCardList {
    
    private List<FestivalCard> festivalCardList;
    
    public FestivalCardList() {
    }

    public FestivalCardList(List<FestivalCard> festivalCardList) {
        this.festivalCardList = festivalCardList;
    }

    public void setFestivalCardList(List<FestivalCard> festivalCardList) {
        this.festivalCardList = festivalCardList;
    }

    public List<FestivalCard> getFestivalCardList() {
        return festivalCardList;
    }

}
