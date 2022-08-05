package Chapter12;
/**
 * <h1>Card</h1>
 * <p>
 * This class represents a French playing card, with an integer representing rank and suit.
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2019-01-11
 */

public class Card
{
	//@@@ CLASS VARIABLES
	public static final String[] RANKS = {
		"Ace", "2", "3", "4", "5", "6", "7",
		"8", "9", "10", "Jack", "Queen", "King"};
	
	public static final String[] SUITS = {
			"Clubs", "Diamonds", "Hearts", "Spades"};
	
	//@@@ INSTANCE VARIABLES @@@
	// ace is 0 (start) through to king is 12(end) - final to make immutable.
	private final int rank;
	
	// 0 = clubs, 1 = diamonds, 2 = hearts, and 3 = spades - final to make immutable.
	private final int suit;
	private boolean available;
	
	//@@@ CONSTRUCTOR(S) @@@
	public Card(int rank, int suit)
	{
		this.rank = rank;
		this.suit = suit;
		this.available = true;
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public int getRank()
	{
		return rank;
	}
	
	public String getRankName()
	{
		return RANKS[rank];
	}
	
	public int getSuit()
	{
		return suit;
	}
	
	public String getSuitName()
	{
		return SUITS[suit];
	}
	
	public boolean isAvailable()
	{
		return available;
	}
	
	//### SETTERS ###
	public void setAvailable(boolean available)
	{
		this.available = available;
	}
	
	//### HELPERS ###
	public String toString()
	{
		String s = "";
		return String.format("%s of %s", RANKS[rank], SUITS[suit]);
	}
	
	public boolean equals(Card that)
	{
		return this.suit == that.suit &&
			this.rank == that.rank;
	}
	
	// Return 1 if this wins, -1 if that wins, or 0 if equivalent. Suit first, rank second.
	public int compareTo(Card that)
	{
		if (this.suit < that.suit) {
			return -1;
		} else if (this.suit > that.suit) {
			return 1;
		} else if (this.rank < that.rank) {
			return -1;
		} else if (this.rank > that.rank) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int compareToSuit(Card that)
	{
		if (this.suit < that.suit) {
			return -1;
		} else if (this.suit > that.suit) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int compareToRank(Card that)
	{
		if(this.rank == that.rank) {
			return 0;
		} else if (this.rank < that.rank) {
			return -1;
		} else {
			return 1;
		}
	}

	public int compareToRankAceHigh(Card that)
	{
		if(this.rank == 0 && that.rank != 0) {
			return 1;
		} else if (this.rank != 0 && that.rank == 0) {
			return -1;
		}
		else {
			return compareToRank(that);
		}
	}

	public int getSortedDeckPosition()
	{
		return this.suit * 13 + this.rank;
	}
	
}
