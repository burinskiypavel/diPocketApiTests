package model.registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegImageData {
    
    public enum ImageType {
        
        SELFIE(1),
        PHOTOID(2),
        PROOFOFADDRESS(3),
        SELFIE2(4),
        PHOTOIDBACK(5),
        SECONDID(6),
        PROOF_OF_RELATIONSHIP(7),
        AVATAR_L(8),
        AVATAR_M(9),
        AVATAR_S(10),
        RESIDENCE_PERMIT_VISA_TYPE_D(11);

        private Integer id;
        
        private static final Map<Integer, ImageType> MATRIX = new HashMap<>();
        static {
            for (ImageType type : values()) {
                MATRIX.put(type.getId(), type);
            }
        }
        
        public static final List<ImageType> ALL_IMAGE_TYPE = new ArrayList<>(9);
        static {
            for (ImageType type : values()) {
                ALL_IMAGE_TYPE.add(type);
            }
        }
        
        public static final List<ImageType> IMAGE_TYPE_FOR_CLIENT_INFO = new ArrayList<>(9);
        static {
            IMAGE_TYPE_FOR_CLIENT_INFO.add(SELFIE);
            IMAGE_TYPE_FOR_CLIENT_INFO.add(PHOTOID);
            IMAGE_TYPE_FOR_CLIENT_INFO.add(PROOFOFADDRESS);
            IMAGE_TYPE_FOR_CLIENT_INFO.add(SELFIE2);
            IMAGE_TYPE_FOR_CLIENT_INFO.add(PHOTOIDBACK);
        }

        
        private ImageType(int id) {
            this.id = id;
        }
        
        public Integer getId() {
            return id;
        }
        
        public static ImageType valueOf(Integer value) {
            return MATRIX.get(value);
        }
    }
    
    public enum ImageState {
        
        NEW(0),
        APPROVED(10),
        RESCAN(-5),
        REJECTED(-10);
        
        private static final Map<Integer, ImageState> MATRIX = new HashMap<>(4);
        static {
            for (ImageState type : values()) {
                MATRIX.put(type.getId(), type);
            }
        }
        
        private Integer id;
        
        private ImageState(Integer id) {
            this.id = id;
        }
        
        public Integer getId() {
            return id;
        }
        
        public static ImageState valueOf(Integer value) {
            return MATRIX.get(value);
        }
    }

    private String deviceUUID;
    private Integer langId;
    private Integer typeId;
    private String base64Image;
    private Integer stateID;
    private Long linkId;
    private String imageURL;
    private ImageType imageType;
    private ImageState imageState;

    public void setDeviceUUID(String deviceUUID) {
        this.deviceUUID = deviceUUID;
    }

    public String getDeviceUUID() {
        return deviceUUID;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

    public Integer getLangId() {
        return langId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setStateID(Integer stateID) {
        this.stateID = stateID;
    }

    public Integer getStateID() {
        return stateID;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    public Long getLinkId() {
        return linkId;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public RegImageData() {
    }

    public void setImageType(ImageType imageType) {
        this.imageType = imageType;
    }

    public ImageType getImageType() {
        return imageType;
    }

    public void setImageState(ImageState imageState) {
        this.imageState = imageState;
    }

    public ImageState getImageState() {
        return imageState;
    }

    public RegImageData(String deviceUUID, Integer langId, Integer typeId, String base64Image) {
        this.deviceUUID = deviceUUID;
        this.langId = langId;
        this.typeId = typeId;
        this.base64Image = base64Image;
    }

    public RegImageData(Integer typeId, Integer stateID, String base64Image, Long linkId) {
        this.typeId = typeId;
        this.stateID = stateID;
        this.base64Image = base64Image;
        this.linkId = linkId;
        this.imageType = ImageType.valueOf(typeId);
        setImageState(ImageState.valueOf(stateID));
    }
}
