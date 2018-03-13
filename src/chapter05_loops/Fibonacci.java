package chapter05_loops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>Calculate Fibonnaci Numbers</h1>
 * <p>
 * This program will start at 0 and 1, and calculate the fibonacci numbers up until the specified limit.
 * </p>
 * <p>
 * tags:	for loop; Scanner; nextInt; Exception; try-catch-finally
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-10
 */
public class Fibonacci
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		int firstNumber = 0;
		int secondNumber = 1;
		List<Integer> fibonacciNumbers = new ArrayList<>();
		fibonacciNumbers.add(Integer.valueOf(firstNumber));
		fibonacciNumbers.add(Integer.valueOf(secondNumber));
		int limit = 0;
		Scanner stdin = new Scanner(System.in);
		boolean errorFound = false;
		
		do
		{
			// Reset after previous attempts
			errorFound = false;
			try
			{
				System.out.println("Enter the number to stop at.");
				limit = stdin.nextInt();
				if (limit <= 0)
				{
					throw new Exception();
				}
			}
			catch (Exception e)
			{
				System.out.println("The number must a positive integer.");
				errorFound = true;
			}
			finally
			{
				// Scanner bug
				stdin.nextLine();
			}
		}
		while (errorFound);
		
		// Calculate Fibonacci numbers
		for (int i = 0; i < limit; i++)
		{
			int result = firstNumber + secondNumber;
			fibonacciNumbers.add(Integer.valueOf(result));
			//System.out.println(firstNumber + " + " + secondNumber + " = " + result);
			// Update the numbers
			firstNumber = secondNumber;
			secondNumber = result;
		}
		
		// Print Fibonacci numbers
		int counter = 1;
		for (Integer anInteger : fibonacciNumbers)
		{
			System.out.print(anInteger + " ");
			counter++;
			if (counter % 10 == 0)
			{
				System.out.println();
			}
		}
	}
}
