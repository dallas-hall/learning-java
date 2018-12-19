package Chapter07;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PowersIterative
{
	private static final Logger logger = Logger.getLogger(PowersIterative.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		PowersIterative powersIterative = new PowersIterative();
		logger.log(Level.INFO, "Exercise 3 - Exponents With Iteration");
		Thread.sleep(005);
		for (int i = 0; i < 8; i++) {
			System.out.println(powersIterative.powerIterative(2, i));
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
}
