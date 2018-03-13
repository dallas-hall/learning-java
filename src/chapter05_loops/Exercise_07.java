package chapter05_loops;

/**
 * <h1>>Tuition Inflation</h1>
 * <p>
 * This program will calculate the inflation of tuition over 10 years..
 * </p>
 * <p>
 * tags: for loop; final;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-01
 */

public class Exercise_07
{
	public static void main(String[] args)
	{
		int tuition = 10000;
		final double INCREASE = 1.05;

		System.out.println("Start is: " + tuition);
		for (int year = 1; year <= 10; year++)
		{
			tuition *= INCREASE;
			System.out.println("In year " + year + " tuition is now: " + tuition);
		}

		System.out.println("4 years of tuition @ 10th year price is: " + tuition * 4);
	}
}