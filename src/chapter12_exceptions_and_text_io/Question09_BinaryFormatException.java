package chapter12_exceptions_and_text_io;

/**
 * <h1>BinaryFormatException</h1>
 * <p>
 * Custom exception class.
 * </p>
 * <p>
 * tags:	extending Exception; super constructor;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2017-05-13
 */
public class Question09_BinaryFormatException extends Exception
{
	//@@@ CONSTRUCTOR(S) @@@
	public Question09_BinaryFormatException()
	{
		//call the superclass constructor in Exception, with no arguments
		super("Invalid binary number.\nMust be [01].\n");
	}
	
	public Question09_BinaryFormatException(String inputString)
	{
		//call the superclass constructor in Exception, with 1 string arguments
		super(inputString + " is an invalid binary number.\nMust be [01].\n");
	}
}
