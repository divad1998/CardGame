package com.theGame.cardGame;

import com.theGame.cardGame.pile.AscendingPile;
import com.theGame.cardGame.pile.DescendingPile;
import com.theGame.cardGame.pile.DiscardPile;

public class TheGame {
    private Table table;
    //initialize card deck
    private Deck deck;
    private Player player;
    public TheGame(Table table, Player player, Deck deck) {
        this.table = table;
        this.player = player;
        this.deck = deck;
    }

	public static void main(String[] args) {

        //instantiate all discardPiles
        DiscardPile discardPile1 = new AscendingPile(1);
        DiscardPile discardPile2 = new DescendingPile(100);
        DiscardPile discardPile3 = new DescendingPile(100);
        DiscardPile discardPile4 = new AscendingPile(1);
        DiscardPile[] piles = {discardPile1, discardPile2, discardPile3, discardPile4};

        Deck deck = new Deck();
        //instantiate table
        Table tableInstance = new Table(piles, deck);

        //instantiate hand and human
        Hand hand = new Hand(6);
        Human human = new Human(hand);

        TheGame theGame = new TheGame(tableInstance, human, deck);
        theGame.play();
	}

    //ToDo: write play()
    public void play() {
        System.out.println("Welcome to your favorite card game.");

        int turnCount = 1;
        Integer turnMoves = 0;
        while(table.deckIsEmpty()) {
            System.out.println("<---------------- Turn #" + turnCount + " ---------------->");
            player.deal(table, deck); //turnMoves is passed by value
            for (turnMoves = 0; turnMoves < 6;) {
                MoveType moveType = player.nextMove();
                if (moveType.equals(MoveType.DISCARD)) {
                    DiscardMove discardMove = player.discard();
                    boolean discarded = table.discard(discardMove);
                    if (discarded) {
                        //remove card from hand
                        player.getHand().remove(discardMove.getCard());
                        turnMoves++;
                    }
                } else if (moveType.equals(MoveType.PASS)) {
                    if (turnMoves < 2) {
                        if (deck.cardCount == 0 && player.handIsEmpty()) {
                            System.out.println("You won! Good brain! Game over.");
                        } else {
                            if (player.confirmGameOver()) {
                                System.out.println("You lost! Play again! Game over.");
                            }
                        }
                    } else {
                        if (deck.cardCount == 0 && player.handIsEmpty()) {
                            System.out.println("You won! Nice effort! Game over.");
                        } else {
                            turnCount++;
                            turnMoves = 0; //value pass or ref?
                        }
                    }
                }
            }
        }

        //draw from deck
        //deal cards to player
        //player.deal(table);

        //Algo of discarding:
        //for loop (i = 1; i < 7; ), i would be an int outside loop
        //prompt player for next move: discarding or passing
        //if d is entered, prompt user for card number and pile number
        //then, attempt discard in human
        //if pile is 1 or 4, call AscendingPile.discard(); After each discard, reduce last of hand
        //discard() algo: <<if card is > getTopCard of pile 1 or 4 or getTopCard of pile 1 minus 10 == card or getTopCard of pile 4 minus 10 == card>> add to pile and return true, else return false
        // if pile is 2 or 3, call DescendingPile.discard();
        //And the algo: <<if card is < getTopCard of pile 2 or 3 or getTopCard of pile 2 plus 10 == card or getTopCard of pile 3 plus 10 == card>> add to pile and return true, else return false
        //if true is returned from any of both discards, remove discarded card from hand and increment i, else, don't.
        //---------------------
        //if p is entered, if i < 2
        //if true, check whether deck.size == 0 && handIsEmpty(), and if true,  sout You won! Game over.
        // else, call confirmGameEnd and if yes/true, sout Game over! You lost.
        // Else if i >= 2,
        //check whether deck.size == 0 && handIsEmpty(), and if true,  sout You won! Game over.
        //else, turnCount++ //and  call deal in player

        }
}