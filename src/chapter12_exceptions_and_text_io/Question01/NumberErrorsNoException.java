package chapter12_exceptions_and_text_io.Question01;

/**
 * <h1>Number Format Exception</h1>
 * <p>
 * This program takes 3 arguments, 2 numbers and a math operator. It checks the arguments and if accept performs math, otherwise prints error messages instead of exceptions.
 * </p>
 * <p>
 * tags:	args; switch case;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-05-07
 */
public class NumberErrorsNoException
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		// Check number of strings passed
		if (args.length != 3) {
			System.out.println("Program usage: number1 arithmetic-symbol number2");
			System.exit(0);
		}
		else if (!args[0].matches("^[0-9]+$") || !args[2].matches("^[0-9]+$")) {
			System.out.println("Invalid numbers entered.");
			System.exit(0);
		}
		
		// The result of the operation
		int result = 0;
		
		//do the math
		boolean valid = false;
		if (args[1].charAt(0) == '/' && Integer.parseInt(args[2]) == 0) {
			System.out.println("Cannot divide by zero");
		}
		else {
			// Determine the operator
			switch (args[1].charAt(0)) {
				case '+':
					result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
					valid = true;
					break;
				case '-':
					result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
					valid = true;
					break;
				case '*':
					result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
					valid = true;
					break;
				case '/':
					valid = true;
					result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
				default:
					System.out.println("Invalid arithmetic operator.");
			}
			// Display result
			if (valid) {
				System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result);
			}
		}
	}
}
