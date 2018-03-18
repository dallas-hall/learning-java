package chapter06_methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>Prime Number Calculator</h1>
 * <p>
 * This program will ask for a number, and compute all prime numbers up to that number.
 * </p>
 * <p>
 * tags:	prime numbers; for loop; for each loop; Scanner; parseInt; nextLine; Exception; try catch; List; ArrayList;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-16
 */
public class Question10
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Scanner stdin = new Scanner(System.in);
		int threshold = 0;
		boolean errorFound = false;
		
		do
		{
			try
			{
				// Reset in case of previous failure.
				errorFound = false;
				System.out.println("Enter a positive number.");
				threshold = Integer.parseInt(stdin.nextLine());
				if(threshold < 2)
					throw new Exception();
			}
			catch (Exception e)
			{
				System.out.println("Only numbers greater than 0 can be primes.");
				errorFound = true;
			}
		} while(errorFound);
		
		List<Integer> primes = new ArrayList<>();
		for(int i = 1; i <= threshold; i++)
		{
			boolean numberIsPrime = isPrime(i);
			if(numberIsPrime)
				primes.add(i);
		}
		
		int counter = 1;
		for(Integer aNumber :  primes)
		{
			System.out.print(aNumber + " ");
			counter++;
			if (counter % 10 == 0)
				System.out.println();
		}
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
	private static boolean isPrime(int number)
	{
		if (number % 2 == 0 && number != 2 || number == 1)
			return false;
		else if(number == 2 || number == 3)
			return true;
		// Since we have removed all even numbers, we can just test odd numbers only.
		else
		{
			for (int i = 3; i < number - 2; i+=2)
			{
				if(number % i == 0)
					return false;
			}
			return true;
		}
	}
}
