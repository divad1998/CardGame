package com.theGame.cardGame;

public interface Player {
    MoveType nextMove();
    DiscardMove discard();
    void deal(Table table, Deck deck);

    boolean handIsFull();
    boolean handIsEmpty();
    boolean confirmGameOver();

    Hand getHand();
}
