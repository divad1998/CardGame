package com.theGame.cardGame;

import java.util.Scanner;

public class Human implements Player {
    private Hand hand;
    private Scanner scanner;
    Table table;
    Deck deck;

    public Human(Hand hand) {
        this.hand = hand;
    }

    @Override
    public MoveType nextMove() {
        //before each move, show how many cards are left in deck
        System.out.println("Deck: [" + deck.cardCount + "]");
        //print & describe number of piles and top card of each
        System.out.println("Discard Piles:");
        int pileNo = 1;
        for (int i = 0; i < table.piles.length; i++) {
            if (pileNo == 1 || pileNo == 4) {
                System.out.println(pileNo + ": +" + "{" + table.piles[i].getTopCard() + "}");
                pileNo++;
            } else {
                System.out.println(pileNo + ": -" + "{" + table.piles[i].getTopCard() + "}");
                pileNo++;
            }
        }
        //print cards in hand
        System.out.println(hand.toString());

        System.out.print("d(iscard) or p(ass) >> ");
        scanner = new Scanner(System.in);
        String move = scanner.next();
        if (move.equalsIgnoreCase("d")) {
            return MoveType.DISCARD;
        } else {
            return MoveType.PASS;
        }
    }

    @Override
    public DiscardMove discard() {
        System.out.print("card number >> ");
        scanner = new Scanner(System.in);
        int card = scanner.nextInt();

        System.out.print("pile number >> ");
        scanner = new Scanner(System.in);
        int pileNo = scanner.nextInt();

        return new DiscardMove(card, pileNo);
    }

    @Override
    public void deal(Table table, Deck deck) {
        this.table = table;
        this.deck = deck;
        //card is drawn from deck
        //add card to player's hand
        for (int index = 0; index < hand.cards.length; index++) {
            if (hand.cards[index] == 0) {
                //table draws, deck draws, card is passed to hand
                int card = table.draw();
                //After draw is complete, reduce size of deck and cardCount
                deck.top = deck.cards[deck.top - 1];
                deck.cardCount = deck.cardCount - 1;

                System.out.println("Dealing "+ card + " to player...");

                hand.deal(index, card);
            }
        }
    }

    @Override
    public boolean handIsFull() {
        return hand.isFull();
    }

    @Override
    public boolean handIsEmpty() {
        return false;
    }

    @Override
    public boolean confirmGameOver() {
        System.out.println("Are you sure? This will end the game.");
        System.out.print("y/n?  >>  ");
        scanner = new Scanner(System.in);
        System.out.println();
        String choice = scanner.next();
        if (choice.equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Hand getHand() {
        return hand;
    }
}