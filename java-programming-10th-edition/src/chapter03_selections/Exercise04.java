/**
 *
 */
package chapter03_selections;

/**
 * <h1>Month Generator/h1>
 * <p>
 * This program will generate a random number that represents a month. It gives a demonstration of switch / case statements.
 * </p>
 * <p>
 * tags:	String printing; math; Math.random; switch; case;
 * </p>
 *
 * @author dhall
 * @version 0.1 - 2017-03-13
 */
public class Exercise04
{
	public static void main(String[] args)
	{
		//create a random number between 12 and 0
		/*
		 * Use Math.random() to generate a random double
		 * Cast this to an int
		 * Multiply this by (max number - min number) + min number) to get a
		 * random number in the range
		 */
		int randomMonth = (int) (Math.random() * (13 - 1) + 1);
		System.out.println("Random number between 1 and 12 is: " + randomMonth);

		switch (randomMonth)
		{
			case 1:
				System.out.println("January");
				break;

			case 2:
				System.out.println("February");
				break;

			case 3:
				System.out.println("March");
				break;

			case 4:
				System.out.println("April");
				break;

			case 5:
				System.out.println("May");
				break;

			case 6:
				System.out.println("June");
				break;

			case 7:
				System.out.println("July");
				break;

			case 8:
				System.out.println("August");
				break;

			case 9:
				System.out.println("September");
				break;

			case 10:
				System.out.println("October");
				break;

			case 11:
				System.out.println("November");
				break;

			case 12:
				System.out.println("December");
				break;

			default:
				System.out.println("Error: invalid number");
				System.exit(1);
		}
	}
}
