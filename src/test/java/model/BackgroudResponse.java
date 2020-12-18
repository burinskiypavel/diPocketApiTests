package model;

import java.util.List;

public class BackgroudResponse {

    private String dataStatus;
    private String pageId;

     List<Entry> entries;

    public String getDataStatus() {
        return dataStatus;
    }

    public String getPageId() {
        return pageId;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        return "BackgroudResponse{" +
                "dataStatus='" + dataStatus + '\'' +
                ", pageId='" + pageId + '\'' +
                ", entries=" + entries +
                '}';
    }
}
