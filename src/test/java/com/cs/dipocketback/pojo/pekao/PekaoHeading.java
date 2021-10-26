package com.cs.dipocketback.pojo.pekao;

public class PekaoHeading {
    
//    public static final int IDENTIFIER = 0;
    public static final int NUMBER_OF_TRANSACTIONS = 1;
    public static final int TURNOVER = 2;

    private String identifier;
    private int numberOfTransactions;
    private Long turnover;

    public PekaoHeading(String identifier, int numberOfTransactions, Long turnover) {
        this.identifier = identifier;
        this.numberOfTransactions = numberOfTransactions;
        this.turnover = turnover;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public void setNumberOfTransactions(int numberOfTransactions) {
        this.numberOfTransactions = numberOfTransactions;
    }

    public Long getTurnover() {
        return turnover;
    }

    public void setTurnover(Long turnover) {
        this.turnover = turnover;
    }

    @Override
    public String toString() {
        return "PekaoHeading{" +
                "identifier=" + identifier +
                ", numberOfTransactions=" + numberOfTransactions +
                ", turnover=" + turnover +
                '}';
    }
}
