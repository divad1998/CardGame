package com.theGame.cardGame.pile;

public abstract class DiscardPile {
    private int topCard;
    private int cardCount;

    public DiscardPile(int topCard) {
        this.topCard = topCard;
    }

    public abstract int getTopCard();
    public abstract int getCardCount();
    public abstract boolean discard(int card);
    public abstract String getRules();
}
