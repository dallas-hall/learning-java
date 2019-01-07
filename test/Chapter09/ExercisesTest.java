package Chapter09;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExercisesTest
{
	private static MatchingBrackets matchingBrackets;
	private static Palindrome palindrome;
	private static StringFormatting stringFormatting;
	private static Abecedarian abecedarian;
	private static Doubloon doubloon;
	private static Anagram anagram;
	private static Scrabble scrabble;
	
	@org.junit.jupiter.api.BeforeAll
	static void initAll()
	{
		matchingBrackets = new MatchingBrackets();
		palindrome = new Palindrome();
		stringFormatting = new StringFormatting();
		abecedarian = new Abecedarian();
		doubloon = new Doubloon();
		anagram = new Anagram();
		scrabble = new Scrabble();
	}
	
	@org.junit.jupiter.api.Test
	void checkMatchingBrackets()
	{
		String s1 = "((1 + 2) * 3)";
		String s2 = "<html>\n\t...\n</html>";
		String s3 = "int[] i = {1, 2, 3, 4}";
		
		assertEquals(0, matchingBrackets.checkMatchingBrackets(s1, '(', ')'));
		assertEquals(1, matchingBrackets.checkMatchingBrackets(s1.replaceFirst("\\(", ""), '(', ')'));
		assertEquals(0, matchingBrackets.checkMatchingBrackets(s2, '<', '>'));
		assertEquals(1, matchingBrackets.checkMatchingBrackets(s2.replaceFirst(">", ""), '<', '>'));
		assertEquals(0, matchingBrackets.checkMatchingBrackets(s3, '[', ']'));
		assertEquals(1, matchingBrackets.checkMatchingBrackets(s3.replaceFirst("\\[", ""), '[', ']'));
		assertEquals(0, matchingBrackets.checkMatchingBrackets(s3, '(', ')'));
		assertEquals(1, matchingBrackets.checkMatchingBrackets(s3.replaceFirst("}", ""), '{', '}'));
	}
	
	@org.junit.jupiter.api.Test
	void isPalindromeRecursive()
	{
		String s1 = "a";
		String s2 = "aa";
		String s3 = "bc";
		String s4 = "kayak";
		String s5 = "hayak";
		
		assertEquals(true, palindrome.isPalindromeRecursive(s1));
		assertEquals(true, palindrome.isPalindromeRecursive(s2));
		assertEquals(false, palindrome.isPalindromeRecursive(s3));
		assertEquals(true, palindrome.isPalindromeRecursive(s4));
		assertEquals(false, palindrome.isPalindromeRecursive(s5));
	}
	
	@org.junit.jupiter.api.Test
	void isPalindromeLoop()
	{
		String s1 = "a";
		String s2 = "aa";
		String s3 = "bc";
		String s4 = "kayak";
		String s5 = "hayak";
		
		assertEquals(true, palindrome.isPalindromeLoop(s1));
		assertEquals(true, palindrome.isPalindromeLoop(s2));
		assertEquals(false, palindrome.isPalindromeLoop(s3));
		assertEquals(true, palindrome.isPalindromeLoop(s4));
		assertEquals(false, palindrome.isPalindromeLoop(s5));
	}
	
	@org.junit.jupiter.api.Test
	void timeString()
	{
		assertEquals("12:01 AM", stringFormatting.timeString(0, 1));
		assertEquals("12:15 AM", stringFormatting.timeString(0, 15));
		assertEquals("12:01 PM", stringFormatting.timeString(12, 1));
		assertEquals("06:59 PM", stringFormatting.timeString(18, 59));
	}
	
	@org.junit.jupiter.api.Test
	void isAbecedarian()
	{
		String s1 = "deflux";
		String s2 = "influx";
		String s3 = "biopsy";
		String s4 = "autopsy";
		
		assertEquals(true, abecedarian.isAbecedarian(s1));
		assertEquals(false, abecedarian.isAbecedarian(s2));
		assertEquals(true, abecedarian.isAbecedarian(s3));
		assertEquals(false, abecedarian.isAbecedarian(s4));
	}
	
	@org.junit.jupiter.api.Test
	void isDoubloon()
	{
		String s1 = "Anna";
		String s2 = "Annah";
		String s3 = "Hanna";
		String s4 = "Hannah";
		
		assertEquals(true, doubloon.isDoubloon(s1));
		assertEquals(false, doubloon.isDoubloon(s2));
		assertEquals(false, doubloon.isDoubloon(s3));
		assertEquals(true, doubloon.isDoubloon(s4));
	}
	
	@org.junit.jupiter.api.Test
	void isAnagram()
	{
		String[] s1 = {"pots", "stop"};
		String[] s2 = {"john", "jon"};
		String[] s3 = {"allen downey", "well annoyed"};
		String[] s4 = {"letter", "better"};
		
		assertEquals(true, anagram.isAnagram(s1[0], s1[1]));
		assertEquals(false, anagram.isAnagram(s2[0], s2[1]));
		assertEquals(true, anagram.isAnagram(s3[0], s3[1]));
		assertEquals(false, anagram.isAnagram(s4[0], s4[1]));
	}
	
	@org.junit.jupiter.api.Test
	void canSpell()
	{
		String letters = "EIODGHT";
		String w1 = "dig";
		String w2 = "dog";
		String w3 = "it";
		String w4 = "sit";
		String w5 = "he";
		String w6 = "she";
		
		assertEquals(true, scrabble.canSpell(w1, letters));
		assertEquals(true, scrabble.canSpell(w2, letters));
		assertEquals(true, scrabble.canSpell(w3, letters));
		assertEquals(false, scrabble.canSpell(w4, letters));
		assertEquals(true, scrabble.canSpell(w5, letters));
		assertEquals(false, scrabble.canSpell(w6, letters));
		
	}
}


