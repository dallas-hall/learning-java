package chapter06_methods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>Twin Primes</h1>
 * <p>
 * This program will print twin primes, we are 2 prime numbers that differ by 2.
 * </p>
 * <p>
 * tags: prime numbers; for loop; for each loop; Scanner; parseInt; nextLine; Exception; try catch; List; ArrayList;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-18
 */
public class Question29
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		int threshold = 100;
		int number = 1;
		int counter = 0;
		boolean done = false;
		
		Map<Integer, Integer> twinPrimes = new HashMap<>();
		while(!done)
		{
			// Skip the number if it is already a pair
			if(twinPrimes.containsValue(number))
			{
				number++;
				continue;
			}
			boolean numberIsPrime = isPrime(number);
			boolean numberHasTwinPrime = hasTwinPrime(number);
			if(numberIsPrime && numberHasTwinPrime)
			{
				twinPrimes.put(number, number+2);
				System.out.println(number + " has the twin prime " + (number + 2));
				counter++;
			}
			number++;
			
			if(counter == threshold)
				done = true;
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
				if(number % i == 0)
					return false;
			return true;
		}
	}
	
	private static boolean hasTwinPrime(int number)
	{
		if (isPrime(number) && isPrime(number + 2))
			return true;
		else
			return false;
	}
}
