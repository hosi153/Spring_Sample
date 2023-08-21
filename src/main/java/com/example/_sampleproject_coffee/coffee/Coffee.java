package com.example._sampleproject_coffee.coffee;

public class Coffee {
    private String korName;
    private String engName;
    private int price;

    public Coffee(String korName, String engName, int price) {
        this.korName = korName;
        this.engName = engName;
        this.price = price;
    }

    public String getKorName() {
        return korName;
    }

    public void setKorName(String korName) {
        this.korName = korName;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
