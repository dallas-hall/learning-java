package chapter05_loops;

/**
 * <h1>Kilogram to Pounds</h1>
 * <p>
 * This program will convert kilograms to pounds. But it will print a formatted table starting from 2.2 pounds and finishing at 437.8 pounds.
 * </p>
 * <p>
 * tags: for loop; nested for loop; final; printf;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-01
 */

public class Exercise_05
{
	public static void main(String[] args)
	{
		
		final double CONVERSION_RATE = 2.2;
		int pounds = 20;
		
		// TODO Auto-generated method stub
		
		System.out.printf("%-10s", "Kilograms");
		System.out.printf("%-10s\t|\t", "Pounds");
		System.out.printf("%-10s", "Pounds");
		System.out.printf("%-10s%n", "Kilograms");
		for (int i = 1; i < 200; i += 2)
		{
			System.out.printf("%-10d", i);
			System.out.printf("%-9.1f\t|\t", i * CONVERSION_RATE);
			for (int j = 1; j < 2; j++)
			{
				System.out.printf("%-10d", pounds);
				System.out.printf("%-9.1f%n", pounds / CONVERSION_RATE);
			}
			pounds += 5;
		}
	}
}
