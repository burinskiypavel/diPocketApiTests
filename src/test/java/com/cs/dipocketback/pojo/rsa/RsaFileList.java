package com.cs.dipocketback.pojo.rsa;

import java.util.List;

public class RsaFileList {
    
    public List<RsaFile> addUpdFileList;
    
    public RsaFileList() {
    }

    public RsaFileList(List<RsaFile> addUpdFileList) {
        this.addUpdFileList = addUpdFileList;
    }

    public void setAddUpdFileList(List<RsaFile> addUpdFileList) {
        this.addUpdFileList = addUpdFileList;
    }

    public List<RsaFile> getAddUpdFileList() {
        return addUpdFileList;
    }
}
