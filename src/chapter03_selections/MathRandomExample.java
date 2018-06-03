package chapter03_selections;

import chapter12_exceptions_and_text_io.Question29.CreateMoveDeleteFiles;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h1>MathRandomExample</h1>
 * <p>
 * This program shows how to use Math.random three different ways to do the same thing.
 * </p>
 * <p>
 * tags:	Math.random();
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-10
 */
public class MathRandomExample
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(CreateMoveDeleteFiles.class.getName());
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		int min = 10;
		int max = 20;
		int limit = 100;
		int printCount = 0;
		try {
			System.out.println("Generating random numbers between min (10) and max (20), excluding max. So 10-19");
			logger.log(Level.INFO, "Using min + (int) (Math.random() * theNumberToAddToMinToGetMax");
			Thread.sleep(500);
			for (int i = 0; i < limit; i++) {
				System.out.print(10 + (int) (Math.random() * 10) + " ");
				printCount++;
				if (printCount % 10 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			Thread.sleep(500);
			logger.log(Level.INFO, "Using min + (int) (Math.random() * (max - min))");
			printCount = 0;
			for (int i = 0; i < limit; i++) {
				System.out.print(min + (int) (Math.random() * (max - min)) + " ");
				printCount++;
				if (printCount % 10 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			Thread.sleep(500);
			logger.log(Level.INFO, "Using (int) (Math.random() * (max - min) + min)");
			printCount = 0;
			for (int i = 0; i < limit; i++) {
				System.out.print((int) (Math.random() * (max - min) + min) + " ");
				printCount++;
				if (printCount % 10 == 0) {
					System.out.println();
				}
			}
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, "An error has occurred.");
			e.printStackTrace();
		}
	}
}
