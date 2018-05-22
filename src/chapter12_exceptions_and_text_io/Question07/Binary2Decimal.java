package chapter12_exceptions_and_text_io.Question07;

import chapter12_exceptions_and_text_io.Question09_BinaryFormatException;

import java.util.Scanner;

/**
 * <h1>Binary2Decimal Converter</h1>
 * <p>
 * This program asks the user for a binary number, validates it, and if valid will convert it to decimal.
 * </p>
 * <p>
 * tags:	Scanner; binary to decimal; extending Exception;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2017-05-13
 */
public class Binary2Decimal
{
	//@@@ INSTANCE VARIABLES @@@
	Scanner stdinKeyboard = new Scanner(System.in);
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Binary2Decimal run1 = new Binary2Decimal();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	Binary2Decimal()
	{
		//get user input and convert to decimal
		try {
			System.out.println(convertBinary(getInput()));
		}
		//catch (InputMismatchException e)
		//Update for Question 09
		catch (Question09_BinaryFormatException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
	//public String getInput() throws InputMismatchException
	//Update for Question 09
	public String getInput() throws Question09_BinaryFormatException
	{
		System.out.println("Enter a binary number");
		String binaryNumber = stdinKeyboard.nextLine();
		if (binaryNumber.matches("^[01]+$")) {
			return binaryNumber;
		}
		else {
			//throw new InputMismatchException("Invalid binary number.");
			//Update for Question 09
			throw new Question09_BinaryFormatException(binaryNumber);
		}
	}
	
	public long convertBinary(String binaryString)
	{
		//convert string to a number, using a radix value during the conversion, in our case base2
		long binaryNumber = Long.parseLong(binaryString, 2);
		return binaryNumber;
	}
}
