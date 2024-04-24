package com.example.thegame;

import java.util.Collections;
import java.util.List;

public class UserCard {
    private List<Integer> userCard;

    public void setUserCard(List<Integer> list) {
        this.userCard = list;
    }

    // 전체 카드 얻기
    public List<Integer> getUserCard() {
        return this.userCard;
    }

    // 특정 카드 얻기
    public int getSpecificUserCard(int index) {
        return userCard.get(index);
    }

    public void removeCard(Integer card) {
        userCard.remove(card);
    }

    public void addCard(int card) {
        userCard.add(card);
    }

    public void sortUserCard() {
        Collections.sort(userCard);
    }

    public boolean haveCard(Integer card) {
        return userCard.contains(card);
    }
}
