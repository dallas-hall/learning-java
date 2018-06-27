package chapter11_inheritance.Question01;

/**
 * <h1>Geometric Object Abstract Class</h1>
 * <p>
 * This program is my implementation of a circle using inheritance and interfaces.
 * </p>
 * <p>
 * tags:	Math.PI; inheritance; abstract class; interfaces; implements; super class;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-09-20
 */
public abstract class GeometricObject implements Comparable<GeometricObject>
{
	//@@@ INSTANCE VARIABLES @@@
	private String colour = null;
	private boolean filled = false;
	private java.util.Date dateCreated = null;
	
	//@@@ MAIN METHOD @@@
	
	
	//@@@ CONSTRUCTOR(S) @@@
	public GeometricObject()
	{
		colour = "Australian gold";
		filled = true;
		dateCreated = new java.util.Date();
	}
	
	public GeometricObject(String colour, boolean filled)
	{
		this.colour = colour;
		this.filled = filled;
		dateCreated = new java.util.Date();
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public String getColour()
	{
		return colour;
	}
	
	public boolean isFilled()
	{
		return filled;
	}
	
	public java.util.Date getDateCreated()
	{
		return dateCreated;
	}
	
	//### SETTERS ###
	public void setColour(String colour)
	{
		this.colour = colour;
	}
	
	public void setFilled(boolean filled)
	{
		this.filled = filled;
	}
	
	//### HELPERS ###
	@Override
	public String toString()
	{
		return "Created on " + dateCreated + "\nCurrent colour: " + colour + "\nCurrently filled? " + filled;
	}
	
	@Override
	public int compareTo(GeometricObject geometricObject)
	{
		return getDateCreated().compareTo(geometricObject.dateCreated);
	}
	
	@Override
	public boolean equals(Object anObject)
	{
		//are they the same object reference
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
		if (!(anObject instanceof GeometricObject)) {
			return false;
		}
		
		//cast Object to our specific class and compare state
		GeometricObject aGeometricObject = (GeometricObject) anObject;
		return this.toString().equals(aGeometricObject.toString());
	}
}
