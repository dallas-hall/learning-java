package Chapter06;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ackermann
{
	private static final Logger logger = Logger.getLogger(Ackermann.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		Ackermann runtime = new Ackermann();
		logger.log(Level.INFO, "Exercise 8 - Ackermann recursive function");
		Thread.sleep(005);
		// https://en.wikipedia.org/wiki/Ackermann_function#Example_expansions
		for(int i = 0; i < 10; i++) {
			System.out.println(runtime.ackermann(1, i));
		}
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
}
