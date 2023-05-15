package model.clientServices;

public class ClientProfileUpdateSelfieRequest {
    private String base64Selfie1;
    private String base64Selfie2;

    public String getBase64Selfie1() {
        return base64Selfie1;
    }

    public void setBase64Selfie1(String base64Selfie1) {
        this.base64Selfie1 = base64Selfie1;
    }

    public String getBase64Selfie2() {
        return base64Selfie2;
    }

    public void setBase64Selfie2(String base64Selfie2) {
        this.base64Selfie2 = base64Selfie2;
    }
}