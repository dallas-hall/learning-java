package chapter12_exceptions_and_text_io;

/**
 * Created by blindcant on 13/05/17.
 */
public class Question10
{
	//MAIN METHOD
	public static void main(String[] args)
	{
		Question10 run1 = new Question10();
	}
	
	//CONSTRUCTOR(S)
	public Question10()
	{
		try
		{
			createOutOfMemoryError();
		}
		catch (Error e)
		{
			//use toString to print the entire message.
			System.out.println("SERIOUS ERROR: " + e.toString());
		}
	}
	
	//METHODS
	public void createOutOfMemoryError() throws Error
	{
		//create an array at the maximum integer value
		int[] array = new int[Integer.MAX_VALUE];
		//populate each element with the maximum integer value
		for (int i = 0; i < array.length; i++)
		{
			array[i] = Integer.MAX_VALUE;
		}
	}
}
