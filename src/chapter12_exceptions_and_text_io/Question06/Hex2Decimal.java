package chapter12_exceptions_and_text_io.Question06;

import chapter12_exceptions_and_text_io.Question08_HexFormatException;

import java.util.Scanner;

/**
 * <h1>Hex2Decimal Converter</h1>
 * <p>
 * This program asks the user for a hex number, validates it, and if valid will convert it to decimal.
 * </p>
 * <p>
 * tags:	Scanner; hex to decimal; extending Exception;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2017-05-13
 */
public class Hex2Decimal
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		
		// Prompt the user to enter a string, if they get it wrong, ask again
		boolean valid = false;
		do {
			try {
				System.out.print("Enter a hex number: ");
				String hex = input.nextLine();
				System.out.println("The decimal value for hex number " + hex + " is " + hexToDecimal(hex.toUpperCase()));
				valid = true;
			}
			// catch (NumberFormatException e)
			//update for Question08
			catch (Question08_HexFormatException e) {
				System.out.println(e.getMessage());
			}
		}
		while (!valid);
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
	//public static int hexToDecimal(String hexString) throws NumberFormatException
	//update for Question08
	public static int hexToDecimal(String hexString) throws Question08_HexFormatException
	{
		int decimalValue = 0;
		if (!hexString.toUpperCase().matches("^[0-9-A-F]+$")) {
			//throw new NumberFormatException(hexString + " is not a valid hexidecimal number.\nMust be between 0-9 and A-F.\n");
			throw new Question08_HexFormatException(hexString);
		}
		
		for (int i = 0; i < hexString.length(); i++) {
			char hexChar = hexString.charAt(i);
			decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
		}
		
		return decimalValue;
	}
	
	public static int hexCharToDecimal(char ch)
	{
		if (ch >= 'A' && ch <= 'F') {
			return 10 + ch - 'A';
		}
		else // ch is '0', '1', ..., or '9'
		{
			return ch - '0';
		}
	}
}
