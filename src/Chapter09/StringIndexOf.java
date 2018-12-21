package Chapter09;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StringIndexOf
{
	private static final Logger logger = Logger.getLogger(StringManipulation.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Original String.");
		Thread.sleep(005);
		String s = "Hi, I am a string.";
		System.out.println(s);

		logger.log(Level.INFO, "indexOf String.");
		Thread.sleep(005);
		System.out.println("Where does 'i' exist in the string? " + s.indexOf("i") + "\nThis is the first i.");
		System.out.println("Where does 'i' exist in the string? " + s.indexOf("i", 2) + "\nThis is the next i.");
		System.out.println("Where does 'd' exist in the string? " + s.indexOf("d") + "\nThis letter doesn't exist.");
		System.out.println("Where does 'Hi' exist in the string? " + s.indexOf("Hi") + "\nThis is the index of the first letter of the substring.");

	}
}
