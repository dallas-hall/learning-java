package chapter05_loops;

/**
 * <h1>>Pyramid Printing</h1>
 * <p>
 * This program will print a pyramid of numbers. It will start with 1 and use the powers of 2 to increment the numbers being printed.
 * </p>
 * <p>
 * tags: for loop; if else;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-13
 */
public class Exercise_19
{
	public static void main(String[] args)
	{
		System.out.println("Pattern One - Stars Only");
		int rows = 8;
		int spacesToPrint = 14;
		int starsToPrint = 1;
		// Print the rows
		for (int row = 0; row < rows; row++)
		{
			// Print the spaces
			for (int space = 0; space < spacesToPrint; space++)
			{
				System.out.print(" ");
			}
			
			// Print the stars
			for (int star = 0; star < starsToPrint; star++)
			{
				System.out.print("* ");
			}
			
			// Finish the row
			System.out.println();
			
			// Update variables
			spacesToPrint -= 2;
			starsToPrint += 2;
		}
		
		System.out.println("\nPattern Two - Numbers Sequential Only");
		rows = 8;
		spacesToPrint = 14;
		int numbersToPrint = 1;
		int number = 1;
		// Print the rows
		for (int row = 0; row < rows; row++)
		{
			// Print the spaces
			for (int space = 0; space < spacesToPrint; space++)
			{
				// Needs to be 2 for proper alignment
				System.out.print("  ");
			}
			
			// Print the stars
			for (int i = 0; i < numbersToPrint; i++, number++)
			{
				// Print every number with a width of 4 chars
				System.out.format("%4d", number);
			}
			
			// Finish the row
			System.out.println();
			
			// Update variables
			spacesToPrint -= 2;
			numbersToPrint += 2;
		}
		
		System.out.println("\nPattern Three - Numbers Using Powers Of 2");
		rows = 8;
		spacesToPrint = 14;
		numbersToPrint = 1;
		// Print the rows
		for (int row = 0; row < rows; row++)
		{
			// Print the spaces
			for (int space = 0; space < spacesToPrint; space++)
			{
				// Needs to be 2 for proper alignment
				System.out.print("  ");
			}
			
			// Print the stars
			for (int i = 0; i < numbersToPrint; i++)
			{
				int middle = numbersToPrint / 2;
				// Print every number with a width of 4 chars
				if(i < middle)
					System.out.format("%4d", (int)Math.pow(2, i));
				else
					System.out.format("%4d", (int)Math.pow(2, i));
			}
			
			// Finish the row
			System.out.println();
			
			// Update variables
			spacesToPrint -= 2;
			numbersToPrint += 2;
		}
	}
}
