package chapter08_multi_d_arrays;

/**
 * Created by blindcant on 30/04/17.
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

