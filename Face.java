/**
 * @author James Nelson and Neil Lukowski
 * @updated September 25, 2019
 * @filename Face.java
 * @description This file creates a "Face" enum that contains the card name, rank, and point value of a standard card
 * used in 5 Card Draw Poker. This file is referenced by Card.java to create a playing card.
 * This enum is used in fulfillment of requirements for Programming Assignment 1 – Five Card Draw in CS 151-01.
 */
enum Face {
    ACE("Ace", 1, 1),
    TWO("Two", 2, 2),
    THREE("Three", 3, 3),
    FOUR("Four", 4, 4),
    FIVE("Five", 5, 5),
    SIX("Six", 6, 6),
    SEVEN("Seven", 7, 7),
    EIGHT("Eight", 8, 8),
    NINE("Nine", 9, 9),
    TEN("Ten", 10, 10),
    JACK("Jack", 11, 10),
    QUEEN("Queen", 12, 10),
    KING("King", 13, 10);

    private String cardName;
    private int points;
    private int rank;

    private Face (String cardName, int rank, int points) {
        this.cardName = cardName;
        this.rank = rank;
        this.points = points;
    }
    public String getName() {
        return this.cardName;
    }
    public int getRank() {
        return this.rank;
    }
    public int value() {
        return points;
    }
}