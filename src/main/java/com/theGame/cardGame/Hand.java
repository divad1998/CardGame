package com.theGame.cardGame;

public class Hand {
    int[] cards;

    private int last;

    public Hand(int capacity) {
        cards = new int[capacity];
    }

    /**
     * deals card to player
     * @param card
     * @return
     */
    public void deal(int index, int card) {
        //add card to player's hand
        cards[index] = card;
        last = index;
    }

    /**
     * remove discarded card from hand
     *
     */
    public void remove(int card) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == card) {
                cards[i] = cards[last];
                cards[last] = 0;
                --last;
            }
        }
    }

    public boolean isFull() {
        return cards[5] == 0;
    }

    public int getLast() {
        return last;
    }

    /**
     * returns the cards in player's hand.
     * @return string containing cards in player's hand.
     */
    public String toString() {
        String returnString = "";
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != 0) {
                returnString = returnString.concat(cards[i] + ", ");
            }
            //
        }
        //Algo:
        //trim returnString
        //get substring
        String formattedString = returnString.trim();
        String formattedString1 = formattedString.substring(0, formattedString.length() - 1);

        return "Human: [" + formattedString1 + "]";
    }
}