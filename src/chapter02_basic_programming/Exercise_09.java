package chapter02_basic_programming;

import java.util.Scanner;

/**
 * <h1>Physics: Calculate Acceleration</h1>
 * <p>
 * This program will calculate average acceleration. This is done by using velocity2 minus velocity 1 divided by time (v2 - v1) / t. Velocity is meters per second.
 * </p>
 * <p>
 * tags:	String printing; math; Scanner; nextDouble;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-10
 */
public class Exercise_09
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		boolean errorFound = false;
		double velocity1 = 0.0;
		double velocity2 = 0.0;
		;
		double time = 0.0;
		;
		
		// Get the user input for each 3 items.
		do
		{
			// Reset after each run
			errorFound = false;
			try
			{
				System.out.println("Enter velocity 1.");
				velocity1 = keyboard.nextDouble();
				// Check for valid numbers.
				if (velocity1 <= 0)
				{
					throw new Exception();
				}
				// Catch input exceptions
			}
			catch (Exception e)
			{
				errorFound = true;
				System.out.println("Please enter a positive decimal number only.");
				// Need this here for the scanner 'bug' of not consuming the newline character
			}
			finally
			{
				keyboard.nextLine();
			}
		}
		while (errorFound);
		
		do
		{
			errorFound = false;
			try
			{
				System.out.println("Enter velocity 2.");
				velocity2 = keyboard.nextDouble();
				if (velocity2 <= 0)
				{
					throw new Exception();
				}
			}
			catch (Exception e)
			{
				errorFound = true;
				System.out.println("Please enter a positive decimal number only.");
			}
			finally
			{
				keyboard.nextLine();
			}
		}
		while (errorFound);
		
		do
		{
			errorFound = false;
			try
			{
				System.out.println("Enter time.");
				time = keyboard.nextDouble();
				if (time <= 0)
				{
					throw new Exception();
				}
			}
			catch (Exception e)
			{
				errorFound = true;
				System.out.println("Please enter a positive decimal number only.");
			}
			finally
			{
				keyboard.nextLine();
			}
		}
		while (errorFound);
		
		// Calculate and display
		double answer = (velocity2 - velocity1) / time;
		System.out.println("The average acceleration is " + answer);
	}
}
