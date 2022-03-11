/**
 * @author James Nelson and Neil Lukowski
 * @updated September 25, 2019
 * @filename Suit.java
 * @description This file creates a "Suit" enum that contains the suits of a standard card
 * used in 5 Card Draw Poker. This file is referenced by Card.java to create a playing card.
 * This enum is used in fulfillment of requirements for Programming Assignment 1 – Five Card Draw in CS 151-01.
 */

enum Suit {
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3),
    CLUBS(4);

    private int suit;

    private Suit(int suit) {
        this.suit = suit;
    }
    public int getSuit() {
        return this.suit;
    }
}