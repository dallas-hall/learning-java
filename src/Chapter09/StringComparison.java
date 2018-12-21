package Chapter09;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StringComparison
{	private static final Logger logger = Logger.getLogger(StringComparison.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Original Strings.");
		Thread.sleep(005);
		String name1 = "Robert";
		String name2 = "Robert";
		// Use the constructor to stop interned strings
		String name3 = new String("Robert");

		logger.log(Level.INFO, "Compare Strings With ==");
		Thread.sleep(005);
		// Comparing object references, name1 and name2 are interned, name3 is not.
		System.out.println("When using == does " + name1 + " equal " + name2 + "?");
		System.out.println(name1 == name2);

		System.out.println("When using == does " + name1 + " equal " + name3 + "?");
		System.out.println(name1 == name3);

		logger.log(Level.INFO, "Compare Strings With .equals");
		Thread.sleep(005);
		// Compares string contents and returns boolean
		System.out.println("When using .equals does " + name1 + " equal " + name2 + "?");
		System.out.println(name1.equals(name2));

		System.out.println("When using .equals does " + name1 + " equal " + name3 + "?");
		System.out.println(name1.equals(name3));

		logger.log(Level.INFO, "Compare Strings With .compareTo");
		Thread.sleep(005);
		// Compares string contents and returns a number.
		// This is lexicographical comparison, 0 is even, negative (before) and positive (after) numbers show inequality.
		System.out.println("When using .compareTo does " + name1 + " equal " + name2 + "?");
		System.out.println(name1.compareTo(name2));

		System.out.println("When using .compareTo does " + name1 + " equal " + name3 + "?");
		System.out.println(name1.compareTo(name3));
	}
}
