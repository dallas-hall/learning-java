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

		logger.log(Level.INFO, "Exercise 3 - Exponents With Iteration");
		Thread.sleep(005);
		System.out.println(runtime.powerIterative(2, 0));
		System.out.println(runtime.powerIterative(2, 1));
		System.out.println(runtime.powerIterative(2, 2));
		System.out.println(runtime.powerIterative(2, 3));
		System.out.println(runtime.powerIterative(2, 4));

		logger.log(Level.INFO, "Exercise 4 - Factorial With Iteration");
		Thread.sleep(005);
		System.out.println(runtime.factorialIterative(1));
		System.out.println(runtime.factorialIterative(2));
		System.out.println(runtime.factorialIterative(3));
		System.out.println(runtime.factorialIterative(4));

		logger.log(Level.INFO, "Exercise 5 - Infinite Series Expansion");
		Thread.sleep(005);
		System.out.println(runtime.myExponent(2, 2));
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
		}
		else if (n == 0) {
			return 1;
		}
		else {
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

	public int factorialIterative(int n)
	{
		if (n == 0) {
			return 0;
		}

		int result = 1;
		for (int i = 1; i <= n; i++) {
			result = result * i;
		}
		return result;
	}

	public double myExponent(double e, int x)
	{
		double result = 0;

		// e ^ x = 1 + x + x ^ 2 / 2! + ... + x ^ i / i!
		// ! means factorial, thus result of power divided by result of factorial
		for (int i = 0; i <= x; i++) {
			if (i == 0) {
				result += 1;
			}
			else if(i == 1) {
				result += x;
			}
			else {
				result += Math.pow(x, i) / factorialIterative(i);
			}
		}
		return result;
	}

	/*public double myExponent2(double e, int x) {
		double result = 0;

		for (int i = 0; i <= x; i++) {
			if (i == 0) {
				result += 1;
			}
			else if(i == 1) {
				result += x;
			}
			else {
				result +=
			}
		}
		return result;
	}*/
}
