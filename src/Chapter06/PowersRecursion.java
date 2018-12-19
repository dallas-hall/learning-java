package Chapter06;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PowersRecursion
{
	private static final Logger logger = Logger.getLogger(PowersRecursion.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		PowersRecursion runtime = new PowersRecursion();
		logger.log(Level.INFO, "Exercise 9 - powers recursion");
		Thread.sleep(005);
		for (int i = 0; i <= 16; i++) {
			System.out.println(runtime.power(2, i));
		}
	}

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
