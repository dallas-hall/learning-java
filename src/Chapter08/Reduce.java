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
		int[] array = new int[ThreadLocalRandom.current().nextInt(1, 11)];
		for (int i = 0; i < array.length; i++) {
			array[i] = ThreadLocalRandom.current().nextInt(0, 51);
		}
		System.out.println(Arrays.toString(array));;

		logger.log(Level.INFO, "Array Reduce - Sum");
		Thread.sleep(005);
		System.out.println("Sum " + reduce.sum(array));

		logger.log(Level.INFO, "Array Reduce - Min");
		Thread.sleep(005);
		System.out.println("Min " + reduce.min(array));

		logger.log(Level.INFO, "Array Reduce - Max");
		Thread.sleep(005);
		System.out.println("Max " + reduce.max(array));

		logger.log(Level.INFO, "Array Reduce - Count");
		Thread.sleep(005);
		System.out.println("Count " + reduce.count(array));
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
}
