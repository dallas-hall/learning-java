/**
 *
 */
package chapter09_objects_and_classes;

/**
 * <h1>Fan Class</h1>
 * <p>
 * This program creates a Fan object, which can have a variety of state such as speed, powered on, colour, and radius.
 * </p>
 * <p>
 * tags:	constructor; getter; setter; java.util.date; toString()
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-17
 */
public class Question08
{
	//@@@ CLASS VARIABLES @@@
	private final static byte SLOW = 1;
	private final static byte MEDIUM = 2;
	private final static byte FAST = 3;
	
	//@@@ INSTANCE VARIABLES @@@
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 5;
	private String colour = "blue";
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Question08 fan1 = new Question08(FAST, true, 10, "yellow");
		Question08 fan2 = new Question08(MEDIUM, false, 5, "blue");
		Question08 fan3 = new Question08();
		
		System.out.println(fan1.toString());
		System.out.println(fan2.toString());
		System.out.println(fan3.toString());
		
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public Question08(int speed, boolean on, double radius, String colour)
	{
		this.speed = speed;
		this.on = on;
		this.radius = radius;
		this.colour = colour;
	}
	
	public Question08()
	{
	}
	
	// getters
	public int getSpeed()
	{
		return this.speed;
	}
	
	public boolean getPowerState()
	{
		return this.on;
	}
	
	public double getRadius()
	{
		return this.radius;
	}
	
	public String getColour()
	{
		return this.colour;
	}
	
	// setters
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	public void setPowerState(boolean on)
	{
		this.on = on;
	}
	
	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	
	public void setColour(String colour)
	{
		this.colour = colour;
	}
	
	// helpers
	public String toString()
	{
		return String.format("%nCurrent speed: %s%nPowered on? %s%nRadius: %,.2f%nColour: %s", speed, on, radius, colour);
	}
}
