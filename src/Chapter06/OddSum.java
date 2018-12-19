package Chapter06;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OddSum
{
	private static final Logger logger = Logger.getLogger(OddSum.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		OddSum runtime = new OddSum();
		logger.log(Level.INFO, "Exercise 7 - oddSum recursion");
		Thread.sleep(005);
		for (int i = 0; i < 10; i++) {
			System.out.println(runtime.oddSum(i));
		}

	}

	public int oddSum(int n)
	{
		int sum = 0;
		int recursionResult = 0;

		if (n <= 0) {
			return -1;
		}

		// Base case, return 1 when n is 1
		if (n == 1) {
			return 1;
		}
		/*
		If n is odd, decrement by 2 and do recursive call
		The result of the recursion needs to be added with n and then added to sum. This is the returned value.
		*/

		if (n % 2 == 1) {
			recursionResult = oddSum(n - 2);
			sum += (recursionResult + n);
		}
		/*
		If n is even, decrement by 1 and do recursive call.
		The result of the recursion needs to be added with sum. n doesn't need to be added here because we are only
		summing odd numbers, so this covers the case where n starts as an even number. This is the returned value.
		*/
		else if (n % 2 == 0) {
			recursionResult = oddSum(n - 1);
			sum += recursionResult;
		}

		return sum;
	}
}
