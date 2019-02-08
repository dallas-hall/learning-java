package Chapter12;

import java.util.*;

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
	private Card[] availableCards;
	private Card[] unavailableCards;
	private int unavailableCardsSize;
	
	//@@@ CONSTRUCTOR(S) @@@
	public CardDeck()
	{
		availableCards = new Card[52];
		unavailableCards = new Card[52];
		unavailableCardsSize = 0;
		makeDeck();
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public Card[] getAvailableCards()
	{
		return availableCards;
	}
	
	public Card[] getUnavailableCards()
	{
		return unavailableCards;
	}
	//### GETTERS ###
	private void makeDeck()
	{
		int index = 0;
		// 0 = clubs, 1 = diamonds, 2 = hearts, and 3 = spades
		for (int suit = 0; suit <= 3; suit++) {
			// 1 = ace (start) through to 13 = king (end)
			for(int rank = 0; rank <= 12; rank++) {
				availableCards[index] = new Card(rank, suit);
				index++;
			}
		}
	}
	
	public void shuffleCards()
	{
	
	}
	
	public void makeCardUnavailable(Card card) {
		card.setAvailable(false);
		unavailableCards[unavailableCardsSize] = card;
		unavailableCardsSize++;
	}
	
	public boolean makeCardAvailable(Card card) {
		int result = isAvailable(card);
		if (result >= 0) {
			card.setAvailable(true);
			unavailableCards[result] = null;
			unavailableCards = adjustUnavailableCards(unavailableCards);
			unavailableCardsSize--;
			return true;
		}
		return false;
	}
	
	//### HELPERS ###
	private Card[] adjustUnavailableCards(Card[] cards)
	{
		ArrayList<Card> arrayList = new ArrayList<>();
		for(Card currentCard : cards) {
			if(currentCard != null) {
				arrayList.add(currentCard);
			}
		}

		return (Card[]) arrayList.toArray();
	}
	
	public void printAllAvailableCards()
	{
		if (availableCards[0] == null) {
			System.out.println("No cards in the deck.");
		}
		else {
			for (Card card : availableCards) {
				// Implicit call to toString
				System.out.println(card);
			}
		}
	}
	
	public void printAllUnavailableCards()
	{
		if (unavailableCards[0] == null) {
			System.out.println("No cards in the deck.");
		}
		else {
			for (Card card : unavailableCards) {
				// Implicit call to toString
				System.out.println(card);
			}
		}
	}
	
	public int isAvailable(Card card)
	{
		for(int i = 0; i < unavailableCardsSize; i++) {
			if(unavailableCards[i].equals(card)) {
				return i;
			}
		}
		return -1;
	}
	
	public int sequentialSearch(Card target)
	{
		for (int i = 0; i < availableCards.length; i++) {
			if (availableCards[i].equals(target)) {
				return i;
			}
		}
		return -1;
	}
	
	public int binarySearchLoop(Card target)
	{
		int low = 0;
		int high = availableCards.length - 1;
		int steps = 0;
		// If the value of low exceeds the value of high, there are no more cards in range to look at.
		while (low <= high) {
			// Start in the middle of low and high
			int mid = (low + high) / 2;
			// Check the card at the middle point against the target
			int compareResult = availableCards[mid].compareTo(target);
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
		int compareResult = availableCards[mid].compareTo(target);
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
	
	public int[] suitHistory(Card[] cards)
	{
		// The histogram returned is ordered by suit and rank, using the order in Card's class variables.
		int[] histogram = new int[52];
		for (int i = 0; i < cards.length; i++) {
			// Add to the histogram every card in the hand
			int suit = cards[i].getSuit() * 10;
			int rank = 0;
			// Ensuring the rank is correct, as it will be 0-12, 13-25, 26-38, 39-51
			if (suit == 10) {
				rank = cards[i].getRank() + 3;
			} else if (suit == 20) {
				rank = cards[i].getRank() + 6;
			} else if (suit == 30) {
				rank = cards[i].getRank() + 9;
			} else {
				rank = cards[i].getRank();
			}
			histogram[rank + suit]++;
		}
		System.out.println(Arrays.toString(histogram));
		return histogram;
	}
}

