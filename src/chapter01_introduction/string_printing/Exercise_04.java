package chapter01_introduction.string_printing;

/**
 * <h1>Print Messages</h1>
 * <p>
 * This program will print a table, 3 columns, 5 rows
 * </p>
 * <p>
 * tags:	String printing; exponents;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2-3-17
 */

public class Exercise_04
{
	public static void main(String[] args)
	{
		// HARD CODED
		System.out.println("HARD CODED");
		System.out.println("a\t\ta^2\t\ta^3");
		System.out.println("1\t\t1\t\t1");
		System.out.println("2\t\t4\t\t8");
		System.out.println("3\t\t9\t\t27");
		System.out.println("4\t\t16\t\t64");
		
		// COMPUTED
		System.out.println("COMPUTED");
		System.out.println("a\t\ta^2\t\ta^3");
		//1 x 1 (1^2) and 1 x 1 x 1 (1^2)
		System.out.println("1\t\t" + Math.pow(1, 2) + "\t\t" + Math.pow(1, 3));
		//2 x 2 (2^2) and 2 x 2 x 2 (2^3)
		System.out.println("2\t\t" + Math.pow(2, 2) + "\t\t" + Math.pow(2, 3));
		//3 x 3 (3^3) and 3 x 3 x 3 (3^3)
		System.out.println("3\t\t" + Math.pow(3, 2) + "\t\t" + Math.pow(3, 3));
		//4 x 4 (4^4) and 4 x 4 x 4 (4^4)
		System.out.println("4\t\t" + Math.pow(4, 2) + "\t" + Math.pow(4, 3));
	}
}
