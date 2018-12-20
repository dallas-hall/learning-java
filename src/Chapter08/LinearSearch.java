package Chapter08;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LinearSearch
{
	private static final Logger logger = Logger.getLogger(LinearSearch.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Linear search on arrays.");
		Thread.sleep(005);
		LinearSearch runtime = new LinearSearch();

		int[] a = runtime.createArray(1000, 1000);
		System.out.println(Arrays.toString(a));

		Random prn = new Random();
		int searchValue = prn.nextInt(1000);

		System.out.printf("%s %s\n", "linearSearchBoolean searched for " + searchValue + " and returned", runtime.linearSearchBoolean(a, searchValue));
		System.out.printf("%s %s\n", "linearSearchIndex searched for " + searchValue + " and returned", runtime.linearSearchIndex(a, searchValue));
		System.out.printf("%s %s\n", "linearSearchValue searched for " + searchValue + " and returned", runtime.linearSearchValue(a, searchValue));
	}

	public int[] createArray(int size, int prnLimit)
	{
		Random prn = new Random();
		int[] a = new int[size];

		for (int i = 0; i < size; i++) {
			a[i] = prn.nextInt(prnLimit);
		}
		return a;
	}

	public boolean linearSearchBoolean(int[] inputArray, int searchValue)
	{
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == searchValue) {
				return true;
			}
		}
		return false;
	}

	public int linearSearchIndex(int[] inputArray, int searchValue)
	{
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == searchValue) {
				return i;
			}
		}
		return -1;
	}

	public Integer linearSearchValue(int[] inputArray, int searchValue)
	{
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == searchValue) {
				return inputArray[i];
			}
		}
		return null;
	}
}
