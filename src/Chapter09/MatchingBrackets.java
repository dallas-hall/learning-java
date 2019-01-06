package Chapter09;
/**
 * <h1>MatchingBrackets</h1>
 * <p>
 * This program takes a string and checks if there is an equal amount of the specified brackets within it.
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2019-01-07
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class MatchingBrackets
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(MatchingBrackets.class.getName());
	
	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Chapter 9 - Exercise 3");
		Thread.sleep(005);
		MatchingBrackets runtime = new MatchingBrackets();
		
		String[] s = {
			"((3 + 7) * 2)",
			"((3 + 7 * 2)",
			"int[] s = {1, 2, 3}",
			"int[] s = {1, 2, 3",
			"int[] s = {1, 2, 3}",
			"int[ s = {1, 2, 3",
			"<html>\n\t<body>\n\t\t...\n\t</body>\n</html>",
			"<html>\n\t<body>\n\t\t...\n\t</body>\n</html"
		};
		
		logger.log(Level.INFO, "Parentheses");
		Thread.sleep(005);
		for (int i = 0; i < s.length; i++) {
			System.out.println("The amount of unmatched parentheses within\n\"" + s[i] + "\"\nis " + runtime.checkMatchingBrackets(s[i], '(', ')'));
		}
		
		logger.log(Level.INFO, "Curly Braces");
		Thread.sleep(005);
		for (int i = 0; i < s.length; i++) {
			System.out.println("The amount of unmatched curly braces within\n\"" + s[i] + "\"\nis " + runtime.checkMatchingBrackets(s[i], '{', '}'));
		}
		
		logger.log(Level.INFO, "Square Brackets");
		Thread.sleep(005);
		for (int i = 0; i < s.length; i++) {
			System.out.println("The amount of unmatched square brackets within\n\"" + s[i] + "\"\nis " + runtime.checkMatchingBrackets(s[i], '[', ']'));
		}
		
		logger.log(Level.INFO, "Angled Brackets");
		Thread.sleep(005);
		for (int i = 0; i < s.length; i++) {
			System.out.println("The amount of unmatched angled brackets within\n\"" + s[i] + "\"\nis " + runtime.checkMatchingBrackets(s[i], '<', '>'));
		}
	}

	//@@@ METHODS @@@
	//### HELPERS ###
	public int checkMatchingBrackets(String inputString, char openBracket, char closeBracket)
	{
		int count = 0;
		for (int i = 0; i < inputString.length(); i++) {
			char c = inputString.charAt(i);
			if (c == openBracket) {
				count++;
			}
			else if (c == closeBracket) {
				count--;
			}
		}
		
		return count;
	}
}
