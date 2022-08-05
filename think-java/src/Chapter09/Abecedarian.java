package Chapter09;/**
 * <h1>Abecedarian</h1>
 * <p>
 * This program checks if a String is an Abecedaraian, which means all letters are in alphabetical order.
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2019-01-08
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class Abecedarian
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(Abecedarian.class.getName());
	
	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		logger.log(Level.INFO, "Chapter 9 - Exercise 5.");
		Abecedarian runtime = new Abecedarian();
		String[] s = {
			"biopsy",
			"biopsies",
			"deflux",
			"influx"
		};
		
		for (int i = 0; i < s.length; i++) {
			System.out.printf("%29s %4b.\n", "Is the word " + s[i] + " an abecedarian? ", runtime.isAbecedarian(s[i]));
		}
	}

	//@@@ METHODS @@@
	//### HELPERS ###
	public boolean isAbecedarian(String s)
	{
		boolean result = true;
		for (int i = 0; i < s.length() - 1; i++) {
			// Use lexicographical comparison to see if the would is an abecedarian.
			char c1 = s.charAt(i);
			char c2 = s.charAt(i + 1);
			if(c1 > c2) {
				result = false;
				break;
			}
		}
		return result;
	}
}
