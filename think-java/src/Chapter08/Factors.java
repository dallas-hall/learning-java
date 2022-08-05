package Chapter08;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Factors
{
	private static final Logger logger = Logger.getLogger(Factors.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Factor Finding");
		Thread.sleep(005);
		Factors runtime = new Factors();
		runtime.printPrimes(121);

		int[][] factors = {
				{2, 4, 8, 1},
				{2, 4, 8, 1, 9},
				{1, 3},
				{3}
		};
		int checkNumber = 8;

		for (int i = 0; i < factors.length; i++) {
			if (i != 0 && i != 1) {
				checkNumber = 3;
			}
			System.out.println("Are "+ Arrays.toString(factors[i]) + " factors of " + checkNumber + "?");
			System.out.println(runtime.areFactors(checkNumber, factors[i]));
			System.out.println("Are "+ Arrays.toString(factors[i]) + " factors of " + checkNumber + " and prime only?");
			System.out.println(runtime.arePrimerFactors(checkNumber, factors[i]));
		}
	}

	public boolean areFactors(int n, int[] numbers)
	{
		for(int i = 0; i < numbers.length; i++) {
			if (n % numbers[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public boolean arePrimerFactors(int n, int[] numbers)
	{
		boolean areFactors = areFactors(n, numbers);
		if (!areFactors) {
			return false;
		}
		else {
			for (int i = 0; i < numbers.length; i++) {
				if(!isPrime(numbers[i])) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isPrime(int n)
	{
		if (n <= 1) {
			return false;
		}
		else if (n == 2) {
			return true;
		}
		else if (n % 2 == 0 && n != 2) {
			return false;
		}
		else {
			for (int i = 3; i < n - 1; i+= 2) {
				if (n % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

	public void printPrimes(int threshold)
	{
		int prints = 0;
		System.out.println("Prime numbers up to "+ threshold);
		for (int i = 0; i <= threshold; i++) {
			boolean isPrime = isPrime(i);
			if (isPrime) {
				System.out.printf("%3d\t", i);
				prints++;
				if (prints % 10 == 0) {
					System.out.println();
				}
			}
		}
	}
}
