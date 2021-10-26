package com.cs.dipocketback.pojo.pekao;

import java.util.Date;
import java.util.List;

public class PekaoTransaction {

//    public static final int IDENTIFIER = 0;
    public static final int INTERNAL_CODE = 1;
    public static final int PAYER_ACCOUNT_NUMBER = 2;
    public static final int TRANSACTION_AMOUNT = 3;
    public static final int POSTING_DATE = 4;
    public static final int PAYMENT_DATE = 5;
    public static final int PAYER1 = 6;
    public static final int PAYER2 = 7;
    public static final int PAYER3 = 8;
    public static final int PAYER4 = 9;
    public static final int BANK_NUMBER = 10;
    public static final int NRB_CONTROL_CODE = 11;
    public static final int EXT_OF_ACCOUNT_NUMBER = 12;
    public static final int KTR = 13;
    public static final int PAYMENT_DETAILS1 = 14;
    public static final int PAYMENT_DETAILS2 = 15;
    public static final int PAYMENT_DETAILS3 = 16;
    public static final int PAYMENT_DETAILS4 = 17;
    public static final int UNIQUE_NUMBER = 18;

    private String identifier;
    private int internalCode;
    private String payerAccountNumber;
    private long transactionAmount;
    private Date postingDate;
    private Date paymentDate;
    private String payer1;
    private String payer2;
    private String payer3;
    private String payer4;
    private int bankNumber;
    private int nrbControlCode;
    private String extOfAccountNumber;
    private String ktr;
    private String paymentDetails1;
    private String paymentDetails2;
    private String paymentDetails3;
    private String paymentDetails4;
    private String uniqueNumber;

    public PekaoTransaction() {
    }

    public PekaoTransaction(String identifier, int internalCode, String payerAccountNumber, 
            long transactionAmount, Date postingDate, Date paymentDate, 
            String payer1, String payer2, String payer3, String payer4, 
            int bankNumber, int nrbControlCode, String extOfAccountNumber, 
            String ktr, String paymentDetails1, String paymentDetails2, 
            String paymentDetails3, String paymentDetails4, String uniqueNumber) {
        this.identifier = identifier;
        this.internalCode = internalCode;
        this.payerAccountNumber = payerAccountNumber;
        this.transactionAmount = transactionAmount;
        this.postingDate = postingDate;
        this.paymentDate = paymentDate;
        this.payer1 = payer1;
        this.payer2 = payer2;
        this.payer3 = payer3;
        this.payer4 = payer4;
        this.bankNumber = bankNumber;
        this.nrbControlCode = nrbControlCode;
        this.extOfAccountNumber = extOfAccountNumber;
        this.ktr = ktr;
        this.paymentDetails1 = paymentDetails1;
        this.paymentDetails2 = paymentDetails2;
        this.paymentDetails3 = paymentDetails3;
        this.paymentDetails4 = paymentDetails4;
        this.uniqueNumber = uniqueNumber;
    }
    
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(int internalCode) {
        this.internalCode = internalCode;
    }

    public String getPayerAccountNumber() {
        return payerAccountNumber;
    }

    public void setPayerAccountNumber(String payerAccountNumber) {
        this.payerAccountNumber = payerAccountNumber;
    }

    public long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPayer1() {
        return payer1;
    }

    public void setPayer1(String payer1) {
        this.payer1 = payer1;
    }

    public String getPayer2() {
        return payer2;
    }

    public void setPayer2(String payer2) {
        this.payer2 = payer2;
    }

    public String getPayer3() {
        return payer3;
    }

    public void setPayer3(String payer3) {
        this.payer3 = payer3;
    }

    public String getPayer4() {
        return payer4;
    }

    public void setPayer4(String payer4) {
        this.payer4 = payer4;
    }

    public int getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(int bankNumber) {
        this.bankNumber = bankNumber;
    }

    public int getNrbControlCode() {
        return nrbControlCode;
    }

    public void setNrbControlCode(int nrbControlCode) {
        this.nrbControlCode = nrbControlCode;
    }

    public String getExtOfAccountNumber() {
        return extOfAccountNumber;
    }

    public void setExtOfAccountNumber(String extOfAccountNumber) {
        this.extOfAccountNumber = extOfAccountNumber;
    }

    public String getKtr() {
        return ktr;
    }

    public void setKtr(String ktr) {
        this.ktr = ktr;
    }

    public String getPaymentDetails1() {
        return paymentDetails1;
    }

    public void setPaymentDetails1(String paymentDetails1) {
        this.paymentDetails1 = paymentDetails1;
    }

    public String getPaymentDetails2() {
        return paymentDetails2;
    }

    public void setPaymentDetails2(String paymentDetails2) {
        this.paymentDetails2 = paymentDetails2;
    }

    public String getPaymentDetails3() {
        return paymentDetails3;
    }

    public void setPaymentDetails3(String paymentDetails3) {
        this.paymentDetails3 = paymentDetails3;
    }

    public String getPaymentDetails4() {
        return paymentDetails4;
    }

    public void setPaymentDetails4(String paymentDetails4) {
        this.paymentDetails4 = paymentDetails4;
    }

    public String getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(String uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    @Override
    public String toString() {
        return "PekaoTransaction{" +
                "identifier=" + identifier +
                ", internalCode=" + internalCode +
                ", payerAccountNumber='" + payerAccountNumber + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", postingDate=" + postingDate +
                ", paymentDate=" + paymentDate +
                ", payer1='" + payer1 + '\'' +
                ", payer2='" + payer2 + '\'' +
                ", payer3='" + payer3 + '\'' +
                ", payer4='" + payer4 + '\'' +
                ", bankNumber=" + bankNumber +
                ", nrbControlCode=" + nrbControlCode +
                ", extOfAccountNumber=" + extOfAccountNumber +
                ", ktr='" + ktr + '\'' +
                ", paymentDetails1='" + paymentDetails1 + '\'' +
                ", paymentDetails2='" + paymentDetails2 + '\'' +
                ", paymentDetails3='" + paymentDetails3 + '\'' +
                ", paymentDetails4='" + paymentDetails4 + '\'' +
                ", uniqueNumber='" + uniqueNumber + '\'' +
                '}';
    }
}
