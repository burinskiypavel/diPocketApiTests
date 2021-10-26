package com.cs.dipocketback.pojo.festival;

public class FestivalRequest {

    private String cardPan;
    private String pin;
    private Boolean festivalCard;
    private String clientStatus;
    private Boolean cardBlocked;
    private Long availableBalance;
    private Long balance;
    private Long blocked;
    private String publicToken;
    private String dipToken;
    private String token;
    private String userName;
    private Boolean hasOtherCards;
    private Boolean isLinked;
    private String login;
    private Boolean isActive;

    //cashLoad
    private String ccy;
    private Long amount;
    private String qrCode;

    private Long feeAmount;
    private Integer feeCcyId;
    private String feeCcy;
    private String feeName;

    //linkCardByQR
    private String qrPhoneNumber;

    private Boolean isSupervisorCard;

    public FestivalRequest() {
    }
    
    public FestivalRequest(String qrCode, String feeCcy, Integer feeCcyId, Long feeAmount) {
        this.qrCode = qrCode;
        this.feeCcy = feeCcy;
        this.feeCcyId = feeCcyId;
        this.feeAmount = feeAmount;
    }

    public FestivalRequest(String qrCode, String ccy, Long amount) {
        this.qrCode = qrCode;
        this.ccy = ccy;
        this.amount = amount;
    }

    public FestivalRequest(Boolean festivalCard) {
        this.festivalCard = festivalCard;
    }

    public void setCardPan(String cardPan) {
        this.cardPan = cardPan;
    }

    public String getCardPan() {
        return cardPan;
    }

    public void setFestivalCard(Boolean festivalCard) {
        this.festivalCard = festivalCard;
    }

    public Boolean getFestivalCard() {
        return festivalCard;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }

    public String getClientStatus() {
        return clientStatus;
    }

    public void setCardBlocked(Boolean cardBlocked) {
        this.cardBlocked = cardBlocked;
    }

    public Boolean getCardBlocked() {
        return cardBlocked;
    }

    public void setAvailableBalance(Long availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Long getAvailableBalance() {
        return availableBalance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBlocked(Long blocked) {
        this.blocked = blocked;
    }

    public Long getBlocked() {
        return blocked;
    }

    public void setPublicToken(String publicToken) {
        this.publicToken = publicToken;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setHasOtherCards(Boolean hasOtherCards) {
        this.hasOtherCards = hasOtherCards;
    }

    public Boolean getHasOtherCards() {
        return hasOtherCards;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getCcy() {
        return ccy;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setIsLinked(Boolean isLinked) {
        this.isLinked = isLinked;
    }

    public Boolean getIsLinked() {
        return isLinked;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setQrPhoneNumber(String qrPhoneNumber) {
        this.qrPhoneNumber = qrPhoneNumber;
    }

    public String getQrPhoneNumber() {
        return qrPhoneNumber;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setFeeAmount(Long feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Long getFeeAmount() {
        return feeAmount;
    }

    public void setFeeCcyId(Integer feeCcyId) {
        this.feeCcyId = feeCcyId;
    }

    public Integer getFeeCcyId() {
        return feeCcyId;
    }

    public void setFeeCcy(String feeCcy) {
        this.feeCcy = feeCcy;
    }

    public String getFeeCcy() {
        return feeCcy;
    }

    public void setDipToken(String dipToken) {
        this.dipToken = dipToken;
    }

    public String getDipToken() {
        return dipToken;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName;
    }

    public String getFeeName() {
        return feeName;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public Boolean getSupervisorCard() {
        return isSupervisorCard;
    }

    public void setSupervisorCard(Boolean supervisorCard) {
        isSupervisorCard = supervisorCard;
    }

    public void clear() {
        cardPan = null;
        qrCode = null;
    }
}
