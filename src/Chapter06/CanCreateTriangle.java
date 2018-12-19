package Chapter06;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CanCreateTriangle
{
	private static final Logger logger = Logger.getLogger(IsDivisible.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		CanCreateTriangle runtime = new CanCreateTriangle();
		logger.log(Level.INFO, "Running canCreateTriangle");
		Thread.sleep(005);

		System.out.println("If any of the three lengths is greater than the sum of the other 2, you cannot form a triangle.");
		for (int i = 1; i < 5; i++) {
			int a = 1;
			int b = 2;
			int c = 3;
			if (i % 2 == 1) {
				a *= 1;
				b *= 2;
				c *= 3;
			} else {
				a *= i;
				b *= i;
				c *= i;
			}

			System.out.println("Can you make a triangle from " + a + ", " + b + ", and " + c + "? " + runtime.canCreateTriangle(a, b, c));
		}

	}

	// If any of the three lengths is greater than the sum of the other 2, you cannot form a triangle.
	public boolean canCreateTriangle(int a, int b, int c)
	{
		int sumAB = a + b;
		int sumAC = a + c;
		int sumBC = b + c;

		if (a > sumBC) {
			return false;
		} else if (b > sumAC) {
			return false;
		} else if (c > sumAB) {
			return false;
		} else {
			return true;
		}
	}
}
