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
	void createRationalNumber()
	{
		System.out.println("Checking rationalNumber constructors");
		assertEquals(0, rationalNumber.getNumerator());
		assertEquals(1, rationalNumber.getDenominator());
		rationalNumber = new RationalNumber(1, 3);
		assertEquals(1, rationalNumber.getNumerator());
		assertEquals(3, rationalNumber.getDenominator());
	}
	
	@org.junit.jupiter.api.Test
	void rationalNumberToString()
	{
		System.out.println("Checking rationalNumber toString");
		rationalNumber = new RationalNumber(1, 3);
		assertEquals("1/3", rationalNumber.toString());
	}
	
	@org.junit.jupiter.api.Test
	void rationalNumberEquals()
	{
		System.out.println("Checking rationalNumber equals");
		rationalNumber = new RationalNumber(3, 5);
		assertEquals(true, rationalNumber.equals(new RationalNumber(3, 5)));
		assertEquals(false, rationalNumber.equals(new RationalNumber(2, 5)));
	}
	
	@org.junit.jupiter.api.Test
	void rationalNumberFlip()
	{
		System.out.println("Checking rationalNumber flip");
		rationalNumber = new RationalNumber(1, 3);
		rationalNumber.flipRationalNumber();
		assertEquals(3, rationalNumber.getNumerator());
		assertEquals(1, rationalNumber.getDenominator());
	}
	
	@org.junit.jupiter.api.Test
	void rationalNumberNegate()
	{
		System.out.println("Checking rationalNumber negate");
		rationalNumber = new RationalNumber(1, 3);
		rationalNumber.negateRationalNumber();
		assert(rationalNumber.getNumerator() == 1 || rationalNumber.getNumerator() == -1);
		assert(rationalNumber.getDenominator() == 3 || rationalNumber.getDenominator() == -3);
	}
	
	@org.junit.jupiter.api.Test
	void rationalNumberToDouble()
	{
		System.out.println("Checking rationalNumber toDouble");
		rationalNumber = new RationalNumber(1, 4);
		assertEquals(0.25, rationalNumber.toDouble());
		rationalNumber = new RationalNumber(1, 3);
		assertEquals(0.3333333333333333, rationalNumber.toDouble());
		rationalNumber = new RationalNumber(1, 2);
		assertEquals(0.5, rationalNumber.toDouble());
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
	
	@org.junit.jupiter.api.Test
	void rationalNumberReduce()
	{
		System.out.println("Checking rationalNumber reduce");
		rationalNumber = new RationalNumber(2, 4);
		assertEquals(true, rationalNumber.reduce().equals(new RationalNumber(1, 2)));
		assertEquals(false, rationalNumber.reduce().equals(new RationalNumber(1, 3)));
		rationalNumber = new RationalNumber(6, 9);
		assertEquals(true, rationalNumber.reduce().equals(new RationalNumber(2, 3)));
		assertEquals(false, rationalNumber.reduce().equals(new RationalNumber(1, 3)));
	}
	
	@org.junit.jupiter.api.Test
	void rationalNumberAdd()
	{
		System.out.println("Checking rationalNumber addRationals");
		rationalNumber = new RationalNumber(1, 3);
		assertEquals(true, rationalNumber.addRationals(1, 6)
			.equals(new RationalNumber(1, 2)));
		rationalNumber = new RationalNumber(2, 4);
		assertEquals(true, rationalNumber.addRationals(4, 6)
										 .equals(new RationalNumber(7, 6)));
	}
}
