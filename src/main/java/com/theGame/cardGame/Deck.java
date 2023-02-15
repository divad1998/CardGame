package com.theGame.cardGame;

import java.util.Random;

public class Deck {
    int[] cards;
    int top;
    int cardCount = 18;

    public Deck() {
        Random random = new Random();
        cards = random.ints(18, 2, 19).toArray();
        top = cards[17];
    }

    /**
     * returns topmost card of deck
     * @return topmost card
     */
    public int drawCard() {
        //Algo:
        // if remainingCardCount > 0
        // return top
        //then top is assigned to cards[top--]
        //and, remainingCardCount is reduced
        if (remainingCardCount() > 0) {
            return top;
        }
        return 0;
    }

    public int remainingCardCount() {
        return cardCount;
    }
}