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


		int number = 8;
		int[] numbers = {2, 4, 8, 1};
		System.out.println("Are "+ Arrays.toString(numbers) + " factors of " + number + "?");
		System.out.println(runtime.areFactors(number, numbers));

		int[] numbers2 = {2, 4, 8, 1, 9};
		System.out.println("Are "+ Arrays.toString(numbers2) + " factors of " + number + "?");
		System.out.println(runtime.areFactors(number, numbers2));
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
		return false;
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
