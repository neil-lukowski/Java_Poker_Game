/**
 * @author Neil Lukowski and James Nelson
 * @updated September 25, 2019
 * @filename WinHand.java
 * @description This enumeration represents a hand of five card draw according to standard five card draw rules.
 * This enum is used in fulfillment of requirements for Programming Assignment 1 – Five Card Draw in CS 151-01.
 */
public enum WinHand {
    ROYALFLUSH("Royal Flush", 1),
    STRAIGHTFLUSH("Straight Flush", 2),
    FOUROFAKIND("Four of a Kind", 3),
    FULLHOUSE("Full House", 4),
    STRAIGHT("Straight", 5),
    FLUSH("Flush", 6),
    THREEOFAKIND("Three of a Kind", 7),
    TWOPAIR("Two Pair", 8),
    PAIR("Pair", 9),
    HIGHCARD("High Card", 10);

    private int value;
    private String handName;

    private WinHand(String handName, int value) {
        this.value = value;
        this.handName = handName;
    }
    public int getWinHand() {
        return this.value;
    }
    public String getWinHandName() {
        return this.handName;
    }
}
