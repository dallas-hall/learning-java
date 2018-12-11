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
		System.out.println(runtime.approximateSquareRoot(9));
		System.out.println(runtime.approximateSquareRoot(16));
		System.out.println(runtime.approximateSquareRoot(25));
	}

	public double approximateSquareRoot(double startNumber)
	{
		// The initial guess is half the starting number
		double guess1 = startNumber / 2;
		double guess2 = 0.0;

		while (true) {
			double difference = Math.abs(guess1 - guess2);

			if(difference < 0.0001) {
				return guess1;
			}
			else {
				// Improve the guesses with the following formula
				guess2 = (guess1 + startNumber / guess1) / 2;
				guess1 = (guess2 + startNumber / guess2) / 2;
			}
		}
	}
}
