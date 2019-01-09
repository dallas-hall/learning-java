package Chapter10;
/**
 * <h1>BigIntegerFactorial</h1>
 * <p>
 * This program shows how using BigInteger can mitigate overflows. It shows this using factorials.
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2019-01-09
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigInteger;

public class BigIntegerFactorial
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(BigIntegerFactorial.class.getName());
	
	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Chapter 10 - Exercise 4");
		BigIntegerFactorial runtime = new BigIntegerFactorial();
		
		logger.log(Level.INFO, "Factorial with long");
		Thread.sleep(005);
		// Long overflow occurs at 21
		for(int i = 0; i <= 30; i++) {
			System.out.printf("%s %s.\n", "The factorial of " + i + " are", runtime.factorialIterative(i));
		}
		
		logger.log(Level.INFO, "Factorial with BigInteger");
		Thread.sleep(005);
		for(int i = 0; i <= 30; i++) {
			System.out.printf("%s %s.\n", "The factorial of " + i + " are", runtime.factorialIterativeBigInteger(i));
		}
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
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
	
	public BigInteger factorialIterativeBigInteger(int n)
	{
		BigInteger result = BigInteger.ONE;
		
		// http://mathforum.org/library/drmath/view/57128.html & https://www.mathsisfun.com/numbers/factorial.html
		if (n == 0) {
			return result;
		}
		
		for (int i = 1; i <= n; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}
}
