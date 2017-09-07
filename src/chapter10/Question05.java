package chapter10;

import java.util.Scanner;

/**
 * Created by blindcant on 23/04/17.
 */
public class Question05
{
	//INSTANCE VARIABLES
	private static Scanner keyboard = new Scanner(System.in);
	private int[] factors;
	private int arraySize = 0;
	private final int MAX_NUMBER = 120;
	
	//MAIN METHOD
	public static void main(String[] args)
	{
		System.out.print("Enter an integer: ");
		int userInput = Integer.parseInt(keyboard.nextLine());
		Question05 run1 = new Question05(userInput);
	}
	
	//CONSTRUCTOR(S)
	public Question05(int startNumber)
	{
		getFactors(startNumber);
		System.out.println("All factors for " + startNumber + " are:");
		printFactors(this.factors);
		System.out.println("The factor pairs for " + startNumber + " are:");
		printFactorsPairs(this.factors);
		System.out.println("The prime factors for " + startNumber + " are:");
		printPrimeFactors(this.factors);
		System.out.println("The non-prime factors for " + startNumber + " are:");
		printNonPrimeFactors(this.factors);
		//System.out.println(startNumber);
	}
	
	//METHODS
	public int getArraySize()
	{
		return this.arraySize;
	}
	
	public int getMaxValue(int[] inputArray)
	{
		int arraySize = getArraySize();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arraySize; i++)
		{
			if (inputArray[i] > max)
			{
				max = inputArray[i];
			}
		}
		return max;
	}
	
	public boolean isEven(int inputNumber)
	{
		if (inputNumber % 2 == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isPrime(int inputValue)
	{
		//A prime number is any number that only has 2 factors, 1 and itself. E.g. 2, 3, 5, 7...
		//if the Number is even (n % 2 = 0) and greater than 2, it isn't prime. Return false immediately
		if (inputValue > 2 && isEven(inputValue))
		{
			return false;
		}
		else if (inputValue == 1)
		{
			return false;
		}
		else if (inputValue == 2)
		{
			return true;
		}
		else
		{
			//if the number can be divided evenly by any number less than itself, it isn't prime
			//we go up by 2 so every divisor being used is always an odd number, as we have already eliminated all evens
			//we use inputValue - 2 because every divisor being uses is always an odd number, thus the highest number we
			// need to check as a divisor is inputValue - 2 as inputValue - 1 is an even number and will never be reached
			for (int divisor = 3; divisor <= (inputValue - 2); divisor+=2)
			{
				if (inputValue % divisor == 0)
				{
					return false;
				}
			}
		}
		//return prime only if the above if/else and for loop check fails.
		return true;
	}
	
	public void getFactors(int inputNumber)
	{
		//assuming that every number will less factors than half of itself
		factors = new int[inputNumber / 2];
		for (int i = 0, divisor = 1; divisor <= inputNumber; divisor++)
		{
			if (inputNumber % divisor == 0)
			{
				factors[i]=divisor;
				this.arraySize++;
				i++;
			}
		}
	}
	
	public void printFactors(int[] inputArray)
	{
		int arraySize = getArraySize();
		for (int i = 0; i < arraySize; i++)
		{
			System.out.print(inputArray[i] + " ");
		}
		System.out.println();
	}
	
	public void printFactorsPairs(int[] inputArray)
	{
		int arraySize = getArraySize();
		for (int i = 0; i < arraySize; i++)
		{
			System.out.print(inputArray[i] + " & " + inputArray[arraySize - (i + 1)] + ". ");
		}
		System.out.println();
	}
	
	public void printPrimeFactors(int[] inputArray)
	{
		int arraySize = getArraySize();
		for (int i = 0; i < arraySize; i++)
		{
			if (isPrime(inputArray[i]))
			{
				System.out.print(inputArray[i] + " ");
			}
			else
			{
				continue;
			}
		}
		System.out.println();
	}
	
	public void printNonPrimeFactors(int[] inputArray)
	{
		int arraySize = getArraySize();
		for (int i = 0; i < arraySize; i++)
		{
			if (!isPrime(inputArray[i]))
			{
				System.out.print(inputArray[i] + " ");
			}
			else
			{
				continue;
			}
		}
		System.out.println();
	}
}
