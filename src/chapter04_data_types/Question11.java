package chapter04_data_types;

import java.util.Scanner;

/**
 * Created by blindcant on 24/04/17.
 */
public class Question11
{
	//INSTANCE VARIABLES
	private Scanner keyboard = new Scanner(System.in);
	
	//MAIN METHOD
	public static void main(String[] args)
	{
		Question11 run1 = new Question11();
	}
	
	//CONSTRUCTOR(S)
	Question11()
	{
		System.out.println("Convert hex to binary");
		System.out.println("Enter a hex digit, [0-9A-F]");
		//convert input to uppercase, convert String to char
		char userInput = keyboard.nextLine().toUpperCase().charAt(0);
		//convert from hex to decimal
		//if it is a character between A and F, the value of ch is minused by 65 and then 10 is added to it
		//A = 65, so 65 - 65 + 10 = (int) 10. In hex A = 10.
		//B = 66, so 65 - 65 + 11 = (int) 11. In hex B = 11.
		//C = 67, so 65 - 65 + 12 = (int) 12. In hex C = 12.
		//D = 68, so 65 - 65 + 13 = (int) 13. In hex D = 13.
		//E = 69, so 65 - 65 + 14 = (int) 14. In hex E = 14.
		//F = 70, so 65 - 65 + 15 = (int) 15. In hex F = 15.
		//remember that chars can be used as numbers, the Unicode number of the char is used
		
		if (userInput <= 'F' && userInput >= 'A')
		{
			//convert the value of char (hex digit) to a decimal
			int binaryValue = userInput - 'A' + 10;
			System.out.println("The hex digit " + userInput + " in binary is: " + Integer.toBinaryString(binaryValue));
		}
		//check if the char value is a digit [0-9]
		else if (Character.isDigit(userInput))
		{
			//convert the value of char (hex digit) to a decimal
			//convert char to string, then string to int
			int binaryValue = Integer.parseInt(String.valueOf(userInput));
			System.out.println("The hex digit " + userInput + " in binary is: " + Integer.toBinaryString(binaryValue));
		}
		else
		{
			System.out.println("Invalid input.");
		}
	}
}
