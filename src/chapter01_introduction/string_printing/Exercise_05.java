package chapter01_introduction.string_printing;

/**
 * <h1>Print Messages</h1>
 * <p>
 * This program will do some random mathematical computation, showing BODMAS.
 * </p>
 * <p>
 * tags:	String printing;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2-3-17
 */

public class Exercise_05
{
	public static void main(String[] args)
	{
		// create variables
		double expression1 = (9.5 * 4.5 - 2.5 * 3);
		double expression2 = (45.5 - 3.5);
		double answer = (expression1 / expression2);
		
		//display the answer
		System.out.println("The answer of ((9.5 * 4.5) - (2.5 * 3))" + " / (45.5 - 3.5) is:");
		System.out.println(answer);
	}
	
}
