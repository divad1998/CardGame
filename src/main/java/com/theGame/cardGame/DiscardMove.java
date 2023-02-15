package com.theGame.cardGame;

public class DiscardMove {
    private int card;
    private int pileNumber;

    public DiscardMove(int card, int pileNumber) {
        this.card = card;
        this.pileNumber = pileNumber;
    }


    public int getCard() {
        return card;
    }

    public int getPileNumber() {
        return pileNumber;
    }
}
