package chapter10_oop;

// PRNG for >= Java 1.7

import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

/**
 * <h1>Integer Array Sorting</h1>
 * <p>
 * This program will sort an integer array in ascending order and print it. It can either use the Java library and a custom method to do this.
 * </p>
 * <p>
 * tags:	ThreadLocalRandom.next(); System.arraycopy; Arrays.sort;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-04-23
 */

public class IntegerArraySorting
{
	//@@@ INSTANCE VARIABLES @@@
	private int[] intArray;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		IntegerArraySorting run1 = new IntegerArraySorting();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public IntegerArraySorting()
	{
		createArray();
		printArrayNoSorting();
		printAutomagicallySortedArray();
		printManuallySortedArray();
	}
	
	//@@@ METHODS @@@
	//### SETTERS ###
	public void createArray()
	{
		intArray = new int[ThreadLocalRandom.current().nextInt(4, 9)];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = ThreadLocalRandom.current().nextInt(0, 101);
		}
	}
	
	//### HELPERS ###
	public void printArrayNoSorting()
	{
		System.out.println("The unsorted array is...");
		for (int i = 0; i < intArray.length; i++) {
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
		for (int i = 0; i < intArray.length; i++) {
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
		for (int i = 0; i < mySortedIntArray.length; i++) {
			int tmpIndex = i;
			int tmpMinValue = mySortedIntArray[i];
			
			//compare the value in the outter position to all other values later in the array
			for (int j = (i + 1); j < mySortedIntArray.length; j++) {
				// if a value is smaller, store it
				int tmpInt = mySortedIntArray[j];
				if (tmpInt < tmpMinValue) {
					tmpIndex = j;
					tmpMinValue = mySortedIntArray[j];
				}
			}
			// if there was lowe value found, do an update.
			if (tmpIndex != i && tmpMinValue != intArray[i]) {
				mySortedIntArray[tmpIndex] = mySortedIntArray[i];
				mySortedIntArray[i] = tmpMinValue;
			}
		}
		
		// print the sorted array
		System.out.println("The manually sorted array is...");
		for (int i = 0; i < mySortedIntArray.length; i++) {
			System.out.println(mySortedIntArray[i]);
		}
	}
}