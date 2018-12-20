package Chapter08;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SortingArrays
{
	private static final Logger logger = Logger.getLogger(SortingArrays.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Sorting arrays.");
		Thread.sleep(005);
		SortingArrays runtime = new SortingArrays();
		int[] array = runtime.createIntArray();
		System.out.printf("%-16s\t%s\n", "Original", Arrays.toString(array));
		System.out.printf("%-16s\t%s\n", "Sorted ascending", Arrays.toString(runtime.sortIntArray(array, true)));
		System.out.printf("%-16s\t%s\n", "Sorted descending", Arrays.toString(runtime.sortIntArray(array, false)));
	}

	public int[] createIntArray()
	{
		int[] a =  new int[10];
		// prn with a seed
		Random prn = new Random(512);
		for (int i = 0; i < a.length; i++)
		{
			a[i] = prn.nextInt(100);
		}
		return a;
	}

	/**
	 * Sorts an array in ascending or descending order.
	 *
	 * @param a - the input array to be sorted.
	 * @param ascendFlag - true will sort ascending and false will sort descending.
	 * @return - the sorted array.
	 */
	public int[] sortIntArray(int[] a, boolean ascendFlag)
	{
		if (a.length == 0) {
			return a;
		}
		int index;
		int value;
		for (int i = 0; i < a.length; i++) {
			index = i;
			value = a[i];
			for (int j = i + 1; j < a.length; j++) {
				if (ascendFlag) {
					if (a[j] < value) {
						index = j;
						value = a[j];
					}
				} else {
					if (a[j] > value) {
						index = j;
						value = a[j];
					}
				}
			}
			if (value != a[i]) {
				a[index] = a[i];
				a[i] = value;
			}
		}
		return a;
	}
}
