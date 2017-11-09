package chapter12_exceptions_and_text_io;

import java.util.Scanner;

/**
 * Created by blindcant on 13/05/17.
 */
public class Question06
{
	/**
	 * Main method
	 */
	public static void main(String[] args)
	{
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		
		// Prompt the user to enter a string, if they get it wrong, ask again
		boolean valid = false;
		do
		{
			try
			{
				System.out.print("Enter a hex number: ");
				String hex = input.nextLine();
				System.out.println("The decimal value for hex number " + hex + " is " + hexToDecimal(hex.toUpperCase()));
				valid = true;
			}
			// catch (NumberFormatException e)
			//update for Question08
			catch (Question08_HexFormatException e)
			{
				System.out.println(e.getMessage());
			}
		}
		while (!valid);
	}
	
	//public static int hexToDecimal(String hexString) throws NumberFormatException
	//update for Question08
	public static int hexToDecimal(String hexString) throws Question08_HexFormatException
	{
		int decimalValue = 0;
		if (!hexString.toUpperCase().matches("^[0-9-A-F]+$"))
		{
			//throw new NumberFormatException(hexString + " is not a valid hexidecimal number.\nMust be between 0-9 and A-F.\n");
			throw new Question08_HexFormatException(hexString);
		}
		
		for (int i = 0; i < hexString.length(); i++)
		{
			char hexChar = hexString.charAt(i);
			decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
		}
		
		return decimalValue;
	}
	
	public static int hexCharToDecimal(char ch)
	{
		if (ch >= 'A' && ch <= 'F')
			return 10 + ch - 'A';
		else // ch is '0', '1', ..., or '9'
			return ch - '0';
	}
}
