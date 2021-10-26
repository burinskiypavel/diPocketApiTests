package com.cs.dipocketback.pojo.topUp;

public class TopUpNeosurfResponse {
    
    private String neosurfTopupPageBase64;
    private String urlOk;
    private String urlError;
    private String urlPending;
    
    public TopUpNeosurfResponse() {
    }

    public TopUpNeosurfResponse(String neosurfTopupPageBase64) {
        this.neosurfTopupPageBase64 = neosurfTopupPageBase64;
    }

    public void setNeosurfTopupPageBase64(String neosurfTopupPage) {
        this.neosurfTopupPageBase64 = neosurfTopupPage;
    }

    public String getNeosurfTopupPageBase64() {
        return neosurfTopupPageBase64;
    }

    public void setUrlOk(String urlOk) {
        this.urlOk = urlOk;
    }

    public String getUrlOk() {
        return urlOk;
    }

    public void setUrlError(String urlError) {
        this.urlError = urlError;
    }

    public String getUrlError() {
        return urlError;
    }

    public void setUrlPending(String urlPending) {
        this.urlPending = urlPending;
    }

    public String getUrlPending() {
        return urlPending;
    }
}
