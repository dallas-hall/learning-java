package chapter10;

import java.util.Scanner;

/*
 * Created by blindcant on 23/04/17.
 */

public class Question06
{
	//INSTANCE VARIABLES
	private static Scanner keyboard = new Scanner(System.in);
	private static int[] primeNumbers;
	private int userInput;
	
	//MAIN METHOD
	public static void main(String[] args)
	{
		Question06 runTime = new Question06();
	}
	
	public Question06()
	{
		System.out.print("Enter a number:");
		userInput = Integer.parseInt(keyboard.nextLine());
		createPrimeNumberArray(userInput);
		printPrimeNumberArray();
	}
	
	public void createPrimeNumberArray(int maxNumber)
	{
		//create the new array, half the size of the maxNumber.
		//this is because all even numbers > 2 aren't prime, so don't have to store them.
		primeNumbers = new int[maxNumber / 2];
		//insert primes, the first is 2.  Start with 1 but skip it as we add 2 the first round, so really start with 3 and keep checking.
		//skip even numbers > 2 because they aren't prime
		
		for (int numberToCheck = 1, i = 0; numberToCheck < maxNumber; numberToCheck+=2)
		{
			//add 2, the only even prime
			if (i == 0)
			{
				primeNumbers[i] = 2;
				i++;
			}
			else if(isPrime(numberToCheck))
			{
				primeNumbers[i] = numberToCheck;
				i++;
			}
			else
			{
				continue;
			}
		}
	}
	
	private boolean isPrime(int numberToCheck)
	{
		StringBuilder aStringBuilder = new StringBuilder();
		// Test whether number is prime
		if(numberToCheck < 2)
		{
			//System.out.println(numberToCheck + " is not prime.  Only numbers >= 2 can be prime.");
			return false;
		}
		else if(numberToCheck == 2)
		{
			//System.out.println("2 is the only even prime.");
			return true;
		}
		else if(numberToCheck % 2 == 0)
		{
			//System.out.println(numberToCheck + " is not prime.  2 is the only even prime.");
			return false;
		}
		for (int divisor = 2; divisor <= numberToCheck - 1; divisor++)
		{
			if (numberToCheck % divisor == 0 && divisor < numberToCheck - 1)
			{ // If true, number is not prime
				aStringBuilder.append(divisor).append(" ");
			}
			
		}
		if (aStringBuilder.length() > 0)
		{
			//System.out.println(numberToCheck + " is not prime, it was evenly divisibe by " + aStringBuilder.toString());
			return false;
		}
		//exhausted all checks, must be prime
		else
		{
			//System.out.println(numberToCheck + " is prime.  It can only be divided evenly by 1 and itself.");
			return true;
		}
	}
	
	public void printPrimeNumberArray()
	{
		System.out.println("Printing all prime numbers up until " + userInput);
		int counter = 1;
		for (int aPrime : primeNumbers)
		{
			if(aPrime != 0)
			{
				System.out.print(aPrime + "\t");
			}
			//print 10 per line
			if(counter % 10 == 0)
			{
				System.out.println();
			}
			counter++;
		}
	}
}
