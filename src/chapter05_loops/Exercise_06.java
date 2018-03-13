package chapter05_loops;

/**
 * <h1>>Miles to Kilometres</h1>
 * <p>
 * This program will convert miles to kilometres. But it will print a formatted table starting from 1.609km and finishing at 16.090km.
 * </p>
 * <p>
 * tags: for loop; nested for loop; final; printf;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-01
 */

public class Exercise_06
{
	public static void main(String[] args)
	{

		final double CONVERSION_RATE = 1.609;
		int kilometers = 20;

		// TODO Auto-generated method stub

		System.out.printf("%-15s", "Miles");
		System.out.printf("%-15s\t|\t", "Kilometers");
		System.out.printf("%-15s", "Kilometers");
		System.out.printf("%-15s%n", "Miles");
		for (int i = 1; i <= 10; i++)
		{
			System.out.printf("%-15d", i);
			System.out.printf("%-12.3f\t|\t", i * CONVERSION_RATE);
			for (int j = 1; j < 2; j++)
			{
				System.out.printf("%-15d", kilometers);
				System.out.printf("%-12.3f%n", kilometers / CONVERSION_RATE);
			}
			kilometers += 5;
		}
	}
}
