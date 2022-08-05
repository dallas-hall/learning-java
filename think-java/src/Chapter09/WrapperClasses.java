package Chapter09;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WrapperClasses
{
	private static final Logger logger = Logger.getLogger(StringFormatting.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Printing Min and Max Of Primitive Types.");
		Thread.sleep(005);

		System.out.println("Byte.MIN_VALUE is " + Byte.MIN_VALUE);
		System.out.println("Byte.MAX_VALUE is " + Byte.MAX_VALUE);
		System.out.println();
		System.out.println("Short.MIN_VALUE is " + Short.MIN_VALUE);
		System.out.println("Short.MAX_VALUE is " + Short.MAX_VALUE);
		System.out.println();
		System.out.println("Integer.MIN_VALUE is " + Integer.MIN_VALUE);
		System.out.println("Integer.MAX_VALUE is " + Integer.MAX_VALUE);
		System.out.println();
		System.out.println("Long.MIN_VALUE is " + Long.MIN_VALUE);
		System.out.println("Long.MAX_VALUE is " + Long.MAX_VALUE);
		System.out.println();
		System.out.println("Float.MIN_VALUE is " + Float.MIN_VALUE);
		System.out.println("Float.MAX_VALUE is " + Float.MAX_VALUE);
		System.out.println();
		System.out.println("Double.MIN_VALUE is " + Double.MIN_VALUE);
		System.out.println("Double.MAX_VALUE is " + Double.MAX_VALUE);
		System.out.println();
	}

}
