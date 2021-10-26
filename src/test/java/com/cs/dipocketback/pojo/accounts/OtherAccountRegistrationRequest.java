package com.cs.dipocketback.pojo.accounts;

public class OtherAccountRegistrationRequest {

    private Long id;
    private String accountName;
    private String cardPAN;
    private String cardHolderName;
    private String cardPostCode;
    private String cardValidThru;
    private String cardCVV;
    private String ccy;

    public OtherAccountRegistrationRequest() {
    }

    public OtherAccountRegistrationRequest(Long id,
                                           String accountName,
                                           String cardPAN,
                                           String cardHolderName,
                                           String cardPostCode,
                                           String cardValidThru,
                                           String cardCVV,
                                           String cardCcy) {
      this.id = id;
      this.cardPAN = cardPAN;
      this.cardHolderName = cardHolderName;
      this.cardPostCode = cardPostCode;
      this.cardValidThru = cardValidThru;
      this.cardCVV = cardCVV;
      this.accountName = accountName;
      this.ccy = cardCcy;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCardPAN(String cardPAN) {
        this.cardPAN = cardPAN;
    }

    public String getCardPAN() {
        return cardPAN;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardPostCode(String cardPostCode) {
        this.cardPostCode = cardPostCode;
    }

    public String getCardPostCode() {
        return cardPostCode;
    }

    public void setCardValidThru(String cardValidThru) {
        this.cardValidThru = cardValidThru;
    }

    public String getCardValidThru() {
        return cardValidThru;
    }

    public void setCardCVV(String cardCVV) {
        this.cardCVV = cardCVV;
    }

    public String getCardCVV() {
        return cardCVV;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getCcy() {
        return ccy;
    }

    @Override
    public String toString() {
        return "OtherAccountRegistrationRequest{" + "id=" + id + ", accountName=" + accountName + ", " +
                "cardPAN=" + cardPAN + ", cardHolderName=" + cardHolderName + ", cardPostCode=" + cardPostCode + ", " +
                "cardValidThru=" + cardValidThru + ", cardCVV=" + cardCVV + ", cardCcy=" + ccy + '}';
    }

}
