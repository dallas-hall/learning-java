package chapter11_inheritance.Question01;

import chapter13_abstract_classes_and_interfaces.Question11.Octagon;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Geometric Object Main Class</h1>
 * <p>
 * This is the driver class for Geometric Objects, showcasing inheritance, polymorphism, and interfaces.
 * </p>
 * <p>
 * tags:	Math.PI; inheritance; abstract class; interfaces; implements; polymorphism; static type; dynamic type;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-09-20
 */
public class Main
{
	//@@@ INSTANCE VARIABLES @@@
	private static List<GeometricObject> shapes = new ArrayList<>();
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		//create shapes and add to the collection
		Circle circle01 = new Circle();
		shapes.add(circle01);
		Circle circle02 = new Circle("Green", false, 2.0);
		shapes.add(circle02);
		Square square01 = new Square();
		shapes.add(square01);
		Square square02 = new Square("Blue", false, 4.0);
		shapes.add(square02);
		Rectangle rectangle01 = new Rectangle();
		shapes.add(rectangle01);
		Rectangle rectangle02 = new Rectangle("Mellow Yellow", false, 4.0, 2.5);
		shapes.add(rectangle02);
		Triangle triangle01 = new Triangle();
		shapes.add(triangle01);
		Triangle triangle02 = new Triangle("Burgandy", false, 3.0, 3.0, 2.0);
		shapes.add(triangle02);
		Triangle triangle03 = new Triangle("Olive", false, 3.0, 2.0, 1.0);
		shapes.add(triangle03);
		Octagon octagon01 = new Octagon();
		shapes.add(octagon01);
		Octagon octagon02 = new Octagon();
		shapes.add(octagon02);
		
		//polymorphic call on toString to print shape details
		for (GeometricObject anObject : shapes)
		{
			//instanceof checks to call a method from an interface that isn't define in the superclass
			System.out.println(anObject.toString());
			if(anObject instanceof Circle)
			{
				((Circle) anObject).howToColour();
			}
			if(anObject instanceof Rectangle)
			{
				((Rectangle) anObject).howToColour();
			}
			if(anObject instanceof Square)
			{
				((Square) anObject).howToColour();
			}
			if(anObject instanceof Triangle)
			{
				((Triangle) anObject).howToColour();
			}
			if(anObject instanceof Octagon)
			{
				((Octagon) anObject).howToColour();
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Comparing the area of rectangle01 to rectangle02: " + rectangle01.compareTo(rectangle02));
		System.out.println("Does the rectangle01 object equal the rectangle02 object: " + rectangle01.equals(rectangle02));
		System.out.println("Comparing the area of square02 to square01: " + square02.compareTo(square01));
		System.out.println("Does the square02 object equal the square01 object: " + square02.equals(square01));
		System.out.println("Comparing the area of triangle01 to triangle02: " + triangle01.compareTo(triangle02));
		System.out.println("Does the triangle01 object equal the triangle02 object: " + triangle01.equals(triangle02));
		System.out.println("Comparing the area of triangle03 to triangle03: " + triangle03.compareTo(triangle03));
		System.out.println("Does the triangle03 object equal the triangle03 object: " + triangle03.equals(triangle03));
		System.out.println("Comparing the perimeter of octagon01 to octagon02: " + octagon01.compareTo(octagon02));
		System.out.println("Does the octagon01 object equal the octagon02 object: " + octagon01.equals(octagon02));
		
	}
}
