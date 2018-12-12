package Chapter07;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercises
{
	private static final Logger logger = Logger.getLogger(Exercises.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Chapter 7 - Exercises");
		Exercises runtime = new Exercises();

		logger.log(Level.INFO, "Exercise 2 - Approximate Square Root");
		Thread.sleep(005);
		System.out.println(runtime.approximateSquareRoot(1));
		System.out.println(runtime.approximateSquareRoot(4));
		System.out.println(runtime.approximateSquareRoot(9));
		System.out.println(runtime.approximateSquareRoot(16));
		System.out.println(runtime.approximateSquareRoot(25));
		System.out.println(runtime.approximateSquareRoot(36));
		System.out.println(runtime.approximateSquareRoot(49));
		System.out.println(runtime.approximateSquareRoot(64));
		System.out.println(runtime.approximateSquareRoot(83));
		System.out.println(runtime.approximateSquareRoot(100));
	}

	public double approximateSquareRoot(double startNumber)
	{
		// The initial guess is half the starting number
		double guess1 = startNumber / 2;
		double guess2 = 0.0;

		while (true) {
			// We are using the absolute number of the difference so we can always compare a positive integer.
			double difference = Math.abs(guess1 - guess2);

			// If we decrease this number there will be more iterations and a more accurate result returned
			// E.g. 0.0001 and 9 returns 3.0000000000393214 but 0.00001 returns 3.0
			if (difference < 0.0001) {
				return guess1;
			} else {
				// Improve the guesses with the following formula
				guess2 = (guess1 + startNumber / guess1) / 2;
				guess1 = (guess2 + startNumber / guess2) / 2;
			}
		}
	}
}
