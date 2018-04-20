package chapter09_objects_and_classes;

import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>2D Array Max Value Location</h1>
 * <p>
 * This program generate a 2D array will with random ints and will return the position of the largest value.
 * </p>
 * <p>
 * tags:	Integer.MIN_VALUE; 2d array; nested for loops;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-04-20
 */
public class Question13
{
	//@@@ INSTANCE VARIABLES @@@
	private int[][] numbers;
	private int row;
	private int column;
	private int maximumValue = Integer.MIN_VALUE;
	
	//@@@ CONSTRUCTOR(S) @@@
	public Question13(int rows, int columns)
	{
		numbers = create2DArray(rows, columns);
	}
	
	public Question13()
	{
		numbers = create2DArray(3, 3);
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public int[][] getNumbers()
	{
		return numbers;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getColumn()
	{
		return column;
	}
	
	public int getMaximumValue()
	{
		return maximumValue;
	}
	
	//### SETTERS ###
	private int[][] create2DArray(int rows, int columns)
	{
		int[][] anArray = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				anArray[i][j] = ThreadLocalRandom.current().nextInt(0, 100);
			}
		}
		return anArray;
	}
	
	public void findMaximumValue(int[][] anArray)
	{
		for (int i = 0; i < anArray.length; i++) {
			for (int j = 0; j < anArray[i].length; j++) {
				if (anArray[i][j] > maximumValue) {
					maximumValue = anArray[i][j];
					row = i;
					column = j;
				}
			}
		}
	}
}
