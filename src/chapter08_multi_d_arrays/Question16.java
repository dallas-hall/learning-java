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
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		int[][] startArray = new int[3][3];
		for (int i = 0; i < startArray.length; i++) {
			for (int j = 0; j < startArray[i].length; j++) {
				startArray[i][j] = ThreadLocalRandom.current().nextInt(1, 11);
			}
		}
		System.out.println(Arrays.deepToString(startArray));
		sortArray(startArray, true);
		System.out.println(Arrays.deepToString(startArray));
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	
	//### SETTERS ###
	public static int[][] sortArray(int[][] anArray, boolean ascending)
	{
		// Row sorting
		for (int i = 0; i < anArray.length; i++) {
			for (int j = 0; j < anArray[i].length; j++) {
				int currentMin = anArray[i][j];
				int currentMinIndex = j;
				//search the rest of the array and look for a smaller number
				for (int k = j + 1; k < anArray[i].length; k++) {
					// < is ascending, > is descending
					if(ascending) {
						if (anArray[i][k] < currentMin) {
							currentMin = anArray[i][k];
							currentMinIndex = k;
						}
					} else {
						if (anArray[i][k] > currentMin) {
							currentMin = anArray[i][k];
							currentMinIndex = k;
						}
					}
				}
				
				//if one is found and it isn't in the same position, swap
				if (currentMinIndex != j) {
					anArray[i][currentMinIndex] = anArray[i][j];
					anArray[i][j] = currentMin;
				}
			}
		}
		
		// Column sorting
		return anArray;
	}
}
