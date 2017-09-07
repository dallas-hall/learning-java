package chapter08;

/**
 * Created by blindcant on 30/04/17.
 *
 * That left to right trick is good, I understand 3D arrays now based on that
 * So for example, int[][][] x = new int[3][3][6]; has 3 rows, 3 columns, with 6 elements in the cell
 * And understanding that multi-dimensional arrays are just an array of arrays really helps as well
 */
public class Array3D
{
	//INSTANCE VARIABLES
	int[][][] x = new int[3][3][6];
	
	//MAIN METHOD
	public static void main(String[] args)
	{
		Array3D array1 = new Array3D();
	}
	
	//CONSTRUCTOR(S)
	public Array3D()
	{
		print3DArrayLength();
		print3DArray();
	}
	
	//METHODS
	public void print3DArrayLength()
	{
		System.out.println("x's length is: " + x.length);
		System.out.println("x[i]'s length is: " + x[0].length);
		System.out.println("x[i][j]'s length is: " + x[0][0].length);
	}
	
	public void print3DArray()
	{
	/*
	That left to right trick is good, I understand 3D arrays now based on that
	So for example, int[][][] x = new array[2][2][2]; has 2 rows, 2 columns, with 2 elements in the cell
	And understanding that multi-dimensional arrays are just an array of arrays really helps as well
	*/
		
		int[][][] array = {{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}};
		
		System.out.println();
		System.out.println("This 3d array is 2 x 2 x 2.  That is 2 rows, by 2 columns, with 2 values in each cell.");
		System.out.println("array's length is: " + array.length);
		System.out.println("array[i]'s length is: " + array[0].length);
		System.out.println("array[i][j]'s length is: " + array[0][0].length);
		System.out.println();
		
		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				System.out.print("{ ");
				for (int k = 0; k < 2; k++)
				{
					System.out.print("element " + String.valueOf(i) + String.valueOf(j) + String.valueOf(k) + " is " + array[i][j][k] + " ");
				}
				//show where the 2d array stops, and array within the cell starts
				System.out.print("} ");
			}
			//create the row effect
			System.out.println();
		}
	}
}
