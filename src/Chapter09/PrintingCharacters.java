package Chapter09;

import Chapter08.PrintingArrays;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintingCharacters
{	private static final Logger logger = Logger.getLogger(PrintingCharacters.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		PrintingCharacters runtime = new PrintingCharacters();

		logger.log(Level.INFO, "Printing lowercase English characters.");
		Thread.sleep(005);
		runtime.printCharacters('a', 'z');

		logger.log(Level.INFO, "Printing uppercase English characters.");
		Thread.sleep(005);
		runtime.printCharacters((char) 65, (char) 90);

		logger.log(Level.INFO, "Printing Korean characters.");
		Thread.sleep(005);

		runtime.printCharacters('\u3131', '\u318E');

	}

	public void printCharacters(char firstChar, char endChar)
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
}
