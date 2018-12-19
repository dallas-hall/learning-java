package Chapter06;

import java.util.logging.Level;
import java.util.logging.Logger;

public class IsDivisible
{
	private static final Logger logger = Logger.getLogger(IsDivisible.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		IsDivisible runtime = new IsDivisible();
		logger.log(Level.INFO, "Running isDivisible");
		Thread.sleep(005);
		int number = 8;
		for (int i = 1; i <= number; i++) {
			System.out.println("Is " + number + " divisible by " + i + "?\t" + runtime.isDivisible(number, i));
		}
	}

	public boolean isDivisible(int number, int divisor)
	{
		if (number % divisor == 0)
			return true;
		else
			return false;
	}
}
