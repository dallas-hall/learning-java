package chapter08_multi_d_arrays;

/**
 * <h1>2D Array Length</h1>
 * <p>
 * This program will manually and automatically show the lengths of a 2d array.
 * </p>
 * <p>
 * tags:	char[][]; nested for loops;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-30
 */

public class Array2DLengthExample
{
	public static void main(String[] args)
	{
		// this array has 8 rows holding 10 columns
		// AKA we have a list of 8, with 10 items in the list
		// so to create this array manually it would be char[][] answers = new char[8][10]
		// because we have 8 1D arrays holding 10 elements
		char[][] answers = {
				{'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
				{'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
				{'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
				{'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
				{'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
				{'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
				{'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
				{'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}
		};
		
		// we can see the 8x10 structure here (MANUAL)
		System.out.println(answers.length);
		System.out.println(answers[0].length);
		System.out.println(answers[1].length);
		System.out.println(answers[2].length);
		System.out.println(answers[3].length);
		System.out.println(answers[4].length);
		System.out.println(answers[5].length);
		System.out.println(answers[6].length);
		System.out.println(answers[7].length);
		
		// we can see the 8x10 structure here (FOR LOOP)
		// show the count of rows.
		System.out.println();
		System.out.println(answers.length);
		// show the count of columns per row, start at row 0 and finish at length - 1
		for (int row = 0; row < answers.length; row++)
		{
			System.out.println(answers[row].length);
		}
		
		// to print all elements (NESTED FOR LOOP)
		System.out.println();
		// while row is less than the row length (answer.length = 8, we have 8 rows), go through the rows
		for (int row = 0; row < answers.length; row++)
		{
			// while columns is less than the count of columns in the current row (answer[row].length = 10), go through the columns in that row
			for (int columns = 0; columns < answers[row].length; columns++)
			{
				// print the combination of @ [row][column]
				System.out.print(answers[row][columns] + " ");
			}
			//create our row effect once we have gone through all the columns
			System.out.println();
		}
	}
}
