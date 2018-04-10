package chapter08_multi_d_arrays;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>2D Array Sorting</h1>
 * <p>
 * This program will sort a 2D array based on the rows first, and then the columns. It will sort in ascending or descending order.
 * </p>
 * <p>
 * tags:	int[][]; ThreadLocalRandom.current().nextInt; nested for loops;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-04-09
 */
public class Question16
{
	//@@@ INSTANCE VARIABLES @@@
	private static boolean debugging = true;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
/*		int[][] startArray = new int[3][3];
		for (int i = 0; i < startArray.length; i++) {
			for (int j = 0; j < startArray[i].length; j++) {
				startArray[i][j] = ThreadLocalRandom.current().nextInt(1, 11);
			}
		}*/
		int[][] startArray = {{4, 2, 2}, {3, 2, 1}, {1, 2, 2}, {6, 1, 1}};
		sortArray(startArray, true);
		System.out.println(Arrays.deepToString(startArray));
	}
	
	//@@@ METHODS @@@
	//### SETTERS ###
	public static void sortArray(int[][] anArray, boolean ascending)
	{
		System.out.println("Before column sorting:\n" + Arrays.deepToString(anArray));
		// Row check
		for (int i = 0; i < anArray.length; i++) {
			// Column check
			for (int j = 0; j < anArray[i].length; j++) {
				int currentMin = anArray[i][j];
				int currentMinIndex = j;
				// Search all the arrays and swap accordingly (descending or ascending order)
				for (int k = j + 1; k < anArray[i].length; k++) {
					// < is ascending, > is descending
					if (ascending) {
						if (anArray[i][k] < currentMin) {
							currentMin = anArray[i][k];
							currentMinIndex = k;
						}
					}
					else {
						if (anArray[i][k] > currentMin) {
							currentMin = anArray[i][k];
							currentMinIndex = k;
						}
					}
				}
				// If one is found and it isn't in the same position, swap
				if (currentMinIndex != j) {
					anArray[i][currentMinIndex] = anArray[i][j];
					anArray[i][j] = currentMin;
				}
			}
		}
		System.out.println("Before array sorting:\n" + Arrays.deepToString(anArray));
		// Row check
		for (int i = 0; i < anArray.length; i++) {
			int indexToCheck = 0;
			// Column check
			for (int j = 0; j < anArray[i].length; j++) {
				// Search all the arrays and swap accordingly (descending or ascending order)
				int[] tempArray;
				if(anArray[j][indexToCheck] > anArray[j + 1][indexToCheck]) {
					tempArray = Arrays.copyOf(anArray[j], anArray[j].length);
					anArray[j] = Arrays.copyOf(anArray[j + 1], anArray[j + 1].length);;
					anArray[j + 1] = Arrays.copyOf(tempArray, tempArray.length);;
				}
			}
		}
		System.out.println("After array sorting:\n" + Arrays.deepToString(anArray));
	}
}
