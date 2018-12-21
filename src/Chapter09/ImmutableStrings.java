package Chapter09;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ImmutableStrings
{
	private static final Logger logger = Logger.getLogger(ImmutableStrings.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Original string.");
		Thread.sleep(005);
		String aString = "Hi, I am a string.";
		System.out.println(aString);

		logger.log(Level.INFO, "Convert to uppercase");
		Thread.sleep(005);
		System.out.println(aString.toUpperCase());

		logger.log(Level.INFO, "Convert to lowercase");
		Thread.sleep(005);
		System.out.println(aString.toLowerCase());

		logger.log(Level.INFO, "Remove first punctuation symbol");
		Thread.sleep(005);
		// https://www.regular-expressions.info/posixbrackets.html
		// https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
		System.out.println(aString.replaceFirst("\\p{Punct}", ""));

		logger.log(Level.INFO, "Remove all punctuation symbols");
		Thread.sleep(005);
		System.out.println(aString.replaceAll("\\p{Punct}", ""));

	}
}
