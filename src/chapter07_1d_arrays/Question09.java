package chapter07_1d_arrays;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>Find Smallest Array Element Index</h1>
 * <p>
 * This program will search an int and double array and return the smallest index found.
 * </p>
 * <p>
 * tags:	Map; HashMap; smallest array element searching; ThreadLocalRandom;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-19
 */
public class Question09
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		double[] doubleArray = new double[10];
		int[] intArray = new int[10];
		
		for(int i = 0; i < 10; i++)
		{
			// Add a random double between 0-100 inclusive
			doubleArray[i] = ThreadLocalRandom.current().nextDouble(0, 101);
			
			// Add a random int between 0-100 inclusive
			intArray[i] = ThreadLocalRandom.current().nextInt(0, 101);
		}
		
		System.out.println("Starting array: " + Arrays.toString(doubleArray));
		System.out.println("Smallest index & value: " + findSmallestValueAndIndex(doubleArray).entrySet());
		System.out.println();
		System.out.println("Starting array: " + Arrays.toString(intArray));
		System.out.println("Smallest index & value: " + findSmallestValueAndIndex(intArray).entrySet());
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
	private static Map<Integer, Double> findSmallestValueAndIndex(double[] doubleArray)
	{
		// key = index and value = index value
		Map<Integer, Double> result = new HashMap<>();
		int doubleArrayLength = doubleArray.length;
		int smallestKey = 0;
		for(int i = 0; i < doubleArrayLength; i++)
		{
			int index = i;
			double value = doubleArray[i];
			if(i == 0)
			{
				result.put(index, value);
				smallestKey = i;
			}
			else
			{
				if(value < result.get(smallestKey))
				{
					result.remove(smallestKey);
					smallestKey = i;
					result.put(index, value);
				}
			}
		}
		return result;
	}
	
	private static Map<Integer, Integer> findSmallestValueAndIndex(int[] intArray)
	{
		Map<Integer, Integer> result = new HashMap<>();
		int intArrayLength = intArray.length;
		int smallestKey = 0;
		for(int i = 0; i < intArrayLength; i++)
		{
			int index = i;
			int value = intArray[i];
			if(i == 0)
			{
				result.put(index, value);
				smallestKey = i;
			}
			else
			{
				if(value < result.get(smallestKey))
				{
					result.remove(smallestKey);
					smallestKey = i;
					result.put(index, value);
				}
			}
		}
		return result;
	}
}
