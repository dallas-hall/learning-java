package chapter05_loops;

/**
 * Created by blindcant on 24/04/17.
 */

import java.util.Scanner;

public class HexDigit2Dec
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a hex digit: ");
		String hexString = input.nextLine();
		
		// Check if the hex string has exactly one character
		if (hexString.length() != 1)
		{
			System.out.println("You must enter exactly one character");
			System.exit(1);
		}
		
		// Display decimal value for the hex digit
		char ch = hexString.toUpperCase().charAt(0);
		//if it is a character between A and F, the value of ch is minused by 65 and then 10 is added to it
		//A = 65, so 65 - 65 + 10 = (int) 10. In hex A = 10.
		//B = 66, so 65 - 65 + 11 = (int) 11. In hex B = 11.
		//C = 67, so 65 - 65 + 12 = (int) 12. In hex C = 12.
		//D = 68, so 65 - 65 + 13 = (int) 13. In hex D = 13.
		//E = 69, so 65 - 65 + 14 = (int) 14. In hex E = 14.
		//F = 70, so 65 - 65 + 15 = (int) 15. In hex F = 15.
		//remember that chars can be used as numbers, the Unicode number of the char is used
		if (ch <= 'F' && ch >= 'A')
		{
			int value = ch - 'A' + 10;
			System.out.println("The decimal value for hex digit " + ch + " is " + value);
		}
		//if it is a digit, we can just print it out as is
		else if (Character.isDigit(ch))
		{
			System.out.println("The decimal value for hex digit " + ch + " is " + ch);
		}
		else
		{
			System.out.println(ch + " is an invalid input");
		}
	}
}
