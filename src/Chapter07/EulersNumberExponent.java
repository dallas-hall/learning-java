package Chapter07;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EulersNumberExponent
{
	private static final Logger logger = Logger.getLogger(EulersNumberExponent.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		EulersNumberExponent eulersNumberExponent = new EulersNumberExponent();

		logger.log(Level.INFO, "Exercise 5 - Infinite Series Expansion");
		Thread.sleep(005);
		// The number of rounds influences how accurate it is, factorialIterative() overflows at 20
		int rounds = 20;
		for (int i = 1; i < 5; i++) {

			eulersNumberExponent.checkMyExp(i, rounds);
		}

		// The approximation accuracy appears to get worse with larger positive numbers.
		double x = 0.10;
		for (int i = 1; i < 5; i++) {
			eulersNumberExponent.checkMyExp(x, rounds);
			x *= 10;
		}

		// The approximation accuracy appears to get worse with smaller negative numbers.
		x = -0.10;
		for (int i = 1; i < 5; i++) {
			eulersNumberExponent.checkMyExp(x, rounds);
			x *= 10;
		}
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
			double denominator = factorial(i);
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

	public void checkMyExp(double x, int rounds)
	{
		// Using .19 and g incase we get scientific notation back
		System.out.printf("%-18s\t%.19g\n", "myExp(" + x + ", " + rounds + ")", myExp(x, rounds));
		System.out.printf("%-18s\t%.19g\n", "myExp2(" + x + ", " + rounds + ")", myExp2(x, rounds));
		System.out.printf("%-18s\t%.19g\n", "Math.exp(" + x + ")", Math.exp(x));
		System.out.println();
	}

	public long factorial(int n)
	{
		// Explained in chapter 6 FactorialRecursion class, repeated here so unit tests pass
		if (n == 0) {
			return 1;
		}
		long recursionResult = factorial(n - 1);
		long result = n * recursionResult;
		return result;
	}
}
