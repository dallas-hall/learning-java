package chapter08_multi_d_arrays;

/**
 * <h1>2D Array & Random Numbers </h1>
 * <p>
 * This program will create a 3 x 3 2d array and fill it with random numbers between 0 and 99.
 * </p>
 * <p>
 * tags:	int[][]; nested for loops;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-30
 */
public class Array2DRandomNumber
{
	public static void main(String[] args)
	{
		//initialise the 2d array, this one is 3 x 3
		//this means 3 rows and 3 columns per row, with 3 value in each
		int[][] matrix = new int[3][3];
		
		for (int row = 0; row < matrix.length; row++)
		{
			for (int column = 0; column < matrix[row].length; column++)
			{
				matrix[row][column] = (int) (Math.random() * 100);
			}
		}
		
		for (int row = 0; row < matrix.length; row++)
		{
			for (int column = 0; column < matrix[row].length; column++)
			{
				System.out.print(matrix[row][column] + " ");
			}
			System.out.println();
		}
	}
}

