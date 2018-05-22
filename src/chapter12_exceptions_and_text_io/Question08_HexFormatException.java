package chapter12_exceptions_and_text_io;

/**
 * <h1>HexFormatException</h1>
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
public class Question08_HexFormatException extends Exception
{
	//@@@ CONSTRUCTOR(S) @@@
	public Question08_HexFormatException()
	{
		//call the superclass constructor in Exception, with no arguments
		super("Invalid hexadecimal number.\nInput must be [0-9A-Fa-f].\n");
	}
	
	public Question08_HexFormatException(String inputString)
	{
		//call the superclass constructor in Exception, with a string argument
		super(inputString + " is an invalid hexadecimal number.\nInput must be [0-9A-F].\n");
	}
}
