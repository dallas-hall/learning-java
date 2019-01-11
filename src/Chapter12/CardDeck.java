package Chapter12;

import Chapter09.Palindrome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * <h1>CardDeck</h1>
 * <p>
 * This program creates a deck of cards and fills them with cards in suited and ranked order.
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2019-01-11
 */


public class CardDeck
{
	//@@@ INSTANCE VARIABLES @@@
	private Card[] cards;
	
	//@@@ CONSTRUCTOR(S) @@@
	public CardDeck()
	{
		cards = new Card[52];
		createCards();
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public Card[] getCards()
	{
		return cards;
	}
	
	//### HELPERS ###
	private void createCards()
	{
		int index = 0;
		// 0 = clubs, 1 = diamonds, 2 = hearts, and 3 = spades
		for (int suit = 0; suit <= 3; suit++) {
			// 1 = ace (start) through to 13 = king (end)
			for(int rank = 0; rank <= 12; rank++) {
				cards[index] = new Card(rank, suit);
				index++;
			}
		}
	}
	
	public void printAllCards()
	{
		if (cards[0] == null) {
			System.out.println("No cards in the deck.");
		}
		else {
			for (Card card : cards) {
				// Implicit call to toString
				System.out.println(card);
			}
		}
	}
	
	public void shuffleCards()
	{
	
	}
	
	public int sequentialSearch(Card target)
	{
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].equals(target)) {
				return i;
			}
		}
		return -1;
	}
	
	public int binarySearchLoop(Card target)
	{
		int low = 0;
		int high = cards.length - 1;
		int steps = 0;
		// If the value of low exceeds the value of high, there are no more cards in range to look at.
		while (low <= high) {
			// Start in the middle of low and high
			int mid = (low + high) / 2;
			// Check the card at the middle point against the target
			int compareResult = cards[mid].compareTo(target);
			steps++;
			
			// If both cards match, return the index which is the value in middle.
			if (compareResult == 0) {
				return mid;
			// If the card compared to is lower than the target, search between middle value + 1 and high.
			} else if (compareResult < 0) {
				low = mid + 1;
			// If the card compared to is higher than the target, search between low and middle value - 1.
			} else {
				high = mid -1;
			}
		}
		return -1;
	}
	
	public int binarySearchRecursive(Card target, int low, int high)
	{
		// If the value of high is less than the value of low, there are no more cards in range to look at.
		if (high < low) {
			return -1;
		}
		
		// Start in the middle of low and high
		int mid = (low + high) / 2;
		// Check the card at the middle point against the target
		int compareResult = cards[mid].compareTo(target);
		int recursionResult;
		
		// If both cards match, return the index which is the value in middle.
		if (compareResult == 0) {
			return mid;
		// If the card compared to is lower than the target, search between middle value + 1 and high.
		} else if (compareResult < 0) {
			recursionResult = binarySearchRecursive(target, mid + 1, high);
			return recursionResult;
		// If the card compared to is higher than the target, search between low and middle value - 1.
		} else {
			recursionResult = binarySearchRecursive(target, low, mid - 1);
			return recursionResult;
		}
	}
}

