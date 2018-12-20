package Chapter08;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinarySearch
{
	private static final Logger logger = Logger.getLogger(BinarySearch.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Linear search on arrays.");
		Thread.sleep(005);
		BinarySearch runtime = new BinarySearch();

		int[] a = runtime.createArray(100, 1000);
		//int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(Arrays.toString(a));

		int searchValue = ThreadLocalRandom.current().nextInt(1, 1000);
		//int searchValue = 10;

		// Binary searching needs a sorted array
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		System.out.printf("%s %s\n", "iterativeBinarySearchBoolean searched for " + searchValue + " and returned", runtime.iterativeBinarySearchBoolean(a, searchValue));
		System.out.printf("%s %s\n", "iterativeBinarySearchIndex searched for " + searchValue + " and returned", runtime.iterativeBinarySearchIndex(a, searchValue));
		System.out.printf("%s %s\n", "iterativeBinarySearchValue searched for " + searchValue + " and returned", runtime.iterativeBinarySearchValue(a, searchValue));
	}

	public int[] createArray(int size, int prnLimit)
	{
		int[] a = new int[size];

		for (int i = 0; i < size; i++) {
			a[i] = ThreadLocalRandom.current().nextInt(0, prnLimit);
		}
		return a;
	}


	/*
	1) sort array
	2) set initial min and max indices values
		a) min = 0
		b) max = array length
	3) set search index, in the middle of min and max
		a) (min + max + 1) / 2
	4) check search index value and increment attempt number
		a) if current value = search value, return found
		b) if current value > search value, min index is current index
		c) if current value < search value, max index is current index
		d) if current search index = previous search index, return not found
	5)  repeat steps 3 onwards
	 */
	public boolean iterativeBinarySearchBoolean(int[] inputArray, int searchValue)
	{
		int minIndex = 0;
		int maxIndex = inputArray.length - 1;
		int attempts = 0;
		int currentIndex = currentIndex = maxIndex / 2;
		// Set to an out of bounds number so we don't stop on the first run
		int previousIndex = -1;

		int currentValue = 0;

		while (true) {
			attempts++;
			currentValue = inputArray[currentIndex];

			if (searchValue == currentValue) {
				System.out.println("Attempt " + attempts);
				return true;
			}
			else if (currentIndex == previousIndex) {
				System.out.println("Attempt " + attempts);
				return false;
			}
			else if (searchValue < currentValue) {
				maxIndex = currentIndex;
				previousIndex = currentIndex;
				currentIndex = (maxIndex + minIndex + 1) / 2;
			}
			else if (searchValue > currentValue) {
				minIndex = currentIndex;
				previousIndex = currentIndex;
				currentIndex = (maxIndex + minIndex + 1) / 2;
			}
		}
	}

	public int iterativeBinarySearchIndex(int[] inputArray, int searchValue)
	{
		int minIndex = 0;
		int maxIndex = inputArray.length - 1;
		int attempts = 0;
		int currentIndex = currentIndex = maxIndex / 2;
		// Set to an out of bounds number so we don't stop on the first run
		int previousIndex = -1;

		int currentValue = 0;

		while (true) {
			attempts++;
			currentValue = inputArray[currentIndex];

			if (searchValue == currentValue) {
				System.out.println("Attempt " + attempts);
				return currentIndex;
			}
			else if (currentIndex == previousIndex) {
				System.out.println("Attempt " + attempts);
				return -1;
			}
			else if (searchValue < currentValue) {
				maxIndex = currentIndex;
				previousIndex = currentIndex;
				currentIndex = (maxIndex + minIndex + 1) / 2;
			}
			else if (searchValue > currentValue) {
				minIndex = currentIndex;
				previousIndex = currentIndex;
				currentIndex = (maxIndex + minIndex + 1) / 2;
			}
		}
	}

	public int iterativeBinarySearchValue(int[] inputArray, int searchValue)
	{
		int minIndex = 0;
		int maxIndex = inputArray.length - 1;
		int attempts = 0;
		int currentIndex = currentIndex = maxIndex / 2;
		// Set to an out of bounds number so we don't stop on the first run
		int previousIndex = -1;

		int currentValue = 0;

		while (true) {
			attempts++;
			currentValue = inputArray[currentIndex];

			if (searchValue == currentValue) {
				System.out.println("Attempt " + attempts);
				return currentValue;
			}
			else if (currentIndex == previousIndex) {
				System.out.println("Attempt " + attempts);
				return -1;
			}
			else if (searchValue < currentValue) {
				maxIndex = currentIndex;
				previousIndex = currentIndex;
				currentIndex = (maxIndex + minIndex + 1) / 2;
			}
			else if (searchValue > currentValue) {
				minIndex = currentIndex;
				previousIndex = currentIndex;
				currentIndex = (maxIndex + minIndex + 1) / 2;
			}
		}
	}
}
