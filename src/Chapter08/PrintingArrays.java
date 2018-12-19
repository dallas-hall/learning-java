package Chapter08;

import java.util.Arrays;

public class PrintingArrays <T>
{
	public static void main(String[] args)
	{
		PrintingArrays printingArrays = new PrintingArrays();
		PseudoRandomNumbers prn = new PseudoRandomNumbers();

		int[] numbers = prn.createArray();
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
