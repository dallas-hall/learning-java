package chapter08;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by blindcant on 30/04/17.
 */
public class Array2DUserInput
{

		public static void main(String[] args)
		{
			//initialise the 2d array, this one is 3 x 3
			//this means 3 rows, 3 columns, with 3 values in each
			int[][] matrix = new int[3][3];
			
			//get user input for the values of the 3 x 3 matrix, this one is numbers on the same line separate by space
			Scanner input = new Scanner(System.in);
			System.out.println("Enter " + matrix.length + " rows and " + matrix[0].length + " columns: ");
			
			//populate the 2d array based on the user input
			for (int row = 0; row < matrix.length; row++)
			{
				for (int column = 0; column < matrix[row].length; column++)
				{
					matrix[row][column] = input.nextInt();
				}
			}
			
			for (int row = 0; row < matrix.length; row++) {
				for (int column = 0; column < matrix[row].length; column++) {
					System.out.print(matrix[row][column] + " ");
				}
				System.out.println();
			}
		}
	}
