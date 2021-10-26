package com.cs.dipocketback.pojo.tds.v2;

import com.cs.dipocketback.pojo.tds.v2.resp.BackgroundCRes;

public class ExtendedBackgroundCRes {

    private Long cResId;
    private BackgroundCRes bgCRes;

    public ExtendedBackgroundCRes() {
    }

    public Long getcResId() {
        return cResId;
    }

    public void setcResId(Long cResId) {
        this.cResId = cResId;
    }

    public BackgroundCRes getBgCRes() {
        return bgCRes;
    }

    public void setBgCRes(BackgroundCRes bgCRes) {
        this.bgCRes = bgCRes;
    }
}
