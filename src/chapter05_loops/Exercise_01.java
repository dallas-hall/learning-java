package chapter05_loops;

/**
 * <h1>Integer Counting</h1>
 * <p>
 * This program will accept integers and at the end it will count how many were positive and how many were negative.
 * </p>
 * <p>
 * tags: Scanner; do while; nextInt; if else;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-01
 */

import java.util.Scanner;

public class Exercise_01
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		int input = 0;
		int positiveCount = 0;
		int negativeCount = 0;
		int total = 0;
		double average = 0.0;
		
		do
		{
			System.out.print("Enter an integer, input will stop when 0 is entered. ");
			input = keyboard.nextInt();
			total += input;
			if (input < 0)
			{
				negativeCount++;
			}
			else if (input > 0)
			{
				positiveCount++;
			}
		}
		while (input != 0);
		if (total != 0)
		{
			System.out.println("Positives total : " + positiveCount);
			System.out.println("Negatives total : " + negativeCount);
			System.out.println("The total was: " + total);
			average = (double) total / (negativeCount + positiveCount);
			System.out.println("The average was: " + average);
		}
		else
		{
			System.out.println("Nothing was entered");
		}
	}
}
