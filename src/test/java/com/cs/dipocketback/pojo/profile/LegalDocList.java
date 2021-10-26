package com.cs.dipocketback.pojo.profile;

import java.util.List;

/*
ANDROID	1.0.7	WHITE	BACCA
IOS	1.0.8	WHITE	BACCA
ANDROID	2.0.0	WHITE	DIPOCKET
IOS	2.0.0	WHITE	DIPOCKET
ANDROID	1.1.3	WHITE	PZT
IOS	1.0.9	GRAY	PZT
 */
@Deprecated
public class LegalDocList {
    
    //DiPocket id
    public static final int SUMMARY_TAC = 1;
    public static final int PRICING = 2;
    public static final int LIMITS = 3;
    public static final int DIP_TAC = 4;
    public static final int CARDS_TAC = 5;
    
    private List<Integer> docIds;
    
    public LegalDocList() {
    }

    public LegalDocList(List<Integer> docIds) {
        this.docIds = docIds;
    }

    public void setDocIds(List<Integer> docIds) {
        this.docIds = docIds;
    }

    public List<Integer> getDocIds() {
        return docIds;
    }
    
}
