package Chapter11;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExercisesTest
{
	private static ScrabbleLetterTile scrabbleLetterTile;
	private static RationalNumber rationalNumber;
	
	@org.junit.jupiter.api.BeforeAll
	static void initAll()
	{
		scrabbleLetterTile = new ScrabbleLetterTile();
		rationalNumber = new RationalNumber();
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
	
	@org.junit.jupiter.api.Test
	void gcdEuclidSubtractionRecursion()
	{
		System.out.println("Testing gcdEuclidSubtractionRecursion with\n" +
			"(13, 13, 13) - trick case: a = b\n" +
			"(37, 600, 1) - first argument is a prime\n" +
			"(20, 100, 20) - one is multiplum of other\n" +
			"(624129, 2061517, 18913) - straight case");
			
		assertEquals(13, rationalNumber.gcdEuclidSubtractionRecursion(13, 13));
		assertEquals(1, rationalNumber.gcdEuclidSubtractionRecursion(37, 600));
		assertEquals(20, rationalNumber.gcdEuclidSubtractionRecursion(20, 100));
		assertEquals(18913, rationalNumber.gcdEuclidSubtractionRecursion(624129, 2061517));
	}
	
	@org.junit.jupiter.api.Test
	void gcdEuclidModuloRecursion()
	{
		System.out.println("Testing gcdEuclidModuloRecursion with\n" +
						   "(13, 13, 13) - trick case: a = b\n" +
						   "(37, 600, 1) - first argument is a prime\n" +
						   "(20, 100, 20) - one is multiplum of other\n" +
						   "(624129, 2061517, 18913) - straight case");
		
		assertEquals(13, rationalNumber.gcdEuclidModuloRecursion(13, 13));
		assertEquals(1, rationalNumber.gcdEuclidModuloRecursion(37, 600));
		assertEquals(20, rationalNumber.gcdEuclidModuloRecursion(20, 100));
		assertEquals(18913, rationalNumber.gcdEuclidModuloRecursion(624129, 2061517));
	}
}
