package com.cs.dipocketback.pojo.accounts;

import java.util.ArrayList;
import java.util.List;

public class SharedAccountDetailList {

    private String note;

    public void setNote(String pNote) {
        this.note = pNote;
    }

    public String getNote() {
        return note;
    }

    private List<SharedAccountDetail> sharedaccountdetails;

    public SharedAccountDetailList() {
    }

    public SharedAccountDetailList(List<SharedAccountDetail> sharedaccountdetails) {
        this.sharedaccountdetails = sharedaccountdetails;
    }

    public void setSharedaccountdetails(List<SharedAccountDetail> pHaredaccountdetails) {
        this.sharedaccountdetails = pHaredaccountdetails;
    }

    public List<SharedAccountDetail> getSharedaccountdetails() {
        return sharedaccountdetails;
    }

    public static SharedAccountDetailList getStubData() {
        SharedAccountDetailList sharedAccountDetailList = new SharedAccountDetailList();
        List list = new ArrayList();
        list.add(new SharedAccountDetail("380675760253", "Buddy", "Duke Dracula", Boolean.TRUE, null));
        list.add(new SharedAccountDetail("380675760240", "Boss", "Fred Krueger", Boolean.FALSE, null));
        //list.add(new SharedAccountDetail("380675760240", null, "Fred Krueger ", Boolean.FALSE));
        sharedAccountDetailList.setSharedaccountdetails(list);

        return sharedAccountDetailList;
    }

}
