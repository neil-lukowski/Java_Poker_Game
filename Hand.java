/**
 * @author Neil Lukowski & James Nelson
 * @updated September 25, 2019
 * @filename Hand.java
 * @description This file simulates a hand of five playing cards and returns a value representing what kind of
 * hand the cards represent, according to hands of five card draw. This file also prints the contents of
 * the hands in question. This class is used in fulfillment of requirements for
 * Programming Assignment 1 – Five Card Draw in CS 151-01.
 */

import java.util.Arrays;

public class Hand {
    private Card[] oneHand;
    private static int HANDSIZE;

    public Hand(int numCards) {
        HANDSIZE = numCards;
        this.oneHand = new Card[HANDSIZE];
    }
    public Hand() {
        this(HANDSIZE);
    }
    public void setCard(int index, Card newCard) {
        this.oneHand[index] = newCard;
    }

    /**
     * This method will sort a hand into ascending order. Will only work in Java 8 or higher.
     * It makes the assumption that you have an array of N Cards named 'cards'; cards
     * is a field within this class.
     */
    public void sort() {
        Arrays.sort(oneHand, (Card u1, Card u2) -> u1.compareTo(u2));
    }
    public WinHand getHandType() {
        WinHand handType = null;
        if (royalFlush() == true) {
            handType = WinHand.ROYALFLUSH;
        }
        else if (straightFlush() == true) {
            handType = WinHand.STRAIGHTFLUSH;
        }
        else if (fourOfAKind() == true) {
            handType = WinHand.FOUROFAKIND;
            getFourKind();
        }
        else if (fullHouse() == true) {
            handType = WinHand.FULLHOUSE;
        }
        else if (straight() == true) {
            handType = WinHand.STRAIGHT;
        }
        else if (flush() == true) {
            handType = WinHand.FLUSH;
        }
        else if (threeOfAKind() == true) {
            handType = WinHand.THREEOFAKIND;
            getThreeKind();
        }
        else if (twoPair() == true) {
            handType = WinHand.TWOPAIR;
        }
        else if (pair() == true) {
            handType = WinHand.PAIR;
            getPair();
        }
        else {
            handType = WinHand.HIGHCARD;
            getHighestCard();
        }
        return handType;
    }
    public int getPair() {
        int pair = 0;
        int i;
        for (i = oneHand.length - 1; i > 0; i--) {
            Card thisCard = oneHand[i];
            Card thatCard = oneHand[i - 1];
            if (thisCard.compareTo(thatCard) == 0) {
                pair = thisCard.rank();
                break;
            }
        }
        return pair;
    }
    public int getThreeKind() {
        Card midCard = oneHand[2];
        return midCard.rank();
    }
    public int getFourKind() {
        Card midCard = oneHand[2];
        return midCard.rank();
    }
    public int getHighestCard() {
        Card highCard = oneHand[4];
        return highCard.rank();
    }
    public boolean royalFlush() {
        boolean isRoyalFlush = oneHand[0].rank() == 1 &&
                oneHand[1].rank() == 10 && oneHand[2].rank() == 11 &&
                oneHand[3].rank() == 12 && oneHand[4].rank() == 13 &&
                oneHand[0].getSuit() == oneHand[1].getSuit() &&
                oneHand[1].getSuit() == oneHand[2].getSuit() &&
                oneHand[2].getSuit() == oneHand[3].getSuit() &&
                oneHand[3].getSuit() == oneHand[4].getSuit();
        /**
         int i;
         int tmp = 0;
         if (oneHand[4].getName() == Face.ACE) {
         for (i = oneHand.length - 1; i > 0; i--) {
         Card thisCard = oneHand[i];
         Card thatCard = oneHand[i - 1];
         if (thisCard.rank() - 1 == thatCard.rank()) {
         if (thisCard.getSuit() == thatCard.getSuit()) {
         tmp++;
         }
         }
         if (tmp == 4) {
         isRoyalFlush = true;
         break;
         }
         }
         }
         */
        return isRoyalFlush;
    }
    public boolean straightFlush() {
        boolean isStraightFlush = false;
        int i;
        int tmp = 0;
        for (i = oneHand.length - 1; i > 0; i--) {
            Card thisCard = oneHand[i];
            Card thatCard = oneHand[i - 1];
            if (thisCard.rank() - 1 == thatCard.rank()) {
                if (thisCard.getSuit() == thatCard.getSuit()) {
                    tmp++;
                }
            }
            if (tmp == 4) {
                isStraightFlush = true;
                break;
            }
        }
        return isStraightFlush;
    }
    public boolean straight() {
        boolean isStraight = false;
        int i;
        int tmp = 0;
        for (i = oneHand.length - 1; i > 0; i--) {
            Card thisCard = oneHand[i];
            Card thatCard = oneHand[i - 1];
            if (thisCard.rank() - 1 == thatCard.rank()) {
                tmp++;
            }
            if (tmp == 4) {
                isStraight = true;
                break;
            }
        }
        return isStraight;
    }
    public boolean flush() {
        boolean isFlush = oneHand[0].getSuit() == oneHand[1].getSuit() &&
                oneHand[1].getSuit() == oneHand[2].getSuit() &&
                oneHand[2].getSuit() == oneHand[3].getSuit() &&
                oneHand[3].getSuit() == oneHand[4].getSuit();
        /**int i;
         int tmp = 0;
         for (i = oneHand.length - 1; i > 0; i--) {
         Card thisCard = oneHand[i];
         Card thatCard = oneHand[i - 1];
         if (thisCard.getSuit() == thatCard.getSuit()) {
         tmp++;
         }
         if (tmp == 4) {
         isFlush = true;
         break;
         }
         }*/
        return isFlush;
    }
    public boolean fourOfAKind() {
        boolean isFourKind = oneHand[0].rank() == oneHand[1].rank() &&
                oneHand[1].rank() == oneHand[2].rank() &&
                oneHand[2].rank() == oneHand[3].rank() ||
                oneHand[1].rank() == oneHand[2].rank() &&
                        oneHand[2].rank() == oneHand[3].rank() &&
                        oneHand[3].rank() == oneHand[4].rank();
        /**int i;
         int tmp = 0;
         for (i = oneHand.length - 1; i > 0; i--) {
         Card thisCard = oneHand[i];
         Card thatCard = oneHand[i - 1];
         if (thisCard.compareTo(thatCard) == 0) {
         tmp++;
         }
         if (tmp == 3) {
         isFourKind = true;
         }
         }*/
        return isFourKind;
    }
    public boolean threeOfAKind() {
        boolean isThreeKind = oneHand[0].rank() == oneHand[2].rank() ||
                oneHand[2].rank() == oneHand[4].rank();
        /**int i;
         int tmp = 0;
         for (i = oneHand.length - 1; i > 0; i--) {
         Card thisCard = oneHand[i];
         Card thatCard = oneHand[i - 1];
         if (thisCard.compareTo(thatCard) == 0) {
         tmp++;
         }
         if (tmp == 2) {
         isThreeKind = true;
         }
         }*/
        return isThreeKind;
    }
    public boolean twoPair() {
        boolean isTwoPair = false;
        int i;
        int tmp = 0;
        for (i = 0; i < 4; i++) {
            Card thisCard = oneHand[i];
            Card thatCard = oneHand[i + 1];
            if (thisCard.compareTo(thatCard) == 0) {
                tmp++;
            }
            if (tmp == 2) {
                isTwoPair = true;
            }
        }
        return isTwoPair;
    }
    public boolean pair() {
        boolean isPair = false;
        int i;
        for (i = 0; i < 4; i++) {
            Card thisCard = oneHand[i];
            Card thatCard = oneHand[i + 1];
            if (thisCard.compareTo(thatCard) == 0) {
                isPair = true;
            }
        }
        return isPair;
    }
    public boolean fullHouse() {
        boolean isFullHouse = false;
        boolean firstCase = oneHand[0].rank() == oneHand[1].rank() &&
                oneHand[1].rank() == oneHand[2].rank() &&
                oneHand[3].rank() == oneHand[4].rank();
        boolean secondCase = oneHand[4].rank() == oneHand[3].rank() &&
                oneHand[3].rank() == oneHand[2].rank() &&
                oneHand[1].rank() == oneHand[0].rank();
        if (firstCase == true || secondCase == true) {
            isFullHouse = true;
        }
        return isFullHouse;
    }
    public String toString() {
        int i;
        /**
         Scanner myScanner = new Scanner(System.in);
         */
        String cardString = "";
        for (i = 0; i < this.oneHand.length; i++) {
            String cardName = "";
            String cardSuit = "";
            if (this.oneHand[i].rank() == 1) {
                cardName = "Ace of ";
            }
            else if (this.oneHand[i].rank() == 2) {
                cardName = "Two of ";
            }
            else if (this.oneHand[i].rank() == 3) {
                cardName = "Three of ";
            }
            else if (this.oneHand[i].rank() == 4) {
                cardName = "Four of ";
            }
            else if (this.oneHand[i].rank() == 5) {
                cardName = "Five of ";
            }
            else if (this.oneHand[i].rank() == 6) {
                cardName = "Six of ";
            }
            else if (this.oneHand[i].rank() == 7) {
                cardName = "Seven of ";
            }
            else if (this.oneHand[i].rank() == 8) {
                cardName = "Eight of ";
            }
            else if (this.oneHand[i].rank() == 9) {
                cardName = "Nine of ";
            }
            else if (this.oneHand[i].rank() == 10) {
                cardName = "Ten of ";
            }
            else if (this.oneHand[i].rank() == 11) {
                cardName = "Jack of ";
            }
            else if (this.oneHand[i].rank() == 12) {
                cardName = "Queen of ";
            }
            else if (this.oneHand[i].rank() == 13) {
                cardName = "King of ";
            }
            if (this.oneHand[i].getSuit() == Suit.DIAMONDS) {
                cardSuit = "Diamonds";
            }
            else if (this.oneHand[i].getSuit() == Suit.HEARTS) {
                cardSuit = "Hearts";
            }
            else if (this.oneHand[i].getSuit() == Suit.SPADES) {
                cardSuit = "Spades";
            }
            else if (this.oneHand[i].getSuit() == Suit.CLUBS) {
                cardSuit = "Clubs";
            }
            cardString = cardString + "\n" + i + ":" + cardName + cardSuit;
        }
        return cardString;
    }
}