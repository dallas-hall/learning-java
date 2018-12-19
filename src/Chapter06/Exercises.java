/*
package Chapter06;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercises
{
	private static final Logger logger = Logger.getLogger(Exercises.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Chapter 6 - Exercises");
		Exercises runtime = new Exercises();


		logger.log(Level.INFO, "Exercise 3 - isTriangle");
		Thread.sleep(005);
		System.out.println("Can you make a triangle from 1, 2, and 3? " + runtime.canCreateTriangle(1, 2, 3));
		System.out.println("Can you make a triangle from 1, 2, and 4? " + runtime.canCreateTriangle(1, 2, 4));

		logger.log(Level.INFO, "Exercise 4 - multadd operation");
		Thread.sleep(005);
		System.out.println("1 * 2 + 3 = " + runtime.multaddOperation(1, 2, 3));
		System.out.println("2 * 4 + 8 = " + runtime.multaddOperation(2, 4, 8));

		logger.log(Level.INFO, "Exercise 6 - prod recursion");
		Thread.sleep(005);
		System.out.println(runtime.prod(1, 4));
		System.out.println(runtime.prodRewrite(1, 4));

		logger.log(Level.INFO, "Exercise 7 - oddSum recursion");
		Thread.sleep(005);
		System.out.println(runtime.oddSum(10));

		logger.log(Level.INFO, "Exercise 8 - Ackermann recursive function");
		Thread.sleep(005);
		// https://en.wikipedia.org/wiki/Ackermann_function#Example_expansions
		System.out.println(runtime.ackermann(1, 2));

		logger.log(Level.INFO, "Exercise 9 - power recursion");
		Thread.sleep(005);
		System.out.println(runtime.power(2, 3));

	}


	// multadd operation is a * b + c, this can concisely represent many computations.
	public double multaddOperation(double a, double b, double c)
	{
		return a * b + c;
	}

	public static int prod(int m, int n)
	{
		if (m == n) {
			return n;
		} else {
			int recurse = prod(m, n - 1);
			int result = n * recurse;
			return result;
		}
	}

	public static int prodRewrite(int m, int n)
	{
		if (m == n) {
			return n;
		} else {
			return prod(m, n - 1) * n;
		}
	}

	public int oddSum(int n)
	{
		int sum = 0;
		int recursionResult = 0;

		// Base case, return 1 when n is 1
		if (n == 1) {
			return 1;
		}

		*/
/*
		If n is odd, decrement by 2 and do recursive call
		The result of the recursion needs to be added with n and then added to sum. This is the returned value.
		*//*

		if (n % 2 == 1) {
			recursionResult = oddSum(n - 2);
			sum += (recursionResult + n);
		}
		*/
/*
		If n is even, decrement by 1 and do recursive call.
		The result of the recursion needs to be added with sum. n doesn't need to be added here because we are only
		summing odd numbers, so this covers the case where n starts as an even number. This is the returned value.
		*//*

		else if (n % 2 == 0) {
			recursionResult = oddSum(n - 1);
			sum += recursionResult;
		}

		return sum;
	}

	public long ackermann(int m, int n)
	{
		long result = 0;

		if (m == 0) {
			result = n + 1;
		} else if (m > 0 && n == 0) {
			result = ackermann(m - 1, 1);
		} else if (m > 0 && n > 0) {
			result = ackermann(m - 1, (int) ackermann(m, n - 1));
		}

		return result;
	}

	*/
/**
	 * This method uses recursion to calculate exponents. The formula being use is x ^ n = x · x ^ n − 1.
	 * When n is even, the formula being used is x ^ n = (x ^ (n / 2)) ^ 2
	 *
	 * @param x - the number to be used in the exponent operation.
	 * @param n - how many times to raise x
	 * @return - the result of the exponent operation.
	 *//*

	public double power(double x, int n)
	{
		double result = 0;

		// 0 ^ n is always 0
		if (x == 0) {
			return 0;
		}

		// x ^ 0 is always 1
		if (n == 0) {
			return 1;
		}
		// x ^ 1 is always x
		else if (n == 1) {
			return x;
		// This is needed to prevent a stack overflow from an infinite recursion call when using x ^ n = (x ^ (n / 2)) ^ 2
		} else if (n == 2) {
			return x * x;
		}
		else {
			// Apparently this is more efficient when n is even.
			if (n % 2 == 0) {
				result = power(power(x, (n / 2)), 2);
			} else {
				result = x * power(x, n - 1);
			}
			//result = x * power(x, n - 1);
			return result;
		}
	}
}
*/
