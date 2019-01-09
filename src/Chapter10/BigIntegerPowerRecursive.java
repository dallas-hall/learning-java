package Chapter10;/**
 * <h1>BigIntegerPowerRecursive</h1>
 * <p>
 * This program
 * </p>
 * <p>
 * tags:	<insert concept tags here for training code only>
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2019-01-09
 */

import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BigIntegerPowerRecursive
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(BigIntegerPowerRecursive.class.getName());
	
	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Chapter 10 - Exercise 5");
		int startNumber = 2;
		BigIntegerPowerRecursive runtime = new BigIntegerPowerRecursive();
		
		logger.log(Level.INFO, "Power recursion with int");
		Thread.sleep(005);
		// Overflow at 2 ^ 31
		for(int i = 0; i < 32; i++) {
			System.out.printf("%s %s.\n", startNumber + " ^ " + i + " is", runtime.powerRecursionInt(startNumber, i)) ;
		}
		
		logger.log(Level.INFO, "Power recursion with BigInteger");
		Thread.sleep(005);
		for(int i = 0; i < 64; i++) {
			System.out.printf("%s %s.\n", startNumber + " ^ " + i + " is", runtime.powerRecursiveBigInteger(startNumber, i)) ;
		}
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
	public int powerRecursionInt(int x, int n)
	{
		if (n == 0) {
			return 1;
		}
		
		// Find x to the n/2 recursively
		int recursionResult = powerRecursionInt(x, n / 2);
		
		// If n is even, the final result is recursionResult squared
		// If n is odd, the final result is recursionResult squared times x
		if (n % 2 == 0) {
			return recursionResult * recursionResult;
		}
		else {
			return recursionResult * recursionResult * x;
		}
	}
	
	public BigInteger powerRecursiveBigInteger(int x, int n)
	{
		if (n == 0) {
			return BigInteger.ONE;
		}
		
		BigInteger recursionResult = powerRecursiveBigInteger(x, n / 2);
		
		if (n % 2 == 0) {
			return recursionResult.multiply(recursionResult);
		}
		else {
			return recursionResult.multiply(recursionResult).multiply(BigInteger.valueOf(x));
		}
	}
}
