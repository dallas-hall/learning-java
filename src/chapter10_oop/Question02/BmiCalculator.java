package chapter10_oop.Question02;

/**
 * <h1>BMI Calculator</h1>
 * <p>
 * This program will calculate BMI.
 * </p>
 * <p>
 * tags:	BMI fomular; kilograms per pound; meters per inch;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-23
 */
public class BmiCalculator
{
	//@@@ CLASS VARIABLES @@@
	public static final double KILOGRAMS_PER_POUND = 0.45359237;
	public static final double METERS_PER_INCH = 0.0254;
	
	//@@@ INSTANCE VARIABLES @@@
	private String name;
	private int age;
	private double weight; // in pounds
	private double height; // in inches
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		BmiCalculator bmi1 = new BmiCalculator("Dallas", 35, 300, 6, 4);
		System.out.println(bmi1.getHeight());
		System.out.println(bmi1.getStatus());
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public BmiCalculator(String name, int age, double weight, double height)
	{
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}
	
	public BmiCalculator(String name, double weight, double height)
	{
		this(name, 20, weight, height);
	}
	
	public BmiCalculator(String name, int age, double weight, double heightFeet, double heightInches)
	{
		this.name = name;
		this.age = age;
		this.weight = weight;
		//convert feet into inches : 12 inches in 1 foot
		this.height = (heightFeet * 12) + heightInches;
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public double getBMI()
	{
		double bmi = weight * KILOGRAMS_PER_POUND / ((height * METERS_PER_INCH) * (height * METERS_PER_INCH));
		return Math.round(bmi * 100) / 100.0;
	}
	
	public String getStatus()
	{
		double bmi = getBMI();
		if (bmi < 18.5) {
			return "Underweight";
		}
		else if (bmi < 25) {
			return "Normal";
		}
		else if (bmi < 30) {
			return "Overweight";
		}
		else {
			return "Obese";
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public double getHeight()
	{
		return height;
	}
}