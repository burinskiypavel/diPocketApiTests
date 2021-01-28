
package model.telenor.auth_authenticate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Imagesstatus {

    @SerializedName("typeId")
    @Expose
    private Integer typeId;
    @SerializedName("stateID")
    @Expose
    private Integer stateID;
    @SerializedName("imageType")
    @Expose
    private String imageType;
    @SerializedName("imageState")
    @Expose
    private String imageState;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getStateID() {
        return stateID;
    }

    public void setStateID(Integer stateID) {
        this.stateID = stateID;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImageState() {
        return imageState;
    }

    public void setImageState(String imageState) {
        this.imageState = imageState;
    }

}
