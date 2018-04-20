package chapter09_objects_and_classes;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>Q6 Test</h1>
 * <p>
 * This program will time the sorting of 100,000 doubles in an array.
 * </p>
 * <p>
 * tags:	Arrays.sort; Arrays.toString; ThreadLocalRandom.current;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-04-20
 */
public class TestQ6
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		// Use _ for number readability
		double[] numbers = new double[100_000];
		Question06 runtime = new Question06();
		runtime.start();
		System.out.println("Generating 100,000 random doubles between 0 and 99.");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = ThreadLocalRandom.current().nextDouble(0, 100);
		}
/*		System.out.println("Printing 100,000 random doubles.");
		System.out.println(Arrays.toString(numbers));*/
		System.out.println("Sorting 100,000 random doubles.");
		Arrays.sort(numbers);
		runtime.stop();
		System.out.println("The total elapsed time was " + runtime.getElapsedTime() + "ms");
	}
}
