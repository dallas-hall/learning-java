package chapter06_methods;

import java.util.Scanner;

/**
 * <h1>Triangle Printing</h1>
 * <p>
 * This program will accept a number and print out a triangle of numbers up to that number. The formatting only works properly for single characters.
 * </p>
 * <p>
 * tags:	for loop; nested for loop; Scanner; parseInt; nextLine; do while; Exception; try catch;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-16
 */
public class Question06
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Scanner stdin = new Scanner(System.in);
		boolean errorFound = false;
		int amount = 0;
		
		do
		{
			try
			{
				// Reset in case of previous failure
				errorFound = false;
				System.out.println("Enter a positive integer. This will be used to print the triangle pattern.");
				amount =  Integer.parseInt(stdin.nextLine());
				if(amount <= 0)
					throw new IllegalArgumentException("The number must be greater than 0.");
			}
			catch (Exception e)
			{
				if(e instanceof NumberFormatException)
					System.out.println("Only numbers can be entered.");
				else
					System.out.println(e.getMessage());
				errorFound = true;
			}
		} while (errorFound);
		
		displayPatternWithStars(amount);
		displayPatternWithNumbersAscending(amount);
		displayPatternWithNumbersDescending(amount);
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
	public static void displayPatternWithStars(int number)
	{
		// We need double the spaces because of the spaces between characters.
		int spaces = number * 2;
		char printChar = '*';
		// Print all lines
		for (int i = 0; i < number; i++)
		{
			// Print spaces
			for(int j = 0; j < spaces; j++)
			{
				System.out.print(" ");
			}
			
			// Print character(s)
			for(int k = 0; k < i + 1; k++)
			{
				System.out.print(" " + printChar);
			}
			
			// Update variables
			// Needs to be 2
			spaces-=2;
			
			// Print line
			System.out.println();
		}
	}
	
	public static void displayPatternWithNumbersAscending(int number)
	{
		int spaces = number * 2;
		for (int i = 0; i < number; i++)
		{
			for(int j = 0; j < spaces; j++)
			{
				System.out.print(" ");
			}
			
			for(int k = 0; k < i + 1; k++)
			{
				System.out.print(" " + (k + 1));
			}
			
			spaces-=2;
			System.out.println();
		}
	}
	
	public static void displayPatternWithNumbersDescending(int number)
	{
		int spaces = number * 2;
		for (int i = 0; i < number; i++)
		{
			int printNumber = i + 1;
			for(int j = 0; j < spaces; j++)
			{
				System.out.print(" ");
			}
			
			for(int k = 0; k < i + 1; k++, printNumber--)
			{
				System.out.print(" " + printNumber);
			}
			
			spaces-=2;
			System.out.println();
		}
	}
}
