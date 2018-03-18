package chapter06_methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>Palindromic Primes</h1>
 * <p>
 * This program will print the first 100 palindromic primes. A palindromic prime is a prime number that is a palindrone.
 * </p>
 * <p>
 * tags: prime numbers; for loop; for each loop; Scanner; parseInt; nextLine; Exception; try catch; List; ArrayList;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-18
 */
public class Question26
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		int threshold = 100;
		int number = 1;
		int counter = 0;
		boolean done = false;
		
		List<Integer> palindromicPrimes = new ArrayList<>();
		while(!done)
		{
			boolean numberIsPrime = isPrime(number);
			boolean numberIsPalindromicPrime = isPalindromicPrime(number);
			if(numberIsPrime && numberIsPalindromicPrime)
			{
				palindromicPrimes.add(number);
				counter++;
			}
			number++;
			
			if(counter == threshold)
				done = true;
		}
		
		counter = 1;
		for(Integer aNumber :  palindromicPrimes)
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
	
	private static boolean isPalindromicPrime(int number)
	{
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(number);
		StringBuffer stringBufferReversed = new StringBuffer();
		stringBufferReversed.append(number).reverse();
		
		if (stringBuffer.toString().equals(stringBufferReversed.toString()))
			return true;
		else
			return false;
	}
}
