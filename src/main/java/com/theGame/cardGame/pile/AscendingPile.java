package com.theGame.cardGame.pile;

public class AscendingPile extends DiscardPile {
    private int topCard;
    private int cardCount;

    private String RULES;

    public AscendingPile(int topCard) {
        super(topCard);
        this.topCard = topCard;
    }

    @Override
    public int getTopCard() {
        return topCard;
    }

    @Override
    public int getCardCount() {
        return cardCount;
    }

    @Override
    public boolean discard(int card) {
        if (card > topCard || topCard - 10 == card) {
            cardCount++;
            topCard = card;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getRules() {
        return null;
    }
}
