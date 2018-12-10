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

		logger.log(Level.INFO, "Multiplication Table (while)");
		Thread.sleep(005);
		runtime.printMultiplicationTableWhile(10);

		logger.log(Level.INFO, "Multiplication Table (for)");
		Thread.sleep(005);
		runtime.printMultiplicationTableFor(10);
	}


	//@@@ METHODS @@@
	//### HELPERS ###
	public void printMultiplicationTableWhile(int limit)
	{
		int i = 1;
		while (i <= limit) {
			printMultiplicationRowWhile(i, limit);
			i++;
		}
	}

	private void printMultiplicationRowWhile(int n, int limit)
	{
		int i = 1;
		while (i <= limit) {
			System.out.printf("%4d", n * i);

			if (i % 10 == 0) {
				System.out.println();
			}

			i++;
		}
	}

	public void printMultiplicationTableFor(int limit)
	{
		for (int i = 1; i <= limit; i++) {
			printMultiplicationRowFor(i, limit);
		}
	}

	private void printMultiplicationRowFor(int n, int limit)
	{
		for (int i = 1; i <= limit; i++) {
			System.out.printf("%4d", n * i);

			if (i % 10 == 0) {
				System.out.println();
			}
		}
	}
}
