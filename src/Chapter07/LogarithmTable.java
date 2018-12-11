package Chapter07;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
A logarithm is "how many of one number do we need to multiply to get another number".
https://www.mathsisfun.com/algebra/logarithms.html

Example, how many 2s do we need to get 8?
2 * 2 * 2 = 8 so the answer (i.e. logarithm) is 3.
 */
public class LogarithmTable
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(LogarithmTable.class.getName());

	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	private int limit;

	//@@@ MAIN METHOD @@@
	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Program starting.");
		Thread.sleep(005);

		LogarithmTable runtime = new LogarithmTable();
		logger.log(Level.INFO, "Logarithm Table Base e (i++)");
		Thread.sleep(005);
		runtime.printLogarithmTableBaseE(10);
		logger.log(Level.INFO, "Logarithm Table Base 2 (i++)");
		Thread.sleep(005);
		runtime.printLogarithmTableBase2(10);
		logger.log(Level.INFO, "Logarithm Table Base 2 Arithmetic Sequence (i *= 2)");
		Thread.sleep(005);
		runtime.printLogarithmTableBase2ArithmeticSequence(100);
	}

	//@@@ METHODS @@@
	//### HELPERS ###
	public void printLogarithmTableBaseE(int n)
	{
		int i = 1;
		while (i < n) {
			double x = i;
			System.out.println(x + " " + Math.log(i));
			i++;
		}
	}

	public void printLogarithmTableBase2(int n)
	{
		int i = 1;
		while (i < n) {
			double x = i;
			System.out.println(x + " " + Math.log(i) / Math.log(2));
			i++;
		}
	}

	public void printLogarithmTableBase2ArithmeticSequence(int n)
	{
		int i = 1;
		while (i < n) {
			double x = i;
			System.out.println(x + " " + Math.log(i) / Math.log(2));
			i *= 2;
		}
	}
}
