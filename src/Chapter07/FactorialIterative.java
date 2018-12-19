package Chapter07;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FactorialIterative
{
	private static final Logger logger = Logger.getLogger(FactorialIterative.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		FactorialIterative factorialIterative = new FactorialIterative();
		logger.log(Level.INFO, "Exercise 4 - Factorial With Iteration");
		Thread.sleep(005);
		// Overflow at 21
		for (int i = 0; i < 21; i++) {
			System.out.println(i + " factorial = " + factorialIterative.factorialIterative(i));
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
}
