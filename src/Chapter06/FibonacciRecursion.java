package Chapter06;

/**
 * <h1>FibonacciRecursion</h1>
 * <p>
 * This program calculates the fibonacci series using recursion.
 * </p>
 * <p>
 *
 * @author blindcant
 * @version 0.1.0 - 2018-12-06
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class FibonacciRecursion
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(FibonacciRecursion.class.getName());
	
	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	private int limit;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		logger.log(Level.INFO, "Program starting.");
		FibonacciRecursion runtime = new FibonacciRecursion(10);
		int limit = runtime.getLimit();
		for (int i = 1; i <= limit; i++) {
			System.out.println(runtime.fibonacci(i));
		}
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public FibonacciRecursion(int limit)
	{
		this.limit = limit;
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public int getLimit()
	{
		return limit;
	}

	//### HELPERS ###
	public int fibonacci(int n)
	{
		// Make sure the first 2 numbers are both 1.
		if (n == 1 || n == 2) {
			return 1;
		}
		int result1 = fibonacci(n - 1);
		int result2 = fibonacci(n - 2);
		return result1 + result2;
		//return fibonacci(n - 1) + fibonacci(n - 2);
	}

}
