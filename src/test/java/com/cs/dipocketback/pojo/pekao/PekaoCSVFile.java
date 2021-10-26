package com.cs.dipocketback.pojo.pekao;

import java.util.List;

public class PekaoCSVFile {
    
    private String fileName;
    private PekaoHeadLine headLine;
    private List<PekaoTransaction> transactions;
    private PekaoHeading heading;
    
    public PekaoCSVFile() {
    }

    public PekaoCSVFile(PekaoHeadLine headLine, List<PekaoTransaction> transactions, PekaoHeading heading, String fileName) {
        this.headLine = headLine;
        this.transactions = transactions;
        this.heading = heading;
        this.fileName = fileName;
    }

    public void setHeadLine(PekaoHeadLine headLine) {
        this.headLine = headLine;
    }

    public PekaoHeadLine getHeadLine() {
        return headLine;
    }

    public void setTransactions(List<PekaoTransaction> transactions) {
        this.transactions = transactions;
    }

    public List<PekaoTransaction> getTransactions() {
        return transactions;
    }

    public void setHeading(PekaoHeading heading) {
        this.heading = heading;
    }

    public PekaoHeading getHeading() {
        return heading;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public String toString() {        
        return "PekaoCSVFile: {"+headLine+"\n"+transactions+"\n"+heading+"}";
    }
}
