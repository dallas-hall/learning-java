package chapter12;

/**
 * Created by blindcant on 13/05/17.
 */
public class Question08_HexFormatException extends Exception
{
	//CONSTRUCTOR(S)
	public Question08_HexFormatException()
	{
		//call the superclass constructor in Exception, with no arguments
		super("Invalid hexadeimcal number.\nInput must be [0-9A-F].\n");
	}
	
	public Question08_HexFormatException(String inputString)
	{
		//call the superclass constructor in Exception, with a string argument
		super(inputString + " is an invalid hexadeimcal number.\nInput must be [0-9A-F].\n");
	}
}
