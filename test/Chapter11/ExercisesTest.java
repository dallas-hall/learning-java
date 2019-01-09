package Chapter11;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExercisesTest
{
	private static ScrabbleLetterTile scrabbleLetterTile;
	
	@org.junit.jupiter.api.BeforeAll
	static void initAll()
	{
		scrabbleLetterTile = new ScrabbleLetterTile();
	}
	
	@org.junit.jupiter.api.Test
	void createSpecificTile()
	{
		System.out.println("Creating specific tiles for A, E, I, O, and U");
		assertEquals('A', new ScrabbleLetterTile('A').getLetter());
		assertEquals('E', new ScrabbleLetterTile('E').getLetter());
		assertEquals('I', new ScrabbleLetterTile('I').getLetter());
		assertEquals('O', new ScrabbleLetterTile('O').getLetter());
		assertEquals('U', new ScrabbleLetterTile('U').getLetter());
	}
	
	@org.junit.jupiter.api.Test
	void createRandomTile()
	{
		// Extra letter for the space character
		char[] letters = new char[27];
		int letter = 65;
		for(int i = 0; i < letters.length - 1; i++) {
			letters[i] = (char) letter++;
		}
		letters[26] = ' ';
		Arrays.sort(letters);
		System.out.println(Arrays.toString(letters));
		// Check that a randomly generated letter is [A-Z ] only.
		assertTrue(Arrays.binarySearch(letters, new ScrabbleLetterTile().getLetter()) >= 0 ? true : false);
	}
	
	@org.junit.jupiter.api.Test
	void equalsTest()
	{
		System.out.println("Checking if 'A' == 'A' and then if 'A' == 'B'.");
		assertTrue(new ScrabbleLetterTile('A').equals(new ScrabbleLetterTile('A')));
		assertEquals(false, new ScrabbleLetterTile('A').equals(new ScrabbleLetterTile('B')));
	}
	
	@org.junit.jupiter.api.Test
	void checkValues()
	{
		System.out.println("Checking the values of tiles.");
		assertTrue(new ScrabbleLetterTile('A').getValue() == 1);
		assertTrue(new ScrabbleLetterTile('Z').getValue() == 10);
		assertTrue(new ScrabbleLetterTile(' ').getValue() == 2);
	}
	
	@org.junit.jupiter.api.Test
	void toStringTest()
	{
		System.out.println("Checking the tile.toString().");
		assertEquals("D has the value 2.", new ScrabbleLetterTile('D').toString());
		assertEquals("P has the value 3.", new ScrabbleLetterTile('P').toString());
		assertEquals("V has the value 4.", new ScrabbleLetterTile('V').toString());
	}
}
