package chapter12_exceptions_and_text_io.Question10;

/**
 * <h1>Out Of Memory Exception</h1>
 * <p>
 * This program purposely causes an out of memory exception.
 * </p>
 * <p>
 * tags:	OutOfMemoryException
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2017-05-13
 */
public class OutOfMemoryException
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		OutOfMemoryException run1 = new OutOfMemoryException();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public OutOfMemoryException()
	{
		try {
			createOutOfMemoryError();
		}
		catch (Error e) {
			//use toString to print the entire message.
			System.out.println("SERIOUS ERROR: " + e.toString());
		}
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
	public void createOutOfMemoryError() throws Error
	{
		//create an array at the maximum integer value
		int[] array = new int[Integer.MAX_VALUE];
		//populate each element with the maximum integer value
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.MAX_VALUE;
		}
	}
}
