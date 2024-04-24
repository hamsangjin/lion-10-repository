package com.example.thegame;

import java.util.*;

public class Deck {
    private List<Integer> deck;

    public Deck() {
        this.deck = new LinkedList<>();

        for (int i = 2; i < 100; i++) {
            deck.add(i);
        }
        Collections.shuffle(deck);
    }

    public int getDeck() {
        return deck.removeLast();
    }

    public int restOfDeck() {
        return deck.size();
    }
}
