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
		for (int i = 1; i <= 10; i++) {
			System.out.println(runtime.approximateSquareRoot(i * i));
		}

		logger.log(Level.INFO, "Exercise 3 - Exponents With Iteration");
		Thread.sleep(005);
		for (int i = 0; i < 8; i++) {
			System.out.println(runtime.powerIterative(2, i));
		}

		logger.log(Level.INFO, "Exercise 4 - Factorial With Iteration");
		Thread.sleep(005);
		for (int i = 0; i < 20; i++) {
			System.out.println(i + " factorial = "+ runtime.factorialIterative(i));
		}

		logger.log(Level.INFO, "Exercise 5 - Infinite Series Expansion");
		Thread.sleep(005);
		System.out.println("myExp(1, 20)\t" + runtime.myExp(1, 20));
		System.out.println("myExp2(1, 20)\t" + runtime.myExp2(1, 20));
		System.out.println("Math.exp(1)\t\t" + Math.exp(1));
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

	public double powerIterative(double x, int n)
	{
		if (x == 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			double result = 1;
			for (int i = 1; i <= n; i++) {
				// result * x is the formula needed to calculate powers
				/*
				This works because initially x * 1 = x ^ 1. The result is stored.
				Then result * 2 = x ^ 2 and so on.
				*/
				result = result * x;
			}
			return result;
		}
	}

	public long factorialIterative(int n)
	{
		long result = 1;

		// http://mathforum.org/library/drmath/view/57128.html & https://www.mathsisfun.com/numbers/factorial.html
		if (n == 0) {
			return result;
		}

		for (int i = 1; i <= n; i++) {
			result = result * i;
		}
		return result;
	}

	// https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#exp-double- returns Euler's number raised to the provided power.
	public double myExp(double x, int n)
	{
		double total = 0;

		// e is euler's number - https://www.mathsisfun.com/numbers/e-eulers-number.html
		// e ^ x = 1 + x + (x ^ 2) / (2!) + ... + (x ^ i) / (i!)
		// ! means factorial, thus result of power divided by result of factorial
/*		for (int i = 0; i <= n; i++) {
			if (i == 0) {
				total += 1;
			} else if (i == 1) {
				total += x;
			} else {
				// http://mathforum.org/library/drmath/view/57493.html
				double numerator = Math.pow(x, i);
				double denominator = factorialIterative(i);
				total = total + numerator / denominator;
			}
			System.out.println(i + " = " + total);
		}*/

		// Can also be, because 0! and 1! is 1
		for (int i = 0; i <= n; i++) {

			// http://mathforum.org/library/drmath/view/57493.html
			double numerator = Math.pow(x, i);
			double denominator = factorialIterative(i);
			total = total + numerator / denominator;
			//System.out.println(i + " = " + total);
		}

		return total;
	}

	public double myExp2(double x, int n)
	{
		// Start at 1 to avoid division by 0 error
		double total = 1.0;
		double numerator = 1.0;
		double denominator = 1.0;

		for (int i = 1; i <= n; i++) {
			// e = 1 / 0! + 1 / 1! + ... + 1 / i!
			numerator = numerator * x;
			denominator = denominator * i;
			total = total + numerator / denominator;
			//System.out.println(i + " = " + total);
		}
		return total;
	}
}
