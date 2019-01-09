package Chapter11;
/**
 * <h1>DateMain</h1>
 * <p>
 * This program is the main class for Date.
 *
 * @author blindcant
 * @version 0.1.0 - 2019-01-09
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class DateMain
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(DateMain.class.getName());
	public static final String PROGRAM_VERSION = "0.1.0";
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Chapter 11 - Exercise 4.");
		logger.log(Level.INFO, "Create random date.");
		Thread.sleep(005);
		Date date1 = new Date();
		System.out.println(date1.toString());
		date1.printUsDate();
		
		logger.log(Level.INFO, "Create specific date.");
		Thread.sleep(005);
		Date date2 = new Date(1970, 1, 1);
		date2.printIso8601();
		date2.printUsDate();
		
		logger.log(Level.INFO, "Comparing dates.");
		System.out.printf("%s %b.\n", "Does " + date1 + " equal " + date2 + "?", date1.equals(date2));
		System.out.printf("%s %b.\n", "Does " + date2 + " equal " + date1 + "?", date2.equals(date1));
	}
}
