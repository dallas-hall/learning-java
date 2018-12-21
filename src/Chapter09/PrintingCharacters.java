package Chapter09;

import Chapter08.PrintingArrays;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintingCharacters
{
	private static final Logger logger = Logger.getLogger(PrintingCharacters.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		PrintingCharacters runtime = new PrintingCharacters();

		logger.log(Level.INFO, "Printing lowercase English characters.");
		Thread.sleep(005);
		runtime.printCharacterRange('a', 'z');

		logger.log(Level.INFO, "Printing uppercase English characters.");
		Thread.sleep(005);
		runtime.printCharacterRange((char) 65, (char) 90);

		logger.log(Level.INFO, "Printing Korean characters.");
		Thread.sleep(005);
		runtime.printCharacterRange('\u3131', '\u318E');

		logger.log(Level.INFO, "Printing all characters from a string (for loop).");
		Thread.sleep(005);
		runtime.printAllStringCharactersForLoop("Hi, I am a string.");

		logger.log(Level.INFO, "Printing all characters from a string (for each loop).");
		Thread.sleep(005);
		runtime.printAllStringCharactersForEachLoop("Hi, I am a string.");
	}

	public void printCharacterRange(char firstChar, char endChar)
	{
		int prints = 0;
		for (char c = firstChar; c <= endChar; c++) {
			System.out.print(c + "\t");
			prints++;
			if (prints % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	public void printAllStringCharactersForLoop(String s)
	{
		System.out.print("{'" + s.charAt(0) + "'");
		for (int i = 1; i < s.length(); i++) {
			System.out.print(", '" + s.charAt(i) + "'");
		}
		System.out.println("}");
	}

	public void printAllStringCharactersForEachLoop(String s)
	{
		System.out.print("{");
		int i = 0;
		// Need to convert from String to array as for each loops can only iterate over collections
		for(char c: s.toCharArray()) {
			if (i == 0) {
				System.out.print("'" + c + "'");
			} else {
				System.out.print(", '" + c + "'");
			}
			i++;
		}
		System.out.println("}");
	}
}
