package chapter10_oop.Question04;

import java.awt.geom.Point2D;

/**
 * <h1>Grid Coordinates</h1>
 * <p>
 * This program will create some grid coordinates using the Point2D class and then show the coordinates and calculate the distance between them.
 * </p>
 * <p>
 * tags:	Point2D; grid points; grid coordinates;
 * </p>
 *
 * @author dhall
 * @version 0.1 - 2017-04-23
 */
public class GridCoordinates
{
	//@@@ INSTANCE VARIABLES @@@
	private double x;
	private double y;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		//POINT 1 SETUP
		//manual way
/*		Question04_07_11_to_14 point1Coordinates = new Question04_07_11_to_14(0,0);
		System.out.println("Current coordinates for point1 are: x:" + point1Coordinates.getX() + " & y:" + point1Coordinates.getY());*/
		
		//using Point2D class
		Point2D point1Object = new Point2D.Double(0, 0);
		System.out.println("Current coordinates for point1 are: x:" + point1Object.getX() + " & y:" + point1Object.getY());
		
		//POINT 2 SETUP
		//manual way
/*		Question04_07_11_to_14 point2Coordinates = new Question04_07_11_to_14(10,30.5);
		System.out.println("Current coordinates for point1 are: x:" + point1Coordinates.getX() + " & y:" + point1Coordinates.getY());*/
		
		//using Point2D class
		Point2D point2Object = new Point2D.Double(10, 30.5);
		System.out.println("Current coordinates for point1 are: x:" + point2Object.getX() + " & y:" + point2Object.getY());
		
		//SHOW DISTANCE BETWEEN THE 2 POINTS
/*		manaul way - DON'T KNOW THE MATH
		System.out.println("The distance between point1 (" + point1Coordinates.getX() + " & " + point1Coordinates.getY() +
				")and point2 is (" + point2Coordinates.getX() + " & " + point2Coordinates.getY() + ") is : "+ point1_2D.distance(point2_2D));*/
		
		//Using Point2D class
		System.out.println("The distance between point1 (" + point1Object.getX() + " & " + point1Object.getY() + ") and point2 is (" + point2Object.getX() + " & " + point2Object.getY() + ") is : " + point1Object.distance(point2Object));
		System.out.println("Conversely, between point2 and point1 is: " + point1Object.distance(point2Object));
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public GridCoordinates(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public double getX()
	{
		return this.x;
	}
	
	public double getY()
	{
		return this.y;
	}
}
