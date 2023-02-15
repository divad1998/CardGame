package com.theGame.cardGame;

import com.theGame.cardGame.pile.DiscardPile;

public class Table {
    DiscardPile[] piles;
    private Deck deck;

    public Table(DiscardPile[] piles, Deck deck) {
        this.piles = piles;
        this.deck = deck;
    }

    public int draw() {
        return deck.drawCard();
    }

    //public boolean discard(DiscardMove discard) {}

    public boolean deckIsEmpty() {
        if (deck.remainingCardCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

   public boolean discard(DiscardMove discardMove) {
       switch (discardMove.getPileNumber()) {
           case 1 -> {
               return piles[0].discard(discardMove.getCard());
           }
           case 2 -> {
               return piles[1].discard(discardMove.getCard());
           }
           case 3 -> {
               return piles[2].discard(discardMove.getCard());
           }
           case 4 -> {
               return piles[3].discard(discardMove.getCard());
           }
       }
       //won't be reached.
       return false;
   }
}