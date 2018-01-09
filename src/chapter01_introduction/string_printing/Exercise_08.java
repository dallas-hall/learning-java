package chapter01_introduction.string_printing;

/**
 * <h1>Print Messages</h1>
 * <p>
 * This program will compute the perimeter / area of a circle
 * </p>
 * <p>
 * tags:	String printing; PI;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2-3-17
 */

public class Exercise_08 {
	public static void main(String[] args) {
		//declare variables
		double radius = 5.5;
		double PI = Math.PI;
		
		//calculations
		System.out.println("Circle perimeter formula = 2 x radius x π");
		System.out.println("Circle area forumla = radius x radius x π");
		System.out.println("radius = " + radius);
		System.out.println("π = " + PI);
		System.out.println("Perimeter = " + (2 * radius * PI));
		System.out.println("Area = " + (radius * radius * PI));
	}
}
