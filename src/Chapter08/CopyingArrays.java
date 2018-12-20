package Chapter08;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CopyingArrays
{
	private static final Logger logger = Logger.getLogger(CopyingArrays.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Copying array contents.");
		Thread.sleep(005);
		CopyingArrays runtime = new CopyingArrays();
		PseudoRandomNumbers prn = new PseudoRandomNumbers();
		int[] a = prn.createArrayRandom();
		System.out.println(a + " = " + Arrays.toString(a));
		// Copy full array manually
		int[] b = runtime.copyIntArray(a);
		System.out.println(b + " = " + Arrays.toString(b));
		// Copy full array with java.util.Arrays
		int[] c = Arrays.copyOf(a, a.length);
		System.out.println(c + " = " + Arrays.toString(c));

	}

	public int[] copyIntArray(int[] inputArray) {
		if (inputArray.length == 0) {
			return inputArray;
		}
		else {
			int[] outputArray = new int[inputArray.length];
			for (int i = 0; i < inputArray.length; i++) {
				outputArray[i] = inputArray[i];
			}
			return outputArray;
		}
	}
}
