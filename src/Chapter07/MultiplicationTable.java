package Chapter07;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiplicationTable
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(MultiplicationTable.class.getName());

	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	private int limit;

	//@@@ MAIN METHOD @@@
	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Program starting.");
		Thread.sleep(005);
		MultiplicationTable runtime = new MultiplicationTable();

		logger.log(Level.INFO, "Complete Multiplication Table (while)");
		Thread.sleep(005);
		runtime.printMultiplicationCompleteTableWhile(10);
		logger.log(Level.INFO, "Half Multiplication Table (while)");
		Thread.sleep(005);
		runtime.printMultiplicationHalfTableWhile(10);

		logger.log(Level.INFO, "Complete Multiplication Table (for)");
		Thread.sleep(005);
		runtime.printMultiplicationCompleteTableFor(10);
		logger.log(Level.INFO, "Half Multiplication Table (for)");
		Thread.sleep(005);
		runtime.printMultiplicationHalfTableFor(10);
	}


	//@@@ METHODS @@@
	//### HELPERS ###
	public void printMultiplicationCompleteTableWhile(int rows)
	{
		int i = 1;
		while (i <= rows) {
			printMultiplicationRowWhile(i, rows);
			i++;
		}
	}

	public void printMultiplicationHalfTableWhile(int rows)
	{
		int i = 1;
		while (i <= rows) {
			printMultiplicationRowWhile(i, i);
			i++;
		}
	}

	private void printMultiplicationRowWhile(int n, int columns)
	{
		int i = 1;
		while (i <= columns) {
			System.out.printf("%4d", n * i);
			i++;
		}
		System.out.println();
	}

	public void printMultiplicationCompleteTableFor(int rows)
	{
		for (int i = 1; i <= rows; i++) {
			printMultiplicationRowFor(i, rows);
		}
	}

	public void printMultiplicationHalfTableFor(int rows)
	{
		for (int i = 1; i <= rows; i++) {
			printMultiplicationRowFor(i, i);
		}
	}

	private void printMultiplicationRowFor(int n, int columns)
	{
		for (int i = 1; i <= columns; i++) {
			System.out.printf("%4d", n * i);
		}
		System.out.println();
	}
}
