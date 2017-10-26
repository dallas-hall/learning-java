package chapter13.Question01;

import chapter11.Question01.Triangle;

import java.util.Scanner;

/**
 * Created by blindcant on 19/09/17.
 */
public class Main
{
	//@@@ INSTANCE VARIABLES @@@
	
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Triangle triangle01 = createTriangle();
		System.out.println(triangle01.toString());
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	
	
	//@@@ METHODS @@@
	public static Triangle createTriangle()
	{
		Scanner stdinKeyboard = new Scanner(System.in);
		System.out.println("Enter triangle colour:");
		String colour = stdinKeyboard.nextLine();
		System.out.println("Is the triangle coloured in? Y or N");
		String answer = stdinKeyboard.nextLine().toLowerCase();
		boolean filled;
		if (answer.equals("y") || answer.equals("yes"))
		{
			filled = true;
		}
		else
		{
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
