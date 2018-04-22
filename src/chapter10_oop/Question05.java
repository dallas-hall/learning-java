package chapter10_oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>Grid Coordinates</h1>
 * <p>
 * This program will create some grid coordinates using the Point2D class and then show the coordinates and calculate the distance between them.
 * </p>
 * <p>
 * tags:	Point2D; grid points; grid coordinates;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-23
 */
public class Question05
{
	//@@@ CLASS VARIABLES @@@
	private static Scanner keyboard = new Scanner(System.in);
	
	//@@@ INSTANCE VARIABLES @@@
	private int[] factorsArray;
	private List factorsList;
	private int arraySize = 0;
	private final int MAX_NUMBER = 120;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		System.out.print("Enter an integer: ");
		int userInput = Integer.parseInt(keyboard.nextLine());
		Question03 question03 = new Question03();
		Question05 run1 = new Question05(userInput);
		run1.runTest(userInput, question03);
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public Question05(int startNumber)
	{
		//assuming that every number will less factors than half of itself + 1
		factorsArray = new int[startNumber / 2 + 1];
		factorsList = new ArrayList();
	
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
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
	
	
	public void getFactorsFromArray(int inputNumber)
	{
		for (int i = 0, divisor = 1; divisor <= inputNumber; divisor++)
		{
			if (inputNumber % divisor == 0)
			{
				factorsArray[i]=divisor;
				this.arraySize++;
				i++;
			}
		}
	}
	
	//### HELPERS ###
	public void printFactorsFromArray(int[] inputArray)
	{
		int arraySize = getArraySize();
		for (int i = 0; i < arraySize; i++)
		{
			System.out.print(inputArray[i] + " ");
		}
		System.out.println();
	}
	
	public void printFactorsFromArrayPairs(int[] inputArray)
	{
		int arraySize = getArraySize();
		for (int i = 0; i < arraySize; i++)
		{
			System.out.print(inputArray[i] + " & " + inputArray[arraySize - (i + 1)] + ". ");
		}
		System.out.println();
	}
	
	public void printPrimeFactorsFromArray(int[] inputArray, Question03 question03)
	{
		int arraySize = getArraySize();
		for (int i = 0; i < arraySize; i++)
		{
			if (question03.isPrime2(inputArray[i]))
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
	
	public void printNonPrimeFactorsFromArray(int[] inputArray, Question03 question03)
	{
		int arraySize = getArraySize();
		for (int i = 0; i < arraySize; i++)
		{
			if (!question03.isPrime2(inputArray[i]))
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
	
	public void runTest(int startNumber, Question03 question03)
	{
		getFactorsFromArray(startNumber);
		System.out.println("All factors for " + startNumber + " are:");
		printFactorsFromArray(this.factorsArray);
		System.out.println("The factor pairs for " + startNumber + " are:");
		printFactorsFromArrayPairs(this.factorsArray);
		System.out.println("The prime factors for " + startNumber + " are:");
		printPrimeFactorsFromArray(this.factorsArray, question03);
		System.out.println("The non-prime factors for " + startNumber + " are:");
		printNonPrimeFactorsFromArray(this.factorsArray, question03);
		//System.out.println(startNumber);
	}
}
