package Chapter08;

import java.util.Arrays;

public class CopyingArrays
{
	public static void main(String[] args)
	{
		CopyingArrays runtime = new CopyingArrays();
		int[] a = {1, 2, 3, 4, 5};
		System.out.println(a + " = " + Arrays.toString(a));
		// Copy full array manually
		int[] b = runtime.copyIntArray(a);
		System.out.println(b + " = " + Arrays.toString(b));
		// Copy full array with java.util.Arrays
		int[] c = Arrays.copyOf(a, a.length);
		System.out.println(c + " = " + Arrays.toString(c));

	}

	public int[] copyIntArray(int[] inputArray) {
		int[] outputArray = new int[inputArray.length];

		for (int i = 0; i < inputArray.length; i++) {
			outputArray[i] = inputArray[i];
		}
		return outputArray;
	}
}
