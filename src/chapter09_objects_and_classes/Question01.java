package chapter09_objects_and_classes;

/**
 * <h1>Rectangle</h1>
 * <p>
 * This program creates a Rectangle object and can return its area and perimeter.
 * </p>
 * <p>
 * tags:	constructor; getter; setter;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-17
 */
public class Question01
{
	//@@@ INSTANCE VARIABLES @@@
	private double width = 0;
	private double height = 0;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Question01 rectangle1 = new Question01(4, 40);
		Question01 rectangle2 = new Question01(3.5, 35.9);
		
		System.out.println("The area for the first rectangle is: " + rectangle1.getArea());
		System.out.println("The area for the first rectangle is: " + rectangle2.getArea());
		
		System.out.println("The perimeter for the first rectangle is: " + rectangle1.getPerimeter());
		System.out.println("The perimeter for the first rectangle is: " + rectangle2.getPerimeter());
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public Question01(double width, double height)
	{
		this.width = width;
		this.height = height;
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public double getArea()
	{
		double area = this.width * this.height;
		return area;
	}
	
	public double getPerimeter()
	{
		double perimeter = (width * 2) + (height * 2);
		return perimeter;
	}
}
