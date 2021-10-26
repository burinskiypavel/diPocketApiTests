package com.cs.dipocketback.pojo.bacs;

public class BacsOutFileTODO {
    
    private Long id;
    private String fileName;
    
    public BacsOutFileTODO() {
    }

    public BacsOutFileTODO(Long id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
    
}
