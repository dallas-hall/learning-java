package Chapter08;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintingArrays
{
	private static final Logger logger = Logger.getLogger(PrintingArrays.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Printing arrays.");
		Thread.sleep(005);
		PrintingArrays printingArrays = new PrintingArrays();
		PseudoRandomNumbers prn = new PseudoRandomNumbers();

		int[] numbers = prn.createArrayThreadLocalRandom();
		System.out.println(printingArrays.getArrayString(numbers));
		System.out.println(Arrays.toString(numbers));
	}

	public String getArrayString(int[] array)
	{
		if (array.length == 0) {
			return "{}";
		}

		StringBuffer stringBuffer = new StringBuffer();
		// Print out the first element
		stringBuffer.append("{" + array[0]);
		for(int i = 1; i < array.length; i++) {
			// Print all elements in between
			stringBuffer.append(", " + array[i]);
		}
		// Print the final curly brace
		stringBuffer.append("}");
		return stringBuffer.toString();
	}
}
