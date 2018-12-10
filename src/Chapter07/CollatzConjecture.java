package Chapter07;

import Chapter06.FibonacciRecursion;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CollatzConjecture
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(FibonacciRecursion.class.getName());

	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	private int limit;

	//@@@ MAIN METHOD @@@
	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Program starting.");
		Thread.sleep(005);
		CollatzConjecture runtime = new CollatzConjecture();

		logger.log(Level.INFO, "Collatz Conjecture.");
		Thread.sleep(005);
		runtime.printCollatzConjecture(3);
	}

	/**
	 * This method performs the Collatz Conjecture - https://en.wikipedia.org/wiki/Collatz_conjecture
	 *
	 * @param n - the number to start the Collatz Conjecture with, must be a positive integer.
	 */
	public void printCollatzConjecture(int n)
	{
		if (n <= 0) {
			System.out.println("Starting number must be positive.");
			return;
		}
		while (n != 1) {
			System.out.println(n);
			// If even, divide by 2
			if (n % 2 == 0) {
				n = n / 2;
			}
			// If odd, multiply by 3 and add 1
			else {
				n = n * 3 + 1;
			}
		}
	}
}
