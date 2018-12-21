package Chapter09;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StringManipulation
{
	private static final Logger logger = Logger.getLogger(StringManipulation.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Original String.");
		Thread.sleep(005);
		StringManipulation runtime = new StringManipulation();
		String s = "Hi, I am a string.";
		System.out.println(s);

		logger.log(Level.INFO, "Reversed String.");
		Thread.sleep(005);
		System.out.println(runtime.reverseStringForLoop(s));

		logger.log(Level.INFO, "Substring - Start Index Only");
		Thread.sleep(005);
		System.out.println(s.substring(4));

		logger.log(Level.INFO, "Substring - Start Index & End Index");
		Thread.sleep(005);
		System.out.println(s.substring(0, 2));

		logger.log(Level.INFO, "Substring - > End Index");
		Thread.sleep(005);
		System.out.println(s.substring(s.length()) + "\nThis returns an empty string");
	}

	private String reverseStringForLoop(String s)
	{
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = s.length() - 1; i >= 0; i--) {
			stringBuilder.append(s.charAt(i));
		}
		return stringBuilder.toString();
	}
}
