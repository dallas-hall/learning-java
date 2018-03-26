package chapter07_1d_arrays;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>Array Bubble Sorting</h1>
 * <p>
 * This program will sort an array using the bubble sort technique. The bubble sort algorithm makes several passes through the array. On each pass, successive
 neighboring pairs are compared. If a pair is not in order, its values are swapped;
 otherwise, the values remain unchanged.
 * </p>
 * <p>
 * tags:	bubble sorting; array;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-26
 */
public class Question18
{
	//@@@ INSTANCE VARIABLES @@@
	public static final int MIN = 0;
	public static final int MAX = 100;
	private static boolean debugging = true;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) {
		int[] unsortedIntegerArray = new int[10];
		int unsortedIntegerArrayLength = unsortedIntegerArray.length;
		
		for(int i = 0; i < unsortedIntegerArrayLength; i++) {
			unsortedIntegerArray[i] = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
		}
		
		System.out.println(Arrays.toString(unsortedIntegerArray));
		int[] bubbleSortedArray = bubbleSortArray(unsortedIntegerArray);
		System.out.println(Arrays.toString(bubbleSortedArray));
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
	public static int[] bubbleSortArray(int[] inputArray) {
		int passes = inputArray.length / 2;
		int inputArrayLength = inputArray.length;
		int[] bubbleSortedArray = new int[inputArrayLength];
		
		for (int i = 0; i < passes; i++) {
			System.out.println("@@@ PASS " + (i + 1) + " @@@");
			// Make sure we only check the next item
			for (int j = 0; j < inputArrayLength; j++) {
				if (j == inputArrayLength - 1)
					break;
				int value1 = inputArray[j];
				int index1 = j;
				int value2 = inputArray[j + 1];
				int index2 = j + 1;
				if (debugging) {
					System.out.println(index1 + " is " + value1 + " and " + index2 + " is " + value2);
				}
				if (value1 > value2) {
					inputArray[j] = value2;
					inputArray[j + 1] = value1;
					if (debugging) {
						System.out.println(index1 + " is now " + inputArray[j]  + " and " +  index2 + " is now " + inputArray[j + 1]);
					}
				}
			}
			
			// Update after each bubble sort
			bubbleSortedArray = inputArray;
		}
		
		return bubbleSortedArray;
	}

	
}

