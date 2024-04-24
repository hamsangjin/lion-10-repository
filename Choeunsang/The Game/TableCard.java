package com.example.thegame;

public class TableCard {
    private final int[] tableCard; // 오름, 오름, 내림, 내림

    public TableCard() {
        this.tableCard = new int[]{1, 1, 100, 100};
    }

    // 카드 얹기
    public void setCard(int index, int cardNum) {
        tableCard[index] = cardNum;
    }

    // 전체 카드 얻기
    public int[] getCard() {
        return this.tableCard;
    }

    // 특정 카드 얻기
    public int getSpecificCard(int index) {
        return tableCard[index];
    }
}
