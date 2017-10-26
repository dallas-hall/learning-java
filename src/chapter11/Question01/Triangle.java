package chapter11.Question01;

/**
 * Created by blindcant on 19/09/17.
 */
public class Triangle extends GeometricObject
{
	//@@@ INSTANCE VARIABLES @@@
	private double side1;
	private double side2;
	private double side3;
	
	//@@@ MAIN METHOD @@@
	
	
	//@@@ CONSTRUCTOR(S) @@@
	public Triangle()
	{
		super();
		side1 = 1.0;
		side2 = 1.0;
		side3 = 1.0;
	}
	
	public Triangle(String colour, boolean isFilled, double side1, double side2, double side3)
	{
		super(colour, isFilled);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public double getSide1()
	{
		return side1;
	}
	
	public double getSide2()
	{
		return side2;
	}
	
	public double getSide3()
	{
		return side3;
	}
	
	public double getPerimeter()
	{
		return side1 + side2 + side3;
	}
	
	public double getArea()
	{
		return Double.NaN;
	}
	
	public boolean isEqualateral()
	{
		if (side1 == side2 && side1 == side3 && side2 == side3)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isIsosceles()
	{
		if (side1 == side2 || side1 == side3 || side2 == side3)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isScalene()
	{
		if (side1 != side2 && side1 != side3 && side2 != side3)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//### SETTERS ###
	public void setSide1(double side1)
	{
		this.side1 = side1;
	}
	
	public void setSide2(double side2)
	{
		this.side2 = side2;
	}
	
	public void setSide3(double side3)
	{
		this.side3 = side3;
	}
	
	//### HELPERS ###
	@Override
	public String toString()
	{
		return Triangle.class.getSimpleName() + "\n" + super.toString() + "\nSide 1: " + side1 + "\nSide 2: " + side2
				+ "\nSide 3: " + side3 + "\nArea: " + getArea() + "\nPerimeter: " + getPerimeter() + "\nIs equalateral? " +
				isEqualateral() + "\nIs isoscelese? " + isIsosceles() + "\nIs scalene? " + isScalene();
	}
	
	@Override
	public int compareTo(GeometricObject geometricObject)
	{
		if(getPerimeter() > ((Triangle)geometricObject).getPerimeter())
		{
			return 1;
		}
		else if(getPerimeter() == ((Triangle)geometricObject).getPerimeter())
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}
	
	public void howToColour()
	{
		Colourable.howToColour();
		System.out.println(" all 3 sides.");
	}
	
	@Override
	public boolean equals(Object anObject)
	{
		//are they the same objects
		if(this == anObject)
		{
			return true;
		}
		
		//is the parameter null?
		if(anObject == null)
		{
			return false;
		}
		
		//are the classes the same
		if (getClass() != anObject.getClass())
		{
			return false;
		}
		
		//
		if (!(anObject instanceof Triangle))
		{
			return false;
		}
		
		//cast Object to our specific class and compare state
		Triangle aTriangle = (Triangle) anObject;
		return toString().equals(anObject.toString());
	}
}
