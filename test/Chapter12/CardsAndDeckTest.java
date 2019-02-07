package Chapter12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CardsAndDeckTest
{
	@org.junit.jupiter.api.Test
	void Cards()
	{
		System.out.println("Creating and checking 4 cards.");
		// Create 4 cards twice, check that the cards are the same.
		assertEquals(new Card(0, 0).toString(), new Card(0, 0).toString());
		assertEquals(new Card(0, 1).toString(), new Card(0, 1).toString());
		assertEquals(new Card(12, 0).toString(), new Card(12, 0).toString());
		assertEquals(new Card(6, 1).toString(), new Card(6, 1).toString());
	}
	
	@org.junit.jupiter.api.Test
	void CardRankAndSuit()
	{
		System.out.println("Create a card and check its rank and suit is correct.");
		Card aceOfClubs = new Card(0, 0);
		assertEquals(aceOfClubs.getSuit(), new Card(0, 0).getSuit());
		assertEquals(aceOfClubs.getRank(), new Card(0, 0).getRank());
		assertEquals(aceOfClubs.getSuitName(), new Card(0, 0).getSuitName());
		assertEquals(aceOfClubs.getRankName(), new Card(0, 0).getRankName());
		
		Card twoOfDiamonds = new Card(1, 1);
		assertNotEquals(aceOfClubs.getSuit(), twoOfDiamonds.getSuit());
		assertNotEquals(aceOfClubs.getRank(), twoOfDiamonds.getRank());
		assertNotEquals(aceOfClubs.getSuitName(), twoOfDiamonds.getSuitName());
		assertNotEquals(aceOfClubs.getRankName(), twoOfDiamonds.getRankName());
		
	}
	
	@org.junit.jupiter.api.Test
	void SortedDecks()
	{
		System.out.println("Creating 2 sorted decks and checking sort equality.");
		// Create 2 sorted decks
		CardDeck deck1 = new CardDeck();
		CardDeck deck2 = new CardDeck();
		
		// Check that the sorting is the same
		for (int i = 0; i < deck1.getCards().length; i++) {
			assertEquals(deck1.getCards()[i].toString(), deck2.getCards()[i].toString());
		}
	}
	
	@org.junit.jupiter.api.Test
	void SequentialSearch()
	{
		System.out.println("Search for cards in a sorted deck of cards.");
		CardDeck deck1 = new CardDeck();
		
		
	}
}

