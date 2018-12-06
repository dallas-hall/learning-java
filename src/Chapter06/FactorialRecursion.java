package Chapter06;

/**
 * <h1>FactorialRecursion</h1>
 * <p>
 * This program uses recursion to calculate a factorial.
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2018-12-06
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class FactorialRecursion
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(FactorialRecursion.class.getName());
	
	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	private int startNumber;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		logger.log(Level.INFO, "Program starting.");
		FactorialRecursion runtime = new FactorialRecursion(4);
		
		System.out.println("A factorial is the result of multiplying the start number by every number between itself and 1, inclusive.");
		System.out.println("The factorial of " + runtime.getStartNumber() + " is " + runtime.factorial(runtime.getStartNumber()));
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public FactorialRecursion(int startNumber)
	{
		this.startNumber = startNumber;
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public int getStartNumber()
	{
		return startNumber;
	}
	
	//### HELPERS ###
	
	/**
	 * This method calculates a factorial by using recursion.
	 *
	 * @param n - This parameter stores the current number to be used for the factorial. It is decremented by 1 on each
	 * recursive call.
	 * @return - During recursion this will return the result of the current step to the previous stack frame. At the
	 * end of recursion it will return the value to the caller.
	 */
	public int factorial(int n)
	{
		/*
		https://www.mathsisfun.com/numbers/factorial.html
		A factorial multiplies all numbers from the start number down to 1.
		*/
		// Base case, once n is 0 we need to return 1
		if (n == 0) {
			return 1;
		}
		/*
		Recurse here to get all the numbers between the start number and 1, inclusive.
		Each stack frame will hold the value of the passed in parameter in n. This parameter is decremented by 1
		as it is passed through recursive calls.
		recursionResult is only calculated once all the recursive function calls are completed. This will hold the value
		that is being returned from the previous stack frame calculation (i.e. n - 1)
		*/
		int recursionResult = factorial(n - 1);
		// Once recursion has finished, unwind the stack and start calculating each part of the equation
		int result = n * recursionResult;
		/*
		For each recursive step, return the intermediary result. This will be stored in recursionResult of the previous
		stack frame.
		For the last stack frame, this will be returned back to the caller, main.
		*/
		return result;
	}
}
