package Chapter05;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h1>FermatsLastTheorem</h1>
 * <p>
 * This program calculates Fermat's last theorem. Which states that there are no integers a, b, and c such that a ^ n + b ^ n = c ^ n, except when n <= 2.
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2018-12-06
 */
public class FermatsLastTheorem
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(FermatsLastTheorem.class.getName());
	
	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		FermatsLastTheorem runtime = new FermatsLastTheorem();
		runtime.checkFermatsLastTheorem(1, 2, 3, 4);
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public FermatsLastTheorem()
	{
		logger.log(Level.INFO, "Chapter 5 - Exercise 4");
		try {
			Thread.sleep(005);
		}
		catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	private String getIndividualAnswerMessage(int n, int m, int o)
	{
		return n + " ^ " + m + " = " + o;
	}
	
	private String getEquationMessage(int a, int b)
	{
		return a + " + " + b + " = " + (a + b);
	}
	
	//### HELPERS ###
	public void checkFermatsLastTheorem(int a, int b, int c, int n)
	{
		System.out.println("The theorem states that a ^ n + b ^ n = c ^ n only when n is greater than 2.");
		System.out.println("a = " + a + "\nb = " + b + "\nc = " + c + "\nn = " + n);
		int answerA = (int) Math.pow(a, n);
		int answerB = (int) Math.pow(b, n);
		int answerC = (int) Math.pow(c, n);
		boolean result = answerA + answerB == answerC;
		System.out.println(getIndividualAnswerMessage(a, n, answerA));
		System.out.println(getIndividualAnswerMessage(b, n, answerB));
		System.out.println(getIndividualAnswerMessage(c, n, answerC));
		System.out.println(getEquationMessage(answerA, answerB));
	

		if (n > 2 && result) {
			System.out.println("With n being greater than 2, the theorem is incorrect.");
		}
		else if (n > 2 && !result) {
			System.out.println("With n being greater than 2, the theorem is correct.");
		}
		else if(n <= 2) {
			System.out.println("With n being less than or equal to 2, there may or may not be matches.");
		}
	}
}
