package com.cs.dipocketback.pojo.web.topup;

public class WebDoTopUpRequest extends WebTopUpBaseRequest {

    private Long srcAccountId;

    public Long getSrcAccountId() {
        return srcAccountId;
    }

    public void setSrcAccountId(Long srcAccountId) {
        this.srcAccountId = srcAccountId;
    }
}
