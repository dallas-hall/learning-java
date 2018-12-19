package Chapter07;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GaussianIntegral
{
	private static final Logger logger = Logger.getLogger(FactorialIterative.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		GaussianIntegral gaussianIntegral = new GaussianIntegral();
		logger.log(Level.INFO, "Exercise 6 - Infinite Series Expansion");
		Thread.sleep(005);

		System.out.println(gaussianIntegral.gauss(1, 1));
		System.out.println(gaussianIntegral.gauss(1, 5));
		System.out.println(gaussianIntegral.gauss(1, 10));
		System.out.println(gaussianIntegral.gauss(1, 15));
		System.out.println(gaussianIntegral.gauss(1, 20));

		System.out.println(gaussianIntegral.otherGauss(1, 1));
		System.out.println(gaussianIntegral.otherGauss(1, 5));
		System.out.println(gaussianIntegral.otherGauss(1, 10));
		System.out.println(gaussianIntegral.otherGauss(1, 15));
		System.out.println(gaussianIntegral.otherGauss(1, 20));
	}

	public double gauss(double x, int n)
	{
		// https://en.wikipedia.org/wiki/Gaussian_integral
		// e is euler's number. e ^ (-x ^ 2) = 1 - x ^ 2 + x ^ 4 /2 - ... + x ^ i ^ i
		double total = 0;
		double result = 0;
		int exponent = 2;
		int divisor = 2;

		for (int i = 0; i < n; i++) {
			if (i == 0) {
				total += 1;
			} else if (i == 1) {
				result = Math.pow(x, exponent);
				total -= result;
				exponent += 2;
			} else if (i == n - 1) {
				// the last step is meant to be (-1)^ i * x ^ (2 ^ i) / i!
				result  = Math.pow(-1, i) * Math.pow(x, (2 * i)) / factorial(i);
				if (i % 2 == 0) {
					total += result;
				}
				else {
					total -= result;
				}

			} else if (i % 2 == 0) {
				result = Math.pow(x, exponent) / divisor;
				total += result;
				divisor += 4;
				exponent += 2;
			} else {
				result = Math.pow(x, exponent) / divisor;
				total -= result;
				divisor += 4;
				exponent += 2;
			}
		}
		return total;
	}

	// https://github.com/ApolloZhu/Think-Java-Exercises/blob/master/Chapter7/7.6.java
	public double otherGauss(double x, int n)
	{
		double result = 1;
		int q = 1;
		double p = 1;
		int pre = 1;
		for (int i = 1; i < n; i++) {
			result += (pre *= -1) * (p *= x * x) / (q *= i);
		}
		return result;
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
