package chapter01_introduction.string_printing;

/**
 * <h1>Print Messages</h1>
 * <p>
 * This program will calculate area of a rectangle
 * </p>
 * <p>
 * tags:	String printing; math;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 4-3-17
 */

public class Exercise_09
{
	public static void main(String[] args)
	{
		//set variables
		double width = 2.5;
		double height = 7.9;
		
		//calculations
		System.out.println("Rectangle area formula = width x height");
		System.out.println("Answer = " + (width * height));
		System.out.println("Rectangle perimeter formula = width x 2 + height x 2");
		System.out.println("Answer = " + (width * 2) + (height * 2));
		
	}
}
