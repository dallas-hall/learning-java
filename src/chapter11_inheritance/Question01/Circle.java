package chapter11_inheritance.Question01;

/**
 * <h1>Circle</h1>
 * <p>
 * This program is my implementation of a circle using inheritance and interfaces.
 * </p>
 * <p>
 * tags:	Math.PI; inheritance; extends; interfaces; implements; super class constructor;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-09-20
 */
public class Circle extends GeometricObject implements Colourable
{
	//@@@ INSTANCE VARIABLES @@@
	private double radius;

	//@@@ CONSTRUCTOR(S) @@@
	public Circle()
	{
		super();
		radius = 1;
	}
	
	public Circle(String colour, boolean isFilled, double radius)
	{
		super(colour, isFilled);
		this.radius = radius;
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public double getRadius()
	{
		return radius;
	}
	
	public double getArea()
	{
		return radius * radius * Math.PI;
	}
	
	public double getDiameter()
	{
		return radius * 2;
	}
	
	public double getPerimeter()
	{
		return getDiameter() * Math.PI;
	}
	
	//### SETTERS ###
	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	
	//### HELPERS ###
	public String toString()
	{
		return Circle.class.getSimpleName() + "\n" + super.toString() + "\nRadius: " + radius + "\nArea: " + getArea() + "\nDiameter: " + getDiameter() + "\nPerimeter: " + getPerimeter();
	}
	
	@Override
	public int compareTo(GeometricObject geometricObject)
	{
		if (getArea() > ((Circle) geometricObject).getArea()) {
			return 1;
		}
		else if (getArea() == ((Circle) geometricObject).getArea()) {
			return 0;
		}
		else {
			return -1;
		}
	}
	
	public void howToColour()
	{
		Colourable.howToColour();
		System.out.println(" the circumference.");
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
		
		// Check if its a circle...
		if (!(anObject instanceof Circle)) {
			return false;
		}
		
		//cast Object to our specific class and compare state
		Circle aCircle = (Circle) anObject;
		return toString().equals(anObject.toString());
	}
}
