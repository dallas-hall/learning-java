package chapter10_oop;

// PRNG for >= Java 1.7
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

/**
 * Write a description of class IntegerArraySorting here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IntegerArraySorting
{
	// instance variables - replace the example below with your own
	private int[] intArray =
			{
					ThreadLocalRandom.current().nextInt(1, 101)
					,ThreadLocalRandom.current().nextInt(1, 101)
					,ThreadLocalRandom.current().nextInt(1, 101)
					,ThreadLocalRandom.current().nextInt(1, 101)
					,ThreadLocalRandom.current().nextInt(1, 101)
			};
	
	public static void main(String[] args)
	{
		IntegerArraySorting run1 = new IntegerArraySorting();
	}
	
	/**
	 * Constructor for objects of class IntegerArraySorting
	 */
	public IntegerArraySorting()
	{
		printArrayNoSorting();
		printAutomagicallySortedArray();
		printManuallySortedArray();
	}
	
	public void printArrayNoSorting()
	{
		System.out.println("The unsorted array is...");
		for (int i = 0; i < intArray.length; i++)
		{
			System.out.println(intArray[i]);
		}
		System.out.println();
	}
	
	public void printAutomagicallySortedArray()
	{
		System.out.println("The automagically sorted array is...");
		
		//create a new array
		int[] sortedIntArray = new int[intArray.length];
		
		//copy the unsorted array into the new array
		System.arraycopy(intArray, 0, sortedIntArray, 0, intArray.length);
		
		//sort the array automagically
		Arrays.sort(sortedIntArray);
		
		//print the sorted array
		for (int i = 0; i < intArray.length; i++)
		{
			System.out.println(sortedIntArray[i]);
		}
		System.out.println();
	}
	
	public void printManuallySortedArray()
	{
		// create a new array
		int[] mySortedIntArray = new int[intArray.length];
		
		//copy the unsorted array into the new array
		System.arraycopy(intArray, 0, mySortedIntArray, 0, intArray.length);
		
		//loop through the unsorted array
		for (int i = 0; i < mySortedIntArray.length; i++)
		{
			int tmpIndex = i;
			int tmpMinValue = mySortedIntArray[i];
			
			//compare the value in the outter position to all other values later in the array
			for (int j = (i + 1); j < mySortedIntArray.length; j++)
			{
				// if a value is smaller, store it
				int tmpInt = mySortedIntArray[j];
				if (tmpInt < tmpMinValue)
				{
					tmpIndex = j;
					tmpMinValue = mySortedIntArray[j];
				}
			}
			// if there was lowe value found, do an update.
			if (tmpIndex != i && tmpMinValue != intArray[i])
			{
				mySortedIntArray[tmpIndex] = mySortedIntArray[i];
				mySortedIntArray[i] = tmpMinValue;
			}
		}
		
		// print the sorted array
		System.out.println("The manually sorted array is...");
		for (int i = 0; i < mySortedIntArray.length; i++)
		{
			System.out.println(mySortedIntArray[i]);
		}
	}
}