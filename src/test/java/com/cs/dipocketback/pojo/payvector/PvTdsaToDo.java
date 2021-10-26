package com.cs.dipocketback.pojo.payvector;

public class PvTdsaToDo {
    
    private String crossReference;
    private String stringPaRes;
    
    public PvTdsaToDo() {
    }

    public PvTdsaToDo(String crossReference, String stringPaRes) {
        this.crossReference = crossReference;
        this.stringPaRes = stringPaRes;
    }

    public void setCrossReference(String crossReference) {
        this.crossReference = crossReference;
    }

    public String getCrossReference() {
        return crossReference;
    }

    public void setStringPaRes(String stringPaRes) {
        this.stringPaRes = stringPaRes;
    }

    public String getStringPaRes() {
        return stringPaRes;
    }
    
}
