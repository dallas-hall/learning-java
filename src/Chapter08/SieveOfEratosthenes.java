package Chapter08;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SieveOfEratosthenes
{
	private static final Logger logger = Logger.getLogger(SieveOfEratosthenes.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Sieve of Eratosthenes - Prime Number Finding");
		Thread.sleep(005);

		SieveOfEratosthenes runtime =  new SieveOfEratosthenes();
		boolean[] results = runtime.sieve(121);

		System.out.println("Primes after Sieve of Eratosthenes are:");
		int prints = 0;
		for (int i = 0; i < results.length; i++) {
			if	(!results[i]) {
				System.out.printf("%3d\t", i + 2);
				prints++;
				if (prints % 10 == 0) {
					System.out.println();
				}
			}
		}
	}

	/*
	https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes

	1) Create a list from 2 to n
	2) Start with p being 2
	3) Go through the list and find all multiples of p that aren't p, mark those numbers
	4) Increment p and repeat step 3 from p to n

	The numbers not marked are prime.
	 */
	public boolean[] sieve(int n)
	{
		boolean[] marked = new boolean[n];

		int[] numbers = new int[n];
		for(int i = 0; i < n; i++) {
			// Start at 2, as prime numbers must be >= 2
			numbers[i] = i + 2;
		}

		System.out.println(Arrays.toString(numbers));
		System.out.println("marked " + Arrays.toString(marked));
		System.out.println();

		for (int p = 2; p < numbers[numbers.length - 1]; p++) {
			for (int i = 0; i < n; i++) {
				if (numbers[i] % p == 0 && numbers[i] != p) {
					marked[i] = true;
				}
			}
		}

		System.out.println(Arrays.toString(numbers));
		System.out.println("marked " + Arrays.toString(marked));
		System.out.println();

		return marked;
	}
}
