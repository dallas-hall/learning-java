package chapter12_exceptions_and_text_io.Question01;

 /**
 * <h1>Number Format Exception</h1>
 * <p>
 * This program takes 3 arguments, 2 numbers and a math operator. It checks the arguments and if accept performs math, otherwise it throws exceptions.
 * </p>
 * <p>
 * tags:	try catch block; throw; Exception; ArithmeticException; args; switch case;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-05-07
 */
public class NumberExceptions
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) throws Exception
	{
		try {
			
			// Check number of strings passed
			if (args.length != 3) {
				throw new Exception("Program usage: number1 arithmetic-symbol number2");
			}
			else if (!args[0].matches("^[0-9]+$") || !args[2].matches("^[0-9]+$")) {
				throw new ArithmeticException("Invalid numbers entered.");
			}
			
			// The result of the operation
			int result = 0;
			
			// Determine the operator
			boolean valid = false;
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
					result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
					valid = true;
					break;
				default:
					throw new ArithmeticException("Invalid arithmetic operator.");
			}
			
			// Display result
			if (valid) {
				System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result);
			}
		}
		catch (ArithmeticException e) {
			System.out.println("ArithmeticException: " + e.getMessage());
			
		}
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}
