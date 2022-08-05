package Chapter08;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reduce
{
	private static final Logger logger = Logger.getLogger(Reduce.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		Reduce reduce = new Reduce();
		int[] array = new int[ThreadLocalRandom.current().nextInt(2, 11)];
		for (int i = 0; i < array.length; i++) {
			array[i] = ThreadLocalRandom.current().nextInt(0, 51);
		}
		System.out.println(Arrays.toString(array));;

		logger.log(Level.INFO, "Array Reduce - Sum");
		Thread.sleep(005);
		System.out.println("Sum " + reduce.sum(array));

		logger.log(Level.INFO, "Array Reduce - Sum (recursive)");
		Thread.sleep(005);
		System.out.println("Sum " + reduce.sumRecursive(array, 0, array.length - 1));

		logger.log(Level.INFO, "Array Reduce - Min");
		Thread.sleep(005);
		System.out.println("Min " + reduce.min(array));

		logger.log(Level.INFO, "Array Reduce - Min (recursive)");
		Thread.sleep(005);
		System.out.println("Min " + reduce.minRecursive(array, 0, array.length - 1));

		logger.log(Level.INFO, "Array Reduce - Max");
		Thread.sleep(005);
		System.out.println("Max " + reduce.max(array));

		logger.log(Level.INFO, "Array Reduce - Max (recursive)");
		Thread.sleep(005);
		System.out.println("Max " + reduce.maxRecursive(array, 0, array.length - 1));

		logger.log(Level.INFO, "Array Reduce - Count");
		Thread.sleep(005);
		System.out.println("Count " + reduce.count(array));

		logger.log(Level.INFO, "Array Reduce - Count (recursive)");
		Thread.sleep(005);
		System.out.println("Count " + reduce.countRecursive(array, 0, array.length - 1));
	}

	public int sum(int[] a)
	{
		int total = 0;
		for (int i = 0; i < a.length;  i++) {
			total += a[i];
		}
		return total;
	}

	public int min(int[] a) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length;  i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}
		return min;
	}

	public int max(int[] a) {
		int min = Integer.MIN_VALUE;
		for (int i = 0; i < a.length;  i++) {
			if (a[i] > min) {
				min = a[i];
			}
		}
		return min;
	}

	public int count(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length;  i++) {
			count++;
		}
		return count;
	}

	public int sumRecursive(int[] a, int startIndex, int endIndex)
	{
		int sum = 0;
		if (startIndex == endIndex) {
			return a[startIndex];
		}

		int recursionResult = sumRecursive(a, startIndex + 1, endIndex);
		sum += recursionResult;
		sum += a[startIndex];
		return sum;
	}

	public int minRecursive(int[] a, int startIndex, int endIndex)
	{
		int min = Integer.MAX_VALUE;
		if (startIndex == endIndex) {
			return a[startIndex];
		}

		int currentValue = a[startIndex];
		int recursionResult = minRecursive(a, startIndex + 1, endIndex);
		if (recursionResult < currentValue && currentValue < min) {
			min =  recursionResult;
		} else {
			min = currentValue;
		}

		return min;
	}

	public int maxRecursive(int[] a, int startIndex, int endIndex)
	{
		int max = Integer.MIN_VALUE;
		if (startIndex == endIndex) {
			return a[startIndex];
		}

		int currentValue = a[startIndex];
		int recursionResult = maxRecursive(a, startIndex + 1, endIndex);
		if (recursionResult > currentValue && currentValue > max) {
			max =  recursionResult;
		} else {
			max = currentValue;
		}

		return max;
	}

	public int countRecursive(int[] a, int startIndex, int endIndex)
	{
		int total = 0;
		if (startIndex == endIndex) {
			return 1;
		}

		int recursionResult = countRecursive(a, startIndex + 1, endIndex);
		recursionResult++;
		total += recursionResult;
		return total;
	}
}
