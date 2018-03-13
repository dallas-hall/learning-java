package chapter05_loops;

/**
 * <h1>Kilogram to Pounds</h1>
 * <p>
 * This program will convert kilograms to pounds.
 * </p>
 * <p>
 * tags: for loop; final; printf;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-01
 */

public class Exercise_03
{
	public static void main(String[] args)
	{
		final double CONVERT_KG_TO_POUND = 2.2;
		
		System.out.printf("%-15s", "Kilograms");
		System.out.printf("%-15s%n", "Pounds");
		for (int i = 1; i < 200; i++)
		{
			System.out.printf("%-15d", i);
			System.out.printf("%-13.1f%n", i * CONVERT_KG_TO_POUND);
		}
	}
}
