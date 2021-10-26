package com.cs.dipocketback.pojo.openBanking;

public class ConsentLink {

    private ConsentRedirect scaRedirect;

    public ConsentLink() {
    }

    public ConsentLink(ConsentRedirect scaRedirect) {
        this.scaRedirect = scaRedirect;
    }

    public ConsentRedirect getScaRedirect() {
        return scaRedirect;
    }

    public void setScaRedirect(ConsentRedirect scaRedirect) {
        this.scaRedirect = scaRedirect;
    }
}
