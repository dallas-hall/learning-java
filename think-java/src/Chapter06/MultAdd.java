package Chapter06;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MultAdd
{
	private static final Logger logger = Logger.getLogger(MultAdd.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		MultAdd runtime = new MultAdd();
		logger.log(Level.INFO, "Exercise 4 - multadd operation");
		for (int i = 0; i < 10; i++) {
			int a = 1 * i;
			int b = 2 * i;
			int c = 3 * i;
			System.out.println("The equation " + a + " * " + b + " + " + c + " = " + runtime.multaddOperation(a, b, c));
		}
	}

	// multadd operation is a * b + c, this can concisely represent many computations.
	public double multaddOperation(double a, double b, double c)
	{
		return a * b + c;
	}
}
