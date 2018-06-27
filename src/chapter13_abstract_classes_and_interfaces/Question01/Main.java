package chapter13_abstract_classes_and_interfaces.Question01;

import chapter11_inheritance.Question01.Triangle;
import java.util.Scanner;

/**
 * <h1>CalendarAndDateExample</h1>
 * <p>
 * This program showcases the use of constructors for an inherited class which also has an interface.
 * </p>
 * <p>
 * tags:	inheritance; interfaces;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2017-09-19
 */

public class Main
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Triangle triangle01 = createTriangle();
		System.out.println(triangle01.toString());
	}
	
	
	//@@@ METHODS @@@
	public static Triangle createTriangle()
	{
		Scanner stdinKeyboard = new Scanner(System.in);
		System.out.println("Enter triangle colour:");
		String colour = stdinKeyboard.nextLine();
		System.out.println("Is the triangle coloured in? Y or N");
		String answer = stdinKeyboard.nextLine().toLowerCase();
		boolean filled;
		if (answer.equals("y") || answer.equals("yes")) {
			filled = true;
		}
		else {
			filled = false;
		}
		System.out.println("Enter triangle side 1 value:");
		double side1 = Double.parseDouble(stdinKeyboard.nextLine());
		System.out.println("Enter triangle side 2 value:");
		double side2 = Double.parseDouble(stdinKeyboard.nextLine());
		System.out.println("Enter triangle side 3 value:");
		double side3 = Double.parseDouble(stdinKeyboard.nextLine());
		
		Triangle triangle01 = new Triangle(colour, filled, side1, side2, side3);
		return triangle01;
	}
}
