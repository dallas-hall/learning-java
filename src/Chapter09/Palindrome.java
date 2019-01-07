package Chapter09;/**
 * <h1>Palindrome</h1>
 * <p>
 * This program does some basic String manipulation like returning first, last, and middle parts of a String, reversing
 * the String, and checking if it is a palindrome.
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2019-01-07
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Palindrome
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(Palindrome.class.getName());
	
	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Chapter 9 - Exercise 4");
		Thread.sleep(005);
		String[] s = {
				"otto",
				"lotto",
				"blotto"
		};
		
		Palindrome runtime = new Palindrome();
		for(int i = 0; i < s.length; i++) {
			logger.log(Level.INFO, "The String \"" + s[i] + "\"");
			Thread.sleep(005);
			System.out.println("The first char is " + runtime.getFirstChar(s[i]));
			System.out.println("The last char is " + runtime.getLastChar(s[i]));
			System.out.println("Everything but the first char is " + runtime.getAllButFirstChar(s[i]));
			System.out.println("Everything but the first and last char is " + runtime.getAllButFirstAndLastChar(s[i]));
			runtime.printString(s[i]);
			runtime.printBackward(s[i]);
			System.out.println(runtime.getReversedString(s[i]));
		}
		
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public char getFirstChar(String s)
	{
		return s.charAt(0);
	}
	
	public String getAllButFirstChar(String s)
	{
		return s.substring(1);
	}
	
	public String getAllButFirstAndLastChar(String s)
	{
		return s.substring(1, s.length() - 1);
	}
	
	public char getLastChar(String s)
	{
		return s.charAt(s.length() - 1);
	}
	
	public String getReversedString(String s)
	{
		StringBuilder sb = new StringBuilder();
		char[] chars = s.toCharArray();
		for (int i = chars.length - 1; i >= 0; i--) {
			sb.append(chars[i]);
		}
		
		return sb.toString();
	}
	
	//### HELPERS ###
	public void printString(String s)
	{
		System.out.println("Forward printing.");
		for(char aChar : s.toCharArray()) {
			System.out.println(aChar);
		}
	}
	
	public void printBackward(String s)
	{
		System.out.println("Backward printing.");
		char[] chars = s.toCharArray();
		for (int i = chars.length - 1; i >= 0; i--) {
			System.out.println(chars[i]);
		}
	}
	
	public boolean isPalindrome(String s)
	{
		return false;
	}
}
