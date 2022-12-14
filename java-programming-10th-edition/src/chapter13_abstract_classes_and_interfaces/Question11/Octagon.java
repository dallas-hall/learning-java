package chapter13_abstract_classes_and_interfaces.Question11;

import chapter11_inheritance.Question01.Colourable;
import chapter11_inheritance.Question01.GeometricObject;

/**
 * <h1>CalendarAndDateExample</h1>
 * <p>
 * This program showcases the use of the Cloneable interface.
 * </p>
 * <p>
 * tags:	inheritance; interfaces; Cloneable; Comparable; overriding;
 * </p>
 *
 * @author dhall
 * @version 0.0.1 - 2017-09-20
 */
public class Octagon extends GeometricObject implements Colourable, Cloneable
{
	//@@@ INSTANCE VARIABLES @@@
	private double side1, side2, side3, side4, side5, side6, side7, side8;
	
	//@@@ CONSTRUCTOR(S) @@@
	public Octagon()
	{
		super();
		side1 = 1;
		side2 = 1;
		side3 = 1;
		side4 = 1;
		side5 = 1;
		side6 = 1;
		side7 = 1;
		side8 = 1;
	}
	
	public Octagon(String colour, boolean isFilled, double side1, double side2, double side3, double side4, double side5, double side6, double side7, double side8)
	{
		super(colour, isFilled);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		this.side4 = side4;
		this.side5 = side5;
		this.side6 = side6;
		this.side7 = side7;
		this.side8 = side8;
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public double getPerimeter()
	{
		return side1 + side2 + side3 + side4 + side5 + side6 + side7 + side8;
	}
	
	public double getArea()
	{
		return (2 + 4 / Math.sqrt(2)) * side1 * side1;
	}
	//### SETTERS ###
	
	//### HELPERS ###
	@Override
	public String toString()
	{
		return Octagon.class.getSimpleName() + "\n" + super.toString() + "\nSide 1: " + side1 + "\nSide 2: " + side2 + "\nSide 3: " + side3 + "\nSide 4: " + side4 + "\nSide 5: " + side5 + "\nSide 6: " + side6 + "\nSide 7: " + side7 + "\nSide 8: " + side8 + "\nArea: " + Double.NaN + "\nPerimeter: " + getPerimeter();
	}
	
	@Override
	public int compareTo(GeometricObject geometricObject)
	{
		if (getArea() > ((Octagon) geometricObject).getArea()) {
			return 1;
		}
		else if (getArea() == ((Octagon) geometricObject).getArea()) {
			return 0;
		}
		else {
			return -1;
		}
	}
	
	public void howToColour()
	{
		Colourable.howToColour();
		System.out.println(" all 8 sides.");
	}
	
	@Override
	public boolean equals(Object anObject)
	{
		//are they the same objects
		if (this == anObject) {
			return true;
		}
		
		//is the parameter null?
		if (anObject == null) {
			return false;
		}
		
		//are the classes the same
		if (getClass() != anObject.getClass()) {
			return false;
		}
		
		// is it even an octagon?
		if (!(anObject instanceof Octagon)) {
			return false;
		}
		
		//cast Object to our specific class and compare state
		Octagon aOctagon = (Octagon) anObject;
		return this.toString().equals(aOctagon.toString());
	}
}
