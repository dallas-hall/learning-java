package chapter12_exceptions_and_text_io;

import java.util.Scanner;

/**
 * Created by blindcant on 13/05/17.
 */
public class Question07
{
	//INSTANCE VARIABLES
	Scanner stdinKeyboard = new Scanner(System.in);
	
	//MAIN METHOD
	public static void main(String[] args)
	{
		Question07 run1 = new Question07();
	}
	
	//CONSTRUCTOR(S)
	Question07()
	{
		//get user input and convert to decimal
		try
		{
			System.out.println(convertBinary(getInput()));
		}
		//catch (InputMismatchException e)
		//Update for Question 09
		catch(Question09_BinaryFormatException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	//METHODS
	//public String getInput() throws InputMismatchException
	//Update for Question 09
	public String getInput() throws Question09_BinaryFormatException
	{
			System.out.println("Enter a binary number");
			String binaryNumber = stdinKeyboard.nextLine();
			if (binaryNumber.matches("^[01]+$"))
			{
				return binaryNumber;
			}
			else
			{
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
