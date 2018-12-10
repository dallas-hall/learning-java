package Chapter07;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ValidateInputDoWhile
{	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(ValidateInputDoWhile.class.getName());

	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	private int limit;

	//@@@ MAIN METHOD @@@
	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Program starting.");
		Thread.sleep(005);
		Scanner scanner = new Scanner(System.in);
		boolean foundValidInput = false;

		do {
			System.out.println("Enter a number.");
			// Check if the input as actually a number
			if(scanner.hasNextDouble()) {
				foundValidInput = true;
			} else {
				logger.log(Level.WARNING, "Input not accepted.");
				Thread.sleep(005);
				String input = scanner.nextLine();
				System.out.println(input + " is not a number, try again.");
			}

		} while (!foundValidInput);
		logger.log(Level.INFO, "Input accepted.");
		Thread.sleep(005);
		double inputNumber = scanner.nextDouble();
		// Consume trailing newline (scanner bug)
		scanner.nextLine();
		System.out.println("You entered " + inputNumber + " which is a number.");
	}
}
