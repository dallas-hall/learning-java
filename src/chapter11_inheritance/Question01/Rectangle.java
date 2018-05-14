package chapter11_inheritance.Question01;

/**
 * <h1>Rectangle</h1>
 * <p>
 * This program is my implementation of a rectangle using inheritance and interfaces.
 * </p>
 * <p>
 * tags:	inheritance; extends; interfaces; implements; super class constructor;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-09-20
 */
public class Rectangle extends GeometricObject
{
	//@@@ INSTANCE VARIABLES @@@
	private double length;
	private double width;

	//@@@ CONSTRUCTOR(S) @@@
	public Rectangle()
	{
		super();
		length = 1.0;
		width = 1.0;
	}
	
	public Rectangle(String colour, boolean isFilled, double length, double width)
	{
		super(colour, isFilled);
		this.length = length;
		this.width = width;
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public double getLength()
	{
		return length;
	}
	
	public double getWidth()
	{
		return width;
	}
	
	
	public double getArea()
	{
		return length * width;
	}
	
	public double getPerimeter()
	{
		return (length * 2) + (width * 2);
	}
	
	//### SETTERS ###
	public void setLength(double length)
	{
		this.length = length;
	}
	
	public void setWidth(double width)
	{
		this.width = width;
	}
	
	//### HELPERS ###
	@Override
	public String toString()
	{
		return Rectangle.class.getSimpleName() + "\n" + super.toString() + "\nLength: " + length + "\nWidth: " + width + "\nArea: " + getArea() + "\nPerimeter: " + getPerimeter();
	}
	
	@Override
	public int compareTo(GeometricObject geometricObject)
	{
		if (getArea() > ((Rectangle) geometricObject).getArea()) {
			return 1;
		}
		else if (getArea() == ((Rectangle) geometricObject).getArea()) {
			return 0;
		}
		else {
			return -1;
		}
	}
	
	public void howToColour()
	{
		Colourable.howToColour();
		System.out.println(" all 4 sides.");
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
		
		//
		if (!(anObject instanceof Rectangle)) {
			return false;
		}
		
		//cast Object to our specific class and compare state
		Rectangle aRectangle = (Rectangle) anObject;
		return toString().equals(anObject.toString());
	}
}
