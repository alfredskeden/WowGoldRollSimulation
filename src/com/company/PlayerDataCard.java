package com.company;

public class PlayerDataCard {

    String name;
    int amountOfGold;
    int roll;
    int goldThreshold = 0;

    public int getGoldThreshold() {
        return goldThreshold;
    }

    public void setGoldThreshold(int goldThreshold) {
        this.goldThreshold = goldThreshold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountOfGold() {
        return amountOfGold;
    }

    public int getRoll() {
        return roll;
    }

    public void setAmountOfGold(int amountOfGold) {
        this.amountOfGold = amountOfGold;
    }

    public int setRoll(int roll) {
        this.roll = roll;
        return this.roll;
    }
}
