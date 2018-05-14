package chapter11_inheritance.Question01;

/**
 * <h1>Square</h1>
 * <p>
 * This program is my implementation of a square using inheritance and interfaces.
 * </p>
 * <p>
 * tags:	inheritance; extends; interfaces; implements; super class constructor;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-09-20
 */
public class Square extends GeometricObject
{
	//@@@ INSTANCE VARIABLES @@@
	private double side;
	
	//@@@ CONSTRUCTOR(S) @@@
	public Square()
	{
		super();
		side = 1.0;
	}
	
	public Square(String colour, boolean isFilled, double side)
	{
		super(colour, isFilled);
		this.side = side;
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public double getSide()
	{
		return side;
	}
	
	public double getArea()
	{
		return side * side;
	}
	
	public double getPerimeter()
	{
		return side * 4;
	}
	
	//### SETTERS ###
	public void setSide(double side)
	{
		this.side = side;
	}
	
	//### HELPERS ###
	@Override
	public String toString()
	{
		return Square.class.getSimpleName() + "\n" + super.toString() + "\nSide: " + side + "\nArea: " + getArea() + "\nPerimeter: " + getPerimeter();
	}
	
	@Override
	public int compareTo(GeometricObject geometricObject)
	{
		if (getArea() > ((Square) geometricObject).getArea()) {
			return 1;
		}
		else if (getArea() == ((Square) geometricObject).getArea()) {
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
		if (!(anObject instanceof Square)) {
			return false;
		}
		
		//cast Object to our specific class and compare state
		Square aSquare = (Square) anObject;
		return toString().equals(anObject.toString());
	}
}
