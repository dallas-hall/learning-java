package Chapter07;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ApproximateSquareRoot
{
	private static final Logger logger = Logger.getLogger(ApproximateSquareRoot.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		ApproximateSquareRoot approximateSquareRoot = new ApproximateSquareRoot();
		logger.log(Level.INFO, "Exercise 2 - Approximate Square Root");
		Thread.sleep(005);
		for (int i = 1; i <= 10; i++) {
			// If we decrease this number there will be more iterations and a more accurate result returned
			// E.g. 0.0001 and 9 returns 3.0000000000393214 but 0.00001 returns 3.0
			System.out.println(approximateSquareRoot.approximateSquareRoot(i * i, 0.0001));
		}
	}

	public double approximateSquareRoot(double startNumber, double checkDifference)
	{
		// The initial guess is half the starting number
		double guess1 = startNumber / 2;
		double guess2 = 0.0;

		while (true) {
			// We are using the absolute number of the difference so we can always compare a positive integer.
			double difference = Math.abs(guess1 - guess2);

			if (difference < checkDifference) {
				return guess1;
			} else {
				// Improve the guesses with the following formula
				guess2 = (guess1 + startNumber / guess1) / 2;
				guess1 = (guess2 + startNumber / guess2) / 2;
			}
		}
	}
}
