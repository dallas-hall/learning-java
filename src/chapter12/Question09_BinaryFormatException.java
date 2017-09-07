package chapter12;

/**
 * Created by blindcant on 13/05/17.
 */
public class Question09_BinaryFormatException extends Exception
{
	//CONSTRUCTOR(S)
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
