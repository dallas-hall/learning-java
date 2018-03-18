package chapter06_methods;

import java.util.*;

/**
 * <h1>Mersenne Primes</h1>
 * <p>
 * This program will print the mersenne numbers that are prime numbers. https://simple.wikipedia.org/wiki/Mersenne_prime states that a Mersenne number is a number that is one less than a power of two. A Mersenne prime is a Mersenne number that is a prime number. This however, is not sufficient. Many mathematicians prefer the definition of a Mersenne number where exponent n has to be a prime number.
 * </p>
 * <p>
 * tags: prime numbers; for loop; for each loop; Scanner; parseInt; nextLine; Exception; try catch; List; ArrayList;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-18
 */
public class Question28
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		int threshold = 32;
		boolean done = false;
		
		Map<Integer, Long> mersennePrimes = new HashMap<>();
		for(int i = 0; i < threshold; i++)
		{
			boolean numberIsPrime = isPrime(i);
			boolean numberIsMersennePrime = false;
			if(numberIsPrime)
				numberIsMersennePrime = isMersennePrime(i);
			if (numberIsPrime && numberIsMersennePrime)
			{
				// This needs to be a long otherwise there is an integer overflow for mersenne prime 31, (2^31)
				long v = (long) Math.pow(2, i) - 1;
				mersennePrimes.put(i, v);
				System.out.println(i + " " + v);
			}
		}
		
		//https://stackoverflow.com/a/35558955
/*		Iterator<Map.Entry<Integer, Integer>> it = mersennePrimes.entrySet().iterator();
		while (it.hasNext())
		{
			Map.Entry<Integer, Integer> pair = it.next();
			System.out.println(pair.getKey() + " " +  pair.getValue());
		}*/
	}
	

	//@@@ METHODS @@@
	//### HELPERS ###
	private static boolean isPrime(long number)
	{
		if (number % 2 == 0 && number != 2 || number == 1)
			return false;
		else if (number == 2 || number == 3)
			return true;
		// Since we have removed all even numbers, we can just test odd numbers only.
		else
		{
			for (int i = 3; i < number - 2; i+=2)
				if (number % i == 0)
					return false;
			return true;
		}
	}
	
	private static boolean isMersennePrime(int number)
	{
		long answer = (long)Math.pow(2, number) - 1;
		if (isPrime(number) && isPrime(answer))
			return true;
		else
			return false;
	}
}
