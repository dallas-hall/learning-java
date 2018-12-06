package Chapter06;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercises
{
	private static final Logger logger = Logger.getLogger(FactorialRecursion.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Chapter 5 - Exercises");
		Exercises runtime = new Exercises();

		logger.log(Level.INFO, "Exercise 2");
		Thread.sleep(005);
		System.out.println("Is 9 divisible by 3? " + runtime.isDivisible(9,3));
		System.out.println("Is 9 divisible by 4? " + runtime.isDivisible(9,4));

		logger.log(Level.INFO, "Exercise 3");
		Thread.sleep(005);
		System.out.println("Can you make a triangle from 1, 2, and 3? " + runtime.canCreateTriangle(1, 2, 3));
		System.out.println("Can you make a triangle from 1, 2, and 4? " + runtime.canCreateTriangle(1, 2, 4));

		logger.log(Level.INFO, "Exercise 4");
		Thread.sleep(005);
		System.out.println("1 * 2 + 3 = " + runtime.multaddOperation(1, 2, 3));
		System.out.println("2 * 4 + 8 = " + runtime.multaddOperation(2, 4, 8));
	}

	public boolean isDivisible(int n, int m)
	{
		if(n % m == 0)
			return true;
		else
			return false;
	}

	// If any of the three lengths is greater than the sum of the other 2, you cannot form a triangle.
	public boolean canCreateTriangle(int a, int b, int c)
	{
		int sumAB =  a + b;
		int sumAC =  a + c;
		int sumBC =  b + c;

		if (a > sumBC) {
			return false;
		}
		else if (b > sumAC) {
			return false;
		}
		else if (c > sumAB) {
			return false;
		}
		else {
			return true;
		}
	}

	// multadd operation is a * b + c, this can concisely represent many computations.
	public double multaddOperation(double a, double b, double c)
	{
		return a * b + c;
	}
}
