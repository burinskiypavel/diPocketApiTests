package model.bo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Client_sites {

    private String site;
    private String name;


    public String getSite() {
        return site;
    }

    public void setSite(String clientFirstName) {
        this.site = clientFirstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String clientFirstName) {
        this.name = clientFirstName;
    }
}
