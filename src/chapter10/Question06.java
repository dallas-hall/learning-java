/*
package chapter10;

import java.util.Scanner;

*/
/**
 * Created by blindcant on 23/04/17.
 *//*

public class Question06
{
	//INSTANCE VARIABLES
	private static Scanner keyboard = new Scanner(System.in);
	private static int[] primeNumbers;
	
	//MAIN METHOD
	public static void main(String[] args)
	{
		System.out.print("Enter a number:");
		int userInput = Integer.parseInt(keyboard.nextLine());
		
	}
	
	public void createPrimeNumberArray(int maxNumber)
	{
		//create the new array, half the size of the start number.
		//this is because all even numbers > 2 aren't prime, so don't have to store them
		primeNumbers = new int[maxNumber / 2];
		//insert primes, the first is 2
		//skip even numbers > 2 because they aren't prime
		//divisor starts at 1, because the first round we store 2, and then increment by 2, so divisor = 3, where we want to start
		for (int i = 0, divisor = 1, startNumber = 2; divisor < maxNumber - 2; i++, divisor=+2, startNumber++)
		{
			if (i == 0)
			{
				primeNumbers[i] = startNumber;
			}
			else if (startNumber % 2 == 1)
			{
				primeNumbers[i];
			}
		}
	}
}
*/
