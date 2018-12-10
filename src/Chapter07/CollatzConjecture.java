package Chapter07;

public class CollatzConjecture
{
	public static void main(String[] args)
	{
		CollatzConjecture runtime = new CollatzConjecture();
		runtime.printCollatzConjecture(3);
	}

	/**
	 * This method performs the Collatz Conjecture - https://en.wikipedia.org/wiki/Collatz_conjecture
	 *
	 * @param n - the number to start the Collatz Conjecture with, must be a positive integer.
	 */
	public void printCollatzConjecture(int n)
	{
		if (n <= 0) {
			System.out.println("Starting number must be positive.");
			return;
		}
		while (n != 1) {
			System.out.println(n);
			// If even, divide by 2
			if (n % 2 == 0) {
				n = n / 2;
			}
			// If odd, multiply by 3 and add 1
			else {
				n = n * 3 + 1;
			}
		}
	}
}
