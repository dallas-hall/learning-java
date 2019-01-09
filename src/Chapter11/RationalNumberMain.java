package Chapter11;
/**
 * <h1>RationalNumberMain</h1>
 * <p>
 * This program is the main class for RationalNumber.
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2019-01-09
 */

import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RationalNumberMain
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(RationalNumberMain.class.getName());
	public static final String PROGRAM_VERSION = "0.1.0";
	
	//@@@ INSTANCE VARIABLES @@@
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Chapter 11 - Exercise 4.");
		logger.log(Level.INFO, "Creating default rational number.");
		RationalNumber rationalNumber = new RationalNumber();
		System.out.println(rationalNumber.toString());

		logger.log(Level.INFO, "Creating specific rational number.");
		Thread.sleep(005);
		rationalNumber = new RationalNumber(1, 3);
		rationalNumber.printRationalNumber();

		logger.log(Level.INFO, "Flip rational number.");
		Thread.sleep(005);
		rationalNumber.flipRationalNumber();
		rationalNumber.printRationalNumber();

		logger.log(Level.INFO, "Negate rational number.");
		Thread.sleep(005);
		rationalNumber.negateRationalNumber();
		rationalNumber.printRationalNumber();

		logger.log(Level.INFO, "Convert to decimal.");
		Thread.sleep(005);
		System.out.printf("%s %f\n", rationalNumber.toString() + " as a decimal is ", rationalNumber.toDouble());
		rationalNumber.flipRationalNumber();
		System.out.printf("%s %f\n", rationalNumber.toString() + " as a decimal is ", rationalNumber.toDouble());

		logger.log(Level.INFO, "GCD / GCF using Euclidean subtraction algorithm.");
		Thread.sleep(005);
		System.out.println(rationalNumber.gcdEuclidSubtractionRecursion(13, 13));
		System.out.println(rationalNumber.gcdEuclidSubtractionRecursion(37, 600));
		System.out.println(rationalNumber.gcdEuclidSubtractionRecursion(20, 100));
		System.out.println(rationalNumber.gcdEuclidSubtractionRecursion(624129, 2061517));
		
		System.out.println(rationalNumber.gcdEuclidModuloRecursion(13, 13));
		System.out.println(rationalNumber.gcdEuclidModuloRecursion(37, 600));
		System.out.println(rationalNumber.gcdEuclidModuloRecursion(20, 100));
		System.out.println(rationalNumber.gcdEuclidModuloRecursion(624129, 2061517));

		
/*
		logger.log(Level.INFO, "LCD / LCF using multiplication tables.");
		Thread.sleep(005);
		//BigInteger lcd = rationalNumber.getLcdLoop(10, 10000);
		//System.out.println(lcd);
		
		logger.log(Level.INFO, "Adding rational numbers.");
		Thread.sleep(005);
		//System.out.printf("%s %s.", "Adding 6/3 to " + rationalNumber.toString() + " is", rationalNumber.addRationals(6, 3));
*/
	
	}
}
