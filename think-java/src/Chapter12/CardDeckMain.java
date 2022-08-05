package Chapter12;
/**
 * <h1>CardDeckMain</h1>
 * <p>
 * This program creates a deck of cards and manipulates them.
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2019-01-11
 */

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Chapter12.Card.RANKS;
import static Chapter12.Card.SUITS;

public class CardDeckMain
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(CardDeckMain.class.getName());
	public static final String PROGRAM_VERSION = "0.1.0";
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Program starting.");
		logger.log(Level.INFO, "Creating & printing cards.");
		Thread.sleep(005);
		CardDeck deck1 =  new CardDeck();
		deck1.printAllAvailableCards();
		deck1.printAllUnavailableCards();
		
		logger.log(Level.INFO, "Sequential searching cards.");
		Thread.sleep(005);
		int searchResult = deck1.sequentialSearch(new Card(3, 1));
		if (searchResult != -1) {
			System.out.println("Found " + RANKS[3] + " of " + SUITS[1] + " @ " + searchResult + ".");
		} else {
			System.out.println("Didn't find the target card.");
		}
		
		logger.log(Level.INFO, "Binary loop searching cards.");
		Thread.sleep(005);
		searchResult = deck1.binarySearchLoop(new Card(3, 1));
		if (searchResult != -1) {
			System.out.println("Found " + RANKS[3] + " of " + SUITS[1] + " @ " + searchResult + ".");
		} else {
			System.out.println("Didn't find the target card.");
		}
		
		logger.log(Level.INFO, "Binary recursive searching cards.");
		Thread.sleep(005);
		searchResult = deck1.binarySearchRecursive(new Card(3, 1), 0, 51);
		if (searchResult != -1) {
			System.out.println("Found " + RANKS[3] + " of " + SUITS[1] + " @ " + searchResult + ".");
		} else {
			System.out.println("Didn't find the target card.");
		}

		logger.log(Level.INFO, "Compare Ace to all cards when Ace is lowest.");
		Thread.sleep(005);
		for(int i = 0; i < 13; i++) {
			System.out.println("With Ace being the lowest, compare " + RANKS[0] + " of " + SUITS[0] + " to "
			+ RANKS[i] + " of " + SUITS[0]);
			System.out.println(new Card(0, 0).compareToRank(new Card(i, 0)));
		}

		logger.log(Level.INFO, "Compare Ace to all cards when Ace is highest.");
		Thread.sleep(005);
		for(int i = 0; i < 13; i++) {
			System.out.println("With Ace being the highest, compare " + RANKS[0] + " of " + SUITS[0] + " to "
					+ RANKS[i] + " of " + SUITS[0]);
			System.out.println(new Card(0, 0).compareToRankAceHigh(new Card(i, 0)));
		}
		
		logger.log(Level.INFO, "Get cards histogram");
		Thread.sleep(005);
		// Create 7 cards, like texas hold-em
		Card[] handAndBoard = new Card[7];
		for (int i = 0; i < handAndBoard.length; i++) {
			handAndBoard[i] =  new Card(ThreadLocalRandom.current().nextInt(0, 13), ThreadLocalRandom.current().nextInt(0, 4));;
		}
		
		logger.log(Level.INFO, "Cards currently in hand and on the board.");
		for(Card card : handAndBoard) {
			System.out.println(card.getRankName() + " of " + card.getSuitName());
		}
		
		int[] histogram = new CardDeck().suitHistory(handAndBoard);
		System.out.println(Arrays.toString(histogram));
	
		
		for (int i = 0; i < histogram.length; i++) {
			int currentRank = i % 13;
			int currentSuit = i / 13;
			
			if(histogram[i] >= 1) {
				System.out.println(RANKS[currentRank] + " of " + SUITS[currentSuit] + " found.");
			}
		}
	}
}
