/**
 * @author James Nelson and Neil Lukowski
 * @updated September 25, 2019
 * @filename Game.java
 * @description This file models a game of 5 Card Draw Poker. It creates a deck of cards, shuffles the deck,
 * displays the hands in formatted text, deals to the player and the computer,
 * allows the a single card to be dealt, runs the game conditions, and prints the winner.
 * This class is used in fulfillment of requirements for Programming Assignment 1 – Five Card Draw in CS 151-01.
 */

import java.util.Random;
import java.util.Scanner;

public class Game {
	private Card[] deck;
	private Hand playerHand;
	private Hand computerHand;
	private static int DECKSIZE;
	private static int DECKCARDS;
	private static int USEDCARDS;
	private static int HANDSIZE;

	public Game() {
		DECKSIZE = 51;
		DECKCARDS = 52;
		USEDCARDS = 10;
		HANDSIZE = 4;
		this.deck = new Card[DECKCARDS];
		int i = 0;
		for (Suit s : Suit.values()) {
			for (Face f : Face.values()) {
				deck[i] = new Card(f,s);
				i++;
			}
		}
		this.playerHand = new Hand(5);
		this.computerHand = new Hand(5);
	}
	public void shuffle() {
		Random rand = new Random();
		int i;
		for (i = 0; i <= DECKSIZE; i++) {
			int randomPosition = rand.nextInt(DECKCARDS);
			Card temp = deck[randomPosition];
			deck[randomPosition] = deck[i];
			deck[i] = temp;
		}
	}
	public void displayHand(Hand thisHand) {
		playerHand.sort();
		computerHand.sort();
		if (thisHand == this.playerHand) {
			System.out.println("\nPlayer:");
		}
		else if (thisHand == this.computerHand) {
			System.out.println("\nComputer:");
		}
		String handString = thisHand.toString();
		System.out.println(handString);
	}
	public void deal() {
		shuffle();
		int i;
		int j;
		for (i = 0; i <= HANDSIZE; i++) {
			playerHand.setCard(i, deck[i]);
		}
		for (j = 0; j <= HANDSIZE; j++) {
			computerHand.setCard(j, deck[j + 5]);
		}
	}
	public void dealOne(int index, Hand thisHand, Card newCard) {
		thisHand.setCard(index, newCard);
	}
	public void go() {
		deal();
		boolean isPlayerWinner = false;
		int usedCards = USEDCARDS;
		displayHand(playerHand);
		Scanner myScanner = new Scanner(System.in);
		System.out.println("How many cards do you want to discard? > ");
		int discardAmount = myScanner.nextInt();
		int discardIndex = 0;
		int i;
		if (discardAmount != 0) {
			System.out.println("Which " + discardAmount + " would you like to swap? > ");
			for (i = 0; i < discardAmount; i++) {
				discardIndex = myScanner.nextInt();
				playerHand.setCard(discardIndex, deck[i + usedCards]);
				usedCards++;
			}
		}
		myScanner.close();
		displayHand(computerHand);
		displayHand(playerHand);
		WinHand playerHandType = playerHand.getHandType();
		WinHand computerHandType = computerHand.getHandType();
		if (playerHandType.getWinHand() < computerHandType.getWinHand()) {
			isPlayerWinner = true;
		}
		else if (playerHandType.getWinHand() == computerHandType.getWinHand()) {
			if(playerHand.getHighestCard() > computerHand.getHighestCard()) {
				isPlayerWinner = true;
			}
		}
		printWinner(isPlayerWinner);
	}
	public void printWinner(boolean whoWon) {
		WinHand playerHandType = playerHand.getHandType();
		WinHand computerHandType = computerHand.getHandType();
		if (whoWon == true) {
			System.out.println("\nPlayer wins with a " + playerHandType.getWinHandName());
		}
		else if (whoWon == false) {
			System.out.println("\nComputer wins with a " + computerHandType.getWinHandName());
		}
	}
	public static void main(String[] args) {
		Game thisGame = new Game();
		thisGame.go();
	}
}