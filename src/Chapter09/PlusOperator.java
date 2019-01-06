package Chapter09;
/**
 * <h1>PlusOperator</h1>
 * <p>
 * This program shows what the + operator does between data types.
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2019-01-07
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class PlusOperator
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(PlusOperator.class.getName());
	
	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Chapter 9 - Exercise 1.6");
		Thread.sleep(005);
		
		// is datatype1 + datatype2 legal? if so, what is the result.
		String[][] concatBoolean = {
			{"boolean", "boolean", "false", ""},
			{"boolean", "char", "false", ""},
			{"boolean", "int", "false", ""},
			{"boolean", "double", "false", ""},
			{"boolean", "String", "true", "String"}
		};
		
		String[][] concatChar = {
			{"char", "boolean", "false", ""},
			{"char", "char", "true", "int"},
			{"char", "int", "true", "int"},
			{"char", "double", "true", "Double"},
			{"char", "String", "true", "String"}
		};
		
		String[][] concatInt = {
			{"int", "boolean", "false", ""},
			{"int", "char", "true", "int"},
			{"int", "int", "true", "int"},
			{"int", "double", "true", "Double"},
			{"int", "String", "true", "String"}
		};
		
		String[][] concatDouble = {
			{"Double", "boolean", "false", ""},
			{"Double", "char", "true", "Double"},
			{"Double", "int", "true", "Double"},
			{"Double", "double", "true", "Double"},
			{"Double", "String", "true", "String"}
		};
		
		String[][] concatString = {
			{"String", "boolean", "true", "String"},
			{"String", "char", "true", "String"},
			{"String", "int", "true", "String"},
			{"String", "double", "true", "String"},
			{"String", "String", "true", "String"}
		};
		
		logger.log(Level.INFO, "boolean");
		Thread.sleep(005);
		for (int i = 0; i < concatBoolean.length; i++) {
			System.out.print("Is using the + operator on a " + concatBoolean[i][0] + " and " + concatBoolean[i][1] + " legal? " + concatBoolean[i][2] + ".");
			if(concatBoolean[i][2].equals("true")) {
				System.out.println(" The result is a " + concatBoolean[i][3]);
			} else {
				System.out.println();
			}
		}
		
		logger.log(Level.INFO, "char");
		Thread.sleep(005);
		for (int i = 0; i < concatChar.length; i++) {
			System.out.print("Is using the + operator on a " + concatChar[i][0] + " and " + concatChar[i][1] + " legal? " + concatChar[i][2] + ".");
			if(concatChar[i][2].equals("true")) {
				System.out.println(" The result is a " + concatChar[i][3]);
			} else {
				System.out.println();
			}
		}
		
		logger.log(Level.INFO, "int");
		Thread.sleep(005);
		for (int i = 0; i < concatInt.length; i++) {
			System.out.print("Is using the + operator on a " + concatInt[i][0] + " and " + concatInt[i][1] + " legal? " + concatInt[i][2] + ".");
			if(concatInt[i][2].equals("true")) {
				System.out.println(" The result is a " + concatInt[i][3]);
			} else {
				System.out.println();
			}
		}
		
		logger.log(Level.INFO, "Double");
		Thread.sleep(005);
		for (int i = 0; i < concatDouble.length; i++) {
			System.out.print("Is using the + operator on a " + concatDouble[i][0] + " and " + concatDouble[i][1] + " legal? " + concatDouble[i][2] + ".");
			if(concatDouble[i][2].equals("true")) {
				System.out.println(" The result is a " + concatDouble[i][3]);
			} else {
				System.out.println();
			}
		}
		
		logger.log(Level.INFO, "String");
		Thread.sleep(005);
		for (int i = 0; i < concatString.length; i++) {
			System.out.print("Is using the + operator on a " + concatString[i][0] + " and " + concatString[i][1] + " legal? " + concatString[i][2] + ".");
			if(concatString[i][2].equals("true")) {
				System.out.println(" The result is a " + concatString[i][3]);
			} else {
				System.out.println();
			}
		}
	}
}
