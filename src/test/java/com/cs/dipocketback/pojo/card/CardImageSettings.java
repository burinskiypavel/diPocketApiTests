package com.cs.dipocketback.pojo.card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardImageSettings {

    private String frontImageRef;
    private String backImageRef;
    private String fontRgb;

    private DrawContainer pan;
    private DrawContainer expDate;
    private DrawContainer cardHolderName;
    private DrawContainer currency;
    private DrawContainer cvv;

    public List<DrawContainer> getDrawContainerList() {
        List<DrawContainer> list = new ArrayList<>(5);
        list.add(pan);
        list.add(expDate);
        list.add(cardHolderName);
        list.add(currency);
        list.add(cvv);
        return list;
    }

    public String getFrontImageRef() {
        return frontImageRef;
    }

    public void setFrontImageRef(String frontImageRef) {
        this.frontImageRef = frontImageRef;
    }

    public String getBackImageRef() {
        return backImageRef;
    }

    public void setBackImageRef(String backImageRef) {
        this.backImageRef = backImageRef;
    }

    public String getFontRgb() {
        return fontRgb;
    }

    public void setFontRgb(String fontRgb) {
        this.fontRgb = fontRgb;
    }

    public DrawContainer getPan() {
        return pan;
    }

    public void setPan(DrawContainer pan) {
        this.pan = pan;
    }

    public DrawContainer getExpDate() {
        return expDate;
    }

    public void setExpDate(DrawContainer expDate) {
        this.expDate = expDate;
    }

    public DrawContainer getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(DrawContainer cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public DrawContainer getCurrency() {
        return currency;
    }

    public void setCurrency(DrawContainer currency) {
        this.currency = currency;
    }

    public DrawContainer getCvv() {
        return cvv;
    }

    public void setCvv(DrawContainer cvv) {
        this.cvv = cvv;
    }

    public static class DrawContainer {

        private String text;
        private int x;
        private int y;
        private Side side;
        private FieldType type;

        public DrawContainer(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public DrawContainer(String text, int x, int y) {
            this.text = text;
            this.x = x;
            this.y = y;
        }

        public DrawContainer(int x, int y, Side side, FieldType type) {
            this.x = x;
            this.y = y;
            this.side = side;
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Side getSide() {
            return side;
        }

        public void setSide(Side side) {
            this.side = side;
        }

        public FieldType getType() {
            return type;
        }

        public void setType(FieldType type) {
            this.type = type;
        }
    }

    public static enum Side {

        FRONT,
        BACK;

        private static Map<String, Side> map = new HashMap<>(2);
        static {
            for (Side side : values()) {
                map.put(side.name(), side);
            }
        }

        public static Side findByName(String name) {
            return map.get(name);
        }

    }


    public static enum FieldType {

        PAN,
        EXP_DATE,
        CARD_HOLDER_NAME,
        CURRENCY,
        CVV;

    }

}
