package chapter05_loops;

/**
 * <h1>Miles to Kilometres</h1>
 * <p>
 * This program will convert miles to kilometres.
 * </p>
 * <p>
 * tags: for loop; final; printf;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-01
 */
public class Exercise_04
{
	public static void main(String[] args)
	{
		final double CONVERT_MILES_TO_KM = 1.609;
		
		System.out.printf("%-15s", "Miles");
		System.out.printf("%-15s%n", "Kilometers");
		
		for (int i = 1; i <= 10; i++)
		{
			System.out.printf("%-15d", i);
			System.out.printf("%-12.3f%n", i * CONVERT_MILES_TO_KM);
		}
	}
}
